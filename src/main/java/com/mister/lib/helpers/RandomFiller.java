package com.mister.lib.helpers;

import com.mister.lib.helpers.provider.ClubDefinition;
import com.mister.lib.model.Coach;
import com.mister.lib.model.Player;
import com.mister.lib.model.Team;
import com.mister.lib.model.enums.Module;
import com.mister.lib.model.enums.Nationality;
import com.mister.lib.model.enums.Position;
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
                getTeamName(),
                getCoach()
        );
        team.setRoster(
                getPlayers(Randomizer.intVal(13, 20))
        );
        return team;
    }

    public static Coach getCoach() {
        return new Coach(
                getName(),
                getSurname(),
                getCoachAge(),
                Randomizer.pickOne(Nationality.values()),
                Randomizer.pickOne(Module.values())
        );
    }


    public static ArrayList<Player> getPlayers(int limit) {
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i < limit; i++) {
            players.add(getPlayer());
        }
        return players;
    }

    public static String getTeamName() {
        return ClubDefinition.getRandom().getClubDefinition(getCity());
    }

    public static String getCity() {
        return WordUtils.capitalize(faker.address.city());
    }

    public static Player getPlayer() {
        Player player = new Player(
                getName(),
                getSurname(),
                getPlayerAge(),
                Nationality.IT,
                Randomizer.pickOne(Position.values())
        );

        player.setSkill(Randomizer.intVal(0, 90));
        return player;
    }

    private static String getSurname() {
        return faker.name.lastName();
    }

    private static String getName() {
        String name = faker.name.firstName();
        return name.endsWith("a") ? name.substring(0, name.length() - 1) + "o" : name;
    }

    public static int getPlayerAge() {
        return Randomizer.intVal(15, 49);
    }

    public static int getCoachAge() {
        return Randomizer.intVal(31, 71);
    }
}
