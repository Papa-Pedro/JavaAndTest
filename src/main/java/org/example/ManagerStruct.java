package org.example;

import java.util.*;

public class ManagerStruct {


    {
        System.out.println("""
                It's chapter about operators
                Choose issue:
                1 - notEvenAndSeven
                2 - evenAndSix
                3 - maxAmong
                4 - stars 
                5 - direction player
                """);
    }

    public static void chooseIssue() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1" -> defineNotEvenAndSeven();
            case "2" -> defineEvenAndSix();
            case "3" -> defineMaxNumber();
            case "4" -> printStars();
            case "5" -> directionPlayer();
            default -> System.out.println("Yor input wrong symbol");
        }
        scanner.close();
    }

    public static void directionPlayer(){
        String[] inputArrayString = readStringArray();
        int x = inputArrayString.length > 0 ? Integer.parseInt(inputArrayString[0]) : 0;
        int y = inputArrayString.length > 1 ? Integer.parseInt(inputArrayString[1]) : 0;
        String direction = inputArrayString[2];
        switch (direction) {
            case "up"    -> y -= 1;
            case "down"  -> y += 1;
            case "left"  -> x -= 1;
            case "right" -> x += 1;
        }
        System.out.println(String.format("x: %d, y: %d, direction: %s", x, y, direction));
    }

    public static void printStars(){
        int amount = readInput();
        String result = "★".repeat(amount);
        System.out.println(result);
    }

    /**
     * Define max element among x1, x2 and x3
     * writhe in inside variable result
     */
    public static void defineMaxNumber() {
        int[] arrayOfX = readInputArray();
        int max = Arrays.stream(arrayOfX).max().orElseThrow();
        int min = Arrays.stream(arrayOfX).min().orElseThrow();
        String result = String.format("минимальное: %d, максимальное: %d", min, max);
        System.out.println(result);
    }

    public static void defineEvenAndSix(){
        int n = readInput();
        boolean result = (n % 2 == 0 && n % 6 == 0);
        System.out.println(result);
    }

    public static void defineNotEvenAndSeven(){
        int n = readInput();
        boolean result = (n % 2 != 0 && n % 7 == 0);
        System.out.println(result);
    }

    private static int readInput(){
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            n = Integer.parseInt(scanner.nextLine());
        }
        scanner.close();
        return n;
    }

    private static int[] readInputArray(){
        Scanner scanner = new Scanner(System.in);
        int[] input = new int[0];
        if (scanner.hasNextLine()) {
            input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        scanner.close();
        return  input;
    }

    public static String[] readStringArray() {
        String[] inputValues = new String[3];

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] values = input.split(" ");
            for (int i = 0; i < 3; i++) {
                inputValues[i] = values[i];
            }
        }
        scanner.close();

        return inputValues;
    }

}
