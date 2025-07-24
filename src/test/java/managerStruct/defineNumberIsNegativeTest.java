package managerStruct;

import org.example.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

public class defineNumberIsNegativeTest extends BaseManageStructTest {

    private ByteArrayInputStream inputStream;


    @Test(dataProvider = "validInput", groups = "Positive")
    public void directTest(String inputData, String expectedResult) {
        inputStream = new ByteArrayInputStream((inputData + "\n").getBytes());
        System.setIn(inputStream);
        ManagerStruct.defineNumberIsNegative();
        String actualResult = outputStream.toString().trim();
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
            ManagerStruct.defineNumberIsNegative();
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
    private static Object[] provideValidData() {
        return new Object[][] {
                //inputData expectedResult
                {"2",    "Число позитивное"},
                {"-100", "Число негативное"},
                {"0", "Число равно 0"}
        };
    }

}
