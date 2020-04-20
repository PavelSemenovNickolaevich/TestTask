package ru.yandex.tests;

//import org.junit.Assert;
//import org.junit.Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.data.TabData;

public class YandexScriptsTestTwo extends TestBase {


    @Test
    public void testYandexTwo () throws InterruptedException {
        app.testHelper().findYandexMarket();
        app.testHelper().selectProductTable();
        app.testHelper().setPrice();
        if (app.testHelper().isTabHeaderPresent()) {
            System.out.println("Header exists");
        } else {
            System.out.println("Header doesn't exist");
        }
        app.testHelper().selectOptionTab();
        //       if (app.testHelper().isCountListExists() == true) {
        //           System.out.println("Option list exists");
//        } else {
//            System.out.println("Option list doesn't exist");
//        }
        int count = app.testHelper().count();
        TabData infoBefore = app.testHelper().getInfoBeforeSearch();
        app.testHelper().setProductTab();
        TabData infoAfter = app.testHelper().getInfoAfterSearch();
        System.out.println(count);

        Assert.assertTrue(count != 12 && count < 12);
        Assert.assertEquals(infoAfter, infoBefore);
    }
}
