package resourse.chouseEnum;

import org.example.managerTwoStar.ManagerTwo;

import java.util.function.Consumer;

public enum ManagerTwoEnum {

    FAKE(0, "fake", ManagerTwo::fake);

    public void execute(ManagerTwo managerTwo) {
        action.accept(managerTwo);
    }

    private final int    code;
    private final String description;
    private final Consumer action;

    ManagerTwoEnum(int code, String description, Consumer<ManagerTwo> action) {
            this.code = code;
            this.description = description;
            this.action = action;
    }

    public int    getCode()        {return code;}
    public String getDescription() {return description;}

    public static ManagerTwoEnum fromCode(int code) {
        for (ManagerTwoEnum option: values()) {
            if (option.code == code) return option;
        }
        return null;
    }

}
