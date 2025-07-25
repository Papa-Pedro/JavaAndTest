package managerStruct;

import org.example.managerStruct.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

public class PrintStarsTest extends BaseManageStructTest {

    private ByteArrayInputStream inputStream;

    @DataProvider(name = "validData")
    private Object[][] provideValidData() {
        return new Object[][] {
                //{data, response}
                {1, "★"},
                {5, "★★★★★"},
                {0, ""}
        };
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
