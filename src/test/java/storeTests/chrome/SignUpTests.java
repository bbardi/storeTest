package storeTests.chrome;

import org.junit.Assert;
import org.junit.Test;
import util.RandomGenerators;

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
        String firstName = RandomGenerators.generateRandomString(10);
        String lastName = RandomGenerators.generateRandomString(10);
        homePage.clickLoginButton();
        authenticationPage.enterSignUpEmail(firstName+lastName+"@example.com");
        authenticationPage.clickSignUp();
        accountCreationPage.setFirstName(firstName);
        accountCreationPage.setLastName(lastName);
        accountCreationPage.setPassword(RandomGenerators.generateRandomString(10));
        accountCreationPage.setFirstNameAddress(firstName);
        accountCreationPage.setLastNameAddress(lastName);
        accountCreationPage.setAddress(RandomGenerators.generateRandomString(10));
        accountCreationPage.setCity(RandomGenerators.generateRandomString(10));
        accountCreationPage.setState("Arizona");
        accountCreationPage.setPostCode("12345");
        accountCreationPage.setCountry("United States");
        accountCreationPage.setMobilePhone("1234567890");
        accountCreationPage.clickRegister();
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",myAccountPage.getWelcomeMessage());
    }
}
