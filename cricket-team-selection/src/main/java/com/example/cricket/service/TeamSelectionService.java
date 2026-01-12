
package com.example.cricket.service;

import com.example.cricket.dao.PlayerDao;
import com.example.cricket.dao.TeamDao;
import com.example.cricket.model.FinalizedTeam;
import com.example.cricket.model.TeamMember;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@Service
public class TeamSelectionService {

    private final PlayerDao playerDao;
    private final TeamDao teamDao;

    public TeamSelectionService(PlayerDao playerDao, TeamDao teamDao) {
        this.playerDao = playerDao;
        this.teamDao = teamDao;
    }

    /** Balanced: 6 batsmen (incl 1 WK), 3 all-rounders, 6 bowlers = 15 */
    public FinalizedTeam finalizeByTopStats(String teamName) {
        return buildAndPersistTeam(teamName, 5, 1, 3, 6);
    }

    /** Batting-focus: 7 batsmen (incl 1 WK), 2 all-rounders, 6 bowlers = 15 */
    public FinalizedTeam finalizeByAvgScore(String teamName) {
        return buildAndPersistTeam(teamName, 6, 1, 2, 6);
    }

    /** Bowling-focus: 5 batsmen (incl 1 WK), 2 all-rounders, 8 bowlers = 15 */
    public FinalizedTeam finalizeByAvgBowling(String teamName) {
        return buildAndPersistTeam(teamName, 4, 1, 2, 8);
    }

    private FinalizedTeam buildAndPersistTeam(String teamName,
                                              int batsmenCount, int wkCount,
                                              int allRounderCount, int bowlerCount) {

        LinkedHashSet<Long> playerIds = new LinkedHashSet<>();

        playerDao.getTopBatsmen(batsmenCount).forEach(p -> playerIds.add(p.getPlayerId()));
        playerDao.getTopWicketKeepers(wkCount).forEach(p -> playerIds.add(p.getPlayerId()));
        playerDao.getTopAllRounders(allRounderCount).forEach(p -> playerIds.add(p.getPlayerId()));
        playerDao.getTopBowlers(bowlerCount).forEach(p -> playerIds.add(p.getPlayerId()));

        long teamId = teamDao.createTeam(teamName);
        teamDao.addPlayersToTeam(teamId, new ArrayList<>(playerIds));

        List<TeamMember> members = teamDao.getTeamMembersWithStats(teamName);
        return new FinalizedTeam(teamName, members);
    }

    /** Pretty printer */
    public String toPrintable(FinalizedTeam team) {
        StringBuilder sb = new StringBuilder();
        sb.append("Final Team: ").append(team.getTeamName()).append("\n");
        sb.append(String.format("%-4s %-22s %-16s %-16s %-16s%n",
                "ID", "Name", "Role", "BattingAvg", "BowlingAvg"));
        sb.append("--------------------------------------------------------------------------------\n");
        for (TeamMember m : team.getMembers()) {
            sb.append(String.format("%-4d %-22s %-16s %-16s %-16s%n",
                    m.getPlayerId(),
                    m.getName(),
                    m.getRole(),
                    m.getBattingAverage(),
                    m.getBowlingAverage()));
        }
        return sb.toString();
    }
}
