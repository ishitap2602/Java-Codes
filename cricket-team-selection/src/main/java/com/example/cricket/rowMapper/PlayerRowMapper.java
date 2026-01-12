
package com.example.cricket.rowmapper;

import com.example.cricket.model.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;

public class PlayerRowMapper implements RowMapper<Player> {
    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("player_id");
        String name = rs.getString("name");
        String role = rs.getString("role");
        BigDecimal batAvg = rs.getBigDecimal("batting_average");
        BigDecimal bowlAvg = rs.getBigDecimal("bowling_average");
        return new Player(id, name, role, batAvg, bowlAvg);
    }
}
