package managerStruct;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public abstract class BaseManageStructTest {

    protected final PrintStream originOutput = System.out;
    protected final InputStream originInput = System.in;
    protected ByteArrayOutputStream outputStream;


    @BeforeMethod(alwaysRun = true)
    public void setUpStream(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterMethod(alwaysRun = true)
    public void restoreStream(){
        System.setOut(originOutput);
        System.setIn(originInput);
    }
}
