import baseTest.FakeIO;
import org.example.*;

import org.example.manager.ManagerStruct;
import org.mockito.MockedConstruction;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.doNothing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertTrue;

public class LessonSelectionTest {

    @Test(dataProvider = "setOfSelection")
    public void callBasisClassTest(String inputChoose) {
        FakeIO io = FakeIO.of(inputChoose);
        // 3. Создаём реальный сервис с подделками
        LessonSelection selection = new LessonSelection(io.scanner(), io.out());
        //подменяем конструктор Basic(Scanner, PrintStream)
        try (
                MockedConstruction<Basis> mb = mockConstruction(
                        Basis.class, (mock, ctx) -> doNothing().when(mock).chooseIssue()
                );
                MockedConstruction<Operators> mo = mockConstruction(
                        Operators.class, (mock, ctx) -> doNothing().when(mock).chooseIssue()
                );
                MockedConstruction<ManagerStruct> mm = mockConstruction(
                        ManagerStruct.class, (mock, ctx) -> doNothing().when(mock).chooseIssue()
                )
        ) {
            //запускаем код
            selection.run();
            String output = io.output();
            assertTrue("Wrong tittle", output.contains("Choose lesson from stepic \"Java Тренажер\""));
            assertTrue(output.contains(inputChoose.trim() + " - " +
                    (inputChoose.startsWith("1") ? "Basis"
                            : inputChoose.startsWith("2") ? "Operators"
                            :                                 "Manager structure")
            ));
            // А вот в зависимости от первой цифры убеждаемся,
            // что вызвался именно нужный мок
            char choice = inputChoose.charAt(0);
            if (choice == '1') {
                Basis b = mb.constructed().get(0);
                verify(b).chooseIssue();
            } else if (choice == '2') {
                Operators o = mo.constructed().get(0);
                verify(o).chooseIssue();
            } else if (choice == '3') {
                ManagerStruct m = mm.constructed().get(0);
                verify(m).chooseIssue();
            }
        }
    }

    @DataProvider(name = "setOfSelection")
    private Object[][] provideSelectionData() {
        return new Object[][] {
                {"1\n0\n"},
                {"2\n0\n"},
                {"3\n0\n"}
        };
    }
}
