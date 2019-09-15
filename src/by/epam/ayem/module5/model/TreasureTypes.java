package by.epam.ayem.module5.model;

import java.util.Random;

public enum TreasureTypes {

    SAPPHIRE, RUBY, AMETHYST, DIAMOND, TOPAZ, SILVER_POT;

    private static Random random = new Random();

    public static TreasureTypes getRandom() {
        int index = random.nextInt(values().length);
        return values()[index];
    }
}
