package com.epam.tc.hw.mobile.scenarios;

import com.epam.tc.hw.mobile.pageObjects.NativePageObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.tc.hw.mobile.setup.BaseTest;

public class NativeMobileTests extends BaseTest {

    @DataProvider(name = "nativeEpamTest")
    public Object[][] nativeEpamTest() {
        return new Object[][] {
                {"emailName@epam.com", "EPAM", "asnjalf195", "BudgetActivity"}};
    }

    @Test(groups = {"native"}, dataProvider = "nativeEpamTest",
            description = "This simple test register in EpamTestApp and sign in as registered user")
    public void registerNativeTest(String email, String name, String password, String endPoint) {

        NativePageObject nativePageObject = new NativePageObject(getDriver());
        nativePageObject.registerUser(email, name, password);
        nativePageObject.loginUser(email, name);

        Assert.assertEquals(endPoint, nativePageObject.pageName.getText());

    }

}
