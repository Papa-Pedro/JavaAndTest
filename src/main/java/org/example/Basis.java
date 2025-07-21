package org.example;

import java.util.Scanner;

public class Basis {

    {
        System.out.println("""
                It's chapter about basis
                Choose issue:
                1 - Variable
                2 - Concatenation""");
    }

    public static void chooseIssue(){
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1" -> {
                String message = readInput();
                String result = "";
                result = message;
                System.out.println(result);
            }
            case "2" -> printWithDeleteSeparation();
            default -> System.out.println("Yor input wrong symbol");
        }
        scanner.close();
    }

    //Concatenation with split at " \\| "
    public static void printWithDeleteSeparation() {
        String[] inputMessages = readInput().split(" \\| ");
        String message1, message2;
        message1 = inputMessages[0];
        message2 = inputMessages[1];
        String result = String.format("%s %s", message1, message2);
        System.out.println(result);
    }

    /**
     * Function for read inside console
     * @return nextLine
     */
    public static String readInput(){
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        scanner.close();
        return inputLine;
    }
}
