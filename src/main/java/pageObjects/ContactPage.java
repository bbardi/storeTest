package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
    private WebDriver driver;
    @FindBy(id="id_contact")
    private WebElement subjectHeading;
    @FindBy(id="email")
    private WebElement email;
    @FindBy(id="id_order")
    private WebElement orderRef;
    @FindBy(id="submitMessage")
    private WebElement submitButton;
    @FindBy(id="message")
    private WebElement messageBox;
    @FindBy(xpath="//*[@class=\"alert alert-success\"]")
    private WebElement successMessage;
    @FindBy(xpath="//*[@class=\"alert alert-danger\"]")
    private WebElement failMessageBox;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillEmail(String email){
        this.email.sendKeys(email);
    }
    public void fillMessageBox(String message){
        this.messageBox.sendKeys(message);
    }
    public void selectHeading(String text){
        Select selector = new Select(subjectHeading);
        selector.selectByVisibleText(text);
    }
    public void clickSubmit(){
        submitButton.click();
    }
    public String getSuccessMessage(){
        return successMessage.getText();
    }
    public String getFailMessage(){
        return failMessageBox.findElement(By.tagName("li")).getText();
    }
}
