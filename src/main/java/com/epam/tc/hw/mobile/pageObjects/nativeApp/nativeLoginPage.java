package com.epam.tc.hw.mobile.pageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class nativeLoginPage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private WebElement SignInBtnAndroid;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement SignInEmailAndriod;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement SignInPwdAndroid;

    @FindBy(xpath = ".//XCUIElementTypeSecureTextField")
    private WebElement SignInPwdIos;

    @FindBy(xpath = ".//XCUIElementTypeTextField")
    private WebElement SignInEmailIos;

    @FindBy(xpath = ".//*[@value= 'Sign In']")
    private WebElement SignInBtnIos;

    static final String Android = "Android";

    static final String iOS = "iOS";

    public nativeLoginPage(AppiumDriver<?> appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void loginUser(String platform, String email, String password) {
        if (Objects.equals(platform, Android)) {
            SignInEmailAndriod.sendKeys(email);
            SignInPwdAndroid.sendKeys(password);
            SignInBtnAndroid.click();
        } else if (Objects.equals(platform, iOS)) {
            SignInEmailIos.sendKeys(email);
            SignInPwdIos.sendKeys(password);
            SignInBtnIos.click();
        }
    }
}
