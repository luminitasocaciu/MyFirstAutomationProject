package com.automationpractice.base.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    private By usernameLocator = By.id("email");
    private By passwordLocator = By.id("passwd");
    private By loginButtonLocator = By.xpath("//span[text()='Sign in']");
    private By errorMessageLocator = By.xpath("//li[text()='Authentication failed.']");

    public LoginPage (WebDriver driver, Logger log) {
        super(driver, log);
    }

    //execute the login
    public SecureAreaPage login(String username, String password) {
        log.info("Executing the login with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginButtonLocator);
        return new SecureAreaPage(driver, log);
    }

    public void negativeLogin(String username, String password) {
        log.info("executing negative login with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginButtonLocator);
    }

    public void waitForErrorMessage() {
        waitForVisibilityOf(errorMessageLocator, 5);
    }

    public String getErrorMessageText() {
        return find(errorMessageLocator).getText();
    }
}
