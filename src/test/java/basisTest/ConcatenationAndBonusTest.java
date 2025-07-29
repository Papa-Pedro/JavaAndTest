package basisTest;

import baseTest.FakeIO;
import org.example.Basis;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConcatenationAndBonusTest {

    @Test(dataProvider = "validData")
    public void positiveTest(String userData, String result) {
        FakeIO fakeIO = FakeIO.of(userData);
        //System.setIn(inputStream);
        Basis.concatenationAndBonus(fakeIO.scanner(), fakeIO.out());
        String output = fakeIO.output();
        Assert.assertEquals(output, result,
                "Нужно сложить строки и число умножить на бонус");
    }

    @DataProvider(name = "validData")
    public Object[][] provideValidData(){
        return new Object[][] {
                //{input, output}
                {"Очки: | 100 | 2", "Очки: 200"},
                {"Очки: | 200 | 2", "Очки: 400"}
        };
    }

}
