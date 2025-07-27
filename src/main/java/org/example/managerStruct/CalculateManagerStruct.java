package org.example.managerStruct;

import resourse.Pair;

import java.util.Arrays;

public final class CalculateManagerStruct {
    //для того что бы нельзя было создать экземпляр, все функции вызываются напрямую
    private CalculateManagerStruct(){}

    /** Функции для вычислений */
    /**
     * Удваивает целое число, если оно положительное
     * @param number - цисло для удвоение
     * @return - удвоенное число или number
     */
    public static int doubleIfPositive(int number) {
        return Integer.signum(number) == 1
                ? number * 2
                : number;
    }

    /**
     * Возвращает маску строку из * заданной длинной
     * @param length - длинна введенного слова
     * @return строка из *
     */
    public static String hiddenWord(int length) {
        return "*".repeat(length);
    }

    /**
     * Возвращает сумму всех чётных чисел от 2 до number (включительно).
     * Предполагается, что number ≥ 0 и чётно.
     */
    public static int sumEvenUpTo(int number) {
        int half = number / 2;
        return half * (half - 1);
    }

    /**
     * Произведение всех нечетных чисел до выбранного числа
     * @param number выбранное число
     * @return произведение
     */
    public static int productOddUpTo(int number) {
        int product = 1;
        int lastOdd = (number % 2 == 0) ? number - 1 : number;
        for (int i = lastOdd; i > 0; i -= 2) {
            product *= i;
        }
        return  product;
    }

    public static int sumOddUpTo(int number) {
        int result = 0;
        while (number > 0) {
            result += number;
            number -= 2;
        }
        return result;
    }

    public static String signDescription(int number) {
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

    public static Pair<Integer, Integer> calculateDirectionPlayer (int x, int y, String direction) {
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
