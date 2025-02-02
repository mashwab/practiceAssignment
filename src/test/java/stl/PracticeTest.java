package stl;

import PageObject.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTest extends BaseTest {

    @Test
    public void registeringUserTest(){
        driver.findElement(By.xpath("//a[@class='dropdown-toggle' and @title='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        regis.firstname().sendKeys(lorem.getFirstName());
        regis.lastname().sendKeys(lorem.getLastName());
        regis.email().sendKeys(lorem.getEmail());
        regis.telephone().sendKeys(lorem.getPhone());
        regis.password().sendKeys("abcdefgh");
        regis.confirmPassword().sendKeys("abcdefgh");
        regis.newsletterCheckbox().click();
        regis.agreeButton().click();
        regis.submitButton().click();

        String validator = driver.findElement(By.xpath("//div [@id='content']//following-sibling::h1")).getText();
        Assert.assertEquals(validator, "Your Account Has Been Created!", "Test successful");
    }
    @Test
    public void orderPlacingTestAsGuestUser(){
        Actions ac = new Actions(driver);
        WebElement desktops = home.desktopSelected();
        ac.moveToElement(desktops).build().perform();

        home.macSelected().click();

        product.iMacSelected().click();

        WebElement inputQuantityField = cart.inputQuantity();
        inputQuantityField.clear();
        inputQuantityField.sendKeys("2");
        cart.addToCartButton().click();
        cart.shoppingCartButton().click();

        shoppingCart.couponDropdown().click();
        shoppingCart.couponCodeField().sendKeys("123");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement checkout = shoppingCart.checkOutButton();
        jse.executeScript("arguments[0].scrollIntoView(true);", checkout);

        General.waitTime();
        shoppingCart.shippingDropdown().click();

        WebElement countryDropdown = shoppingCart.countryField();
        Select countryDropdownSelector = new Select(countryDropdown);
        countryDropdownSelector.selectByVisibleText("Bangladesh");

        WebElement regionDropdown = shoppingCart.regionField();
        Select regionDropdownSelector = new Select(regionDropdown);
        regionDropdownSelector.selectByVisibleText("Dhaka");

        shoppingCart.postCodeField().sendKeys("2000");

        shoppingCart.giftCertificateDropdown().click();
        shoppingCart.giftCertificateField().sendKeys("1234");

        checkout.click();

        String productCheckoutBannerValue = checkOut.productCheckoutBanner().getText().trim();
        String expectedValue = "Products marked with *** are not available in the desired quantity or not in stock!\n" +
                "×";
        Assert.assertEquals(productCheckoutBannerValue, expectedValue, "Test passed");
    }
}
