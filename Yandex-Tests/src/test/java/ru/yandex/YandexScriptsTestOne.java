package ru.yandex;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class YandexScriptsTestOne {
    private WebDriver wd;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        wd = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testYandex() throws Exception {
        wd.get("https://yandex.ru/");
        wd.findElement(By.id("text")).clear();
        wd.findElement(By.id("text")).sendKeys("yandexmarket");
        wd.findElement(By.id("text")).sendKeys(Keys.ENTER);
        wd.findElement(By.id("uniq15871144151781358861")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
        wd.findElement(By.xpath("//div[5]/div/a/span")).click();
        wd.findElement(By.linkText("Ноутбуки")).click();
        wd.findElement(By.id("glpriceto")).click();
        wd.findElement(By.id("glpriceto")).clear();
        wd.findElement(By.id("glpriceto")).sendKeys("30000");
        wd.findElement(By.xpath("//div[@id='search-prepack']/div/div/div[3]/div/div/div[2]/div[2]/div/div/fieldset/ul/li[6]/div/a/label/div")).click();
        wd.findElement(By.xpath("//div[@id='search-prepack']/div/div/div[3]/div/div/div[2]/div[2]/div/div/fieldset/ul/li[8]/div/a/label/div")).click();
        wd.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        wd.findElement(By.xpath("//div[@id='uniq15872317257651']/span")).click();
        wd.findElement(By.id("header-search")).click();
        wd.findElement(By.id("header-search")).clear();
        wd.findElement(By.id("header-search")).sendKeys("Ноутбук HP 15-db0");
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @After
    public void tearDown() throws Exception {
        wd.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
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
