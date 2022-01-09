package com.epam.tc.hw.mobile.pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class WebPageObject  {

    @FindBy(xpath = ".//input[@name='q']")
    private WebElement googleInput;

    @FindBy(xpath = ".//a[@class='cz3goc BmP5tf']")
    private List<WebElement> googleSearch;

    @FindBy(xpath = "(.//*[@class= 'sbic sb43'])[1]")
    private WebElement iosFirstLink;

    public WebPageObject(AppiumDriver<?> appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
        new WebDriverWait(appiumDriver, 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }

    public void searchOnGoogle(String input, String platform) {
        googleInput.sendKeys(input);
         if (Objects.equals(platform, "Android")) {
             googleInput.sendKeys(Keys.ENTER);
         } else if (Objects.equals(platform, "iOS")) {
             iosFirstLink.click();
         }
    }

    public List <String> getSearchLinks() {
        List <String> links = new LinkedList<>();
        for (WebElement search : googleSearch) {
            links.add(search.getAttribute("href"));
        }
        return links;
    }

    public List <String> getSearchNames() {
        List <String> links = new LinkedList<>();
        for (WebElement search : googleSearch) {
            links.add(search.getText());
        }
        return links;
    }
}
