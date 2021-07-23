package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {
    private WebDriver driver;
    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;
    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "passwd")
    private WebElement passwordField;
    @FindBy(id = "firstname")
    private WebElement firstNameAddressField;
    @FindBy(id = "lastname")
    private WebElement lastNameAddressField;
    @FindBy(id = "address1")
    private WebElement addressField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "id_state")
    private WebElement stateField;
    @FindBy(id = "postcode")
    private WebElement postcodeField;
    @FindBy(id = "id_country")
    private WebElement countryField;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;
    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void setFirstNameAddress(String firstName) {
        firstNameAddressField.sendKeys(firstName);
    }

    public void setLastNameAddress(String lastName) {
        lastNameAddressField.sendKeys(lastName);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void setAddress(String address){
        addressField.sendKeys(address);
    }
    public void setCity(String city){
        cityField.sendKeys(city);
    }
    public void setState(String state){
        Select selector = new Select(stateField);
        selector.selectByVisibleText(state);
    }
    public void setPostCode(String postCode){
        postcodeField.sendKeys(postCode);
    }
    public void setCountry(String country){
        Select selector = new Select(countryField);
        selector.selectByVisibleText(country);
    }
    public void setMobilePhone(String phoneNumber){
        mobilePhoneField.sendKeys(phoneNumber);
    }
    public void clickRegister(){
        submitButton.click();
    }
}
