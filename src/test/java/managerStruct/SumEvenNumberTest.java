package managerStruct;

import org.example.manager.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class SumEvenNumberTest extends BaseManageStructTest {

    @Test(dataProvider = "validData", groups = "positive")
    public void sumEvenCheck(int number, int expectResult) {
        inputStream = new ByteArrayInputStream((number + "\n").getBytes());
        System.setIn(inputStream);
        ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
        managerStruct.sumEvenNumber();
        int actualResult = Integer.parseInt(outStream.toString().trim());
        Assert.assertEquals(
                actualResult,
                expectResult,
                "Прямой тест на подсчет суммы до n"
        );
    }

    @Test(dataProvider = "negativeData", groups = "negative")
    public void wrongInput(String input, String expectedResult) {
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        try {
            ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
            managerStruct.sumEvenNumber();
            Assert.fail("Ожидалось что тест упадет с " + input);
        } catch (Throwable e) {
            String actualException = e.getClass().getSimpleName();
            String expectException = expectedResult;
            Assert.assertEquals(
                    actualException,
                    expectException,
                    String.format("Ожидалось что с \"%s\" мы получим исключени %s. " +
                            "Получили %s c текстом \"%s\"", input, expectException, actualException, e.getMessage())
            );
        }
    }

    @DataProvider(name = "validData")
    private Object[][] provideValidData() {
        return new Object[][] {
                //inputData, result
                {4, 6},
                {6, 12},
                {8, 20}
        };
    }

    @DataProvider(name = "negativeData")
    private Object[][] provideWrongData() {
        return new Object[][] {
                {"7",   "IllegalArgumentException"},
                {"two", "NoSuchElementException"},
                {"\n",  "NoSuchElementException"}
        };
    }

}
