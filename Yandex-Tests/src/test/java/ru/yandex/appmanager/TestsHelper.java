package ru.yandex.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TestsHelper {
    private WebDriver wd;

    public TestsHelper (WebDriver wd) {
        this.wd = wd;
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

        wd.findElement(By.cssSelector("button.button_focused_yes")).sendKeys(Keys.ARROW_UP, Keys.ENTER);
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
        //  String nameComp  =  wd.findElements(By.cssSelector("div.n-snippet-list")).get(0).getText();
        String nameComp = wd.findElements(By.cssSelector("h3.n-snippet-card2__title")).get(0).findElement(By.cssSelector("a"))
                .getAttribute("title");
        wd.findElement(By.id("header-search")).sendKeys(nameComp);
        wd.findElements(By.linkText("Найти"));
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

    public void scroll () throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(0,600)", "");
        Thread.sleep(4000);
    }

    public void scrollMax () throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(600,4500)", "");
        Thread.sleep(4000);
    }
}
