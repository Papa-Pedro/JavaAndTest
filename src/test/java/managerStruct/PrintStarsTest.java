package managerStruct;

import org.example.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class PrintStarsTest {

    private final PrintStream originOutput = System.out;
    private final InputStream originInput = System.in;

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @DataProvider(name = "validData")
    private Object[] provideValidData() {
        return new Object[][] {
                //{data, response}
                {1, "★"},
                {5, "★★★★★"},
                {0, ""}
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
    public void positiveTest(int userData, String result){
        inputStream = new ByteArrayInputStream((userData + "\n").getBytes());
        System.setIn(inputStream);
        ManagerStruct.printStars();
        String output = outputStream.toString().trim();
        Assert.assertEquals(output, result, "Проверка на валдных значениях");
    }

}
