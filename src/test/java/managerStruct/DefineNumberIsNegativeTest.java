package managerStruct;

import baseTest.BaseTest;
import org.example.manager.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class DefineNumberIsNegativeTest extends BaseTest {

    @Test(dataProvider = "validInput", groups = "Positive")
    public void directTest(String inputData, String expectedResult) {
        inputStream = new ByteArrayInputStream((inputData + "\n").getBytes());
        System.setIn(inputStream);
        // Создаём экземляр с инфраструктурой ввода/вывода
        ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
        managerStruct.defineNumberIsNegative();
        String actualResult = outStream.toString().trim();
        Assert.assertEquals(
                actualResult,
                expectedResult,
                "Позитивный тест на сравнение"
        );
    }

    @Test(groups = "Negative")
    public void inputNotNumber() {
        inputStream = new ByteArrayInputStream("Один\n".getBytes());
        System.setIn(inputStream);
        try {
            // Создаём экземляр с инфраструктурой ввода/вывода
            ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
            managerStruct.defineNumberIsNegative();
            Assert.fail("Ожидалось что будет исключение");
        } catch (Throwable e) {
            String actualException   = e.getClass().getSimpleName();
            String expectedException = "IllegalArgumentException";
            Assert.assertEquals(
                    actualException,
                    expectedException,
                    e.getMessage()
            );
        }
    }

    @DataProvider(name = "validInput")
    private static Object[][] provideValidData() {
        return new Object[][] {
                //inputData expectedResult
                {"2",    "Число позитивное"},
                {"-100", "Число негативное"},
                {"0", "Число равно 0"}
        };
    }

}
