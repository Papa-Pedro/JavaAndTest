package org.example;

import resourse.Pair;
import resourse.Trio;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;


//класс финальный что бы его не использовали как родителя
public final class InputRead {

    //-------------- CORE-LEVEL PARSERS (только парсинг + исключения) ---------
    /**
     * Пытается распарсить строку как int
     * @throws NumberFormatException если строка нецелочисленная
     */
    public static int parseIntStrict(String line) {
        return Integer.parseInt(line);
    }

    /**
     * Просто обёртка над scanner.nextLine()
     * @exception NoSuchElementException - если строка совсем пустая
     */
    public static String readString(Scanner scanner) {
        return scanner.nextLine();
    }

    /**
     * Проверяем что строка не пустая
     * @throw IllegalArgumentException - если строка пустая или состоит только из пробелов
     */
    public static String parseStringStrict(String line) {
        if (line == null || line.trim().isEmpty() ) {
            throw new IllegalArgumentException("Пустая строка не допустима");
        }
        return line;
    }

    /**
     * Проверяем что столько "слов", сколько нам нужно переменных
     */
        public static void defineSize(String[] parts, int size) {
            if (parts.length > size) throw new IllegalArgumentException(
                    "Ожидалось " + size + " значения(ий), а введено: " + parts.length
            );
        }

    //-------------- UI-LEVEL PROMPTS (интерактив с пользователем) ---------
    /**
     * Интерактивно запрашивает число пока его не получит
     * ловит NoSuchElementException и переспрашивает, пока не будет валидно.
     * @param scanner - для работы с stream input
     * @return возвращает число
     */
    public static int readInt(Scanner scanner, PrintStream out) {
        while (true) {
            //Ушел от .hasNextLine(), в нашем случае она вылезет только если пользователь явно прибьет консоль
            //Так же часто используется для чтения из файла
            String line = scanner.nextLine().trim();
            try {
                return parseIntStrict(line);
            } catch (Throwable e) {
                out.printf("«%s» не число, повторите.%n", line);
            }
        }
    }

    /**
     * Интерактивно запрашивает строку пока не получит ввод
     * если строк несколько берет первую
     * Ловит NoSuchElementException если поток ввода исчерпан (и пробрасывает дальше),
     * - IllegalArgumentException от parseStringStrict,
     * и в обоих случаях предлагает ввести дальше
     * @param scanner - для работы с stream input
     * @return возвращает строку
     */
    public static String readString(Scanner scanner, PrintStream out) {
        while (true) {
            String line;
            try {
                line = readString(scanner);
            } catch (NoSuchElementException e) {
                out.println("Ввод закончился, ожидалась строка");
                throw e;
            }

            try {
                return parseStringStrict(line);
            } catch (IllegalArgumentException e) {
                out.printf("«%s» — некорректная строка, повторите ввод.%n", line.trim());
                throw e;
            }
        }
    }

    public static int[] readInputArray(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            return Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } else throw new NumberFormatException("Нет доступных строк для чтения");
    }

    /**
     * Ждем на вход два символа нужного типа, читаем символы и записываем их в Pair
     * @return объект Pair
     */
    public static Pair readPair(Scanner scanner, PrintStream out) {
        String line;
        while (true) {
            //Проверка на непустую строку
            try {
                line = readString(scanner);
            } catch (NoSuchElementException e) {
                out.println("Ввод закончился, ожидалась строка");
                throw e;
            }
            //Проверка что строка не из пробелов
            try {
                line = parseStringStrict(line);
            } catch (IllegalArgumentException e) {
                out.printf("«%s» — некорректная строка, повторите ввод.%n", line.trim());
                throw e;
            }
            String[] parts = line.split("\\s+", 2);
            try {
                defineSize(parts, 2);
                return new Pair(parts[0], parts[1]);
            } catch (IllegalArgumentException e) {
                out.println(e.getMessage());
            }
        }
    }

    /**
     * Ждем на вход три символа нужного типа, читаем эти символы как строки и записываем их в Trio
     * @param scanner -  - для работы с stream input
     * @return объект Trio
     */
    public static Trio readTrioString(Scanner scanner, PrintStream out){
        String line; // = scanner.nextLine().trim();
        while (true) {
            //Проверка что строка вообще не пустая
            try {
                line = readString(scanner);
            } catch (NoSuchElementException e) {
                out.println("Ввод закончился, ожидалась строка");
                throw e;
            }
            //Проверка что в строке есть символы
            try {
                line = parseStringStrict(line);
            } catch (IllegalArgumentException e) {
                out.printf("«%s» — некорректная строка, повторите ввод.%n", line.trim());
            }
            String[] parts = line.split("\\s+", 3);
            //Проверка что колличество слов больше трех
            try {
                defineSize(parts, 3);
                return new Trio(parts[0], parts[1], parts[2]);
            } catch (IllegalArgumentException e) {
                out.println(e.getMessage());
            }
        }
    }

}
