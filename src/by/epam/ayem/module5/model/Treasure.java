package by.epam.ayem.module5.model;

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
        this.treasureCost = random.nextDouble() * weight;
    }

    @Override
    public String toString() {
        return treasureTypes + ": " + String.format("%.2f", weight)
                + " kg, cost " + String.format("%.2f", treasureCost) + '.';
    }

    public double getTreasureCost() {
        return treasureCost;
    }

    public void setTreasureCost(double treasureCost) {
        this.treasureCost = treasureCost;
    }
}
