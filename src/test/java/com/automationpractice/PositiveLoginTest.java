package com.automationpractice;

import com.automationpractice.base.base.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestUtilities {

    @Test
    public void loginTest() {
        System.out.println("Starting loginTest");

        //open main page
        String url = "http://automationpractice.com/index.php";
        driver.get(url);
        System.out.println("Main page is opened.");

        //click on Sign in button
        driver.findElement(By.xpath("a[@class='login']")).click();

        //enter username and password
        driver.findElement(By.id("email")).sendKeys("luminitasocaciu@yahoo.com");
        driver.findElement(By.id("passwd")).sendKeys("steleVerzi");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        sleep(3000);

        //click login button
        WebElement loginButton = driver.findElement(By.id("SubmitLogin"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        //verifications
        //new url
        String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        //log out button is visible
        Assert.assertTrue(driver.findElement(By.xpath("a[@class='logout']")).isDisplayed(),
                "logout button is not visible");

        //successful login message
        String expectedSuccessMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
        String actualSuccessMessage = driver.findElement(By.xpath("//p[@class='info-account']")).getText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                   + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }
}
