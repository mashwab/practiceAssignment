package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver)
    {
        super(driver);
    }
    public WebElement iMacSelected (){
        return driver.findElement(By.xpath("//a[contains(text(), 'iMac')]"));
    }
}
