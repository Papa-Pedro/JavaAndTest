package operatorsTest;

import org.example.Operators;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class SubtractionTwoNumberTest {

    private final PrintStream originOutput = System.out;
    private final InputStream originInput  = System.in;

    public ByteArrayOutputStream outputStream;
    public ByteArrayInputStream inputStream;

    @DataProvider(name = "testData")
    private Object[] provideValidData() {
        return new Object[][] {
                {"5 2", "3"},
                {"2 5", "-3"}
        };
    }

    @BeforeMethod
    public void setUpStream(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterMethod
    public void restoreStream(){
        System.setIn(originInput);
        System.setOut(originOutput);
    }

    @Test(dataProvider = "testData")
    public void positiveTest(String variable, String result){
        inputStream = new ByteArrayInputStream((variable + "\n").getBytes());
        System.setIn(inputStream);
        Operators.subtractionTwoNumber();
        String output = outputStream.toString().trim();
        Assert.assertEquals(output, result,
                "Вычитание чисел");
    }
}
