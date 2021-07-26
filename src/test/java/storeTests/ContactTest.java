package storeTests;

import org.junit.Assert;
import org.junit.Test;

public class ContactTest extends BaseTests{
    @Test
    public void sendMessage(){
        homePage.clickContactButton();
        contactPage.selectHeading("Customer service");
        contactPage.fillEmail(generateRandomString(5)+"@testing.com");
        contactPage.fillMessageBox("Testing");
        contactPage.clickSubmit();
        Assert.assertEquals("Your message has been successfully sent to our team.",contactPage.getSuccessMessage());
    }
    @Test
    public void sendMessageWhileLoggedIn(){
        homePage.clickLoginButton();
        authenticationPage.enterEmail("testing@example.com");
        authenticationPage.enterPassword("testing123");
        authenticationPage.clickLogin();
        homePage.clickContactButton();
        contactPage.selectHeading("Customer service");
        contactPage.fillMessageBox("Testing");
        contactPage.clickSubmit();
        Assert.assertEquals("Your message has been successfully sent to our team.",contactPage.getSuccessMessage());
    }
    @Test
    public void sendMessageHeadingUnselected(){
        homePage.clickContactButton();
        contactPage.fillEmail(generateRandomString(5)+"@testing.com");
        contactPage.fillMessageBox("Testing");
        contactPage.clickSubmit();
        Assert.assertEquals("Please select a subject from the list provided.",contactPage.getFailMessage());
    }
    @Test
    public void sendMessageInvalidEMail(){
        homePage.clickContactButton();
        contactPage.selectHeading("Customer service");
        contactPage.fillEmail(generateRandomString(5));
        contactPage.fillMessageBox("Testing");
        contactPage.clickSubmit();
        Assert.assertEquals("Invalid email address.",contactPage.getFailMessage());
    }
}
