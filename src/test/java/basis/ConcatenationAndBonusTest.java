package basis;

import org.example.Basis;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class ConcatenationAndBonusTest {

    private final PrintStream originOutput = System.out;
    private final InputStream originInput = System.in;

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @DataProvider(name = "validData")
    public Object[] provideValidData(){
        return new Object[][] {
                //{input, output}
                {"Очки: | 100 | 2", "Очки: 200"},
                {"Очки: | 200 | 2", "Очки: 400"}
        };
    }


    @AfterMethod
    public void restoreSteam() {
        System.setIn(originInput);
        System.setOut(originOutput);
    }

    @BeforeMethod
    public void setUpStreams() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test(dataProvider = "validData")
    public void positiveTest(String userData, String result) {
        inputStream = new ByteArrayInputStream( (userData + "\n").getBytes() );
        System.setIn(inputStream);
        Basis.concatenationAndBonus();
        String output = outputStream.toString().trim();
        Assert.assertEquals(output, result,
                "Нужно сложить строки и число умножить на бонус");
    }

}
