package org.example;

import java.util.Scanner;

public class Operators {

    {
       System.out.println("""
                It's chapter about operators
                Choose issue:
                1 - Additional
                2 - Multiply
                3 - Subtraction
                4 - Division
                5 - Remainder by division
                6 - Seconds per minutes
                7 - Seconds per Hours
                8 - Number was even
                9 - Additional and subtraction
                10 - Multiply and division
                11 - Equal two number
                12 - ResultMyRole
                13 - GroupAge""");
    }

    public static void chooseIssue(){
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1" -> additionalTwoNumber();
            case "2" -> multiplyTwoNumber();
            case "3" -> subtractionTwoNumber();
            case "4" -> divisionTwoNumber();
            case "5" -> remainderByDivision();
            case "6" -> translateMinPerSec();
            case "7" -> translateSecPerHours();
            case "8" -> decideEvenOrNot();
            case "9" -> doAdditionalOrSubtraction();
            case "10" -> doMultiplyOrDivision();
            case "11" -> equalTwoNumber();
            case "12" -> resultMyRole();
            case "13" -> defineGroupAge();
            default -> System.out.println("Yor input wrong symbol");
        }
        scanner.close();
    }

    /**
     * define age group, if more 18 print "взрослый" else "подросток"
     */
    public static void defineGroupAge(){
        int age = readNumber();
        String result = "";
        result = age >= 18 ? "взрослый" : "подросток";
        System.out.println(result);
    }

    /**
     * You have param name role, depending from value print
     * 1 - admin
     * 2 — moderator
     * 3 — user
     * default — guest
     */
    public static void resultMyRole() {
        int role = readNumber();
        String result = "";
        result = switch (role)
                {
                    case 1 -> "admin";
                    case 2 -> "moderator";
                    case 3 -> "user";
                    default -> "guest";
                };
        System.out.println(result);
    }

    /**
     * equal number x and y (int)
     * and print true is equal, else false
     */
    public static void equalTwoNumber(){
        int x, y;
        boolean result = false;
        int[] inputValues = readInput();
        x = inputValues[0];
        y = inputValues[1];
        if (x == y) result = true;
        System.out.println(result);
    }

    public static void doMultiplyOrDivision(){
        int x, y;
        String op;
        String[] inputValues = readString();
        x = Integer.parseInt(inputValues[0]);
        op = inputValues[1];
        y = Integer.parseInt(inputValues[2]);
        //System.out.println(String.format("%s %s %s", x, op, y));
        switch (op) {
            case "x" -> System.out.println((x * y));
            case "/" -> {
                if (y == 0) throw new ArithmeticException("Деление на ноль");
                if (x % y == 0) System.out.println(x / y);
                else System.out.println((double) x / y);
            }
            case "", " " -> System.out.println(0);
            default -> throw new IllegalArgumentException("Не разрешенная операция" + op);
        }
    }

    public static void doAdditionalOrSubtraction(){
        int x, y;
        String op;
        int result = 0;

        String[] inputValues = readString();
        x = Integer.parseInt(inputValues[0]);
        op = inputValues[1];
        y = Integer.parseInt(inputValues[2]);
        switch (op) {
            case "+" -> result = x + y;
            case "-" -> result = x - y;
        }
        System.out.println(result);
    }

    public static void decideEvenOrNot(){
        int num = readNumber();
        String result = "";
        if (num % 2 == 0) result = "четное";
        else result = "нечетное";
        System.out.println(result);
    }

    public static void translateSecPerHours(){
        int hours = readNumber();
        int result = 0;
        int secPerHouse = 3600;
        result = hours * secPerHouse;
        System.out.println(result);
    }

    public static void translateMinPerSec(){
        int minutes = readNumber();
        int result = 0;
        result = minutes * 60;
        System.out.println(result);
    }

    public static void remainderByDivision(){
        int x, y, result;
        int[] inputValues = readInput();
        x = inputValues[0];
        y = inputValues[1];
        result = x % y;
        System.out.println(result);
    }

    public static void divisionTwoNumber(){
        int x, y;
        int[] inputValues = readInput();
        x = inputValues[0];
        y = inputValues[1];

        if (y == 0) throw new ArithmeticException("Деление на ноль");
        if (x % y == 0) System.out.println(x / y);
        else System.out.println((double) x / y);

    }

    public static void subtractionTwoNumber() {
        int x, y, result;
        int[] inputValues = readInput();
        x = inputValues[0];
        y = inputValues[1];
        result = x - y;
        System.out.println(result);
    }

    public static void multiplyTwoNumber() {
        int x, y, result;
        int[] inputValue = readInput();
        x = inputValue[0];
        y = inputValue[1];
        result = x * y;
        System.out.println(result);
    }

    public static void additionalTwoNumber(){
        int x, y, result;
        int[] inputValues = readInput();
        x = inputValues[0];
        y = inputValues[1];
        result = x + y;
        System.out.println(result);
    }

    public static int[] readInput() {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        scanner.close();

        String[] values = inputLine.split(" ");
        int[] result = new int[2];
        result[0] = Integer.parseInt(values[0]);
        result[1] = Integer.parseInt(values[1]);
        return result;
    }

    public static int readNumber() {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            number = Integer.parseInt(scanner.nextLine());
        }
        scanner.close();
        return number;
    }

    public static String[] readString() {
        String[] inputValues = new String[3];

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            inputValues = input.split(" ");
        }
        scanner.close();

        return inputValues;
    }

}
