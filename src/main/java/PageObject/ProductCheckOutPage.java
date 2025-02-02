package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductCheckOutPage extends BasePage{
    public ProductCheckOutPage(WebDriver driver)
    {
        super(driver);
    }
    public WebElement productCheckoutBanner (){
        return driver.findElement(By.xpath("//div[contains(text(), 'Products marked with')]"));
    }
}
