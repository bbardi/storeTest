package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath="//*[@class=\"login\"]")
    private WebElement loginButton;
    @FindBy(xpath="//a[@title=\"Faded Short Sleeve T-shirts\" and @class=\"product-name\"]")
    private WebElement articleLink;
    @FindBy(xpath="//a[@data-id-product=\"1\"]")
    private WebElement addProductToCartButton;
    @FindBy(xpath="//a[@title=\"Proceed to checkout\"]")
    private WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//a[@title=\"Contact Us\"]")
    private WebElement contactButton;
    @FindBy(xpath = "//a[@title=\"My Store\"]")
    private WebElement siteLogo;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a")
    private WebElement firstProductLink;
    @FindBy(xpath = "//a[@title=\"View my customer account\"]")
    private WebElement accountButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://automationpractice.com/index.php");
    }

    public void clickLoginButton(){
        loginButton.click();
    }
    public void clickContactButton() {
        contactButton.click();
    }
    public void clickAddProductButton(){
        Actions actionBuilder = new Actions(driver);
        actionBuilder.moveToElement(articleLink).perform();
        actionBuilder.moveToElement(addProductToCartButton).click().perform();
    }
    public void clickCheckoutButton(){
        proceedToCheckoutButton.click();
    }
    public void clickSiteLogo(){
        siteLogo.click();
    }
    public void clickFirstProductLink(){
        firstProductLink.click();
    }
    public void clickAccountButton(){
        accountButton.click();
    }
}
