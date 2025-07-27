import managerStruct.BaseManageStructTest;
import org.example.*;

import org.example.managerStruct.ManagerStruct;
import org.mockito.MockedConstruction;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.doNothing;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertTrue;

public class LessonSelectionTest extends BaseManageStructTest{

    protected Scanner fakeScanner;

    @Test
    public void callBasisClassTest() {
        // 0\n для выхода из цикла
        inputStream = new ByteArrayInputStream("1\n0\n".getBytes());
        // 1. Подделываем ввод: пользователь выбрал "1"
        fakeScanner = new Scanner(inputStream);
        // 3. Создаём реальный сервис с подделками
        LessonSelection selection = new LessonSelection(fakeScanner, new PrintStream(outStream));
        //подменяем конструктор Basic(Scanner, PrintStream)
        try (MockedConstruction<Basis> mockedConstruction =
                mockConstruction(Basis.class, (mockBasis, context) -> {
                    //stub-м его метод
                    doNothing().when(mockBasis).chooseIssue();
                })){
            //запускаем код
            selection.run();
            String output = outStream.toString().trim();
            assertTrue("Wrong tittle", output.contains("Choose lesson from stepic"));
            assertTrue(output.contains("1 - Basis"));
            Basis create = mockedConstruction.constructed().get(0);
            verify(create).chooseIssue();
        }
    }

    @Test
    public void callOperationClassTest() {
        //prepare String for input
        inputStream = new ByteArrayInputStream("2\n0\n".getBytes());
        //create fake scanner and put prepare string (inputStream)
        fakeScanner = new Scanner(inputStream);
        //create object when called class
        LessonSelection selection = new LessonSelection(fakeScanner, new PrintStream(outStream));

        try (MockedConstruction<Operators> mockedConstruction =
                mockConstruction(Operators.class, (mockOperation, context) -> {
                    doNothing().when(mockOperation).chooseIssue();
                })) {
            selection.run();
            String output = outStream.toString().trim();
            assertTrue("Wrong tittle", output.contains("Choose lesson from stepic"));
            assertTrue(output.contains("2 - Operators"));

            Operators create = mockedConstruction.constructed().get(0);
            verify(create).chooseIssue();
        }
    }

    @Test
    public void callManageStructTest() {
        inputStream = new ByteArrayInputStream("3\n0\n".getBytes());
        fakeScanner = new Scanner(inputStream);
        LessonSelection selection = new LessonSelection(fakeScanner, new PrintStream(outStream));

        try (MockedConstruction<ManagerStruct> mockedConstruction =
                mockConstruction(ManagerStruct.class, (mockManageStruct, context) -> {
                    doNothing().when(mockManageStruct).chooseIssue();
                })) {
            selection.run();
            //String output = outputStream.toString().trim();
            ManagerStruct create = mockedConstruction.constructed().get(0);
            verify(create).chooseIssue();
        }
    }
}
