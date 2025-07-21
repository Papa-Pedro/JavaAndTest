package basis;

import org.example.Basis;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class PrintWithDeleteSeparationTest {
    //Сохраняем оригинальный System.in
    private final InputStream originInput   = System.in;
    private final PrintStream originOutput = System.out;
    //Переменная для того что должно выводиться в консоль
    private ByteArrayOutputStream outContent;

    @BeforeMethod
    public void setUpStreams(){
        //Создаем в памяти байтовый буффер, куда можно все записывать
        outContent = new ByteArrayOutputStream();
        //PrintStream говорит "всё, что ты раньше писал в консоль, теперь пиши в outContent"
        //setOut перенаправляет стандартный поток вывода в PrintStream
        System.setOut(new PrintStream(outContent));
    }

    @AfterMethod
    public void restoreStreams(){
        //Вернём оригинальные потоки, чтобы не сломать другие тесты
        System.setOut(originOutput);
        System.setIn(originInput);
    }

    @Test
    public void positiveTest_WithSpaseAndSymbol() {
        String userData = "Привет | Мир";
        //Подготовливаем буффер ввода
        System.setIn(new ByteArrayInputStream(userData.getBytes()));
        Basis.printWithDeleteSeparation();
        //Ловим то что должно было пойти в консоль
        String output = outContent.toString().trim();
        Assert.assertEquals(output, "Привет Мир", "Ожидается что строка будет равна - Привет Мир");
    }

}
