package operatorsTest;

import org.example.Operators;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class DoMultiplyOrDivisionTest {

    private final PrintStream originOutput = System.out;
    private final InputStream originInput = System.in;

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @DataProvider(name = "validData")
    private Object[] provideValidData() {
        return new Object[][]{
                //{data, response}
                {"2 x 3", "6"},
                {"4 / 2", "2"}
        };
    }

    @AfterMethod
    public void restoreStream() {
        System.setOut(originOutput);
        System.setIn(originInput);
    }

    @BeforeMethod
    public void setUpStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test(dataProvider = "validData")
    public void positiveTest(String userData, String result) {
        inputStream = new ByteArrayInputStream((userData + "\n").getBytes());
        System.setIn(inputStream);
        Operators.doMultiplyOrDivision();
        String output = outputStream.toString().trim();
        Assert.assertEquals(output, result, "Арифметическая операция (x /) не прошла");
    }

    @Test
    public void testWithMissSign() {
        String inputWithoutSign = "10  5\n";
        inputStream = new ByteArrayInputStream(inputWithoutSign.getBytes());
        System.setIn(inputStream);
        Operators.doMultiplyOrDivision();
        String output = outputStream.toString().trim();
        Assert.assertEquals(output, "0", "При пустом знаке вывелся не 0");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divisionByZeroTest(){
        String inputWithDivisionZero = "10 / 0\n";
        inputStream = new ByteArrayInputStream(inputWithDivisionZero.getBytes());
        System.setIn(inputStream);
        Operators.doMultiplyOrDivision();
    }

    @Test(groups = "negative", expectedExceptions = IllegalArgumentException.class)
    public void testReadInput_wrongSign() {
        String inputWrongSign = "10 + 2\n";
        inputStream = new ByteArrayInputStream(inputWrongSign.getBytes());
        System.setIn(inputStream);
        Operators.doMultiplyOrDivision();
    }

}
