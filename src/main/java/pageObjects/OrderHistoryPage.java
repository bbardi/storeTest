package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OrderHistoryPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a")
    private WebElement firstOrderLink;
    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[7]/a[2]")
    private WebElement firstOrderReorderLink;
    @FindBy(xpath = "//*[@id=\"sendOrderMessage\"]/p[1]")
    private WebElement sendMessageText;
    @FindBy(xpath = "//button[@name=\"submitMessage\"]")
    private WebElement sendMessageButton;
    @FindBy(name="id_product")
    private WebElement productSelector;
    @FindBy(name="msgText")
    private WebElement messageBox;
    @FindBy(xpath="//*[@class=\"alert alert-success\"]")
    private WebElement successMessage;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickFirstOrderLink(){
        firstOrderLink.click();
    }
    public String getSendMessageText(){
        return sendMessageText.getText();
    }
    public void clickSendMessageButton(){
        sendMessageButton.click();
    }
    public void selectProduct(String value){
        Select selector = new Select(productSelector);
        selector.selectByValue(value);
    }
    public void setMessage(String message){
        messageBox.sendKeys(message);
    }
    public String getSuccessMessage(){
        return successMessage.getText();
    }
    public void clickReorder(){
        firstOrderReorderLink.click();
    }
}
