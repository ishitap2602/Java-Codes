
package com.example.cricket.dao;

import com.example.cricket.model.TeamMember;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TeamDao {

    private final JdbcTemplate selectionJdbc;

    public TeamDao(@Qualifier("selectionJdbcTemplate") JdbcTemplate selectionJdbc) {
        this.selectionJdbc = selectionJdbc;
    }

    public long createTeam(String teamName) {
        String sql = "INSERT INTO team (team_name) VALUES (?)";
        KeyHolder kh = new GeneratedKeyHolder();
        selectionJdbc.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, teamName);
            return ps;
        }, kh);
        Number key = kh.getKey();
        return key == null ? -1L : key.longValue();
    }

    public void addPlayersToTeam(long teamId, List<Long> playerIds) {
        String sql = "INSERT INTO team_player (team_id, player_id) VALUES (?, ?)";
        selectionJdbc.batchUpdate(sql, playerIds, playerIds.size(),
                (ps, playerId) -> {
                    ps.setLong(1, teamId);
                    ps.setLong(2, playerId);
                });
    }

    /** Cross-database join to print team with stats from cricket_stats */
    public List<TeamMember> getTeamMembersWithStats(String teamName) {
        String sql = """
            SELECT p.player_id, p.name, p.role, p.batting_average, p.bowling_average
            FROM team_selection.team_player tp
            JOIN team_selection.team t ON t.team_id = tp.team_id
            JOIN cricket_stats.players p ON p.player_id = tp.player_id
            WHERE t.team_name = ?
            ORDER BY
              CASE p.role
                WHEN 'BATSMAN' THEN 1
                WHEN 'WICKET_KEEPER' THEN 2
                WHEN 'ALL_ROUNDER' THEN 3
                WHEN 'BOWLER' THEN 4
                ELSE 5
              END,
              p.batting_average DESC,
              p.bowling_average ASC
            """;
        return selectionJdbc.query(sql, (rs, rowNum) ->
            new TeamMember(
                rs.getLong("player_id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getBigDecimal("batting_average"),
                rs.getBigDecimal("bowling_average")
            ), teamName);
    }
}
``
