package resourse.chouseEnum;

import org.example.Basis;
import org.example.Operators;
import org.example.manager.ManagerStruct;
import org.example.managerTwoStar.ManagerTwo;
//import org.example.managerTwoStar.ManagerTwo;

import java.io.PrintStream;
import java.util.Scanner;

public enum LessonOptionsEnum {

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
    MANAGER_TWO("4") {
        @Override
        public void execute(Scanner scanner, PrintStream out) {
            ManagerTwo managerTwo = new ManagerTwo(scanner, out);
            managerTwo.chooseIssue();
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
    LessonOptionsEnum(String code) { this.code = code;}

    /** парсер из введённой строки → enum */
    public static LessonOptionsEnum from(String input) {
        for (LessonOptionsEnum opt : values()) {
            if (opt.code.equals(input)) return opt;
        }
        return null;
    }




}
