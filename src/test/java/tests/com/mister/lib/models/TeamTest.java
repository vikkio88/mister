package tests.com.mister.lib.models;


import com.mister.lib.model.Player;
import com.mister.lib.model.Team;
import com.mister.lib.model.enums.Nationality;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


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
        return new Team(name);
    }
}
