package operators;

import org.example.Operators;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;

public class AdditionalTwoNumberTest {

    private final PrintStream originOutput = System.out;
    private final InputStream originInput = System.in;

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @DataProvider(name = "userData")
    public Object[] provideValidData(){
        return new Object[][] {
                //{numbers, output}
                {"2 2", "4"}
        };
    }

    @BeforeMethod
    private void setUpStreams(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterMethod
    private void restoreStream() {
        System.setOut(originOutput);
        System.setIn(originInput);
    }

    @Test(dataProvider = "userData")
    public void positiveTest(String firstNumber, String result) {
        //подготовили данные для первого ввода
        inputStream = new ByteArrayInputStream((firstNumber + "\n").getBytes());
        System.setIn(inputStream);
        Operators.additionalTwoNumber();
        String output = outputStream.toString().trim();
        Assert.assertEquals(output, result, "Нужно было сложить два числа");

    }
}
