package ru.yandex.appmanager;

import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.tests.TestBase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
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

    public void selectOption () throws InterruptedException {
        Thread.sleep(4000);
        scroll();
        Thread.sleep(4000);
    //    wd.findElements(By.cssSelector("li._1-l0XiE_ze")).get(5).findElement(By.id("7893318_152722")).click();
   //     wd.findElements(By.cssSelector("li._1-l0XiE_ze")).get(8).findElement(By.id("7893318_152981")).click();
        wd.findElements(By.cssSelector("div.LhMupC0dLR")).get(5).click();
        wd.findElements(By.cssSelector("div.LhMupC0dLR")).get(7).click();
        scrollMax();
     //   wd.findElement(By.id("7893318_152722")).click();
     //   wd.findElement(By.xpath(".//*[id = '7893318_152722']")).click();
  //      wd.findElement(By.name("Производитель Lenovo")).click();
     wd.findElement(By.cssSelector("span.select_js_inited")).click();

       wd.findElement(By.cssSelector("button.button_focused_yes")).sendKeys(Keys.ARROW_UP,Keys.ENTER);
  //      wd.findElement(By.linkText("Показывать по 48")).sendKeys("Показывать по 12");
      //  wd.findElement(By.xpath("(//button[@type='button'])[2]")).click()
       Thread.sleep(5000);

  //     wd.findElements(By.cssSelector("select.select__control")).get(0).click();
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
        Thread.sleep(4000);
    }

    public void scroll() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)wd;
        js.executeScript("window.scrollBy(0,600)", "");
        Thread.sleep(4000);
    }

    public void scrollMax() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)wd;
        js.executeScript("window.scrollBy(600,4500)", "");
        Thread.sleep(4000);
    }

}
