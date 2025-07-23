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

public class DirectionPlayerTest {

    private final PrintStream originOutput = System.out;
    private final InputStream originInput = System.in;

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @DataProvider(name = "validData")
    private Object[] provideValidData() {
        return new Object[][] {
                //{data, response}
                {"1 1 down", "x: 1, y: 2, direction: down"},
                {"1 1 left", "x: 0, y: 1, direction: left"},
                {"1 1 right", "x: 2, y: 1, direction: right"},
                {"1 1 up", "x: 1, y: 0, direction: up"}
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
        ManagerStruct.directionPlayer();
        String output = outputStream.toString().trim();
        Assert.assertEquals(output, result, "Проверка на валдных значениях");
    }

}
