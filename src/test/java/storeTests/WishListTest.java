package storeTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MyWishListsPage;

public class WishListTest extends BaseTests {
    @Test
    public void createWishList(){
        homePage.clickLoginButton();
        authenticationPage.enterEmail("testing@example.com");
        authenticationPage.enterPassword("testing123");
        authenticationPage.clickLogin();
        myAccountPage.clickWishListButton();
        String wishlistName = generateRandomString(10);
        wishListsPage.sendWishListName(wishlistName);
        wishListsPage.clickSubmitWishListButton();
        Assert.assertTrue(wishListsPage.wishListExists(wishlistName));
    }
    @Test
    public void deleteWishList() {
        homePage.clickLoginButton();
        authenticationPage.enterEmail("testing@example.com");
        authenticationPage.enterPassword("testing123");
        authenticationPage.clickLogin();
        myAccountPage.clickWishListButton();
        String wishlistName = generateRandomString(10);
        wishListsPage.sendWishListName(wishlistName);
        wishListsPage.clickSubmitWishListButton();
        Assert.assertTrue(wishListsPage.wishListExists(wishlistName));
        wishListsPage.deleteWishlist(wishlistName);
        wishListsPage.confirmDeletion();
        new WebDriverWait(driver,1).until(e-> !wishListsPage.wishListExists(wishlistName));
        Assert.assertFalse(wishListsPage.wishListExists(wishlistName));
    }
}
