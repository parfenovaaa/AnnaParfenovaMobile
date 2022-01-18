package com.epam.tc.hw.mobile.scenarios;

import com.epam.tc.hw.mobile.pageObjects.nativeApp.NativePageObject;
import com.epam.tc.hw.mobile.pageObjects.nativeApp.nativeLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.tc.hw.mobile.setup.BaseTest;

public class NativeMobileTests extends BaseTest {

    @DataProvider(name = "nativeEpamTest")
    public Object[][] nativeEpamTest() {
        return new Object[][]{
                {"emailName@epam.com", "EPAM", "asnjalf195", "BudgetActivity"}};
    }

    @Test(groups = {"native"}, dataProvider = "nativeEpamTest",
            description = "This simple test register in EpamTestApp and sign in as registered user")
    public void registerNativeTest(String email, String name, String password, String endPoint) {
        String platform = getDriver().getPlatformName();
        NativePageObject nativePageObject = new NativePageObject(getDriver());
        nativeLoginPage nativeLoginPage = new nativeLoginPage(getDriver());

        nativePageObject.registerUser(platform, email, name, password);
        nativeLoginPage.loginUser(platform, email, name);
        String actualPageName = nativePageObject.getPageName(platform);

        Assert.assertTrue(actualPageName.contains(endPoint),
                "failure - Failed to login in app");
    }

}
