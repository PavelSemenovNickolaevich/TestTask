package ru.yandex.appmanager;

import org.openqa.selenium.*;
import ru.yandex.data.NoteData;
import ru.yandex.data.TabData;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TestsHelper {
    private WebDriver wd;

    public TestsHelper (WebDriver wd) {
        this.wd = wd;
    }

    public void findProduct () {
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void selectOptionNote () throws InterruptedException {
        Thread.sleep(2000);
        scroll();
        Thread.sleep(2000);
        wd.findElements(By.cssSelector("div.LhMupC0dLR")).get(5).click();
        wd.findElements(By.cssSelector("div.LhMupC0dLR")).get(7).click();
        scrollMax();
        wd.findElement(By.cssSelector("span.select_js_inited")).click();
        wd.findElement(By.cssSelector("button.button_focused_yes")).sendKeys(Keys.ARROW_UP, Keys.ENTER);
        Thread.sleep(3000);
    }

    public void selectOptionTab () throws InterruptedException {
        Thread.sleep(2000);
        scroll();
        Thread.sleep(6000);
        wd.findElements(By.cssSelector("div.LhMupC0dLR")).get(6).click();
        Thread.sleep(6000);
        wd.findElements(By.cssSelector("div.LhMupC0dLR")).get(5).click();
        Thread.sleep(4000);
        //   wd.findElement(By.cssSelector("span.select_js_inited")).click();
        //    wd.findElement(By.cssSelector("button.button_focused_yes")).sendKeys(Keys.ARROW_UP, Keys.ENTER);
        Thread.sleep(3000);
        //   scrollMaxTab();
        //wd.findElement(By.cssSelector("span.select_js_inited")).click();
        //   wd.findElement(By.cssSelector("button.button_focused_yes")).sendKeys(Keys.ARROW_UP, Keys.ENTER);
        Thread.sleep(2000);
    }

    public void selectProductNote () throws InterruptedException {
        wd.findElement(By.linkText("Компьютеры")).click();
        wd.findElement(By.linkText("Ноутбуки")).click();
    }

    public void selectProductTable () throws InterruptedException {
        wd.findElement(By.linkText("Компьютеры")).click();
        wd.findElement(By.linkText("Планшеты")).click();
    }


    public void setProductNote () throws InterruptedException {
        String nameComp = wd.findElements(By.cssSelector("h3.n-snippet-card2__title")).get(0).findElement(By.cssSelector("a"))
                .getAttribute("title");
        wd.findElement(By.id("header-search")).sendKeys(nameComp);
        wd.findElement(By.cssSelector("button.button2_js_inited")).click();
        Thread.sleep(3000);
    }

    public void setProductTab () throws InterruptedException {
        String nameComp = wd.findElements(By.cssSelector("h3.n-snippet-card2__title")).get(0).findElement(By.cssSelector("a"))
                .getAttribute("title");
        wd.findElement(By.id("header-search")).sendKeys(nameComp);
        wd.findElement(By.cssSelector("button.button2_js_inited")).click();
        Thread.sleep(3000);
    }

    //price for note
    public void setHighPrice () {
        wd.findElement(By.id("glpriceto")).click();
        wd.findElement(By.id("glpriceto")).clear();
        wd.findElement(By.id("glpriceto")).sendKeys("30000");
    }

    //price for tab
    public void setPrice () throws InterruptedException {
        wd.findElement(By.id("glpricefrom")).sendKeys("20000");
        Thread.sleep(2000);
        wd.findElement(By.id("glpriceto")).sendKeys("25000");
    }

    public void findYandexMarket () throws InterruptedException {
        String selectLinkOpeninNewWindow = Keys.chord((Keys.CONTROL + "\n"));
        wd.findElement(By.linkText("market.yandex.ru")).sendKeys(selectLinkOpeninNewWindow);
        ArrayList<String> tabs = new ArrayList<String>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
    }

    public void scroll () throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(0,600)", "");
        Thread.sleep(2000);
    }

    public void scrollMax () throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(600,4500)", "");
        Thread.sleep(3000);
    }

    public void scrollMaxTab () throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(600,1600)", "");
        Thread.sleep(2000);
    }


    public boolean isNotebookHeaderPresent () {
        return wd.findElement(By.cssSelector("h1.title_js_inited")).getAttribute("title").contains("Ноутбуки");
    }

    public boolean isTabHeaderPresent () {
        return wd.findElement(By.cssSelector("h1.title_js_inited")).getAttribute("title").contains("Планшеты");
    }


    public String showTwelve () {
        return wd.findElements(By.cssSelector("span.button__text ")).get(9).getText();
    }


    public int countElements () {
        return wd.findElements(By.cssSelector("h3.n-snippet-card2__title")).size();
    }


    public NoteData getInfoBefore () {
        String nameComp = wd.findElements(By.cssSelector("h3.n-snippet-card2__title")).get(0).findElement(By.cssSelector("a"))
                .getAttribute("title");
        String price = wd.findElements(By.cssSelector("div.price")).get(0).getText();
        return new NoteData(nameComp, price);
    }

    public NoteData getInfoAfter () {
        String nameComp = wd.findElements(By.cssSelector("h3.n-snippet-card2__title")).get(1).findElement(By.cssSelector("a"))
                .getAttribute("title");
        String price = wd.findElements(By.cssSelector("div.price")).get(1).getText();
        return new NoteData(nameComp, price);
    }


    public boolean isCountListExists () {
        try {
            wd.findElement(By.cssSelector("span.select_js_inited")).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public int count () {
        List<WebElement> elements = wd.findElements(By.cssSelector("h3.n-snippet-card2__title"));
        return elements.size();
    }

    public TabData getInfoBeforeSearch () {
        String nameComp = wd.findElements(By.cssSelector("h3.n-snippet-card2__title")).get(0).findElement(By.cssSelector("a"))
                .getAttribute("title");
        String price = wd.findElements(By.cssSelector("div.price")).get(0).getText();
        return new TabData(nameComp, price);
    }

    public TabData getInfoAfterSearch () {
        String nameComp = wd.findElements(By.cssSelector("h3.n-snippet-card2__title")).get(1).findElement(By.cssSelector("a"))
                .getAttribute("title");
        String price = wd.findElements(By.cssSelector("div.price")).get(1).getText();
        return new TabData(nameComp, price);
    }

}
