package org.example.managerTwoStar;

import org.example.InputRead;
import resourse.chouseEnum.ManagerTwoEnum;

import java.io.PrintStream;
import java.util.Scanner;

public class ManagerTwo {

    private final Scanner scanner;
    private final PrintStream out;

    public ManagerTwo(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.out = printStream;
    }

    public void chooseIssue() {
        for (ManagerTwoEnum options : ManagerTwoEnum.values()) {
            out.printf("%d - %s%n", options.getCode(), options.getDescription());
        }
        out.println("Choose your item");

        int input = InputRead.readInt(scanner, out);
        ManagerTwoEnum options = ManagerTwoEnum.fromCode(input);

        if (options == null) {
            out.println("Невернный ввод: " + input);
        } else {
            options.execute(this);
        }
    }

    /**
     * На вход подается n,
     * нужно определить колличество перестановок n
     * минус один
     */
    public void mixUpHats() {
        int n;
        while (true) {
            try {
                n = LessonException.positiveInput(scanner, out);
                break;
            } catch (IllegalArgumentException e) {
                out.println("Number must been more one");
            }
        }
        int result = CalculateManagerTwoStar.amountOfViolation(n);
        out.println(result);
    }
}
