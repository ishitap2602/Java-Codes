
package com.test.service;

import com.test.dao.PlayerDao;
import com.test.model.Player;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeamSelectionService {

    // Inject from application.properties with sensible defaults
    private final int battersCount;
    private final int bowlersCount;
    private final int allRoundersCount;

    private final PlayerDao dao;

    public TeamSelectionService(
            PlayerDao dao,
            @Value("${team.batters.count:7}") int battersCount,
            @Value("${team.bowlers.count:6}") int bowlersCount,
            @Value("${team.allrounders.count:2}") int allRoundersCount) {
        this.dao = dao;
        this.battersCount = battersCount;
        this.bowlersCount = bowlersCount;
        this.allRoundersCount = allRoundersCount;
    }

    public List<Player> selectFinalTeam() {
        List<Player> topBatters      = dao.topBatters(battersCount);
        List<Player> topBowlers      = dao.topBowlers(bowlersCount);
        List<Player> topAllRounders  = rankAllRoundersByCombinedScore(allRoundersCount);

        Map<Integer, Player> unique = new LinkedHashMap<>();
        addAll(unique, topBatters);
        addAll(unique, topBowlers);
        addAll(unique, topAllRounders);

        return new ArrayList<>(unique.values());
    }

    private void addAll(Map<Integer, Player> acc, List<Player> list) {
        for (Player p : list) acc.putIfAbsent(p.getId(), p);
    }

    private List<Player> rankAllRoundersByCombinedScore(int limit) {
        List<Player> allRounders = dao.allRoundersWithBothAverages();
        if (allRounders.isEmpty()) return Collections.emptyList();

        double maxBat = allRounders.stream()
                .map(Player::getBattingAverage).filter(Objects::nonNull)
                .mapToDouble(BigDecimal::doubleValue).max().orElse(1.0);

        double minBowl = allRounders.stream()
                .map(Player::getBowlingAverage).filter(Objects::nonNull)
                .mapToDouble(BigDecimal::doubleValue).min().orElse(1.0);

        record Scored(Player player, double score) {}

        return allRounders.stream()
                .map(p -> {
                    double bat = p.getBattingAverage() != null ? p.getBattingAverage().doubleValue() : 0.0;
                    double bowl = p.getBowlingAverage() != null ? p.getBowlingAverage().doubleValue() : Double.MAX_VALUE;
                    double score = 0.6 * (bat / maxBat) + 0.4 * (minBowl / bowl);
                    return new Scored(p, score);
                })
                .sorted(Comparator.comparingDouble(Scored::score).reversed())
                .limit(limit)
                .map(Scored::player)
                .collect(Collectors.toList());
    }

    public void printTeam(List<Player> team) {
        System.out.println("\n=== FINAL WORLD CUP TEAM ===");
        System.out.printf("%-3s %-22s %-15s %-15s %-15s%n", "ID", "Name", "Role", "BattingAvg", "BowlingAvg");
        System.out.println("-------------------------------------------------------------------------------");
        for (Player p : team) {
            String bat = p.getBattingAverage() != null ? p.getBattingAverage().toPlainString() : "-";
            String bowl = p.getBowlingAverage() != null ? p.getBowlingAverage().toPlainString() : "-";
            System.out.printf("%-3d %-22s %-15s %-15s %-15s%n",
                    p.getId(), p.getName(), p.getRole(), bat, bowl);
        }
    }
}
