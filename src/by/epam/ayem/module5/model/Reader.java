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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Reader {

    final static Logger logger = Logger.getLogger("Reader.class");

    public List<Treasure> readObjectsFromFile(String fileName) {
        List<Treasure> treasures = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            while (true) {
                Treasure treasure = (Treasure) in.readObject();
                treasures.add(treasure);
            }
        } catch (EOFException e) {
            logger.info("File has been ended");
        } catch (ClassNotFoundException e) {
            logger.info("Class not found");
        } catch (IOException e) {
            logger.info("IOException");
        }
        return treasures;
    }
}
