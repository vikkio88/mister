package tests.com.mister.lib.model;

import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.Round;
import com.mister.lib.model.Team;
import org.junit.Test;
import tests.com.mister.lib.helper.LeagueFixture;

import java.util.ArrayList;
import java.util.List;

public class LeagueTest {
    @Test
    public void generateRoundsCorrectly() {
        List<Team> teams = new ArrayList<Team>() {{
            add(new Team("Roma"));
            add(new Team("Juventus"));
            add(new Team("Inter"));
            add(new Team("Milan"));
        }};
        List<Round> rounds = LeagueFixture.generate(teams);
        rounds.forEach(r -> {
            System.out.println(String.format("Round %d.......", r.getMatchDay()));
            r.getMatches().forEach(System.out::println);
        });
    }

    @Test
    public void itGivesCurrentRoundInitiallytheFirst() {
        List<Team> teams = RandomFiller.getTeams(6);
    }
}
