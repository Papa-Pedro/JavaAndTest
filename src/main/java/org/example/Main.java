package org.example;


import java.io.PrintStream;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PrintStream outStream = System.out;
        //Создаём объект, который знает, как читать и писать
        LessonSelection service = new LessonSelection(scanner, outStream);
        //запускаем прогу
        service.run();

        scanner.close();

    }
}