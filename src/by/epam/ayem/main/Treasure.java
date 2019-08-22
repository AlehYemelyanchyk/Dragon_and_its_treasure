package by.epam.ayem.main;

/*Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
Реализовать возможность просмотра сокровищ, выбора самого дорогого по смоимости сокровища и выбора сокровищ
на заданную сумму.*/

import java.util.Random;

public class Treasure {

    private TreasureTypes treasureTypes;
    private double weight;
    private double treasureCost;

    private static Random random = new Random();

    public Treasure() {
        this.treasureTypes = TreasureTypes.getRandom();
        this.weight = random.nextDouble() * 10;
        this.treasureCost = treasureTypes.getPriceForKilo() * weight;
    }

    @Override
    public String toString() {
        return treasureTypes.getReadableName() + ": " + String.format("%.2f", weight)
                + " kg, cost " + String.format("%.2f", treasureCost) + '.';
    }

    public TreasureTypes getTreasureTypes() {
        return treasureTypes;
    }

    public void setTreasureTypes(TreasureTypes treasureTypes) {
        this.treasureTypes = treasureTypes;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTreasureCost() {
        return treasureCost;
    }

    public void setTreasureCost(double treasureCost) {
        this.treasureCost = treasureCost;
    }
}
