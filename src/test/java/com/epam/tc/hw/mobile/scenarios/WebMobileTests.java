package com.epam.tc.hw.mobile.scenarios;

import com.epam.tc.hw.mobile.pageObjects.WebPageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.tc.hw.mobile.setup.BaseTest;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WebMobileTests extends BaseTest {

    SoftAssert softAssert= new SoftAssert();

    @DataProvider(name = "googleEpamWebTest")
    public Object[][] googleEpamWebTest() {
        return new Object[][] {
                {"http://google.com", "EPAM", "https://www.epam.com/"}};
    }

    @Test(groups = {"web"}, dataProvider = "googleEpamWebTest",
            description = "Web search in chrome on google.com using keyword Epam ")
    public void simpleWebTest(String searchUrl, String keyword , String expected) {
        getDriver().get(searchUrl);

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        WebPageObject webPageObject = new WebPageObject(getDriver());

        webPageObject.searchOnGoogle(keyword);

        List<String> actualLinks = webPageObject.getSearchLinks();
        Assert.assertTrue(actualLinks.contains(expected),
                "failure - There is no link on " + expected + " on  the page.");

        List<String> actualNames = webPageObject.getSearchNames();
        for (String element: actualNames) {
            softAssert.assertTrue(element.contains(searchUrl));
        }

        softAssert.assertAll("failure - On search page first " + actualNames.size()
                            + " links aren`t relevant to " + keyword);

    }

}
