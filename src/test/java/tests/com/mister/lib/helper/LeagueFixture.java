package tests.com.mister.lib.helper;

import com.mister.lib.model.Match;
import com.mister.lib.model.Round;
import com.mister.lib.model.Team;

import java.util.ArrayList;
import java.util.List;

public class LeagueFixture {
    public static List<Round> generate(List<Team> teams) {
        List<Round> rounds = new ArrayList<>();
        int teamsNumber = teams.size();
        int roundsNumber = teamsNumber - 1;
        int halfSize = teamsNumber / 2;
        for (int i = 0; i < roundsNumber; i++) {
            Round tempRound = new Round();
            int teamIndex = i % teamsNumber;
            tempRound.addMatch(new Match(teams.get(teamIndex), teams.get(0)));
            for (int j = 1; j < halfSize; j++) {
                int teamA = (i + j) % teamsNumber;
                int teamB = (i + teamsNumber - j) % teamsNumber;
                tempRound.addMatch(new Match(teams.get(teamA), teams.get(teamB)));
            }
            rounds.add(tempRound);
        }
        rounds.forEach(r -> {
            System.out.println("Round.......");
            r.getMatches().forEach(System.out::println);
        });
        return rounds;

    }
}
