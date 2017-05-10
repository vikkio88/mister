package tests.com.mister.lib.model;

import com.mister.lib.model.League;
import com.mister.lib.model.Round;
import com.mister.lib.model.Team;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import tests.com.mister.lib.helper.LeagueFixture;

import java.util.ArrayList;
import java.util.List;

public class LeagueTest {

    private List<Team> getTeams() {
        return new ArrayList<Team>() {{
            add(new Team("Roma"));
            add(new Team("Juventus"));
            add(new Team("Inter"));
            add(new Team("Milan"));
        }};
    }

    @Test
    public void generateRoundsCorrectly() {
        List<Team> teams = getTeams();
        List<Round> rounds = LeagueFixture.generate(teams);
        Assert.assertEquals(rounds.size(), (teams.size() - 1) * 2);
    }

    @Test
    public void canSimulateAllTheMatchesByRound() {
        List<Team> teams = getTeams();
        List<Round> rounds = LeagueFixture.generate(teams);
        League sampleLeague = new League("Serie A", teams, rounds);
        for (int i = 0; i < rounds.size(); i++) {
            sampleLeague.getNextRound();
        }
        Assert.assertFalse(sampleLeague.hasMatchLeft());
    }
}
