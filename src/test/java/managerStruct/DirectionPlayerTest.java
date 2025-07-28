package managerStruct;

import baseTest.BaseTest;
import org.example.manager.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.example.InputRead.readTrioString;

public class DirectionPlayerTest extends BaseTest {

    @Test(dataProvider = "validData")
    public void validTest_insideSquare(String inputData, String resultFun, String context){
        inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);
        // Создаём экземляр с инфраструктурой ввода/вывода
        ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
        managerStruct.directionPlayer();
        String output = outStream.toString().trim();
        Assert.assertEquals(output, resultFun, "Проблема в позиции: " + context);
    }

    @Test
    public void emptyInputTest() {

        Scanner scanner = new Scanner(new ByteArrayInputStream("".getBytes()));
        PrintStream fakeOut = new PrintStream(outStream);

        Assert.expectThrows(NoSuchElementException.class,
                () -> readTrioString(scanner, fakeOut));
        Assert.assertEquals(
                outStream.toString().trim(),
                "Ввод закончился, ожидалась строка"
        );
    }

    @Test(dataProvider = "inputNotValidData")
    public void negativeTest_inputNotNumber(String input){
        inputStream = new ByteArrayInputStream((input + "\n").getBytes());
        System.setIn(inputStream);
        try {
            // Создаём экземляр с инфраструктурой ввода/вывода
            ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
            managerStruct.directionPlayer();
            Assert.fail("Ожидали IllegalArgumentException но ничего не пробросилось");
        } catch (Throwable e) {
            String actualName   = e.getClass().getSimpleName();
            String expectedName = "IllegalArgumentException";
            Assert.assertEquals(
                    actualName,
                    expectedName,
                    e.getMessage()
            );
        }
    }

    @DataProvider(name = "validData")
    private Object[][] provideValidDataInside() {
        return new Object[][] {
                //{inputData, outputData, position}
                {"99    99 down", "x: 99, y: 100, direction: down", "inside"},
                {"1 1 left", "x: 0, y: 1, direction: left", "inside"},
                {"99 100 down", "x: 99, y: 100, direction: down", "outside"},
                {"0 1     left", "x: 0, y: 1, direction: left", "outside"}
        };
    }

    @DataProvider(name = "inputNotValidData")
    private Object[][] provideNotNumber() {
        return new Object[][] {
                {"99 one up"},
                {"two 12 down"},
                {"99 12 revert"}

        };
    }
}
