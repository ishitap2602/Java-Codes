
package com.test.dao;

import com.test.model.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Maps a row from the 'player' table to a Player domain object.
 * Columns expected:
 *   id, name, role, batting_average, bowling_average
 */
public class PlayerRowMapper implements RowMapper<Player> {

    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        Player p = new Player();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setRole(rs.getString("role"));
        // DECIMAL -> BigDecimal (may be NULL)
        p.setBattingAverage(rs.getBigDecimal("batting_average"));
        p.setBowlingAverage(rs.getBigDecimal("bowling_average"));
        return p;
    }
}
