package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static endpoints.LoginPageEndPoints.loginPageURL;
import static endpoints.LoginPageEndPoints.registerPageURL;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait, Actions action){
        super(driver, wait, action);
    }

    @FindBy(xpath = "//input[@placeholder='Электронная почта']")
    WebElement loginInput;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    WebElement passInput;

    @FindBy(xpath = "//button[text()='Войти']")
    WebElement loginButton;

    @FindBy(xpath = "//ng-message[text()='Введите email']")
    WebElement emailError;

    @FindBy(xpath = "//ng-message[text()='Введите пароль']")
    WebElement passError;

    @FindBy(xpath = "//ng-message")
    WebElement error;

    @FindBy(xpath = "//div[text()='blackjail67@gmail.com']")
    WebElement emailHomePage;


    public void loginToCarrot(String login, String pass){
        writeText(loginInput, login);
        writeText(passInput, pass);
        click(loginButton);
    }

    public String emailHomePage(){
        return readText(emailHomePage);
    }

    public String getEmailErr(){
        return readText(emailError);
    }

    public String getPassErr(){
        return readText(passError);
    }

    public String getErr(){
        return readText(error);
    }

    public void goToCarrot(){
        driver.manage().deleteAllCookies();
        driver.get(loginPageURL);
    }

    public void checkURL(){
        if(getPageURL().equals(registerPageURL)){
            goToCarrot();
        }
    }
}
