package com.epam.tc.hw.mobile.scenarios;

import com.epam.tc.hw.mobile.pageObjects.NativePageObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.tc.hw.mobile.setup.BaseTest;

import java.util.Objects;

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

        if (Objects.equals(platform, "Android")) {
            nativePageObject.registerAndroidUser(email, name, password);
            nativePageObject.loginAndroidUser(email, name);
            String actualPageName = nativePageObject.getAndroidPageName();

            Assert.assertTrue(actualPageName.contains(endPoint),
                    "failure - Failed to login in app");
        } else if (Objects.equals(platform, "iOS")) {
            nativePageObject.registerIosUser(email, name, password);
            nativePageObject.loginIosUser(email, password);
            String actualPageName = nativePageObject.getIosPageName();

            Assert.assertTrue(actualPageName.contains(endPoint),
                    "failure - Failed to login in app");
        }
    }

}
