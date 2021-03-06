package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyWishListsPage {
    private WebDriver driver;
    @FindBy(id="name")
    private WebElement wishlistNameCheckbox;
    @FindBy(name = "submitWishlist")
    private WebElement submitWishListButton;
    @FindBy(xpath="//*[@id=\"block-history\"]/table/tbody/tr/*[@style=\"width:200px;\"]")
    private List<WebElement> wishListNames;
    @FindBy(xpath="//*[@id=\"block-history\"]/table/tbody/tr/*[@class=\"wishlist_delete\"]/a")
    private List<WebElement> wishListDeleteButtons;
    @FindBy(xpath = "//*[@id=\"block-history\"]/table/tbody/tr/td[2]")
    private List<WebElement> quantityList;
    @FindBy(xpath = "//a[@class=\"lnkdel\"][1]")
    private WebElement deleteFirstItemFromWishlist;

    public MyWishListsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void sendWishListName(String name){
        wishlistNameCheckbox.sendKeys(name);
    }
    public void clickSubmitWishListButton(){
        submitWishListButton.click();
    }

    public boolean wishListExists(String wishlistName) {
        return wishListNames.stream()
                .map(WebElement::getText)
                .anyMatch(el -> el.equals(wishlistName));
    }
    public void clickWishList(String wishListName){
        for(WebElement el : wishListNames){
            if(wishListName.equals(el.getText())){
                el.findElement(By.tagName("a")).click();
            }
        }
    }
    public void deleteWishlist(String wishlistName){
        int i = 0;
        for(WebElement el : wishListNames){
            if(wishlistName.equals(el.getText())){
                break;
            }
            i++;
        }
        wishListDeleteButtons.get(i).click();
    }
    public void confirmDeletion(){
        driver.switchTo().alert().accept();
    }
    public String getQuantity(String wishlistName){
        int i = 0;
        for(WebElement el : wishListNames){
            if(wishlistName.equals(el.getText())){
                break;
            }
            i++;
        }
        return quantityList.get(i).getText();
    }
    public void clickDeleteItemFromWishlist(){
        deleteFirstItemFromWishlist.click();
    }
}
