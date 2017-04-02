package tests.com.mister.lib.model;

import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.Match;
import com.mister.lib.model.MatchResult;
import com.mister.lib.model.Team;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;

public class MatchTest {
    @NotNull
    private Match getMatch() {
        Team home, away;
        home = RandomFiller.getTeam();
        away = RandomFiller.getTeam();
        return new Match(home, away);
    }

    @Test
    public void itAcceptsTwoTeamsAndByDefaultWasPlayedReturnsFalse() {
        Match match = getMatch();
        Assert.assertFalse(match.wasPlayed());
    }

    @Test
    public void whenSimulatedReturnsAMatchResultAndSimulatedIsTrue() {
        Match match = getMatch();
        MatchResult result = match.simulate();
        Assert.assertTrue(result != null);
        Assert.assertTrue(match.wasPlayed());
    }
}
