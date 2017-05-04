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
        List<Round> rounds = new ArrayList<>();
        for (int round = 0; round < totalRounds; round++) {
            Round tempRound = new Round();
            for (int match = 0; match < matchesPerRound; match++) {
                int home = (round + match) % (numberOfTeams - 1);
                int away = (numberOfTeams - 1 - match + round) % (numberOfTeams - 1);
                if (match == 0) {
                    away = numberOfTeams - 1;
                }
                tempRound.addMatch(new Match(teams.get(home), teams.get(away)));
            }
            rounds.add(tempRound);
        }
        return rounds;
    }
}
