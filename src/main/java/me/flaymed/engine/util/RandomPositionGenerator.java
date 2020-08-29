package me.flaymed.engine.util;

import java.util.Random;

public class RandomPositionGenerator {

    public static int generateRandomValue(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

}
