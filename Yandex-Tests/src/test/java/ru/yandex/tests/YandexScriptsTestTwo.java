package ru.yandex.tests;

import org.junit.Test;

public class YandexScriptsTestTwo extends TestBase {


    @Test
    public void testYandexTwo() throws InterruptedException {
        app.testHelper().findYandexMarket();
        app.testHelper().selectProductTable();
        app.testHelper().setPrice();
        if (app.testHelper().isTabHeaderPresent()) {
            System.out.println("Header exist");
        } else {
            System.out.println("Header doesn't exist");
        }
        app.testHelper().selectOptionTab();
    }
}
