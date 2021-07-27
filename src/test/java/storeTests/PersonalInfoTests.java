package storeTests;

import org.junit.Assert;
import org.junit.Test;
import util.RandomGenerators;

public class PersonalInfoTests extends BaseTests{
    @Test
    public void changeName(){
        String newFirstName = RandomGenerators.generateRandomString(5);
        String newLastName = RandomGenerators.generateRandomString(5);
        newFirstName = newFirstName.substring(0, 1).toUpperCase() + newFirstName.substring(1);
        newLastName = newLastName.substring(0, 1).toUpperCase() + newLastName.substring(1);
        homePage.clickLoginButton();
        authenticationPage.enterEmail("testing@example.com");
        authenticationPage.enterPassword("testing123");
        authenticationPage.clickLogin();
        myAccountPage.clickEditAccountInfoButton();
        personalInformationPage.fillFirstName(newFirstName);
        personalInformationPage.fillLastName(newLastName);
        personalInformationPage.fillCurrentPassword("testing123");
        personalInformationPage.clickSubmitInfo();
        Assert.assertEquals("Your personal information has been successfully updated.",personalInformationPage.getSuccessMessageBox());
        Assert.assertEquals(newFirstName + " " + newLastName, homePage.getFullName());
    }
}
