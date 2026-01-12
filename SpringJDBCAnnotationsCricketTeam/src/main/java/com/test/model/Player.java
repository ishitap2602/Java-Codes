
package com.test.model;

import java.math.BigDecimal;

/**
 * Domain model representing a cricket player.
 * Matches the MySQL table:
 *
 *   CREATE TABLE player (
 *     id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 *     name VARCHAR(100) NOT NULL,
 *     role VARCHAR(20)  NOT NULL,
 *     batting_average DECIMAL(5,2) NULL,
 *     bowling_average DECIMAL(5,2) NULL
 *   );
 *
 * Notes:
 * - battingAverage may be NULL for pure bowlers.
 * - bowlingAverage may be NULL for pure batsmen.
 * - role values: BATSMAN | BOWLER | ALL_ROUNDER | WICKET_KEEPER
 */
public class Player {

    private int id;
    private String name;
    private String role; // BATSMAN, BOWLER, ALL_ROUNDER, WICKET_KEEPER
    private BigDecimal battingAverage;   // nullable
    private BigDecimal bowlingAverage;   // nullable

    public Player() {
    }

    public Player(int id, String name, String role,
                  BigDecimal battingAverage, BigDecimal bowlingAverage) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.battingAverage = battingAverage;
        this.bowlingAverage = bowlingAverage;
    }

    // --- Getters / Setters ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getBattingAverage() {
        return battingAverage;
    }

    public void setBattingAverage(BigDecimal battingAverage) {
        this.battingAverage = battingAverage;
    }

    public BigDecimal getBowlingAverage() {
        return bowlingAverage;
    }

    public void setBowlingAverage(BigDecimal bowlingAverage) {
        this.bowlingAverage = bowlingAverage;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", battingAverage=" + battingAverage +
                ", bowlingAverage=" + bowlingAverage +
                '}';
    }
}

