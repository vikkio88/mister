package tests.com.mister.lib.model;


import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.helpers.Randomizer;
import com.mister.lib.model.Team;
import org.junit.Assert;
import org.junit.Test;


public class TeamTest {
    private String name = "Team A";

    @Test
    public void itHasExpectedFields() {
        Team team = getTeam();
        Assert.assertEquals(name, team.getName());
        Assert.assertEquals(0, team.getPlayersNumber());
        Assert.assertTrue(team.getFinance() < 50);
        Assert.assertTrue(team.getFinance() > 1);
    }


    private Team getTeam() {
        return new Team(name, RandomFiller.getCoach());
    }
}
