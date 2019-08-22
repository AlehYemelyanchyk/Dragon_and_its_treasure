package by.epam.ayem.main;

import java.util.Random;

public enum TreasureTypes {

    SAPPHIRE(2.5, "Sapphire"), RUBY(3.8, "Ruby"),
    AMETHYST(2.1, "Amethyst"), DIAMOND(4.0, "Diamond"),
    TOPAZ(1.7, "Topaz"), GOLD_POT(1.5, "Pot with gold"),
    SILVER_POT(0.7, "Pot with silver");

    private double priceForKilo;
    private String readableName;

    private static Random random = new Random();

    TreasureTypes(double priceForKilo, String readableName) {
        this.priceForKilo = priceForKilo;
        this.readableName = readableName;
    }

    public static TreasureTypes getRandom() {
        int index = random.nextInt(values().length);
        return values()[index];
    }

    public double getPriceForKilo() {
        return priceForKilo;
    }

    public String getReadableName() {
        return readableName;
    }
}
