package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInformationPage {
    private WebDriver driver;
    @FindBy(id="firstname")
    private WebElement firstNameField;
    @FindBy(id="lastname")
    private WebElement lastNameField;
    @FindBy(id="email")
    private WebElement emailField;
    @FindBy(id="old_passwd")
    private WebElement currentPasswordField;
    @FindBy(id="passwd")
    private WebElement newPasswordField;
    @FindBy(id="confirmation")
    private WebElement newPasswordConfirmField;
    @FindBy(xpath = "//*[@class=\"alert alert-success\"]")
    private WebElement successMessageBox;
    @FindBy(name = "submitIdentity")
    private WebElement submitInfo;

    public PersonalInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstName(String name){
        firstNameField.clear();
        firstNameField.sendKeys(name);
    }
    public void fillLastName(String name) {
        lastNameField.clear();
        lastNameField.sendKeys(name);
    }
    public void fillEMail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void fillCurrentPassword(String passwd){
        currentPasswordField.sendKeys(passwd);
    }
    public void fillNewPassword(String passwd){
       newPasswordField.sendKeys(passwd);
    }
    public void fillNewPasswordConfirm(String passwd){
        newPasswordConfirmField.sendKeys(passwd);
    }
    public String getSuccessMessageBox(){
        return successMessageBox.getText();
    }
    public void clickSubmitInfo(){
        submitInfo.click();
    }
}
