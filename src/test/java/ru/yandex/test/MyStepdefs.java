package ru.yandex.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    public WebDriver chromeDriver;

    @Given("перейти на сайт Яндекса '(.*)'")
    public void перейтиНаСайтЯндекса(String site) {
        System.setProperty("webdriver.chrome.driver", "C:\\testing\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        chromeDriver.get(site);
    }

    @Then("найти в Яндексе слово '(.*)'")
    public void найтиВЯндексеСлово(String word) {

        WebElement searchField = chromeDriver.findElement(By.xpath("//*[@id=\'text\']"));
        WebElement searchButton = chromeDriver.findElement(By.xpath("//button[@type='submit']"));

        searchField.click();
        searchField.sendKeys(word);
        searchButton.click();
    }

    @Then("в выдаче Яндекса есть ссылка '(.*)'")
    public void вВыдачеЯндексаЕстьСсылка(String siteToFind) {

        List<WebElement> SearchResultsSites = chromeDriver.findElements(By.xpath("//a[contains(@class,'link link_theme_outer')]//b"));

        boolean hasWikiLink = false;
        for (WebElement webElement : SearchResultsSites) {
            if (webElement.getText().equals(siteToFind)) {
                hasWikiLink = true;
            }
        }
        Assert.assertTrue(hasWikiLink);
    }

    @Then("закончить проверку поисковой выдачи Яндекса")
    public void закончитьПроверкуПоисковойВыдачиЯндекса() {
        chromeDriver.quit();
    }
}
