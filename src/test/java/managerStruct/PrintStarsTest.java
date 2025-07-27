package managerStruct;

import org.example.managerStruct.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class PrintStarsTest extends BaseManageStructTest {

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
        // Создаём экземляр с инфраструктурой ввода/вывода
        ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
        managerStruct.printStars();
        String output = outStream.toString().trim();
        Assert.assertEquals(output, result, "Проверка на валдных значениях");
    }

}
