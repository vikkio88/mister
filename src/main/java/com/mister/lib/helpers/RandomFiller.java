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
    private static final String FALLBACK_LOCALE = "it";
    private static Faker faker = new Faker(FALLBACK_LOCALE);

    public static int finance() {
        if (Randomizer.chance(20)) {
            return Randomizer.intVal(10, 50) * Team.FINANCE_MULTIPLIER;
        }
        return Randomizer.intVal(1, 20) * Team.FINANCE_MULTIPLIER;
    }

    public static ArrayList<Team> getTeams(int limit) {
        ArrayList<Team> teams = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            teams.add(getTeam());
        }
        return teams;
    }

    public static Team getTeam() {
        Coach coach = getCoach(getNationality());
        Team team = new Team(
                getTeamName(),
                coach
        );

        team.setRoster(
                getPlayers(Randomizer.intVal(12, 16))
        );
        //adding a goal keeper
        Player goalKeeper = getPlayer(getNationality());
        goalKeeper.setPosition(Position.GK);
        team.getRoster().add(goalKeeper);

        //adding some foreign players
        ArrayList<Player> foreigners = geForeignPlayers(Randomizer.intVal(5, 8));
        team.getRoster().addAll(foreigners);
        return team;
    }

    private static Nationality getNationality() {
        return Randomizer.pickOne(Nationality.values());
    }

    private static void setFaker(String nationCode) {
        if (!faker.getLocale().equals(nationCode)) {
            faker = new Faker(nationCode);
        }
    }

    public static Coach getCoach(Nationality nationality) {
        setFaker(nationality.getNationCode());
        Coach coach = getCoach();
        setFaker(FALLBACK_LOCALE);
        return coach;
    }

    public static Coach getCoach() {
        Coach coach = new Coach(
                getName(),
                getSurname(),
                getCoachAge(),
                getNationalityFromFaker(),
                Randomizer.pickOne(Module.values())
        );
        coach.setSkill(getSkillValue());
        return coach;
    }

    private static int getSkillValue() {
        return Randomizer.intVal(31, 98);
    }

    public static ArrayList<Player> geForeignPlayers(int limit) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            players.add(getPlayer(getNationality()));
        }
        return players;
    }

    public static ArrayList<Player> getPlayers(int limit) {
        ArrayList<Player> players = new ArrayList<>();
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

    public static Player getPlayer(Nationality nationality) {
        setFaker(nationality.getNationCode());
        Player player = getPlayer();
        setFaker(FALLBACK_LOCALE);
        return player;
    }

    public static Player getPlayer() {
        Player player = new Player(
                getName(),
                getSurname(),
                getPlayerAge(),
                getNationalityFromFaker(),
                Randomizer.pickOne(Position.values())
        );

        player.setSkill(getSkillValue());
        return player;
    }

    public static Player getPlayer(Position position) {
        Player player = getPlayer();
        player.setPosition(position);
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

    private static Nationality getNationalityFromFaker() {
        return Nationality.valueOf(faker.getLocale().toUpperCase());
    }
}
