package com.epam.tc.hw.mobile.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject  {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    public WebElement signInBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    public WebElement registerBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    public WebElement loginEmail;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    public WebElement loginPwd;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    public WebElement registerEmail;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    public WebElement registerUsername;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    public WebElement registerPwd;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    public WebElement registerConfirmPwd;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    public WebElement registerAccBtn;

    @AndroidFindBy(xpath = ".//android.view.ViewGroup/android.widget.TextView")
    public WebElement pageName;

    public NativePageObject(AppiumDriver<?> appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public void registerUser(String email, String name, String password) {
        registerBtn.click();
        registerEmail.sendKeys(email);
        registerUsername.sendKeys(name);
        registerPwd.sendKeys(password);
        registerConfirmPwd.sendKeys(password);
        registerAccBtn.click();
    }

    public void loginUser(String email, String password) {
        loginEmail.sendKeys(email);
        loginPwd.sendKeys(password);
        signInBtn.click();
    }

}
