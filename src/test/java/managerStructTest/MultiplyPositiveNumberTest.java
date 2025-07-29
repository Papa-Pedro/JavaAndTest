package managerStructTest;

import baseTest.BaseTest;
import org.example.manager.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MultiplyPositiveNumberTest extends BaseTest {

    @DataProvider(name = "positiveTest")
    private Object[][] providerPositiveData() {
        return new Object[][] {
                {2, 4},
                {-2, -2},
                {0, 0}
        };
    }

    @DataProvider(name = "negativeTest")
    private Object[][] provideNegativeData() {
        return new Object[][]{
                {"one", "IllegalArgumentException"},
                {"\n",  "IllegalArgumentException"},
        };
    }

    @Test(dataProvider = "positiveTest", groups = "positive")
    public void directTest(int inputData, int expectedResult) {
        inputStream = new ByteArrayInputStream((inputData + "\n").getBytes());
        System.setIn(inputStream);
        ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
        managerStruct.multiplyPositiveNumber();
        int actualResult = Integer.parseInt(outStream.toString().trim());
        Assert.assertEquals(
                actualResult,
                expectedResult,
                "Прямая проверка, позитивная"
        );
    }

    @Test(dataProvider = "negativeTest", groups = "negative")
    public void wrongInputTest(String inputData, String expectedException) {
        inputStream = new ByteArrayInputStream((inputData + "\n").getBytes());
        System.setIn(inputStream);
        try {
            ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
            managerStruct.sumEvenNumber();
            Assert.fail("Ожидался выброс исключения");
        } catch (Throwable e) {
            String actualException = e.getClass().getSimpleName();
            Assert.assertEquals(
                    actualException,
                    expectedException,
                    String.format("Ожидалось %s а получили %s", expectedException, actualException)
            );
        }
    }

}
