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
                5 - direction player inside square
                6 - Number is negative""");
    }

    //Структура для работы со строкой ввода в три символа.
    public record TrioString(String first, String second, String third) {};

    public static void chooseIssue() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1" -> defineNotEvenAndSeven();
            case "2" -> defineEvenAndSix();
            case "3" -> defineMaxNumber();
            case "4" -> printStars();
            case "5" -> directionPlayer();
            case "6" -> defineNumberIsNegative();
            default -> System.out.println("Yor input wrong symbol");
        }
        scanner.close();
    }

    /**
     * input a number n
     * if n positive result = "Число позитивное"
     * if n negative result = "Число негативное"
     * if n equal 0 result = "Число равно 0"
     * result it's variable which print
     */
    public static void defineNumberIsNegative(){
        int n = readInput();
        String result = "";
        //Integer.signum(n) возвращает знак числа
        result = switch (Integer.signum(n)) {
            case  1 -> "Число позитивное";
            case -1 -> "Число негативное";
            case  0 -> "Число равно 0";
            default -> throw new IllegalStateException("Непредвиденная ситуация");
        };
        System.out.println(result);
    }

    public static void directionPlayer(){
        //берем все три введенные символа в массиве
        TrioString input = readTrioString();
        //мы уверены что у нас не пустая строка и введено три символа
        //нам надо убедиться только что это числа
        int x, y;
        try {
            x = Integer.parseInt(input.first());
            y = Integer.parseInt(input.second());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Первые два элемента должны быть числом");
        }

        String direction = input.third();
        //В случае если направление не важно выводим другую ошибку
        switch (direction) {
            case "up"    -> { if (y > 0) y -= 1; }
            case "down"  -> { if (y < 100) y += 1; }
            case "left"  -> { if (x > 0) x -= 1; }
            case "right" -> { if (x < 100) x += 1; }
            default -> throw new IllegalArgumentException("Направление может быть только ud, down, left или right а не " + direction);
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
            try {
                n = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Введенный символ должен быть числом");
            }
        }
        scanner.close();
        return n;
    }

    private static TrioString readTrioString(){
        Scanner scanner = new Scanner(System.in);
        //trim() - удаляет лишние пробелы.
        String line = scanner.nextLine().trim();
        //isBlank() - проверяет строку на пустоту, если пустая бросается исключние
        //Строки с одними пробелма, перводами строки и прочими символами isBlank тоже считает пустыми
        if (line.isBlank()) {
            throw new IllegalArgumentException("Нужно ввести три значения через пробел");
        }
        //Строка разибивает на массив из limit (3) строк, по символу \\s+ (один или множество пробелов)
        //Таким образом мы можем ввести не только "100 0 up"
        //но и "100     0    up", это все будет валидным
        String[] parts = line.split("\\s+", 3);
        //Если колличество элементов меньше трех, тогда бросаем исключение
        if (parts.length < 3) {
            throw new IllegalArgumentException(
                    "Ожидалось 3 значения, а введено: " + parts.length
            );
        }
        return new TrioString(parts[0], parts[1], parts[2]);
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
