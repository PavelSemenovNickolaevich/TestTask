package ru.yandex.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver wd;
    private TestsHelper testsHelper;
    private String browser;

    public ApplicationManager (String browser) {
        this.browser = browser;
    }


    public void initYandexMarketSearch () throws InterruptedException {
        if (browser == BrowserType.CHROME) {
            wd = new ChromeDriver();
        } else if (browser == BrowserType.FIREFOX) {
            wd = new FirefoxDriver();
        }
        wd.manage().window().maximize();
        wd.get("https://yandex.ru/");
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wd.findElement(By.id("text")).clear();
        wd.findElement(By.id("text")).sendKeys("yandex market");
        wd.findElement(By.id("text")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        testsHelper = new TestsHelper(wd);
    }

    public void stop () {
        wd.quit();
    }

    public TestsHelper testHelper () {
        return testsHelper;
    }
}
