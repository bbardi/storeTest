package storeTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        wishListsPage.deleteWishlist(wishlistName);
        wishListsPage.confirmDeletion();
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
    @Test
    public void addToWishList(){
        homePage.clickLoginButton();
        authenticationPage.enterEmail("testing@example.com");
        authenticationPage.enterPassword("testing123");
        authenticationPage.clickLogin();
        myAccountPage.clickWishListButton();
        String wishlistName = generateRandomString(10);
        wishListsPage.sendWishListName(wishlistName);
        wishListsPage.clickSubmitWishListButton();
        homePage.clickSiteLogo();
        homePage.clickFirstProductLink();
        productPage.clickAddToWishList();
        Assert.assertEquals("Added to your wishlist.",productPage.getMessageBoxText());
        productPage.clickCloseMessageBox();
        homePage.clickAccountButton();
        myAccountPage.clickWishListButton();
        Assert.assertEquals("1",wishListsPage.getQuantity(wishlistName));
        wishListsPage.deleteWishlist(wishlistName);
        wishListsPage.confirmDeletion();
    }
}
