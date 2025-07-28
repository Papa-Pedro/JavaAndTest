package managerTwoStars;

import baseTest.FakeIO;
import org.example.managerTwoStar.ManagerTwo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class mixUpHatTest {

    @Test(dataProvider = "validData", groups = "positive")
    public void checkValidInput(int inputData, int expectedResult) {
        FakeIO io = FakeIO.of(String.valueOf(inputData));
        ManagerTwo managerTwo = new ManagerTwo(io.scanner(), io.out());
        managerTwo.mixUpHats();
        int actualResult = Integer.parseInt(io.output().trim());
        assertEquals(actualResult, expectedResult, "Проверка прямого подсчета");
    }

    @Test(dataProvider = "negativeDate", groups = "negative")
    public void inputNegative(int inputData) {
        FakeIO io = FakeIO.of(String.valueOf(inputData));
        ManagerTwo managerTwo = new ManagerTwo(io.scanner(), io.out());

        assertThrows(IllegalArgumentException.class,
                () -> managerTwo.mixUpHats());
    }

    @DataProvider(name = "validData")
    private Object[][] provideValidData() {
        return new Object[][] {
                //inputValue, expectedReuslt
                {1, 0},
                {2, 1},
                {3, 2},
                {4, 9},
                {5, 44}
        };
    }

    @DataProvider(name = "negativeDate")
    private Object[][] provideNegativeData() {
        return new Object[][] {
                {0},
                {-2}
        };
    }

}