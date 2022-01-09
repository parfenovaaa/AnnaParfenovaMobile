package com.epam.tc.hw.mobile.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject  {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private WebElement androidSignInBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement androidRegBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement andriodSignInEmail;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement androidSignInPwd;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    private WebElement androidRegEmail;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    private WebElement androidRegName;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    private WebElement androidRegPwd;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    private WebElement androidRegConfirmPwd;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    private WebElement androidRegUserBtn;

    @AndroidFindBy(xpath = ".//android.view.ViewGroup/android.widget.TextView")
    private WebElement androidPageName;

    @FindBy(xpath = ".//XCUIElementTypeSecureTextField")
    private WebElement iosSignInPwd;

    @FindBy(xpath = ".//XCUIElementTypeTextField")
    private WebElement iosSignInEmail;

    @FindBy(xpath = ".//*[@value= 'Sign In']")
    private WebElement iosSignInBtn;

    @FindBy(xpath = ".//*[@value= 'Register new account']")
    private WebElement iosRegBtn;

    @FindBy(xpath = ".//*[@value= 'user@example.com']")
    private WebElement iosRegEmail;

    @FindBy(xpath = ".//*[@value= 'TimApple']")
    private WebElement iosRegName;

    @FindBy(xpath = ".//*[@value= 'Required']")
    private WebElement iosRegPwd;

    @FindBy(xpath = ".//*[@value= 'Repeat please']")
    private WebElement iosRegConfirmPwd;

    @FindBy(xpath = ".//*[@type= 'XCUIElementTypeSwitch']")
    private WebElement iosRegSwitch;

    @FindBy(xpath = ".//*[@name= 'I read agreaments and agree wit it']")
    private WebElement iosRegAgreament;

    @FindBy(xpath = ".//*[@value= 'Register new account']")
    private WebElement iosRegUserBtn;

    @FindBy(xpath = ".//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText")
    private WebElement iosPageName;

    public NativePageObject(AppiumDriver<?> appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public void registerIosUser(String email, String name, String password) {
        iosRegBtn.click();
        iosRegPwd.sendKeys(password);
        iosRegConfirmPwd.sendKeys(password);
        iosRegEmail.sendKeys(email);
        iosRegName.sendKeys(name);
        iosRegSwitch.click();
        iosRegAgreament.click();
        iosRegUserBtn.click();
    }

    public void registerAndroidUser(String email, String name, String password) {
        androidRegBtn.click();
        androidRegEmail.sendKeys(email);
        androidRegName.sendKeys(name);
        androidRegPwd.sendKeys(password);
        androidRegConfirmPwd.sendKeys(password);
        androidRegUserBtn.click();
    }

    public void loginAndroidUser(String email, String password) {
        andriodSignInEmail.sendKeys(email);
        androidSignInPwd.sendKeys(password);
        androidSignInBtn.click();
    }

    public void loginIosUser(String email, String password) {
        iosSignInEmail.sendKeys(email);
        iosSignInPwd.sendKeys(password);
        iosSignInBtn.click();
    }

    public String getAndroidPageName() {
        return androidPageName.getText();
    }

    public String getIosPageName() {
        return iosPageName.getText();
    }

}
