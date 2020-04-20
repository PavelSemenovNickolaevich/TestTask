package ru.yandex.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;
import ru.yandex.appmanager.ApplicationManager;

import static org.junit.Assert.fail;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @Before
    public void setUp () throws Exception {
        app.initYandexMarketSearch();
    }

    @After
    public void tearDown () throws Exception {
        app.stop();
    }


}
