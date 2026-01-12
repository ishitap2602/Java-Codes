
package com.test.dao;

import com.test.model.Player;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO for 'player' table using Spring JDBC.
 * Multi-DB: uses writeJdbcTemplate for INSERT/DELETE and readJdbcTemplate for SELECT queries.
 */
@Repository
public class PlayerDao {

    private final JdbcTemplate writeJdbc;
    private final JdbcTemplate readJdbc;
    private final PlayerRowMapper mapper = new PlayerRowMapper();

    public PlayerDao(@Qualifier("writeJdbcTemplate") JdbcTemplate writeJdbc,
                     @Qualifier("readJdbcTemplate") JdbcTemplate readJdbc) {
        this.writeJdbc = writeJdbc;
        this.readJdbc = readJdbc;
    }

    // -----------------------------
    // Writes (primary datasource)
    // -----------------------------

    public int insert(Player p) {
        String sql = "INSERT INTO player (name, role, batting_average, bowling_average) VALUES (?, ?, ?, ?)";
        return writeJdbc.update(sql, p.getName(), p.getRole(), p.getBattingAverage(), p.getBowlingAverage());
    }

    public int deleteAll() {
        return writeJdbc.update("DELETE FROM player");
    }

    // Optional helper
    public int deleteById(int id) {
        return writeJdbc.update("DELETE FROM player WHERE id = ?", id);
    }

    // -----------------------------
    // Reads (replica datasource)
    // -----------------------------

    public List<Player> findAll() {
        String sql = "SELECT id, name, role, batting_average, bowling_average FROM player";
        return readJdbc.query(sql, mapper);
    }

    /** Top batters: includes BATSMAN, WICKET_KEEPER, ALL_ROUNDER with non-null batting_average */
    public List<Player> topBatters(int limit) {
        String sql = """
            SELECT id, name, role, batting_average, bowling_average
            FROM player
            WHERE batting_average IS NOT NULL
              AND role IN ('BATSMAN','WICKET_KEEPER','ALL_ROUNDER')
            ORDER BY batting_average DESC
            LIMIT ?
            """;
        return readJdbc.query(sql, mapper, limit);
    }

    /** Top bowlers: includes BOWLER and ALL_ROUNDER with non-null bowling_average (lower is better) */
    public List<Player> topBowlers(int limit) {
        String sql = """
            SELECT id, name, role, batting_average, bowling_average
            FROM player
            WHERE bowling_average IS NOT NULL
              AND role IN ('BOWLER','ALL_ROUNDER')
            ORDER BY bowling_average ASC
            LIMIT ?
            """;
        return readJdbc.query(sql, mapper, limit);
    }

    /** All-rounders that have BOTH averages present (for combined score ranking in the service layer) */
    public List<Player> allRoundersWithBothAverages() {
        String sql = """
            SELECT id, name, role, batting_average, bowling_average
            FROM player
            WHERE role = 'ALL_ROUNDER'
              AND batting_average IS NOT NULL
              AND bowling_average IS NOT NULL
            """;
        return readJdbc.query(sql, mapper);
    }
}
