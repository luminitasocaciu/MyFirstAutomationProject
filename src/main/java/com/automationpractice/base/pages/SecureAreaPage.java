package com.automationpractice.base.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject{

    private String pageUrl = "http://automationpractice.com/index.php?controller=my-account";
    private By logoutButton = By.xpath("//a[@class='logout']");
    private  By message = By.xpath("//p[@class='info-account']");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //get URL variable from PageObject
    public String getPageUrl() {
        return pageUrl;
    }

    //verification if logoutButton is visible on the page
    public boolean isLogoutButtonVisible() {
        return find(logoutButton).isDisplayed();
    }

    //return text from success message
    public String getSuccessMessageText() {
            return find(message).getText();
    }

}
