package org.example.managerTwoStar;

import org.example.InputRead;

import java.io.PrintStream;
import java.util.Scanner;

public class LessonException {

    public static int positiveInput(Scanner scanner, PrintStream out) {
        int n = InputRead.readInt(scanner, out);
        if ( n < 1 ) throw new IllegalArgumentException("Number must been more one");
        return n;
    }

}
