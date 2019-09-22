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

public class Treasure implements Serializable {

    private TreasureTypes treasureTypes;
    private double weight;
    private double treasureCost;

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

    @Override
    public String toString() {
        return treasureTypes + ": " + String.format("%.2f", weight)
                + " kg, cost " + String.format("%.2f", treasureCost) + '.';
    }
}
