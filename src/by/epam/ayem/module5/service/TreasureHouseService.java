package by.epam.ayem.module5.service;

/*Задача 4.
Создать консольное приложение, удовлетворяющее следующим требованиям:
1) Приложение должно быть объектно-, а не процедурно-ориентированным.
2) Каждый класс должен иметь отражающее смысл название и информативный состав.
3) Наследование должно применяться только тогда, когда это имеет смысл.
4) При кодировании должны быть использованы соглашения об оформления кода java code convention.
5) Классы должны быть грамотно разложены по пакетам.
7) Консольное меню должно быть минимальным.
8) Для хранения данных можно использовать файлы.

Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
Реализовать возможность просмотра сокровищ, выбора самого дорогого по смоимости сокровища и выбора сокровищ
на заданную сумму.*/

import by.epam.ayem.module5.model.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TreasureHouseService {

    private Scanner scanner = new Scanner(System.in);
    private Reader reader = new Reader();
    private Writer writer = new Writer();
    private Random random = new Random();
    private final static String FILE_NAME = "treasures.txt";

    public void findTreasuresAmountingTo(TreasureHouse treasureHouse) {
        System.out.println("Please, enter the worth of the treasures: ");

        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.println("Please, use a number.");
        }

        double worth = scanner.nextDouble();
        double totalAmount = 0.0;
        double left = worth;
        System.out.println("Treasures amounting to " + worth + ":");


        if (!treasureHouse.getTreasures().isEmpty()) {
            double leastExpensiveTreasure = findLeastExpensiveTreasure(treasureHouse).getTreasureCost();

            while (left >= leastExpensiveTreasure && !treasureHouse.getTreasures().isEmpty()) {
                int index = random.nextInt(treasureHouse.getTreasures().size());

                if (left >= treasureHouse.getTreasures().get(index).getTreasureCost()) {
                    totalAmount += treasureHouse.getTreasures().get(index).getTreasureCost();
                    left = worth - totalAmount;
                    System.out.println(treasureHouse.getTreasures().get(index));
                    treasureHouse.getTreasures().remove(index);
                }
            }
            System.out.println("Total worth = " + String.format("%.2f", totalAmount));
        } else {
            System.out.println("The treasure house is empty");
        }

    }

    private Treasure findLeastExpensiveTreasure(TreasureHouse treasureHouse) {
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


    public void findMostExpensiveTreasure(TreasureHouse treasureHouse) {
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
        treasureHouse.setTreasures(reader.readObjectsFromFile(FILE_NAME));
        showTreasures(treasureHouse.getTreasures());
    }

    private void showTreasures(List<Treasure> treasures) {
        for (Treasure item : treasures) {
            System.out.println((treasures.indexOf(item) + 1) + ". " + item.toString());
        }
    }

    public void fillTreasureHouse(TreasureHouse treasureHouse) {
        while (treasureHouse.getTreasures().size() < 100) {
            treasureHouse.getTreasures().add(createRandomTreasure());
        }
        writer.writeObjectsToFile(treasureHouse, FILE_NAME);
    }

    private Treasure createRandomTreasure() {
        Treasure treasure = new Treasure();

        int index = random.nextInt(TreasureTypes.values().length);

        treasure.setTreasureTypes(TreasureTypes.values()[index]);
        treasure.setTreasureCost((random.nextDouble() * 10) + 1);
        treasure.setWeight(random.nextDouble());

        return treasure;
    }
}
