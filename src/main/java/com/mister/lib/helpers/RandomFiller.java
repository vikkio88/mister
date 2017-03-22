package com.mister.lib.helpers;

import java.util.Random;

public class RandomFiller {
    Random random;

    public RandomFiller() {
        this.random = new Random();
    }

    public int rand(int high) {
        return random.nextInt(high);
    }
}
