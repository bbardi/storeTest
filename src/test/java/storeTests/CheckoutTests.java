package storeTests;

import org.junit.Assert;
import org.junit.Test;

public class CheckoutTests extends BaseTests {
    @Test
    public void checkoutWithoutBeingLoggedIn(){
        homePage.clickAddProductButton();
        homePage.clickCheckoutButton();
        checkoutPage.clickProceedToCheckoutButton();
        authenticationPage.enterEmail("testing@example.com");
        authenticationPage.enterPassword("testing123");
        authenticationPage.clickLogin();
        checkoutPage.clickProcessAddressButton();
        checkoutPage.clickAgreeCheckBox();
        checkoutPage.clickProcessCarrierButton();
        checkoutPage.clickBankWirePaymentButton();
        checkoutPage.clickFinalizeButton();
        Assert.assertEquals("Your order on My Store is complete.",checkoutPage.getOrderMessage());
    }
}
