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
            Basis basis = new Basis(scanner, out);
            basis.chooseIssue();
        }
    },
    OPERATORS("2") {
        @Override
        public void execute(Scanner scanner, PrintStream out) {
            Operators operators = new Operators(scanner, out);
            operators.chooseIssue();
        }
    },
    MANAGER("3") {
        @Override
        public void execute(Scanner scanner, PrintStream out) {
            ManagerStruct managerStruct = new ManagerStruct(scanner, out);
            managerStruct.chooseIssue();
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
