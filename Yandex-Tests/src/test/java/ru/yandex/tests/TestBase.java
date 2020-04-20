package ru.yandex.tests;

//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.yandex.appmanager.ApplicationManager;

//import static org.junit.Assert.fail;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeClass
    public void setUp () throws Exception {
        app.initYandexMarketSearch();
    }

    @AfterClass
    public void tearDown () throws Exception {
        app.stop();
    }


}
