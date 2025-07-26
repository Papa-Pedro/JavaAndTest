import managerStruct.BaseManageStructTest;
import org.example.LessonSelection;
import org.example.Operators;
import org.mockito.MockedStatic;
import org.testng.annotations.Test;
import resourse.LessonOptions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.mockStatic;

public class LessonSelectionTest extends BaseManageStructTest {
    //private ByteArrayInputStream inputStream;
    Scanner fakeScanner = new Scanner(new ByteArrayInputStream("0\n".getBytes()));
    ByteArrayOutputStream fakeOutputStream = new ByteArrayOutputStream();
    PrintStream fakeOut = new PrintStream(fakeOutputStream);

    @Test
    public void callOperationClassTest() {
        try (MockedStatic<Operators> mocked = mockStatic(Operators.class)) {
            LessonOptions opt = LessonOptions.from("2");
            opt.execute(fakeScanner, fakeOut);
            mocked.verify(Operators::chooseIssue);
        }
    }
}
