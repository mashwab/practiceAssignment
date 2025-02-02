package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    public WebElement desktopSelected (){
        return driver.findElement(By.xpath("//a[text()='Desktops']"));
    }
    public WebElement macSelected (){
        return driver.findElement(By.xpath("//a[contains(text(), 'Mac ')]"));
    }
}
