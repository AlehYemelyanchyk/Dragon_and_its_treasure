package by.epam.ayem.module5;

/*Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
Реализовать возможность просмотра сокровищ, выбора самого дорогого по смоимости сокровища и выбора сокровищ
на заданную сумму.*/

import by.epam.ayem.module5.service.DragonsTreasureApp;

public class AppRunner {
    public static void main(String[] args) {
        new DragonsTreasureApp().run();
    }
}
