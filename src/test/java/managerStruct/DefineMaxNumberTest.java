package managerStruct;

import org.example.managerStruct.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class DefineMaxNumberTest extends BaseManageStructTest {

    @DataProvider(name = "validData")
    private Object[][] provideValidData() {
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
        // Создаём экземляр с инфраструктурой ввода/вывода
        ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
        managerStruct.defineMaxNumber();
        String output = fakeOutStream.toString().trim();
        Assert.assertEquals(output, result, "Проверка на валидный поиск max и min");
    }

}
