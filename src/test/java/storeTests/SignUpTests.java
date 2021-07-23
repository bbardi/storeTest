package storeTests;

import org.junit.Assert;
import org.junit.Test;

public class SignUpTests extends BaseTests {
    @Test
    public void testInvalidEmail(){
        homePage.clickLoginButton();
        authenticationPage.enterSignUpEmail("invalid");
        authenticationPage.clickSignUp();
        Assert.assertEquals("Invalid email address.",authenticationPage.getErrorMessage());
    }
    @Test
    public void shouldSuccessfullyCreateAccount(){
        String firstName = generateRandomString(10);
        String lastName = generateRandomString(10);
        homePage.clickLoginButton();
        authenticationPage.enterSignUpEmail(firstName+lastName+"@example.com");
        authenticationPage.clickSignUp();
        accountCreationPage.setFirstName(firstName);
        accountCreationPage.setLastName(lastName);
        accountCreationPage.setPassword(generateRandomString(10));
        accountCreationPage.setFirstNameAddress(firstName);
        accountCreationPage.setLastNameAddress(lastName);
        accountCreationPage.setAddress(generateRandomString(10));
        accountCreationPage.setCity(generateRandomString(10));
        accountCreationPage.setState("Arizona");
        accountCreationPage.setPostCode("12345");
        accountCreationPage.setCountry("United States");
        accountCreationPage.setMobilePhone("1234567890");
        accountCreationPage.clickRegister();
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",myAccountPage.getWelcomeMessage());
    }
}
