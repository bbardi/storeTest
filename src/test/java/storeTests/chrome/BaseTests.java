package storeTests.chrome;

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
    public OrderHistoryPage orderHistoryPage;
    public ContactPage contactPage;
    public ProductPage productPage;
    public PersonalInformationPage personalInformationPage;

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
        orderHistoryPage = PageFactory.initElements(driver,OrderHistoryPage.class);
        contactPage = PageFactory.initElements(driver,ContactPage.class);
        productPage = PageFactory.initElements(driver,ProductPage.class);
        personalInformationPage = PageFactory.initElements(driver,PersonalInformationPage.class);
    }
    @After
    public void finish(){
        driver.quit();
    }

}
