package operators;

import org.example.Operators;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class DivisionTwoNumberTest {

    private final PrintStream originOutput = System.out;
    private final InputStream originInput = System.in;

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream  inputStream;

    @DataProvider(name = "validData")
    public Object[] provideValidData(){
        return new Object[][] {
                //{input, result}
                {"4 2", "2"},
                {"8 5", "1.6"}
        };
    }

    @AfterMethod
    private void restoreStream(){
        System.setIn(originInput);
        System.setOut(originOutput);
    }

    @BeforeMethod
    private void setUpStream(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test(dataProvider = "validData")
    public void positiveTest(String numbers, String result){
        inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);
        Operators.divisionTwoNumber();
        String output = outputStream.toString().trim();
        Assert.assertEquals(output, result, "Позитивный тест на деление двух чисел");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divideByZeroThrows(){
        inputStream = new ByteArrayInputStream("7 0\n".getBytes());
        System.setIn(inputStream);
        Operators.divisionTwoNumber();
    }

}
