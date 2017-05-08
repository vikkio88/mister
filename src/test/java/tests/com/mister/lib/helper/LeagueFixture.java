package tests.com.mister.lib.helper;

import com.mister.lib.model.Match;
import com.mister.lib.model.Round;
import com.mister.lib.model.Team;

import java.util.ArrayList;
import java.util.List;

public class LeagueFixture {

    public static List<Round> generate(List<Team> teams) {
        int numberOfTeams = teams.size();
        int totalRounds = numberOfTeams - 1;
        int matchesPerRound = numberOfTeams / 2;
        List<Round> roundsFirstHalf = new ArrayList<>();
        List<Round> roundsSecondHalf = new ArrayList<>();
        for (int round = 0; round < totalRounds; round++) {
            Round tempRoundFirstHalf = new Round(round + 1);
            Round tempRoundSecondHalf = new Round(totalRounds + 1 + round);
            for (int match = 0; match < matchesPerRound; match++) {
                int home = (round + match) % (numberOfTeams - 1);
                int away = (numberOfTeams - 1 - match + round) % (numberOfTeams - 1);
                if (match == 0) {
                    away = numberOfTeams - 1;
                }
                tempRoundFirstHalf.addMatch(new Match(teams.get(home), teams.get(away)));
                tempRoundSecondHalf.addMatch(new Match(teams.get(away), teams.get(home)));
            }
            roundsFirstHalf.add(tempRoundFirstHalf);
            roundsSecondHalf.add(tempRoundSecondHalf);
        }

        roundsFirstHalf.addAll(roundsSecondHalf);
        return roundsFirstHalf;
    }
}
