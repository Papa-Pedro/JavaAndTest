package resourse;

import org.example.Basis;
import org.example.Operators;
import org.example.managerStruct.ManagerStruct;

import java.io.PrintStream;
import java.util.Scanner;

public enum LessonOptions {

    BASIS("1") {
        @Override
        public void execute(Scanner scanner, PrintStream out) {
            new Basis().chooseIssue();
        }
    },
    OPERATORS("2") {
        @Override
        public void execute(Scanner scanner, PrintStream out) {
            Operators.chooseIssue();
        }
    },
    MANAGER("3") {
        @Override
        public void execute(Scanner scanner, PrintStream out) {
            new ManagerStruct().chooseIssue();
        }
    },
    EXIT("0") {
        @Override
        public void execute(Scanner scanner, PrintStream out) {
            //ничего не вызываем или ожидаем
        }
    };

    //Внутреняя логика по передачи PrintStream and InputStream
    public abstract void execute(Scanner scanner, PrintStream out);
    //Конструктор для передачи состояния нажатого кода
    private final String code;
    LessonOptions(String code) { this.code = code;}

    /** парсер из введённой строки → enum */
    public static LessonOptions from(String input) {
        for (LessonOptions opt : values()) {
            if (opt.code.equals(input)) return opt;
        }
        return null;
    }




}
