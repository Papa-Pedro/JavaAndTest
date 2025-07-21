package basis;

import org.example.Basis;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;

public class ReadInputTest {

    //Сохраняем оригинальный System.in что бы потом вернуть
    private final java.io.InputStream originalIn = System.in;

    //вовзвращаем оригинальный System.in
    @AfterMethod
    public void restoreSystemIn(){
        System.setIn(originalIn);
    }

    @Test
    public void testReadInput_SingleLine() {
        //Готовимся симулировать ввод с символами и переводом строки
        String simulated = "Variable\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulated.getBytes());
        //Подмена System.in
        System.setIn(in);
        //Вызываем readInput и проверяем что вернется то же самое
        String result = Basis.readInput();
        Assert.assertEquals(result, "Variable", "readInput должен вернуть ровно ту строку, что мы дали на вход");
    }

    @Test
    public void testReadInput_WithSpaces() {
        String simulated = "Hello world 123\n";
        System.setIn(new ByteArrayInputStream(simulated.getBytes()));

        String result = Basis.readInput();
        Assert.assertEquals(result, "Hello world 123");
    }

    @Test
    public void testReadInput_EmptyString() {
        String simulate = "\n";
        System.setIn(new ByteArrayInputStream(simulate.getBytes()));

        String result = Basis.readInput();
        Assert.assertEquals(result, "");
    }

}
