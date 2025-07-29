package basisTest;

import baseTest.FakeIO;
import org.example.Basis;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintWithDeleteSeparationTest {

    @Test
    public void positiveTest_WithSpaseAndSymbol() {
        FakeIO fakeIO = FakeIO.of("Привет | Мир");
        //Подготовливаем буффер ввода
        Basis.printWithDeleteSeparation(fakeIO.scanner(), fakeIO.out());
        //Ловим то что должно было пойти в консоль
        String output = fakeIO.output();
        Assert.assertEquals(output, "Привет Мир", "Ожидается что строка будет равна - Привет Мир");
    }

}
