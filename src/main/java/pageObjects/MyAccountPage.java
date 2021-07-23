package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {
    private WebDriver driver;
    @FindBy(xpath="//*[@class=\"info-account\"]")
    private WebElement welcomeMessage;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getWelcomeMessage(){
        return welcomeMessage.getText();
    }
}
