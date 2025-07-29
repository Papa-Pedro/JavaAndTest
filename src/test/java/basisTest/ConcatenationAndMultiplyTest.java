package basisTest;

import baseTest.FakeIO;
import org.example.Basis;
import org.testng.Assert;
import org.testng.annotations.*;

public class ConcatenationAndMultiplyTest {

    @Test(dataProvider = "validInputs")
    public void positiveTest(String userData, String result){
        FakeIO fakeIO = FakeIO.of(userData);
        //Подменяем System.in
        Basis.concatenationAndMultiply(fakeIO.scanner(), fakeIO.out());
        //Ловим то что должно было пойти в консоль
        String output = fakeIO.output();
        Assert.assertEquals(output, result,
                "Ожидается что будет убирать разделить и число умножаться на два");
    }

    //Подготовка входных условий для теста
    @DataProvider(name = "validInputs")
    public Object[][] provideValidInputs(){
        return new Object[][] {
                //{ input     , expected }
                {"Очки: | 100", "Очки: 200"},
                {"Очки: | 200", "Очки: 400"}
        };
    }
}
