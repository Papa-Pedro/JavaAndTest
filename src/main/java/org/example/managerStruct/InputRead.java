package org.example.managerStruct;

import resourse.Trio;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;


//класс финальный что бы его не использовали как родителя
public final class InputRead {

    public static int readInt(Scanner scanner) {
        //scanner = new Scanner(System.in);
        if (scanner.hasNextLine() ) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Введенная строка должена быть числом");
            }
        } else throw new NoSuchElementException("Нет доступных строк для чтения");
    }

    public static String readString(Scanner scanner) {
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) throw new NoSuchElementException("Нет доступных строк для чтения");
            return line;
        } else throw new NoSuchElementException("Нет доступных строк для чтения");
    }

    public static Trio readTrioString(){
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
        return new Trio<>(parts[0], parts[1], parts[2]);
    }

    public static int[] readInputArray(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            return Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } else throw new NumberFormatException("Нет доступных строк для чтения");
    }

}
