package managerStruct;

import baseTest.BaseTest;
import org.example.manager.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.example.InputRead.parseStringStrict;
import static org.testng.Assert.assertThrows;

public class HiddenWordTest extends BaseTest {

    @Test(dataProvider = "validData", groups = "positive")
    public void hiddenTest(String number, String expectResult) {
        inputStream = new ByteArrayInputStream((number + "\n").getBytes());
        System.setIn(inputStream);
        ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
        managerStruct.hiddenWord();
        String actualResult = outStream.toString().trim();
        Assert.assertEquals(
                actualResult,
                expectResult,
                "Прямой тест на подсчет суммы до n"
        );
    }

    @Test(groups = "negative")
    public void emptyTest() {
        inputStream = new ByteArrayInputStream("".getBytes());
        System.setIn(inputStream);
        String expectException = "NoSuchElementException";
        try {
            ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
            managerStruct.hiddenWord();
            Assert.fail("Ожидалось что тест упадет с " + expectException);
        } catch (Throwable e) {
            String actualException = e.getClass().getSimpleName();
            Assert.assertEquals(
                    actualException,
                    expectException,
                    String.format("Ожидалось что мы получим исключени %s. " +
                            "Получили %s c текстом \"%s\"", expectException, actualException, e.getMessage())
            );
        }
    }

    @Test(dataProvider = "negativeData", groups = "negative")
    public void wrongInput(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> parseStringStrict(input));
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
                {"\n"},
                {"    "},
                {"\n\n"}
        };
    }
}
