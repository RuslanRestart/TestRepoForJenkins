import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expectedResult;

    public AccountTest(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {"Тимоти Шаламе", true},
                {"ТимотейШевроле", false},
                {" Тимоти Шаламе", false},
                {"Тимоти Шаламе ", false},
                {"Ти Ш", true},
                {"Тимоти Джеральд Шаламе", false},
                {"ТимотиШаламе ", false},
                {"А Б", true},
                {"Тимоти Шаламеееееее", true},
                {"Timothy Chalamet", true},
                {" ТимотиШаламе ", false}
        };
    }

    @Test
    @DisplayName("Check name to emboss")
    @Description("Имя содержит от 3 до 19 символов вкл. Содержит только 1 пробел. Пробелов в начале или в конце строки нет.") // описание теста
    public void checkNameToEmbossTest(){
        Account account = new Account(name);
        boolean actualResult = account.checkNameToEmboss();
        assertEquals("Ожидаемый результат не совпадает с фактическим!", expectedResult, actualResult);
    }

}
