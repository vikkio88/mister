package com.mister.lib.helpers;

import java.util.Random;

public class RandomFiller {
    public static int finance() {
        if (Randomizer.chance(20)) {
            return Randomizer.intVal(10, 50);
        }
        return Randomizer.intVal(1, 20);
    }
}
