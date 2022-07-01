package com.automationpractice.loginpagetests;

import com.automationpractice.base.base.TestUtilities;
import com.automationpractice.base.pages.LoginPage;
import com.automationpractice.base.pages.MainPage;
import com.automationpractice.base.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestUtilities {

    @Test
    public void loginTest() {
        System.out.println("Starting loginTest");

        //open main page
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        //click on Sign in button
        LoginPage loginPage = mainPage.clickSignInButton();

        //enter username and password
        SecureAreaPage secureAreaPage = loginPage.login("luminitasocaciu@yahoo.com", "steleVerzi");

        //verifications
        //new url
        Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

        //log out button is visible
        Assert.assertTrue(secureAreaPage.isLogoutButtonVisible(), "Logout button is not visible.");

        //successful login message
        String expectedSuccessMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                   + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }
}
