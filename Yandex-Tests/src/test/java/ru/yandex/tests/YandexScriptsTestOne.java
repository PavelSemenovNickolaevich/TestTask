package ru.yandex.tests;

import org.junit.*;

import org.openqa.selenium.*;

public class YandexScriptsTestOne extends TestBase {

    @Test
    public void testYandex() throws Exception {
        findYandexMarket();
        changeWindow();
        selectProduct(By.cssSelector("div._1vnugfYUli"), By.linkText("Ноутбуки"));
        setHighPrice("glpriceto", "30000");
        selectOption();
        setProduct("header-search", "Ноутбук HP 15-db0");
        findProduct("//button[@type='submit']");
    }

    private void findProduct (String s) {
        applicationManager.wd.findElement(By.xpath(s)).click();
    }

    private void selectOption () {
        applicationManager.wd.findElement(By.xpath("//div[@id='search-prepack']/div/div/div[3]/div/div/div[2]/div[2]/div/div/fieldset/ul/li[6]/div/a/label/div")).click();
        applicationManager.wd.findElement(By.xpath("//div[@id='search-prepack']/div/div/div[3]/div/div/div[2]/div[2]/div/div/fieldset/ul/li[8]/div/a/label/div")).click();
        applicationManager.wd.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        applicationManager.wd.findElement(By.xpath("//div[@id='uniq15872317257651']/span")).click();
    }

    private void changeWindow () {
        applicationManager.wd.switchTo().window("https://market.yandex.ru/");
    }

    private void selectProduct (By by, By ноутбуки) {
        applicationManager.wd.findElement(by).click();
        applicationManager.wd.findElement(ноутбуки).click();
    }

    private void setProduct (String s, String s2) {
        applicationManager.wd.findElement(By.id(s)).click();
        applicationManager.wd.findElement(By.id(s)).clear();
        applicationManager.wd.findElement(By.id(s)).sendKeys(s2);
    }

    private void setHighPrice (String glpriceto, String s) {
        applicationManager.wd.findElement(By.id(glpriceto)).click();
        applicationManager.wd.findElement(By.id(glpriceto)).clear();
        applicationManager.wd.findElement(By.id(glpriceto)).sendKeys(s);
    }

    private void findYandexMarket () {
        applicationManager.wd.findElements(By.cssSelector("div.organic__url-text")).get(0).click();
    }


}
