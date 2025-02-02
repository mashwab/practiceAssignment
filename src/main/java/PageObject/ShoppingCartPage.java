package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement couponDropdown() {
        return driver.findElement(By.xpath("//a[text() = 'Use Coupon Code ']"));
    }

    public WebElement couponCodeField() {
        return driver.findElement(By.xpath("//div/input[@name='coupon']"));
    }

    public WebElement shippingDropdown() {
        return driver.findElement(By.xpath("//a[normalize-space() = 'Estimate Shipping & Taxes']"));
    }

    public WebElement countryField() {
        return driver.findElement(By.xpath("//div/select[@id='input-country']"));
    }

    public WebElement regionField() {
        return driver.findElement(By.xpath("//div/select[@id='input-zone']"));
    }

    public WebElement postCodeField() {
        return driver.findElement(By.xpath("//div/input[@name='postcode']"));
    }

    public WebElement giftCertificateDropdown() {
        return driver.findElement(By.xpath("//a[normalize-space()='Use Gift Certificate']"));
    }

    public WebElement giftCertificateField() {
        return driver.findElement(By.xpath("//input[@name='voucher' and @id='input-voucher']"));
    }

    public WebElement checkOutButton() {
        return driver.findElement(By.xpath("//a[text() = 'Checkout']"));
    }
}
