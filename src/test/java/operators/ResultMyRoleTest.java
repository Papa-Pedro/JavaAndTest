package operators;

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

public class ResultMyRoleTest {

    private final PrintStream originOutput = System.out;
    private final InputStream originInput = System.in;

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @DataProvider(name = "validData")
    private Object[] provideValidData() {
        return new Object[][] {
                //{data, response}
                {"1", "admin"},
                {"2", "moderator"},
                {"3", "user"},
                {"17", "guest"}
        };
    }

    @AfterMethod
    public void restoreStream(){
        System.setOut(originOutput);
        System.setIn(originInput);
    }

    @BeforeMethod
    public void setUpStream(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test(dataProvider = "validData")
    public void positiveTest(String userData, String result){
        inputStream = new ByteArrayInputStream((userData + "\n").getBytes());
        System.setIn(inputStream);
        Operators.resultMyRole();
        String output = outputStream.toString().trim();
        Assert.assertEquals(output, result, "Проверка соответсвия ролей");
    }
}
