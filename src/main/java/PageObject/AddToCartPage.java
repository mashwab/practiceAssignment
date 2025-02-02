package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage extends BasePage{
    //protected WebDriver driver;
    public AddToCartPage(WebDriver driver)
    {
        super(driver);
    }
    public WebElement inputQuantity (){
        return driver.findElement(By.xpath("//input[@id='input-quantity']"));
    }
    public WebElement addToCartButton (){
        return driver.findElement(By.id("button-cart"));
    }
    public WebElement shoppingCartButton (){
        return driver.findElement(By.xpath("//i/following-sibling::span[text() = 'Shopping Cart']"));
    }
}
