package managerStructTest;

import baseTest.BaseTest;
import org.example.manager.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MultiplyOddUpToTest extends BaseTest {

    @DataProvider(name = "validData")
    private static Object[][] provideValidData() {
        return new Object[][] {
                //inputData, expectResult
                {"3", "3"},
                {"5", "15"},
                {"7", "105"},
                {"8", "105"}
        };
    }

    @DataProvider(name = "notValidData")
    private static Object[][] provideNotValidData() {
        return new Object[][] {
                //inputData, message about input
                {"one", "Input a string"},
                {"\n", "Input empty string"},
                {"-7", "Number must be positive"}
        };
    }

    @Test(dataProvider = "validData", groups = "positive")
    public void directCheck(String inputData, String expectResult) {
        inputStream = new ByteArrayInputStream((inputData + "\n").getBytes());
        System.setIn(inputStream);
        // Создаём экземляр с инфраструктурой ввода/вывода
        ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
        managerStruct.multiplyOddUpTo();
        String actualResult = outStream.toString().trim();
        Assert.assertEquals(
                actualResult,
                expectResult,
                "Прямой тест на подсчет суммы до n"
        );
    }

    @Test(dataProvider = "notValidData", groups = "negative")
    public void inputNotValidData(String inputData, String message) {
        inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);
        try {
            ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
            managerStruct.multiplyOddUpTo();
            Assert.fail("Ожидалось что будет исключение с " + message);
        } catch (Throwable e)
        {
            String actualException = e.getClass().getSimpleName();
            String expectException = "IllegalArgumentException";
            Assert.assertEquals(
                    actualException,
                    expectException,
                    "Ожидалось что с " + message + "мы получим исключение" + expectException + ". Получили " + e.getMessage()
            );
        };
    }
}
