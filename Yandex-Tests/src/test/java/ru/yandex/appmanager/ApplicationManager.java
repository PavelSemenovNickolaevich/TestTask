package ru.yandex.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    protected WebDriver wd;

    private boolean acceptNextAlert = true;

    public void stop () {
        wd.quit();
    }

    public void initYandexMarketSearch () {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("https://yandex.ru/");
        wd.manage().window().setSize(new Dimension(1920, 1080));
        wd.findElement(By.id("text")).clear();
        wd.findElement(By.id("text")).sendKeys("yandexmarket");
        wd.findElement(By.id("text")).sendKeys(Keys.ENTER);
    }

    public boolean isElementPresent (By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent () {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText () {
        try {
            Alert alert = wd.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
