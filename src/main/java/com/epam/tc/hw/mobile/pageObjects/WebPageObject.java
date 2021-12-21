package com.epam.tc.hw.mobile.pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

public class WebPageObject  {

    @FindBy(xpath = ".//input[@name='q']")
    public WebElement googleInput;

    @FindBy(xpath = "//*[@id=\"rso\"]/div/div/div/div/div/a[@class='cz3goc BmP5tf']")
    public List<WebElement> googleSearch;


    public WebPageObject(AppiumDriver<?> appiumDriver) {
        PageFactory.initElements(appiumDriver, this);

    }

    public void searchOnGoogle(String input) {
        googleInput.sendKeys(input);
        googleInput.sendKeys(Keys.ENTER);
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
