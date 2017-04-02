package tests.com.mister.lib.model;


import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.Player;
import com.mister.lib.model.Team;
import com.mister.lib.model.enums.Position;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


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

    @Test
    public void itGroupsPlayersPerRole() {
        Team team = new Team(RandomFiller.getTeamName());
        team.setRoster(new ArrayList<>());
        team.getRoster().add(RandomFiller.getPlayer(Position.GK));
        team.getRoster().add(RandomFiller.getPlayer(Position.D));
        team.getRoster().add(RandomFiller.getPlayer(Position.M));
        team.getRoster().add(RandomFiller.getPlayer(Position.S));
        HashMap<Position, Integer> expected = Position.getEmptyRolesHash();
        expected.put(Position.GK, 1);
        expected.put(Position.D, 1);
        expected.put(Position.M, 1);
        expected.put(Position.S, 1);
        HashMap<Position, Integer> playersPerRole = team.getPlayersPerRole();
        for (Map.Entry<Position, Integer> result : playersPerRole.entrySet()) {
            Assert.assertEquals(expected.get(result.getKey()), result.getValue());
        }
    }

    @Test
    public void itGettingScorersReturnsAnOrderedListOfPlayers() {
        Team team = RandomFiller.getTeam();
        Position previousPosition = null;
        int previousSkill = 100;
        for (Player player : team.getPossibleScorers()) {
            if (previousPosition == null) {
                previousPosition = player.getPosition();
                previousSkill = player.getSkill();
                continue;
            }

            if (player.getPosition() != previousPosition) {
                Assert.assertTrue(player.getPosition().getWeight() < previousPosition.getWeight());
                previousPosition = player.getPosition();
                previousSkill = player.getSkill();
                continue;
            }
            Assert.assertTrue(player.getSkill() <= previousSkill);
            previousSkill = player.getSkill();
        }
    }


    private Team getTeam() {
        return new Team(name, RandomFiller.getCoach());
    }
}
