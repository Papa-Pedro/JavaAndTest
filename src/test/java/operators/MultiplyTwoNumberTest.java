package operators;

import org.example.Operators;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class MultiplyTwoNumberTest {

    private final PrintStream originOutput = System.out;
    private final InputStream originInput = System.in;

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream  inputStream;

    @DataProvider(name = "inputNumbers")
    private Object[] provideValidData() {
        return new Object[][] {
                //inputNumber, result
                {"2 2", "4"},
                {"3 4", "12"}
        };
    }

    @BeforeMethod
    private void setUpStreams(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterMethod
    private void restoreStream(){
        System.setOut(originOutput);
        System.setIn(originInput);
    }

    @Test(dataProvider = "inputNumbers")
    public void positiveTest(String numbers, String result){
        inputStream = new ByteArrayInputStream((numbers + "\n").getBytes());
        System.setIn(inputStream);
        Operators.multiplyTwoNumber();
        String output = outputStream.toString().trim();
        Assert.assertEquals(output, result,
                "Проверка на валидное умножение");
    }
}
