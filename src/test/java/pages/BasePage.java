package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;

    public BasePage(WebDriver driver, WebDriverWait wait, Actions action){
        this.driver = driver;
        this.wait = wait;
        this.action = action;

        PageFactory.initElements(driver, this);
    }

    public void click (WebElement element){
        element.click();
    }

    public void writeText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public String readText(WebElement element){
        return element.getText();
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return driver.getTitle();
    }

    public void goTo(String url){
        driver.get(url);
    }

    public void findElement(String value){
        driver.findElements(By.xpath(value));
    }

    public Boolean getDisplayedState(String path) {
        return driver.findElement(By.xpath(path)).isDisplayed();
    }

    public void waitSevenSec(){
        try {
            Thread.sleep(7000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
