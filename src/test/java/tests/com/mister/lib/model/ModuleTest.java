package tests.com.mister.lib.model;


import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.Player;
import com.mister.lib.model.Team;
import com.mister.lib.model.enums.Module;
import com.mister.lib.model.enums.Position;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class ModuleTest {

    @Test
    public void allConfigurationsHave11Players() {
        for (Module module : Module.values()) {
            int[] roles = module.getRoles();
            int sum = Arrays.stream(roles).sum();
            Assert.assertEquals(11, sum);
        }
    }

    @Test
    public void itReturnsTrueIfTeamCanPlayModule() {
        Assert.assertTrue(Module.M442.teamCanPlay(getGoodTeam()));
    }

    @Test
    public void itReturnsFalseIfTeamCantPlayModule() {
        Assert.assertFalse(Module.M442.teamCanPlay(getBadTeam()));
    }

    private Team getBadTeam() {
        Team team = new Team("GoodTeam");
        ArrayList<Player> players = new ArrayList<>();
        players.add(RandomFiller.getPlayer(Position.GK));
        team.setRoster(players);
        return team;
    }

    private Team getGoodTeam() {
        Team team = new Team("GoodTeam");
        ArrayList<Player> players = new ArrayList<>();
        players.add(RandomFiller.getPlayer(Position.GK));
        players.add(RandomFiller.getPlayer(Position.D));
        players.add(RandomFiller.getPlayer(Position.D));
        players.add(RandomFiller.getPlayer(Position.D));
        players.add(RandomFiller.getPlayer(Position.LD));
        players.add(RandomFiller.getPlayer(Position.RD));
        players.add(RandomFiller.getPlayer(Position.M));
        players.add(RandomFiller.getPlayer(Position.M));
        players.add(RandomFiller.getPlayer(Position.M));
        players.add(RandomFiller.getPlayer(Position.RM));
        players.add(RandomFiller.getPlayer(Position.LM));
        players.add(RandomFiller.getPlayer(Position.S));
        players.add(RandomFiller.getPlayer(Position.S));
        players.add(RandomFiller.getPlayer(Position.S));
        players.add(RandomFiller.getPlayer(Position.LS));
        players.add(RandomFiller.getPlayer(Position.RS));
        team.setRoster(players);
        return team;
    }
}
