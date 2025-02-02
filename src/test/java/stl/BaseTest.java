package stl;

import PageObject.*;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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
    protected final Properties property;
    public BaseTest() {
        String filePath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"Resource"+File.separator+"config.properties";
        property = new Properties();
        try
        {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            property.load(fileInputStream);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void openBrowser() {
        String browserName = property.getProperty("browserName");
        String url = property.getProperty("baseURL");

        if(browserName.equalsIgnoreCase("FIREFOX")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("CHROME")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            System.out.println("No such browser has been found");
        }

        driver.get(url);
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