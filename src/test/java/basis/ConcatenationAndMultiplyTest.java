package basis;

import org.example.Basis;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;

public class ConcatenationAndMultiplyTest {

    private final InputStream  originInput  = System.in;
    private final PrintStream originOutput = System.out;

    private ByteArrayOutputStream outContent;
    //Подготовка входных условий для теста
    @DataProvider(name = "validInputs")
    public Object[][] provideValidInputs(){
        return new Object[][] {
                //{ input     , expected }
                {"Очки: | 100", "Очки: 200"},
                {"Очки: | 200", "Очки: 400"}
        };
    }
    //Подготовка для перехвата вывода
    @BeforeMethod
    public void setUpStreams(){
        outContent = new ByteArrayOutputStream();
        //PrintStream говорит "всё, что ты раньше писал в консоль, теперь пиши в outContent"
        //setOut перенаправляет стандартный поток вывода в PrintStream
        System.setOut(new PrintStream(outContent));
    }

    @AfterMethod
    public void restoreStream() {
        System.setOut(originOutput);
        System.setIn(originInput);
    }

    @Test(dataProvider = "validInputs")
    public void positiveTest(String userData, String result){
        //Подменяем System.in
        System.setIn(new ByteArrayInputStream((userData + "\n").getBytes()));
        Basis.concatenationAndMultiply();
        //Ловим то что должно было пойти в консоль
        String output = outContent.toString().trim();
        Assert.assertEquals(output, result,
                "Ожидается что будет убирать разделить и число умножаться на два");
    }
}
