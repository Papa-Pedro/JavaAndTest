package baseTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

//Мини фабрика для работы с фейковым вводом и выводом
public class FakeIO {

    private final Scanner scanner;
    private final ByteArrayOutputStream buffer;
    private final PrintStream outputStream;

    private FakeIO(String input) {
        this.scanner      = new Scanner(new ByteArrayInputStream(input.getBytes()));
        this.buffer       = new ByteArrayOutputStream();
        this.outputStream = new PrintStream(buffer);
    }

    public static FakeIO of(String input) {
        return new FakeIO(input);
    }

    public Scanner scanner() {
        return scanner;
    }

    public PrintStream out() {
        return outputStream;
    }

    public String output() {
        return buffer.toString().trim();
    }

}
