package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {
    private WebDriver driver;
    @FindBy(xpath="//*[@class=\"info-account\"]")
    private WebElement welcomeMessage;
    @FindBy(xpath="//*[@title=\"My wishlists\"]")
    private WebElement wishListButton;
    @FindBy(xpath = "//*[@title=\"Orders\"]")
    private WebElement orderHistoryButton;
    @FindBy(xpath = "//*[@title=\"Information\"]")
    private WebElement editAccountInfoButton;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getWelcomeMessage(){
        return welcomeMessage.getText();
    }
    public void clickWishListButton() {
        wishListButton.click();
    }
    public void clickOrderHistoryButton() {
        orderHistoryButton.click();
    }
    public void clickEditAccountInfoButton() {
        editAccountInfoButton.click();
    }
}
