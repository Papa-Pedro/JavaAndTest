package org.example;

import java.io.PrintStream;
import java.security.KeyPair;
import java.util.Scanner;

public class Basis {

    private final Scanner scanner;
    private final PrintStream out;

    public Basis(Scanner scanner, PrintStream out){
        this.scanner = scanner;
        this.out = out;
    }

    {
        System.out.println("""
                It's chapter about basis
                Choose issue:
                1 - Variable
                2 - Concatenation
                3 - Concatenation and multiply on 2
                4 - Concatenation and bonus""");
    }

    public void chooseIssue() {
        String line = scanner.nextLine().trim();
        switch (line) {
            case "1" -> {
                String message = InputRead.readString(scanner);
                String result = "";
                result = message;
                System.out.println(result);
            }
            case "2" -> printWithDeleteSeparation(scanner, out);
            case "3" -> concatenationAndMultiply(scanner, out);
            default -> System.out.println("Yor input wrong symbol");
        }
    }

    //Concatenation with split at " \\| "
    public static void printWithDeleteSeparation(Scanner scanner, PrintStream out) {
        String[] inputMessages = InputRead.readString(scanner, out).split(" \\| ");
        String message1, message2;
        message1 = inputMessages[0];
        message2 = inputMessages[1];
        String result = String.format("%s %s", message1, message2);
        out.println(result);
    }

    /**
     * Concatenation 2 variables (message and score),
     * split by  " \\| " and multiply score on 2
     */
    public static void concatenationAndMultiply(Scanner scanner, PrintStream out){
        String[] inputValue = InputRead.readString(scanner, out).split(" \\| ");
        String message = inputValue[0];
        int score = Integer.parseInt(inputValue[1]);
        String result = String.format("%s %d", message, score * 2 );
        out.println(result);
    }

    /**
     * Concatenation 2 variables (message and score),
     * split by  " \\| " and multiply score on bonus
     */
    public static void concatenationAndBonus(Scanner scanner, PrintStream out){
        String message;
        int score, bonus;
        String[] inputValue = InputRead.readString(scanner, out).split(" \\| ");
        message = inputValue[0];
        score = Integer.parseInt(inputValue[1]);
        bonus = Integer.parseInt(inputValue[2]);
        String result = message + " " + score * bonus;
        out.println(result);
    }

}
