package ru.yandex.appmanager;

import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.tests.TestBase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    protected WebDriver wd;
    private boolean acceptNextAlert = true;


    public void initYandexMarketSearch () throws InterruptedException {
        //      ChromeOptions option = new ChromeOptions();
        //    option.addArguments("--window-size=500,500");
        //    wd = new ChromeDriver(option);
        wd = new ChromeDriver();
        // wd.manage().window().setSize(new Dimension(1920, 1080));
        wd.manage().window().maximize();
        wd.get("https://yandex.ru/");
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wd.findElement(By.id("text")).clear();
        wd.findElement(By.id("text")).sendKeys("yandex market");
        wd.findElement(By.id("text")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    public void stop () {
        wd.quit();
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


    public void selectProduct () throws InterruptedException {
        wd.findElement(By.linkText("Компьютеры")).click();
        wd.findElement(By.linkText("Ноутбуки")).click();
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

    public String openInNewWindow (String url) {
        String name = "some_random_name";
        ((JavascriptExecutor) wd)
                .executeScript("window.open(arguments[0],\"" + name + "\")", url);
        return name;
    }

    public void findYandexMarket () throws InterruptedException {
        String oldWindowSet = wd.getWindowHandle();
        // wd.findElements(By.cssSelector("div.organic__url-text")).get(0).click();
        //wd.findElements(By.cssSelector("div.organic__url-text")).get(0).sendKeys(Keys.CONTROL +"\n");
        String selectLinkOpeninNewWindow = Keys.chord((Keys.CONTROL + "\n"));
        wd.findElement(By.linkText("market.yandex.ru")).sendKeys(selectLinkOpeninNewWindow);
        ArrayList<String> tabs = new ArrayList<String>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));

        // wd.findElement(By.linkText("market.yandex.ru")).click();
        //   wd.findElement(By.cssSelector("a.\"http://yandex.ru/clck/jsredir?bu=hsc95e&from=yandex.ru%3Bsearch%2F%3Bweb%3B%3B&text=&etext=2202.X2-a0a9PWdQ-rdwxbmX0L5mjqz2vJalIgY1dBXm63YZsZ3d0dWpjY2l3c2ZnZmZi.1a45e098cfe37169929cff5070d1eeff2cc6140e&uuid=&state=jLT9ScZ_wbo,&&cst=AiuY0DBWFJ5fN_r-AEszk-vBe2mdsP7wyfms6WV0f7_v2VFBvoTT8kjJ_sqQN1L4nO8HnXj_lJwEBIONfk4yyU1ZWM_0O5h7eeWz_uUVxRCsSVrUAHPT40MCdbQfiUEhii0jmS1RVn7MrfoZzEoM47ZHhNpoSpleqbGyDLJnv_9MuxcbDq0_RdslmWUGoMmY-RIOUt-wGLApPBwtft5JX3NpIBL8e2YpqUiPio5-GGXUvQBM-kZ7TRpPXnZX-ER3LCGk739ow460bDNt_yCdSI7aLoYVp_oqyoyviHqgEBFrPchw932yD3f8cYRvW5OPMF1GIKrtsKPQrR_d5zfIvfAqujqk8efPwSPXbz-0SbHz6eg3Filb_cdLB9vObP9cfmmPgUCvBQRjdAE1skLBKZ0wU_MoyhEwQZfwJ4tt3VV6HZqtrVLt-rF7_5nk6j0VMjkPYUgHH3LZYniZ3wp4MnO4Ucz2cpSCjHLKczxTbTDEuAEpERlNrTKCj4oHRwcr_CTO-1Xq1sYehl-TjztTFnAIU6Mp2nuA_TgGvOHa9x3FgDi9CE6tQVLqC-hgYtYxx6dwlXPVykoRtx-4o6nQiQA_Jq1Y0kjv9lQwerHqBQp0CiY_on7eSgcVsHm7zAXRwjBix0Ay7xza_OG3HD40ZTZbHwAYBcWe9ohgjahmHYCQHA_4LUPkcLjPzibK8n9RYpqy02Al815a_gmbCWQN5b5-kf2Uy9cqx1ErN11YRm5ImZbj5LDAGETI49XFMoRuL9jgUnwdR2jJ7GcyTzEKNKWpHKiVONY-mdHaB0eKA6O0qcTh3IevfVjUgS7r8Cq9EOH350sodUDi_kkVBypRTHDCNL08IwmXKQKoU5eXRxM,&data=UlNrNmk5WktYejY4cHFySjRXSWhXQmROUUdOXzNRVDdfekJ3UEROeHhtbFRWbmY0OTBuN2kzdS0wcWJVWDdjelV4eldsLVc4RFJQeVpGRWJWRzU5VklDT2ZWMEdaWTRORUVELUR0SVdGTjZDZUxrNlRZRmhlUSws&sign=e8a10536aa6c2bff0b4d21cebd8757fa&keyno=0&b64e=2&ref=orjY4mGPRjk5boDnW0uvlrrd71vZw9kp5uQozpMtKCWg6u_jfsR3Q5vYD5tly1LxQLzyKicLZLw,&l10n=ru&cts=1587287457871%40%40events%3D%5B%7B%22event%22%3A%22click%22%2C%22id%22%3A%22hsc95e%22%2C%22cts%22%3A1587287457871%2C%22fast%22%3A%7B%22organic%22%3A1%7D%2C%22service%22%3A%22web%22%2C%22event-id%22%3A%22k96tywy7nc%22%7D%5D&mc=4.588534464208534&hdtime=5307267.61\"")).click();
        //  wd = new ChromeDriver();
        //  wd.get(String.valueOf(link));
        Thread.sleep(6000);
        //wd.get("https://market.yandex.ru/");
        // wd.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"n");
        //  String newWindow = wd.getWindowHandle();
        //  wd.switchTo().window(newWindow);
    }

}
