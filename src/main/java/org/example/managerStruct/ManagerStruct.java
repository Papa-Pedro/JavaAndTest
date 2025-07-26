package org.example.managerStruct;

import resourse.Pair;
import resourse.Trio;
import resourse.chouseEnum.ManageOptions;

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
        //Выводи все перечисленный пункты из Enum с помощью перебора.
        for (ManageOptions options : ManageOptions.values()) {
            out.printf("%s - %s%n", options.getCode(), options.getDescription());
        }
        out.println("Choose your item");
        //Ждем выбора пункта

        String input = scanner.nextLine().trim();
        ManageOptions options = ManageOptions.fromCode(input);

        if (options == null) {
            out.println("Невернный ввод: " + input);
        } else {
           // InputRead inputRead = InputRead.of(scanner);
            options.execute(this);
        }
    }

    public void hiddenWord(){
        String message = InputRead.readString(scanner);
        StringBuilder result = CalculateManagerStruct.hiddenWord(message.length());
        out.println(result);
    }

    public void sumEvenNumber(){
        int n = InputRead.readInt(scanner);
        if (n % 2 != 0) throw new IllegalArgumentException("Введенное число не четное");
        int result = CalculateManagerStruct.calculateSumEvenNumber(n);
        out.println(result);
    }

    /**
     * Need calculate multiply all not even number
     * until the number n, it has not even.
     * @throws InterruptedException если n < 1
     */
    public void multiplyOddUpTo(){
        int n = InputRead.readInt(scanner);
        if (n < 1) throw new IllegalArgumentException("Число для удовлетворения условий должно быть больше 1");
        System.out.println(CalculateManagerStruct.calculateMultiplyOddUpTo(n));
    }

    /**
     * Need calculate sum all not even number
     * until the number n, it has not even.
     */
    public void sumAllNotEvenNumber(){
        int n = InputRead.readInt(scanner);
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
    public void defineNumberIsNegative(){
        int n = InputRead.readInt(scanner);
        System.out.println(CalculateManagerStruct.calculateDefineNumberIsNegative(n));
    }

    public void directionPlayer(){
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

    public void printStars(){
        int amount = InputRead.readInt(scanner);
        String result = "★".repeat(amount);
        System.out.println(result);
    }

    /**
     * Define max element among x1, x2 and x3
     * writhe in inside variable result
     */
    public void defineMaxNumber() {
        int[] arrayOfX = InputRead.readInputArray();//readInputArray();
       /* int max = Arrays.stream(arrayOfX).max().orElseThrow();
        int min = Arrays.stream(arrayOfX).min().orElseThrow();
        String result = String.format("минимальное: %d, максимальное: %d", min, max);*/
        System.out.println(CalculateManagerStruct.calculateDefineMaxNumber(arrayOfX));
    }

    public void defineEvenAndSix(){
        int n = InputRead.readInt(scanner);
        boolean result = (n % 2 == 0 && n % 6 == 0);
        System.out.println(result);
    }

    public void defineNotEvenAndSeven(){
        int n = InputRead.readInt(scanner);
        boolean result = (n % 2 != 0 && n % 7 == 0);
        System.out.println(result);
    }

}
