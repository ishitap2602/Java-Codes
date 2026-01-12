
package com.example.cricket.model;

import java.util.List;

public class FinalizedTeam {
    private String teamName;
    private List<TeamMember> members;

    public FinalizedTeam(String teamName, List<TeamMember> members) {
        this.teamName = teamName;
        this.members = members;
    }

    public String getTeamName() { return teamName; }
    public List<TeamMember> getMembers() { return members; }
}

