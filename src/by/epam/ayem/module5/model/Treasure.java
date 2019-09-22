package by.epam.ayem.module5.model;



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

import java.io.Serializable;
import java.util.Random;

public class Treasure implements Serializable {

    private final TreasureTypes treasureTypes;
    private final double weight;
    private final double treasureCost;

    private static Random random = new Random();

    public Treasure() {
        this.treasureTypes = TreasureTypes.getRandom();
        this.weight = random.nextDouble() * 10;
        this.treasureCost = random.nextDouble() * weight;
    }

    public double getTreasureCost() {
        return treasureCost;
    }

    public TreasureTypes getTreasureTypes() {
        return treasureTypes;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return treasureTypes + ": " + String.format("%.2f", weight)
                + " kg, cost " + String.format("%.2f", treasureCost) + '.';
    }
}
