package by.epam.ayem.module5.service;

import by.epam.ayem.module5.model.Treasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
Реализовать возможность просмотра сокровищ, выбора самого дорогого по смоимости сокровища и выбора сокровищ
на заданную сумму.*/

public class TreasureHouse {

    private List<Treasure> treasures;
    private Random random = new Random();

    public TreasureHouse() {
        treasures = new ArrayList<>();
    }

    public void getTreasuresAmountingTo(double worth) {
        double totalAmount = 0.0;
        double left = worth;
        System.out.println("Treasures amounting to " + worth + ":");

        while (!treasures.isEmpty() && totalAmount <= worth && left >= getLeastExpensiveTreasure().getTreasureCost()) {
            int index = random.nextInt(treasures.size());

            if (left >= treasures.get(index).getTreasureCost()) {
                totalAmount += treasures.get(index).getTreasureCost();
                left = worth - totalAmount;
                System.out.println(treasures.get(index).toString());
                treasures.remove(index);
            }
        }

        System.out.println("Total worth = " + String.format("%.2f", totalAmount));
    }

    private Treasure getLeastExpensiveTreasure() {
        double leastExpensive = Double.MAX_VALUE;
        Treasure leastExpensiveItem = null;

        for (Treasure item : treasures) {
            if (item.getTreasureCost() < leastExpensive) {
                leastExpensive = item.getTreasureCost();
                leastExpensiveItem = item;
            }
        }
        return leastExpensiveItem;
    }

    public void showMostExpensiveTreasure() {
        double mostExpensive = 0;
        Treasure mostExpensiveItem = null;

        for (Treasure item : treasures) {
            if (item.getTreasureCost() > mostExpensive) {
                mostExpensive = item.getTreasureCost();
                mostExpensiveItem = item;
            }
        }
        System.out.println("The most expensive item is " + mostExpensiveItem.toString());
    }

    public void showTreasures() {
        for (Treasure item : treasures) {
            System.out.println((treasures.indexOf(item) + 1) + ". " + item.toString());
        }
    }

    public void fillTreasure(Treasure... treasure) {
        while (treasures.size() < 100) {
            treasures.add(new Treasure());
            fillTreasure(new Treasure());
        }
    }
}
