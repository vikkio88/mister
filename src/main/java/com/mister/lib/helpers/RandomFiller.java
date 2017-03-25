package com.mister.lib.helpers;

import java.util.Random;

public class RandomFiller {
    static Random random = new Random();

    public static int rand(int high) {
        return random.nextInt(high);
    }

    public static int rand(int low, int high) {
        return rand((high - low) + 1) + low;
    }

    public static int finance() {
        if (chance(20)) {
            return rand(10, 50);
        }

        return rand(1, 20);
    }

    public static boolean chance(int percentage) {
        return rand(100) < percentage;
    }
}
