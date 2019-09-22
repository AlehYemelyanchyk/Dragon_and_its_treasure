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

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Writer {

    final static Logger logger = Logger.getLogger("Writer.class");

    public void writeObjectsToFile(TreasureHouse treasureHouse) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(treasureHouse.getFileName())))) {
            for (Treasure treasure : treasureHouse.getTreasures()) {
                out.writeObject(treasure);
            }
        } catch (IOException e) {
            logger.info("IOException");
        }
    }
}
