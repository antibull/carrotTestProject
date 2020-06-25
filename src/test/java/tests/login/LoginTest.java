package tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import parameters.DataProviderClass;
import tests.BaseTest;

import static endpoints.LoginPageEndPoints.loginPageURL;

public class LoginTest extends BaseTest {
    private static final String homeModal = "//div[@class='padding-40']";

    @Test(dataProvider = "successCredentials", dataProviderClass = DataProviderClass.class, priority = 1)
    public void signIn(String email, String password, String title){
        LoginPage login = new LoginPage(driver, wait, action);

        login.goToCarrot();
        login.checkURL();
        login.loginToCarrot(email, password);
        //это костыль вызванный двумя причинами:
        //1. Не всегда открывается страница юзера сразу, как правило висит белая страница с урлом содержащим что-то ида юзера
        //      в это случае помогает с уже сущ.кукой обновить страницу, либо открыть страницу логина как пример
        //2. После нажатия Войти проходит чуть больше 2х секунд до авторизации
        // Можно поправить этот "Костыль", но нужно посидеть и подумать:)
        login.waitSevenSec();
        login.goTo(loginPageURL);

        Assert.assertTrue(login.getDisplayedState(homeModal));
    }

    @Test(dataProvider = "wrongCredentials", dataProviderClass = DataProviderClass.class, priority = 2)
    public void signInWithWrongCredentials(String email, String password, String error){
        LoginPage login = new LoginPage(driver, wait, action);

        login.goToCarrot();
        login.checkURL();
        login.loginToCarrot(email, password);

        Assert.assertEquals(login.getErr(), error);
    }

    @Test(dataProvider = "nullCredentials", dataProviderClass = DataProviderClass.class, priority = 3)
    public void signInWithNullCredentials(String email, String password, String errorMail, String errorPass){
        LoginPage login = new LoginPage(driver, wait, action);

        login.goToCarrot();
        login.checkURL();
        login.loginToCarrot(email, password);

        Assert.assertEquals(login.getEmailErr(), errorMail);
        Assert.assertEquals(login.getPassErr(), errorPass);
    }
}
