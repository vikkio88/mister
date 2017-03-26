package tests.com.mister.lib.helper;

import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.Player;
import com.mister.lib.model.Team;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RandomFillerTest {
    @Test
    public void itReturnsAValidTeamName() {
        String firstTeamName = RandomFiller.getTeamName();
        Assert.assertTrue(!firstTeamName.equals(""));
        String secondTeamName = RandomFiller.getTeamName();
        Assert.assertTrue(!firstTeamName.equals(secondTeamName));
    }

    @Test
    public void itReturnsARandomPlayerCorrectly() {
        Player firstPlayer = RandomFiller.getPlayer();
        Assert.assertTrue(!firstPlayer.getName().equals(""));
        Player secondPlayer = RandomFiller.getPlayer();
        Assert.assertTrue(!firstPlayer.getName().equals(secondPlayer.getName()));
    }

    @Test
    public void itReturnsASelectedNumberOfPlayer() {
        int number = 10;
        ArrayList<Player> players = RandomFiller.getPlayers(number);
        Assert.assertEquals(number, players.size());
    }

    @Test
    public void itReturnsACompleteTeam() {
        Team team = RandomFiller.getTeam();
        Assert.assertTrue(team.getRoster().size() > 0);
        Assert.assertTrue(team.getCoach() != null);
    }
}

