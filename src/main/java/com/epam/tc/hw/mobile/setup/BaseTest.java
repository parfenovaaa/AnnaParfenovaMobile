package com.epam.tc.hw.mobile.setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class BaseTest implements IDriver {

    private static final String PROJECT_NAME = "anna_parfenova2";
    private static final String API_KEY = "BaBREd+ISG0nXOc954tYb1v10lFg55+4NCXMV5WI5NRGE0YK6ZquhjB1wulyRHVn1gEKCp52vDKR0IxLu9kYhsW9tcQSUxQR41U/+bc94ZbMC+BX/k8Xt1GRCp50MVTUpvBQAQ6EcOWEn5yCKPmG7yxfeJIilJ1nlIgbgiCXsO0n0D6QnziIGKKKxJDNYzlAaSf4QU8w8eT0TZSQL+TZnUho3pQ9+WEW8ANzsrmNiTdwwb1x9ZXZ8j7v+KNHPejoV59biEqgGia5KsQ9nyVrhL5PQcbiwf15hTlx2s6s5vDTv/M7e4f+PxQkj1AsGH53l2E6W0IOtv/kGbTVzC0O6eiHEYF8kT661WmScn9WVKVHZyLNzkyj+PcoYdTm8QI9gShfuyyFycCAf3mym/9I5dgG9m6Fl0gIvVAL0GWdf9CSLUN3pRxSslTI0buGlLZiQ2Vwp8JeePPdeLnJcgYm+BqrsDt4pqoE/d29S6J2rsFyIIAN1szrCgJtY26Je+JKj92JcG6CCxTgJa9fnal3OCneMBwCW3aqJofXB8C5WiCLRATU8FTOeWPShXYZKgq7Ke9cX/CpvcLBYldUGSPX1icNpeqE51Od16yxj+sNfpDoREZfa0msTeHafZjHnnWgtvYVSjWOz/4dR2t4j3zj0WS9W2nqKCpqS4h+mUp7/LZn/bwi3tH2D9pTRknjCxchzSAU2u9m/I5UTDtFaCuN+jzOzljRCoZWW9iFitebuybsQSkS3tSvzh4tx/ylYPh6/X37ZlPnYEo2jxce4NdSXaqaqGolBdwNEEjkWiOsYR2VD0DpiW8rkNVJx8Ehf2OAWNEb5mhdOnZECoRDWvE/yK2YoM3p/ZhijI48SkcwGx8nWpe0Axp67An8hgg6wNJH6VHmgQKlBD1zcFhUh/+gYPc";
    private static final String APPIUM_HUB = "mobilecloud.epam.com";

    private static AppiumDriver<?> appiumDriver; // singleton

    @Override
    public AppiumDriver<?> getDriver() { return appiumDriver; }

    @Parameters({"platformName", "appType", "deviceName", "platformVersion", "udid", "browserName", "app", "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName, String appType,
                      @Optional("") String deviceName,
                      @Optional("") String platformVersion,
                      @Optional("") String udid,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId) {
        System.out.println("Before: app type - "+appType);
        setAppiumDriver(platformName, deviceName, platformVersion, udid, browserName, app, appPackage, appActivity, bundleId);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String deviceName, String platformVersion, String udid, String browserName, String app,
                                 String appPackage, String appActivity, String bundleId){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName",platformName);
        capabilities.setCapability("platformVersion",platformVersion);
        capabilities.setCapability("deviceName",deviceName);
        capabilities.setCapability("udid", udid);

        if(app.endsWith(".apk")) capabilities.setCapability("app", (new File(app)).getAbsolutePath());

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck","true");

        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("bundleId", bundleId);

        try {
            String key = URLEncoder.encode(API_KEY, StandardCharsets.UTF_8.name());
            appiumDriver = new AppiumDriver<>(new URL(format("https://%s:%s@%s/wd/hub", PROJECT_NAME, key, APPIUM_HUB)), capabilities);
        } catch (MalformedURLException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

}
