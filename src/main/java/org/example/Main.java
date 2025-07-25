package org.example;

import org.example.managerStruct.ManagerStruct;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Choose lesson from stepic "Java Тренажер"
                1 - Basis
                2 - Operators
                3 - Manager structure""");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1" -> {
                Basis basis = new Basis();
                basis.chooseIssue();
            }
            case "2" -> {
                Operators operators = new Operators();
                operators.chooseIssue();
            }
            case "3" -> {
                ManagerStruct managerStruct = new ManagerStruct();
                managerStruct.chooseIssue();
            }
            default -> System.out.println("Yor input wrong symbol");
        }
    }
}