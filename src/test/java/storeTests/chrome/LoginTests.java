package storeTests.chrome;

import org.junit.Assert;
import org.junit.Test;

public class LoginTests extends BaseTests {
    @Test
    public void shouldSuccessfullyLogIn(){
        homePage.clickLoginButton();
        authenticationPage.enterEmail("testing@example.com");
        authenticationPage.enterPassword("testing123");
        authenticationPage.clickLogin();
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",myAccountPage.getWelcomeMessage());
    }
    @Test
    public void shouldFailLogIn(){
        homePage.clickLoginButton();
        authenticationPage.enterEmail("testing@example.com");
        authenticationPage.enterPassword("thisisinvalid");
        authenticationPage.clickLogin();
        Assert.assertEquals("Authentication failed.",authenticationPage.getErrorMessage());
    }
    @Test
    public void shouldFailInvalidEMail(){
        homePage.clickLoginButton();
        authenticationPage.enterEmail("testing@examp");
        authenticationPage.enterPassword("thisisinvalid");
        authenticationPage.clickLogin();
        Assert.assertEquals("Invalid email address.",authenticationPage.getErrorMessage());
    }
    @Test
    public void shouldFailInvalidPassword(){
        homePage.clickLoginButton();
        authenticationPage.enterEmail("testing@example.com");
        authenticationPage.enterPassword("this");
        authenticationPage.clickLogin();
        Assert.assertEquals("Invalid password.",authenticationPage.getErrorMessage());
    }
}
