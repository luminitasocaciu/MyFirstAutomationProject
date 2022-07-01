package com.automationpractice.loginpagetests;

import com.automationpractice.base.base.TestUtilities;
import com.automationpractice.base.pages.LoginPage;
import com.automationpractice.base.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestUtilities {

    @Parameters({ "username", "password", "expectedMessage" })
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting negativeTest");

        //open main page
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        //click signIn button
        LoginPage loginPage = mainPage.clickSignInButton();

        //make a negative login
        loginPage.negativeLogin(username, password);

        //wait for error message
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();

        //Verification
        Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
    }
}
