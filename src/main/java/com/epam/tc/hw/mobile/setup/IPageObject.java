package com.epam.tc.hw.mobile.setup;

import org.openqa.selenium.WebElement;

public interface IPageObject {

    WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

}
