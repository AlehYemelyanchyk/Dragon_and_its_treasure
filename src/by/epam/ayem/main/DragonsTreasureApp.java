package by.epam.ayem.main;

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

import java.util.Scanner;

public class DragonsTreasureApp {

    public void run() {

        Scanner scanner = new Scanner(System.in);

        TreasureHouse treasureHouse = new TreasureHouse();
        treasureHouse.fillTreasure();

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
                    treasureHouse.showTreasures();
                    break;
                case 2:
                    treasureHouse.showMostExpensiveTreasure();
                    break;
                case 3:
                    System.out.println("Please, enter the worth of the treasures: ");

                    while (!scanner.hasNextDouble()) {
                        scanner.next();
                        System.out.println("Please, use an number.");
                    }

                    double worth = scanner.nextDouble();
                    treasureHouse.getTreasuresAmountingTo(worth);
                    break;
                case 0:
                    quit = true;
            }
        }
    }
}
