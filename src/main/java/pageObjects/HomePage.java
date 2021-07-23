package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath="//*[@class=\"login\"]")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://automationpractice.com/index.php");
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
