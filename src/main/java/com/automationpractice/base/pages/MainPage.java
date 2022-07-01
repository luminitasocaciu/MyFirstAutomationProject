package com.automationpractice.base.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePageObject {

    private String pageUrl = "http://automationpractice.com/index.php";
    private By signInLocator = By.xpath("//a[@class='login']");

    public MainPage (WebDriver driver, Logger log) {
        super(driver, log);
    }

    //open mainPage with the URL
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    //open loginPage by clicking signIn button
    public LoginPage clickSignInButton() {
        log.info("Clicking Sign In button on Main Page");
        click(signInLocator);
        return new LoginPage(driver, log);
    }
}
