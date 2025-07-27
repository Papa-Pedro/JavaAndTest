package resourse.chouseEnum;

import org.example.managerStruct.ManagerStruct;

import java.util.function.Consumer;

public enum ManageOptions {

    CHECK_ODD_AND_SEVEN("1", "Проверить нечётность и делимость на 7",
            ManagerStruct::defineNotEvenAndSeven),
    CHECK_EVEN_AND_SIX("2", "Проверить на четность и делимость на 6",
            ManagerStruct::defineEvenAndSix),
    CHECK_MAX_NUMBER("3", "Найдите максимальный номер",
            ManagerStruct::defineMaxNumber),
    PAINT_STARS("4", "Нарисуте заданное колличество звезд",
            ManagerStruct::printStars),
    CALCULATE_DIRECT("5", "Расчитайте расположение по направлению",
            ManagerStruct::directionPlayer),
    DEFINE_NEGATIVE("6", "Определите является ли номер негативным",
            ManagerStruct::defineNumberIsNegative),
    SUM_ODD_NUMBER("7", "Посчитайте сумму всех нечетных номеров до",
            ManagerStruct::sumAllNotEvenNumber),
    MULTIPLY_EVEN_NUMBER("8", "Посчитайте произведение всех четных цифр до номер",
            ManagerStruct::multiplyOddUpTo),
    SUM_EVEN_NUMBER("9", "Сумма всех четных числе до номера",
            ManagerStruct::sumEvenNumber),
    HIDDEN_WORD("10", "Скрыть слово за звездочками",
            ManagerStruct::hiddenWord),
    MULTIPLY_ON_TWO("11", "Умножить положительное число на два",
            ManagerStruct::multiplyPositiveNumber)
    ;

    public void execute(ManagerStruct managerStruct) {
        action.accept(managerStruct);
    };

    private final String code;
    private final String description;
    private final Consumer action;

    ManageOptions(String code, String description, Consumer<ManagerStruct> action) {
        this.code = code;
        this.description = description;
        this.action = action;
    }

    public String getCode() {return code;}
    public String getDescription() {return description;}

    public static ManageOptions fromCode(String code){
        for (ManageOptions options : values()) {
            if (options.code.equals(code)) return options;
        }
        return null;
    }

}
