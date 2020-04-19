package ru.yandex.tests;

import org.junit.*;

import static org.junit.Assert.assertThat;

public class YandexScriptsTestOne extends TestBase {

    @Test
    public void testYandex () throws Exception {
        app.testHelper().findYandexMarket();
        app.testHelper().selectProduct();
        if (app.testHelper().isNotebookHeaderPresent()) {
            System.out.println("Header exist");
        } else {
            System.out.println("Header doesnt exist");
        }
        app.testHelper().setHighPrice();
        app.testHelper().selectOption();
        String optionList = app.testHelper().showTwelve();
        String numberElement = String.valueOf(app.testHelper().countElements());
        app.testHelper().setProduct();
        //       app.findProduct();

        Assert.assertEquals(numberElement,cleaned(optionList));
    }

    public  String cleaned (String list) {
        return list.replaceAll("\\s", "").replaceAll("Показыватьпо", "");
    }


}

