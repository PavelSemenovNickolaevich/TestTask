package ru.yandex.tests;

import org.junit.*;

public class YandexScriptsTestOne extends TestBase {

    @Test
    public void testYandex () throws Exception {
        app.getTestsHelper().findYandexMarket();
        app.getTestsHelper().selectProduct();
        if (app.getTestsHelper().isNotebookHeaderPresent()) {
            System.out.println("Header exist");
        } else {
            System.out.println("Header doesnt exist");
        }
        app.getTestsHelper().setHighPrice();
        app.getTestsHelper().selectOption();
        app.getTestsHelper().setProduct();
        //       app.findProduct();
    }


}

