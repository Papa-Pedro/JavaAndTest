package org.example.managerTwoStar;

import org.example.manager.InputRead;
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
        ManagerTwoEnum managerEnum = ManagerTwoEnum.fromCode(input);
        /** ToDO */
    }

    public void fake() {

    }
}
