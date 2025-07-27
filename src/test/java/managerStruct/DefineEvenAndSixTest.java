package managerStruct;

import org.example.managerStruct.ManagerStruct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class DefineEvenAndSixTest extends BaseManageStructTest {

    @DataProvider(name = "validData")
    private Object[][] provideValidData() {
        return new Object[][] {
                //{data, response}
                {6, true},
                {7, false},
                {12, true}
        };
    }

    @Test(dataProvider = "validData")
    public void positiveTest(int userData, Boolean result){
        inputStream = new ByteArrayInputStream((userData + "\n").getBytes());
        System.setIn(inputStream);
        // Создаём экземляр с инфраструктурой ввода/вывода
        ManagerStruct managerStruct = new ManagerStruct(new Scanner(System.in), System.out);
        managerStruct.defineEvenAndSix();
        Boolean output = Boolean.valueOf(outStream.toString().trim());
        System.out.println("TestNG version: " + org.testng.Assert.class.getPackage().getImplementationVersion());
        Assert.assertEquals(output, result, "Проверка на валдных значениях");
    }

}
