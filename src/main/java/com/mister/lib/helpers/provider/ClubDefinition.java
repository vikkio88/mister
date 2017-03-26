package com.mister.lib.helpers.provider;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ClubDefinition {
    FC("%s FC"),
    AS("AS %s"),
    AC("AC %s"),
    CITY("%s City"),
    SPORTING("Sporting %s"),
    CALCIO("%s Calcio"),
    CITTA_DI("Città di %s"),
    POLISPORTIVA("Polisportiva %s"),
    REAL("Real %s"),
    JUVE("Juve%s"),
    EMPTY("");

    private static final List<ClubDefinition> DEFINITION_LIST = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = DEFINITION_LIST.size();
    private static final Random RANDOM = new Random();
    private String clubDefinition;

    ClubDefinition(String clubDefinition) {
        this.clubDefinition = clubDefinition;
    }

    public static ClubDefinition getRandom() {
        return DEFINITION_LIST.get(RANDOM.nextInt(SIZE));
    }

    public String getClubDefinition(String cityName) {
        return String.format(clubDefinition, cityName);
    }
}
