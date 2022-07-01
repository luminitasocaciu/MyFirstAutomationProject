package com.automationpractice.base.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject (WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    //open page with giver URL
    protected void openUrl(String url) {
        driver.get(url);
    }

    //find element using given locator
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    //click on element with given locator when it is visible
    protected void click(By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    //type given text into element with given locator
    protected void type(String text, By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

    //get URL of current page from browser
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    //wait for specific expectedCondition for the given amount of time in sec

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 50;
        Duration seconds = Duration.ofSeconds(timeOutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(condition);
    }

    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null);
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

}
