package com.epam.tc.hw.mobile.pageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class NativePageObject {
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement RegBtnAndroid;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    private WebElement RegEmailAndroid;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    private WebElement RegNameAndroid;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    private WebElement RegPwdAndroid;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    private WebElement RegConfirmPwdAndroid;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    private WebElement RegUserBtnAndroid;

    @AndroidFindBy(xpath = ".//android.view.ViewGroup/android.widget.TextView")
    private WebElement PageNameAndroid;

    @FindBy(xpath = ".//*[@value= 'Register new account']")
    private WebElement RegBtnIos;

    @FindBy(xpath = ".//*[@value= 'user@example.com']")
    private WebElement RegEmailIos;

    @FindBy(xpath = ".//*[@value= 'TimApple']")
    private WebElement RegNameIos;

    @FindBy(xpath = ".//*[@value= 'Required']")
    private WebElement RegPwdIos;

    @FindBy(xpath = ".//*[@value= 'Repeat please']")
    private WebElement RegConfirmPwdIos;

    @FindBy(xpath = ".//*[@type= 'XCUIElementTypeSwitch']")
    private WebElement RegSwitchIos;

    @FindBy(xpath = ".//*[@name= 'I read agreaments and agree wit it']")
    private WebElement RegAgreamentIos;

    @FindBy(xpath = ".//*[@value= 'Register new account']")
    private WebElement RegUserBtnIos;

    @FindBy(xpath = ".//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText")
    private WebElement PageNameIos;

    static final String Android = "Android";

    static final String iOS = "iOS";

    public NativePageObject(AppiumDriver<?> appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void registerUser(String platform, String email, String name, String password) {
        if (Objects.equals(platform, iOS)) {
            RegBtnIos.click();
            RegPwdIos.sendKeys(password);
            RegConfirmPwdIos.sendKeys(password);
            RegEmailIos.sendKeys(email);
            RegNameIos.sendKeys(name);
            RegSwitchIos.click();
            RegAgreamentIos.click();
            RegUserBtnIos.click();
        } else if (Objects.equals(platform, Android)) {
            RegBtnAndroid.click();
            RegEmailAndroid.sendKeys(email);
            RegNameAndroid.sendKeys(name);
            RegPwdAndroid.sendKeys(password);
            RegConfirmPwdAndroid.sendKeys(password);
            RegUserBtnAndroid.click();
        }
    }

    public String getPageName(String platform) {
        String pageName = null;
        if (Objects.equals(platform, Android)) {
            pageName = PageNameAndroid.getText();
        } else if (Objects.equals(platform, iOS)) {
            pageName = PageNameIos.getText();
        }
        return pageName;
    }

}
