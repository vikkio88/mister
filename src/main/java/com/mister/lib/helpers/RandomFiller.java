package com.mister.lib.helpers;

import com.mister.lib.helpers.provider.ClubDefinition;
import com.mister.lib.model.Player;
import com.mister.lib.model.Team;
import io.bloco.faker.Faker;
import org.apache.commons.lang3.text.WordUtils;

import java.util.ArrayList;

public class RandomFiller {
    static Faker faker = new Faker("it");

    public static int finance() {
        if (Randomizer.chance(20)) {
            return Randomizer.intVal(10, 50);
        }
        return Randomizer.intVal(1, 20);
    }

    public static ArrayList<Team> getTeams(int limit) {
        ArrayList<Team> teams = new ArrayList<Team>();
        for (int i = 0; i < limit; i++) {
            teams.add(getTeam());
        }
        return teams;
    }

    public static Team getTeam() {
        Team team = new Team(
                getTeamName()
        );
        team.setRoster(
                getPlayers(Randomizer.intVal(13, 20))
        );
        return team;
    }

    private static ArrayList<Player> getPlayers(int limit) {
        return new ArrayList<Player>();
    }

    public static String getTeamName() {
        return ClubDefinition.getRandom().getClubDefinition(getCity());
    }

    public static String getCity() {
        return WordUtils.capitalize(faker.address.city());
    }
}
