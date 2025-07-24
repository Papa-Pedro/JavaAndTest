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

public class DefineMaxNumberTest extends BaseManageStructTest {
    private ByteArrayInputStream inputStream;

    @DataProvider(name = "validData")
    private Object[] provideValidData() {
        return new Object[][] {
                //{data, response}
                {"2 1 3", "минимальное: 1, максимальное: 3"},
                {"2 4 3", "минимальное: 2, максимальное: 4"}
        };
    }

    @Test(dataProvider = "validData")
    public void positiveTest(String userData, String result){
        inputStream = new ByteArrayInputStream((userData + "\n").getBytes());
        System.setIn(inputStream);
        ManagerStruct.defineMaxNumber();
        String output = outputStream.toString().trim();
        Assert.assertEquals(output, result, "Проверка на валидный поиск max и min");
    }

}
