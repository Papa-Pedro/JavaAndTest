package org.example.managerStruct;

import resourse.Pair;

import java.util.Arrays;
import java.util.Scanner;

public final class CalculateManagerStruct {
    //для того что бы нельзя было создать экземпляр, все функции вызываются напрямую
    private CalculateManagerStruct(){}

    public static StringBuilder hiddenWord(int length) {
        return new StringBuilder()
                .append("*".repeat(length));
    }

    public static int calculateSumEvenNumber(int number) {
        return (int) (Math.pow(number, 2) / 4 + number / 2);
    }

    public static int calculateMultiplyOddUpTo(int number) {
       // System.out.println(number);
        int result = 1;
        for (int i = (number % 2 == 0) ? --number: number; i > 0; i -= 2) result *= i;
        return  result;
    }

    public static int calculateSumAllNotEvenNumber(int number) {
        int result = 0;
        while (number > 0) {
            result += number;
            number -= 2;
        }
        return result;
    }

    public static String calculateDefineNumberIsNegative(int number) {
        String result = "";
        //Integer.signum(n) возвращает знак числа
        result = switch (Integer.signum(number)) {
            case  1 -> "Число позитивное";
            case -1 -> "Число негативное";
            case  0 -> "Число равно 0";
            default -> throw new IllegalStateException("Непредвиденная ситуация");
        };
        return result;
    }

    public static Pair calculateDirectionPlayer (int x, int y, String direction) {
        //В случае если направление не важно выводим другую ошибку
        return switch (direction) {
            case "up"    -> new Pair(x, y > 0   ? y - 1 : y);
            case "down"  -> new Pair(x, y < 100 ? y + 1 : y);
            case "left"  -> new Pair(x > 0   ? x - 1 : x, y);
            case "right" -> new Pair(x < 100 ? x + 1 : x, y);
            default -> throw new IllegalArgumentException("Направление может быть только ud, down, left или right а не " + direction);
        };
    }


    public static String calculateDefineMaxNumber (int[] arrayOfX) {
        String result;
        int max = Arrays.stream(arrayOfX).max().orElseThrow();
        int min = Arrays.stream(arrayOfX).min().orElseThrow();
        result = String.format("минимальное: %d, максимальное: %d", min, max);
        return result;
    }
}
