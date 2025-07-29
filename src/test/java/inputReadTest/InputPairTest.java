package inputReadTest;

import baseTest.FakeIO;
import org.example.InputRead;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resourse.Pair;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

public class InputPairTest {

    @Test(dataProvider = "validData", groups = "positive")
    public void testReadString_SingleLine(String inputData, Object expectedFirst, Object expectedSecond) {
        //Готовимся симулировать ввод с символами и переводом строки
        FakeIO fakeIO = FakeIO.of(inputData + "\n");
        //Вызываем readString и проверяем что вернется то же самое
        Pair<?, ?> actual = InputRead.readPair(fakeIO.scanner(), fakeIO.out());
        assertEquals(actual.first(), expectedFirst, "first() не совпал");
        assertEquals(actual.second(), expectedSecond, "second() не совпал");
    }

    @Test(dataProvider = "emptyData", groups = "negative")
    public void restReadString_EmptyData(String inputData, Class<? extends RuntimeException> exception, String message) {
        FakeIO fakeIO = FakeIO.of(inputData);
        Assert.expectThrows(exception, () -> InputRead.readPair(fakeIO.scanner(), fakeIO.out()));
        Assert.assertTrue(fakeIO.output().contains(message));
    }

    @DataProvider(name = "validData")
    private Object[][] provideData() {
        return new Object[][] {
                {"Mine name", "Mine", "name"},
                {"It's work been hard", "It's", "work been hard"}
        };
    }

    @DataProvider(name = "emptyData")
    private Object[][] provideEmptyData(){
        return new Object[][] {
                {"",      NoSuchElementException.class,   "Ввод закончился, ожидалась строка"},
                {"\n",    IllegalArgumentException.class, "— некорректная строка, повторите ввод"},
                {"    ",  IllegalArgumentException.class, "— некорректная строка, повторите ввод"},
                {"Alone", IllegalArgumentException.class, "Ожидалось минимум 2 значения(ий), а введено: 1"}
        };
    }
}
