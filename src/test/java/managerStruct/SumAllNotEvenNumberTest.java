package managerStruct;

import org.example.managerStruct.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

public class SumAllNotEvenNumberTest extends BaseManageStructTest {

    private ByteArrayInputStream inputStream;

    @Test(dataProvider = "validData", groups = "positive")
    public void directCheck(String inputData, String expectResult) {
        inputStream = new ByteArrayInputStream((inputData + "\n").getBytes());
        System.setIn(inputStream);
        ManagerStruct.sumAllNotEvenNumber();
        String actualResult = outputStream.toString().trim();
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
            ManagerStruct.sumAllNotEvenNumber();
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

    @DataProvider(name = "validData")
    private static Object[][] provideValidData() {
        return new Object[][] {
                //inputData, expectResult
                {"3", "4"},
                {"5", "9"}
        };
    }

    @DataProvider(name = "notValidData")
    private static Object[][] provideNotValidData() {
        return new Object[][] {
                //inputData, message about input
                {"one", "Input a string"},
                {"\n", "Input empty string"},
                {"8", "Input even number"}
        };
    }
}
