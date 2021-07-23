package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage {
    private WebDriver driver;
    @FindBy(id="SubmitLogin")
    private WebElement loginButton;
    @FindBy(id="email")
    private WebElement loginEmail;
    @FindBy(id="passwd")
    private WebElement loginPassword;
    @FindBy(xpath="//*[@class=\"alert alert-danger\"]")
    private WebElement failMessageBox;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email){
        loginEmail.sendKeys(email);
    }
    public void enterPassword(String password){
        loginPassword.sendKeys(password);
    }
    public void clickLogin(){
        loginButton.click();
    }
    public String getErrorMessage(){
        return failMessageBox.findElement(By.tagName("li")).getText();
    }
}
