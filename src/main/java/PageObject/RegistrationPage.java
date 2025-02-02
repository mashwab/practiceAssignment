package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver)
    {
        super(driver);
    }
    public WebElement firstname (){
        return driver.findElement(By.id("input-firstname"));
    }
    public WebElement lastname (){
        return driver.findElement(By.id("input-lastname"));
    }
    public WebElement email (){
        return driver.findElement(By.id("input-email"));
    }
    public WebElement telephone (){
        return driver.findElement(By.id("input-telephone"));
    }
    public WebElement password (){
        return driver.findElement(By.id("input-password"));
    }
    public WebElement confirmPassword (){
        return driver.findElement(By.id("input-confirm"));
    }
    public WebElement newsletterCheckbox (){
        return driver.findElement(By.name("newsletter"));
    }
    public WebElement agreeButton (){
        return driver.findElement(By.name("agree"));
    }
    public WebElement submitButton (){
        return driver.findElement(By.xpath("//input[@type='submit']"));
    }

}
