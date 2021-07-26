package storeTests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class BaseTests {
    public WebDriver driver;
    public HomePage homePage;
    public AuthenticationPage authenticationPage;
    public MyAccountPage myAccountPage;
    public AccountCreationPage accountCreationPage;
    public CheckoutPage checkoutPage;
    public MyWishListsPage wishListsPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = PageFactory.initElements(driver, HomePage.class);
        authenticationPage = PageFactory.initElements(driver, AuthenticationPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
        checkoutPage = PageFactory.initElements(driver,CheckoutPage.class);
        wishListsPage = PageFactory.initElements(driver,MyWishListsPage.class);
    }
    @After
    public void finish(){
        driver.quit();
    }

    public String generateRandomString(int length){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        return random.ints(leftLimit,rightLimit)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
