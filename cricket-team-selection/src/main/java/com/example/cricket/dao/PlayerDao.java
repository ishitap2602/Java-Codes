
package com.example.cricket.dao;

import com.example.cricket.model.Player;
import com.example.cricket.rowmapper.PlayerRowMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDao {

    private final JdbcTemplate statsJdbc;

    public PlayerDao(@Qualifier("statsJdbcTemplate") JdbcTemplate statsJdbc) {
        this.statsJdbc = statsJdbc;
    }

    public List<Player> getTopBatsmen(int limit) {
        String sql = """
            SELECT player_id, name, role, batting_average, bowling_average
            FROM players
            WHERE role IN ('BATSMAN','WICKET_KEEPER')
            ORDER BY batting_average DESC
            LIMIT ?
            """;
        return statsJdbc.query(sql, new PlayerRowMapper(), limit);
    }

    public List<Player> getTopBowlers(int limit) {
        String sql = """
            SELECT player_id, name, role, batting_average, bowling_average
            FROM players
            WHERE role = 'BOWLER'
            ORDER BY bowling_average ASC
            LIMIT ?
            """;
        return statsJdbc.query(sql, new PlayerRowMapper(), limit);
    }

    public List<Player> getTopAllRounders(int limit) {
        String sql = """
            SELECT player_id, name, role, batting_average, bowling_average
            FROM players
            WHERE role = 'ALL_ROUNDER'
            ORDER BY batting_average DESC, bowling_average ASC
            LIMIT ?
            """;
        return statsJdbc.query(sql, new PlayerRowMapper(), limit);
    }

    public List<Player> getTopWicketKeepers(int limit) {
        String sql = """
            SELECT player_id, name, role, batting_average, bowling_average
            FROM players
            WHERE role = 'WICKET_KEEPER'
            ORDER BY batting_average DESC
            LIMIT ?
            """;
        return statsJdbc.query(sql, new PlayerRowMapper(), limit);
    }

    /** "Top stats" – simple overall balance: batting desc, bowling asc */
    public List<Player> getTopOverall(int limit) {
        String sql = """
            SELECT player_id, name, role, batting_average, bowling_average
            FROM players
            ORDER BY batting_average DESC, bowling_average ASC
            LIMIT ?
            """;
        return statsJdbc.query(sql, new PlayerRowMapper(), limit);
    }
}
