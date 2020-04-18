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

    public void findProduct () {
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void selectOption () {
        wd.findElement(By.xpath("//div[@id='search-prepack']/div/div/div[3]/div/div/div[2]/div[2]/div/div/fieldset/ul/li[6]/div/a/label/div")).click();
        wd.findElement(By.xpath("//div[@id='search-prepack']/div/div/div[3]/div/div/div[2]/div[2]/div/div/fieldset/ul/li[8]/div/a/label/div")).click();
        wd.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        wd.findElement(By.xpath("//div[@id='uniq15872317257651']/span")).click();
    }

    public void changeWindow () {
        wd.switchTo().window("https://market.yandex.ru/");
    }

    public void selectProduct () {
        wd.findElement(By.cssSelector("div._1vnugfYUli")).click();
        wd.findElement(By.linkText("\"Ноутбуки\"")).click();
    }

    public void setProduct () {
        wd.findElement(By.id("header-search")).click();
        wd.findElement(By.id("header-search")).clear();
        wd.findElement(By.id("header-search")).sendKeys("Ноутбук HP 15-db0");
    }

    public void setHighPrice () {
        wd.findElement(By.id("glpriceto")).click();
        wd.findElement(By.id("glpriceto")).clear();
        wd.findElement(By.id("glpriceto")).sendKeys("30000");
    }

    public void findYandexMarket () {
        wd.findElements(By.cssSelector("div.organic__url-text")).get(0).click();
    }
}
