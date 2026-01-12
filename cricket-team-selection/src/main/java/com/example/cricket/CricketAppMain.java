
package com.example.cricket;

import com.example.cricket.model.FinalizedTeam;
import com.example.cricket.service.TeamSelectionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CricketAppMain {
    public static void main(String[] args) {
        // Load Spring context from XML
        try (ClassPathXmlApplicationContext ctx =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {

            TeamSelectionService selectionService = ctx.getBean(TeamSelectionService.class);

            FinalizedTeam team1 = selectionService.finalizeByTopStats("World Cup 2026 - TopStats");
            System.out.println(selectionService.toPrintable(team1));

            FinalizedTeam team2 = selectionService.finalizeByAvgScore("World Cup 2026 - AvgScore");
            System.out.println(selectionService.toPrintable(team2));

            FinalizedTeam team3 = selectionService.finalizeByAvgBowling("World Cup 2026 - AvgBowling");
            System.out.println(selectionService.toPrintable(team3));
        }
    }
}
