package storeTests;

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
}
