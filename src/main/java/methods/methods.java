package methods;

import org.openqa.selenium.WebElement;

public class methods {
    //Click method
    public void click (WebElement element){
        element.click();
    }
    //Write text
    public void writeText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
    //Read text
    public String readText(WebElement element){
        return element.getText();
    }
}
