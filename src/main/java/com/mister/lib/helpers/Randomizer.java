package com.mister.lib.helpers;

import java.util.Random;

public class Randomizer {
    static Random random = new Random();

    public static int intVal(int high) {
        return random.nextInt(high);
    }

    public static int intVal(int low, int high) {
        return intVal((high - low) + 1) + low;
    }

    public static boolean chance(int percentage) {
        return intVal(100) < percentage;
    }
}
