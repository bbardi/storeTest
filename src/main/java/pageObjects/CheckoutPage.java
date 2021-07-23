package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
    private WebDriver driver;
    @FindBy(xpath="//a[@title=\"Proceed to checkout\" and contains(@class,'standard-checkout')]")
    private WebElement proceedToCheckoutButton;
    @FindBy(id="cgv")
    private WebElement agreeCheckBox;
    @FindBy(name = "processAddress")
    private WebElement processAddressButton;
    @FindBy(name = "processCarrier")
    private WebElement processCarrierButton;
    @FindBy(className = "bankwire")
    private WebElement bankWirePayment;
    @FindBy(className = "cheque")
    private WebElement chequePayment;
    @FindBy(xpath = "//*[@class=\"button btn btn-default button-medium\"]")
    private WebElement finalizeButton;
    @FindBy(xpath = "//*[@class=\"cheque-indent\"]")
    private WebElement orderMessage;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }
    public void clickAgreeCheckBox(){
        agreeCheckBox.click();
    }
    public void clickProcessAddressButton(){
        processAddressButton.click();
    }
    public void clickProcessCarrierButton(){
        processCarrierButton.click();
    }
    public void clickBankWirePaymentButton(){
        bankWirePayment.click();
    }
    public void clickChequePaymentButton(){
        chequePayment.click();
    }
    public void clickFinalizeButton(){
        finalizeButton.click();
    }
    public String getOrderMessage(){
        return orderMessage.getText();
    }
}
