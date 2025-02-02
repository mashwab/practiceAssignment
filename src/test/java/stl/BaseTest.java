package stl;

import PageObject.*;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    BasePage basePage;
    protected Lorem lorem;
    RegistrationPage regis;
    HomePage home;
    ShoppingCartPage shoppingCart;
    ProductPage product;
    AddToCartPage cart;
    ProductCheckOutPage checkOut;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://tutorialsninja.com/demo/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        basePage = new BasePage(driver);
        lorem = LoremIpsum.getInstance();

        regis = new RegistrationPage(driver);
        home = new HomePage(driver);
        shoppingCart = new ShoppingCartPage(driver);
        product = new ProductPage(driver);
        cart = new AddToCartPage(driver);
        checkOut = new ProductCheckOutPage(driver);
    }

    @AfterMethod
    public void closingBrowser() {
       driver.quit();
    }
}