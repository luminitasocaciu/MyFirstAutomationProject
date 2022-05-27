package com.automationpractice.base.base;

public class TestUtilities extends BaseTest {

    //Static sleep
    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
