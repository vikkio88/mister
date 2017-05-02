package tests.com.mister.lib.model;

import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.Team;
import org.junit.Test;
import tests.com.mister.lib.helper.LeagueFixture;

import java.util.List;

public class LeagueTest {
    @Test
    public void generateRoundsCorrectly() {
        List<Team> teams = RandomFiller.getTeams(6);
        LeagueFixture.generate(teams);
    }

    @Test
    public void itGivesCurrentRoundInitiallytheFirst() {
        List<Team> teams = RandomFiller.getTeams(6);
    }
}
