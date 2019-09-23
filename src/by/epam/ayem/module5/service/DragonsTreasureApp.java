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

import by.epam.ayem.module5.model.TreasureHouse;

import java.util.Scanner;

public class DragonsTreasureApp {

    private static Scanner scanner = new Scanner(System.in);
    private static TreasureHouseService treasureHouseService = new TreasureHouseService();

    public void run() {

        TreasureHouse treasureHouse = new TreasureHouse();
        treasureHouseService.fillTreasureHouse(treasureHouse);

        boolean quit = false;

        while (!quit) {
            System.out.println("\nPlease, enter a number: \n" +
                    "1. Show all the treasures.\n" +
                    "2. Show the most expensive treasure.\n" +
                    "3. Get treasures amounting to ... \n" +
                    "0. Quit. \n");

            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            int choice = scanner.nextInt();
            scanner.hasNextLine();

            switch (choice) {
                case 1:
                    treasureHouseService.readTreasures(treasureHouse);
                    break;
                case 2:
                    treasureHouseService.findMostExpensiveTreasure(treasureHouse);
                    break;
                case 3:
                    treasureHouseService.findTreasuresAmountingTo(treasureHouse);
                    break;
                case 0:
                    quit = true;
            }
        }
    }
}
