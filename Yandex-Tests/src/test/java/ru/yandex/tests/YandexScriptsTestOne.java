package ru.yandex.tests;

import org.junit.*;

import org.openqa.selenium.*;

public class YandexScriptsTestOne extends TestBase {

    @Test
    public void testYandex () throws Exception {
        applicationManager.findYandexMarket();
        applicationManager.changeWindow();
        applicationManager.selectProduct();
        applicationManager.setHighPrice();
        applicationManager.selectOption();
        applicationManager.setProduct();
        applicationManager.findProduct();
    }

}
