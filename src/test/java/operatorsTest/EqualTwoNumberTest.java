package operatorsTest;

import org.example.Operators;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class EqualTwoNumberTest {

    private PrintStream originOut = System.out;
    private InputStream originInput = System.in;

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @DataProvider(name = "userData")
    private Object[] provideUserData() {
        return new Object[][] {
                //{data, response}
                {"10 10", "true"},
                {"10 20", "false"}
        };
    }

    @BeforeMethod
    private void setUpStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterMethod
    private void restoreStream() {
        System.setOut(originOut);
        System.setIn(originInput);
    }

    @Test(dataProvider = "userData")
    private void positiveTest(String userData, String response) {
        inputStream = new ByteArrayInputStream((userData + "\n").getBytes());
        System.setIn(inputStream);
        Operators.equalTwoNumber();
        String outputData = outputStream.toString().trim();
        Assert.assertEquals(outputData, response, "Позитивный тест на сравненеи не прошел");
    }

}
