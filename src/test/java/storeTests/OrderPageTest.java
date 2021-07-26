package storeTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageTest extends BaseTests{
    @Test
    public void canSeeOrderInformation(){
        homePage.clickLoginButton();
        authenticationPage.enterEmail("testing@example.com");
        authenticationPage.enterPassword("testing123");
        authenticationPage.clickLogin();
        myAccountPage.clickOrderHistoryButton();
        orderHistoryPage.clickFirstOrderLink();
        Assert.assertEquals("If you would like to add a comment about your order, please write it in the field below.",orderHistoryPage.getSendMessageText());
    }
    @Test
    public void canSendMessages(){
        homePage.clickLoginButton();
        authenticationPage.enterEmail("testing@example.com");
        authenticationPage.enterPassword("testing123");
        authenticationPage.clickLogin();
        myAccountPage.clickOrderHistoryButton();
        orderHistoryPage.clickFirstOrderLink();
        orderHistoryPage.selectProduct("1");
        orderHistoryPage.setMessage("Testing");
        orderHistoryPage.clickSendMessageButton();
        Assert.assertEquals("Message successfully sent",orderHistoryPage.getSuccessMessage());
    }
    @Test
    public void reorder(){
        homePage.clickLoginButton();
        authenticationPage.enterEmail("testing@example.com");
        authenticationPage.enterPassword("testing123");
        authenticationPage.clickLogin();
        myAccountPage.clickOrderHistoryButton();
        orderHistoryPage.clickReorder();
        checkoutPage.clickProceedToCheckoutButton();
        checkoutPage.clickProcessAddressButton();
        checkoutPage.clickAgreeCheckBox();
        checkoutPage.clickProcessCarrierButton();
        checkoutPage.clickBankWirePaymentButton();
        checkoutPage.clickFinalizeButton();
        Assert.assertEquals("Your order on My Store is complete.",checkoutPage.getOrderMessage());
    }
}
