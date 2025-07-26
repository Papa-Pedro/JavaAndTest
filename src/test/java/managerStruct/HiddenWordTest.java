package managerStruct;

import org.example.managerStruct.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class HiddenWordTest extends BaseManageStructTest {

    @Test(dataProvider = "validData", groups = "positive")
    public void hiddenTest(String number, String expectResult) {
        inputStream = new ByteArrayInputStream((number + "\n").getBytes());
        System.setIn(inputStream);
        ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
        managerStruct.hiddenWord();
        String actualResult = fakeOutStream.toString().trim();
        Assert.assertEquals(
                actualResult,
                expectResult,
                "Прямой тест на подсчет суммы до n"
        );
    }

    @Test(dataProvider = "negativeData", groups = "negative")
    public void emptyTest(String input, String message) {
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        try {
            ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
            managerStruct.hiddenWord();
            Assert.fail("Ожидалось что тест упадет с " + message);
        } catch (Throwable e) {
            String actualException = e.getClass().getSimpleName();
            String expectException = "NoSuchElementException";
            Assert.assertEquals(
                    actualException,
                    expectException,
                    String.format("Ожидалось что с \"%s\" мы получим исключени %s. " +
                            "Получили %s c текстом \"%s\"", message, expectException, actualException, e.getMessage())
            );
        }
    }

    @DataProvider(name = "validData")
    private Object[][] provideValidData() {
        return new Object[][] {
                //inputData, result
                {"a",    "*"},
                {"аб",   "**"},
                {"1246", "****"}
        };
    }

    @DataProvider(name = "negativeData")
    private Object[][] provideWrongData() {
        return new Object[][] {
                {"", "Input empty string"},
                {"\n",  "Input empty string"}
        };
    }

}
