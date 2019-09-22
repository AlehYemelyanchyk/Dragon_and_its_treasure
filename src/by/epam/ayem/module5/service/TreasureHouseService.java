package by.epam.ayem.module5.service;

import by.epam.ayem.module5.model.Reader;
import by.epam.ayem.module5.model.Treasure;
import by.epam.ayem.module5.model.TreasureHouse;
import by.epam.ayem.module5.model.Writer;

import java.util.List;
import java.util.Random;

public class TreasureHouseService {

    private Reader reader = new Reader();
    private Writer writer = new Writer();
    private Random random = new Random();

    public void getTreasuresAmountingTo(TreasureHouse treasureHouse, double worth) {
        double totalAmount = 0.0;
        double left = worth;
        System.out.println("Treasures amounting to " + worth + ":");

        while (!treasureHouse.getTreasures().isEmpty() && totalAmount <= worth
                && left >= getLeastExpensiveTreasure(treasureHouse).getTreasureCost()) {
            int index = random.nextInt(treasureHouse.getTreasures().size());

            if (left >= treasureHouse.getTreasures().get(index).getTreasureCost()) {
                totalAmount += treasureHouse.getTreasures().get(index).getTreasureCost();
                left = worth - totalAmount;
                System.out.println(treasureHouse.getTreasures().get(index).toString());
                treasureHouse.getTreasures().remove(index);
            }
        }

        System.out.println("Total worth = " + String.format("%.2f", totalAmount));
    }

    private Treasure getLeastExpensiveTreasure(TreasureHouse treasureHouse) {
        double leastExpensive = Double.MAX_VALUE;
        Treasure leastExpensiveItem = null;

        for (Treasure item : treasureHouse.getTreasures()) {
            if (item.getTreasureCost() < leastExpensive) {
                leastExpensive = item.getTreasureCost();
                leastExpensiveItem = item;
            }
        }
        return leastExpensiveItem;
    }

    public void showMostExpensiveTreasure(TreasureHouse treasureHouse) {
        double mostExpensive = 0;
        Treasure mostExpensiveItem = null;

        for (Treasure item : treasureHouse.getTreasures()) {
            if (item.getTreasureCost() > mostExpensive) {
                mostExpensive = item.getTreasureCost();
                mostExpensiveItem = item;
            }
        }
        if (mostExpensiveItem != null) {
            System.out.println("The most expensive item is " + mostExpensiveItem.toString());
        } else {
            System.out.println("There is no such item");
        }
    }

    public void readTreasures(TreasureHouse treasureHouse) {
        treasureHouse.setTreasures(reader.readObjectsFromFile(treasureHouse.getFileName()));
        showTreasures(treasureHouse.getTreasures());
    }

    private void showTreasures(List<Treasure> treasures) {
        for (Treasure item : treasures) {
            System.out.println((treasures.indexOf(item) + 1) + ". " + item.toString());
        }
    }

    public void fillTreasure(TreasureHouse treasureHouse) {
        fillTreasure(treasureHouse, new Treasure());
    }

    private void fillTreasure(TreasureHouse treasureHouse, Treasure treasure) {
        while (treasureHouse.getTreasures().size() < 100) {
            treasureHouse.getTreasures().add(new Treasure());
            fillTreasure(treasureHouse, new Treasure());
        }
        // I need this method invoke here to fill the treasure.txt file in the first place.
//        writer.writeObjectsToFile(treasureHouse);
    }
}
