package parameters;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "successCredentials")
    public static Object[][] getSuccessCredentials(){
        return new Object[][]
                {
                        {"blackjail67@gmail.com", "gs5WBQYw0W", "Carrot quest - панель администратора"}
                };
    }

    @DataProvider(name = "wrongCredentials")
    public static Object[][] getWrongCredentials(){
        return new Object[][]
                {
                        {"123@gmail.com", "Qwerty1", "Неверные email или пароль"},
                        {"", "gs5WBQYw0W", "Введите email"},
                        {"blackjail67@gmail.com", "", "Введите пароль"},
                        {"123@gmail.com", "gs5WBQYw0W", "Неверные email или пароль"},
                        {"blackjail67@gmail.com", "Qwerty1", "Неверные email или пароль"}
                };
    }

    @DataProvider(name = "nullCredentials")
    public static Object[][] getNullCredentials(){
        return new Object[][]
                {
                        {"", "", "Введите email", "Введите пароль"}
                };
    }
}
