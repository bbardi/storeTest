package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"wishlist_button\"]")
    private WebElement addToWishList;
    @FindBy(xpath = "//*[@class=\"fancybox-error\"]")
    private WebElement messageBox;
    @FindBy(xpath = "//a[@title=\"Close\"]")
    private WebElement closeMessageBox;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAddToWishList(){
        addToWishList.click();
    }
    public String getMessageBoxText(){
        return messageBox.getText();
    }
    public void clickCloseMessageBox(){
        closeMessageBox.click();
    }
}
