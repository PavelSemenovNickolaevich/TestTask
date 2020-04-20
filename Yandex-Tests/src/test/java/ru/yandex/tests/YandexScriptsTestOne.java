package ru.yandex.tests;

import org.junit.*;
import ru.yandex.data.NoteData;

import static org.junit.Assert.assertThat;

public class YandexScriptsTestOne extends TestBase {

    @Test
    public void testYandexOne () throws Exception {
        app.testHelper().findYandexMarket();
        app.testHelper().selectProductNote();
        if (app.testHelper().isNotebookHeaderPresent()) {
            System.out.println("Header exist");
        } else {
            System.out.println("Header doesn't exist");
        }
        app.testHelper().setHighPrice();
        app.testHelper().selectOptionNote();
        String optionList = app.testHelper().showTwelve();
        String numberElement = String.valueOf(app.testHelper().countElements());
        String dataBefore = String.valueOf(app.testHelper().getInfoBefore());
        app.testHelper().setProduct();
        String dataAfter = String.valueOf(app.testHelper().getInfoAfter());

        Assert.assertEquals(numberElement, cleaned(optionList));
        Assert.assertEquals(cleanedTitle(dataAfter), dataBefore);
        System.out.println(dataAfter);
        System.out.println(dataBefore);
    }

    public String cleaned (String list) {
        return list.replaceAll("\\s", "")
                .replaceAll("Показыватьпо", "");
    }

    public String cleanedTitle (String nameComp) {
        return nameComp.replaceAll(", цвет: черный", "");
    }


}

