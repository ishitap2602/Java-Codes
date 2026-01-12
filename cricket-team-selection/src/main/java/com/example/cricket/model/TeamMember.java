
package com.example.cricket.model;

import java.math.BigDecimal;

public class TeamMember {
    private Long playerId;
    private String name;
    private String role;
    private BigDecimal battingAverage;
    private BigDecimal bowlingAverage;

    public TeamMember() {}

    public TeamMember(Long playerId, String name, String role,
                      BigDecimal battingAverage, BigDecimal bowlingAverage) {
        this.playerId = playerId;
        this.name = name;
        this.role = role;
        this.battingAverage = battingAverage;
        this.bowlingAverage = bowlingAverage;
    }

    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public BigDecimal getBattingAverage() { return battingAverage; }
    public void setBattingAverage(BigDecimal battingAverage) { this.battingAverage = battingAverage; }
    public BigDecimal getBowlingAverage() { return bowlingAverage; }
    public void setBowlingAverage(BigDecimal bowlingAverage) { this.bowlingAverage = bowlingAverage; }
}

