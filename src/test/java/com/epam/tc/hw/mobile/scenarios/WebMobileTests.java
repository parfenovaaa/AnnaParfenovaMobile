package com.epam.tc.hw.mobile.scenarios;

import com.epam.tc.hw.mobile.pageObjects.WebPageObject;
import com.epam.tc.hw.mobile.setup.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WebMobileTests extends BaseTest {

    @DataProvider(name = "googleEpamWebTest")
    public Object[][] googleEpamWebTest() {
        return new Object[][] {
                {"http://google.com", "EPAM", "https://www.epam.com/"}};
    }

    @Test(groups = {"web"}, dataProvider = "googleEpamWebTest",
            description = "Web search in chrome on google.com using keyword Epam ")
    public void simpleWebTest(String searchUrl, String keyword , String expected) {
        WebPageObject webPageObject = new WebPageObject(getDriver());
        getDriver().get(searchUrl);
        String platform = getDriver().getPlatformName();

        webPageObject.searchOnGoogle(keyword, platform);

        SoftAssert softAssert= new SoftAssert();
        List<String> actualLinks = webPageObject.getSearchLinks();
        softAssert.assertTrue(actualLinks.contains(expected),
                String.format("failure - There is no link on  %s on  the page.", expected));

        List<String> actualNames = webPageObject.getSearchNames();
        for (String element: actualNames) {
            softAssert.assertTrue(element.contains(keyword));
        }

        softAssert.assertAll(String.format("failure - On search page first %d links aren`t relevant to %s",
                actualNames.size(), keyword));
    }

}
