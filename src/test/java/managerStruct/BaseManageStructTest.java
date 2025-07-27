package managerStruct;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public abstract class BaseManageStructTest {

    protected final PrintStream originOutput = System.out;
    protected final InputStream originInput = System.in;
    protected ByteArrayOutputStream outStream;
    protected ByteArrayInputStream inputStream;

    @BeforeMethod(alwaysRun = true)
    public void setUpStream(){
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
    }

    @AfterMethod(alwaysRun = true)
    public void restoreStream(){
        System.setOut(originOutput);
        System.setIn(originInput);
    }
}
