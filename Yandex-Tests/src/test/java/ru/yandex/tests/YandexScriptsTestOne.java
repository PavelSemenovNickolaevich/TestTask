package ru.yandex.tests;

import org.junit.*;

public class YandexScriptsTestOne extends TestBase {

    @Test
    public void testYandex () throws Exception {
        app.findYandexMarket();
        app.selectProduct();
        //       app.setHighPrice();
        //      app.selectOption();
        //       app.setProduct();
        //       app.findProduct();
    }

}
