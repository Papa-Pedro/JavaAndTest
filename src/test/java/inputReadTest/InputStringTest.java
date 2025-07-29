package inputReadTest;

import baseTest.FakeIO;
import org.example.Basis;
import org.example.InputRead;
import org.example.managerTwoStar.LessonException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

public class InputStringTest {

    @Test(dataProvider = "validData", groups = "positive")
    public void testReadString_SingleLine(String inputData) {
        //Готовимся симулировать ввод с символами и переводом строки
        FakeIO fakeIO = FakeIO.of(inputData);
        //Вызываем readString и проверяем что вернется то же самое
        String result = InputRead.readString(fakeIO.scanner(), fakeIO.out());
        Assert.assertEquals(result, inputData, "readInput должен вернуть ровно ту строку, что мы дали на вход");
    }

    @Test(dataProvider = "emptyData", groups = "negative")
    public void restReadString_EmptyData(String inputData, Class<? extends RuntimeException> exception, String message) {
        FakeIO fakeIO = FakeIO.of(inputData);
        Assert.expectThrows(exception, () -> InputRead.readString(fakeIO.scanner(), fakeIO.out()));
        Assert.assertTrue(fakeIO.output().contains(message));
    }

    @DataProvider(name = "validData")
    private Object[][] provideData() {
        return new Object[][] {
                {"Variable"},
                {"Hello world 123"}
        };
    }

    @DataProvider(name = "emptyData")
    private Object[][] provideEmptyData(){
        return new Object[][] {
                {"", NoSuchElementException.class, "Ввод закончился, ожидалась строка"},
                {"\n", IllegalArgumentException.class, "— некорректная строка, повторите ввод"},
                {"    ", IllegalArgumentException.class, "— некорректная строка, повторите ввод"}
        };
    }

}
