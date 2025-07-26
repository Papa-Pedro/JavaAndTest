package org.example;

import org.example.managerStruct.InputRead;
import org.example.managerStruct.ManagerStruct;
import resourse.LessonOptions;

import java.io.PrintStream;
import java.util.Scanner;

public class LessonSelection {

    /**
     * System.in будт создавать в Main и передавать дальше
     * так тестам легче работать с ByteArrayInputStream и ByteArrayOutputStream
     */
    private final Scanner scanner;
    private final PrintStream out;

    public LessonSelection(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("""
                Choose lesson from stepic "Java Тренажер"
                1 - Basis
                2 - Operators
                3 - Manager structure
                0 - Exit""");
            String line = scanner.nextLine().trim();

            LessonOptions opt = LessonOptions.from(line);
            if (opt == null) {
                out.println("Неправильный ввод");
            } else if (opt == LessonOptions.EXIT) {
                running = false;
            } else {
                opt.execute(scanner, out);
            }
        }
    }
}
