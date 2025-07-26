package org.example.managerStruct;

import resourse.Pair;
import resourse.Trio;

import java.io.PrintStream;
import java.util.*;

public class ManagerStruct {

    private final Scanner scanner;
    private final PrintStream out;

    public ManagerStruct(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    //Точка входа, вызывается из Main
    public void chooseIssue() {
        System.out.println("""
                It's chapter about operators
                Choose issue:
                1 - notEvenAndSeven
                2 - evenAndSix
                3 - maxAmong
                4 - stars 
                5 - direction player inside square
                6 - Number is negative
                7 - Sum all not even number unit the number
                8 - Multiply all not even number unit the number""");
        //Словарь «код → действие»
        String key = scanner.nextLine().trim();
        Map<String, Runnable> command = Map.of(
                "1", ManagerStruct::defineNotEvenAndSeven,
                "2", ManagerStruct::defineEvenAndSix,
                "3", ManagerStruct::defineMaxNumber,
                "4", ManagerStruct::printStars,
                "5", ManagerStruct::directionPlayer,
                "6", ManagerStruct::defineNumberIsNegative,
                "7", ManagerStruct::sumAllNotEvenNumber,
                "8", ManagerStruct::multiplyOddUpTo
        );
        // Запускаем нужное действие или ругаемся
        command.getOrDefault(key, () -> System.out.println("Wrong symbol")).run();
    }

    /**
     * Need calculate multiply all not even number
     * until the number n, it has not even.
     * @throws InterruptedException если n < 1
     */
    public static void multiplyOddUpTo(){
        int n = InputRead.readInt();
        if (n < 1) throw new IllegalArgumentException("Число для удовлетворения условий должно быть больше 1");
        System.out.println(CalculateManagerStruct.calculateMultiplyOddUpTo(n));
    }

    /**
     * Need calculate sum all not even number
     * until the number n, it has not even.
     */
    public static void sumAllNotEvenNumber(){
        int n = InputRead.readInt();
        if (n % 2 == 0) throw new IllegalArgumentException("Введенная переменная должна быть четной");
        System.out.println(CalculateManagerStruct.calculateSumAllNotEvenNumber(n));
    }

    /**
     * input a number n
     * if n positive result = "Число позитивное"
     * if n negative result = "Число негативное"
     * if n equal 0 result = "Число равно 0"
     * result it's variable which print
     */
    public static void defineNumberIsNegative(){
        int n = InputRead.readInt();
        System.out.println(CalculateManagerStruct.calculateDefineNumberIsNegative(n));
    }

    public static void directionPlayer(){
        //берем все три введенные символа в массиве
        Trio<String, String, String> input = InputRead.readTrioString();
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
        Pair pair = CalculateManagerStruct.calculateDirectionPlayer(x, y , direction);
        System.out.println(String.format(
                "x: %d, y: %d, direction: %s",
                pair.first(), pair.second(), direction));
    }

    public static void printStars(){
        int amount = InputRead.readInt();
        String result = "★".repeat(amount);
        System.out.println(result);
    }

    /**
     * Define max element among x1, x2 and x3
     * writhe in inside variable result
     */
    public static void defineMaxNumber() {
        int[] arrayOfX = InputRead.readInputArray();//readInputArray();
       /* int max = Arrays.stream(arrayOfX).max().orElseThrow();
        int min = Arrays.stream(arrayOfX).min().orElseThrow();
        String result = String.format("минимальное: %d, максимальное: %d", min, max);*/
        System.out.println(CalculateManagerStruct.calculateDefineMaxNumber(arrayOfX));
    }

    public static void defineEvenAndSix(){
        int n = InputRead.readInt();
        boolean result = (n % 2 == 0 && n % 6 == 0);
        System.out.println(result);
    }

    public static void defineNotEvenAndSeven(){
        int n = InputRead.readInt();
        boolean result = (n % 2 != 0 && n % 7 == 0);
        System.out.println(result);
    }

}
