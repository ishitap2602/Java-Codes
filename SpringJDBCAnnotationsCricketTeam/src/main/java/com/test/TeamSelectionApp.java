
package com.test;

import com.test.config.AppConfig;
import com.test.dao.PlayerDao;
import com.test.model.Player;
import com.test.service.TeamSelectionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * Entry point for the Cricket World Cup team selection demo.
 *
 * - Loads Spring context (plain Spring, no Boot).
 * - Seeds test data if table is empty.
 * - Selects final team based on:
 *      • Top batting averages
 *      • Top bowling averages
 *      • Top all-rounders (combined score)
 * - Prints team with battingAverage & bowlingAverage.
 *
 * Composition defaults (in TeamSelectionService):
 *   BATTERS_COUNT = 7, BOWLERS_COUNT = 6, ALL_ROUNDERS_COUNT = 2
 */
public class TeamSelectionApp {

    public static void main(String[] args) {
        // Start plain Spring context using Java @Configuration
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {

            // Beans
            PlayerDao dao = ctx.getBean(PlayerDao.class);
            TeamSelectionService service = ctx.getBean(TeamSelectionService.class);

            // Seed data if table is empty (safe starter)
            if (dao.findAll().isEmpty()) {
                System.out.println("Seeding sample data into 'player' table...");

                dao.insert(new Player(0, "Rohit Sharma", "BATSMAN",
                        new BigDecimal("48.20"), null));

                dao.insert(new Player(0, "Shubman Gill", "BATSMAN",
                        new BigDecimal("51.10"), null));

                dao.insert(new Player(0, "Virat Kohli", "BATSMAN",
                        new BigDecimal("57.60"), null));

                dao.insert(new Player(0, "KL Rahul", "WICKET_KEEPER",
                        new BigDecimal("44.30"), null));

                dao.insert(new Player(0, "Shreyas Iyer", "BATSMAN",
                        new BigDecimal("42.05"), null));

                dao.insert(new Player(0, "Ravindra Jadeja", "ALL_ROUNDER",
                        new BigDecimal("32.10"), new BigDecimal("34.50")));

                dao.insert(new Player(0, "Hardik Pandya", "ALL_ROUNDER",
                        new BigDecimal("33.80"), new BigDecimal("37.40")));

                dao.insert(new Player(0, "Jasprit Bumrah", "BOWLER",
                        null, new BigDecimal("24.90")));

                dao.insert(new Player(0, "Mohammed Shami", "BOWLER",
                        null, new BigDecimal("27.10")));

                dao.insert(new Player(0, "Kuldeep Yadav", "BOWLER",
                        null, new BigDecimal("28.50")));

                dao.insert(new Player(0, "Ravi Bishnoi", "BOWLER",
                        null, new BigDecimal("29.10")));

                dao.insert(new Player(0, "Arshdeep Singh", "BOWLER",
                        null, new BigDecimal("30.40")));

                dao.insert(new Player(0, "Suryakumar Yadav", "BATSMAN",
                        new BigDecimal("39.10"), null));

                dao.insert(new Player(0, "Sanju Samson", "WICKET_KEEPER",
                        new BigDecimal("41.50"), null));
            }

            // Select & print final team
            List<Player> finalTeam = service.selectFinalTeam();
            service.printTeam(finalTeam);
        }
    }
}
