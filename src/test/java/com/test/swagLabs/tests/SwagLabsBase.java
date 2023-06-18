package com.test.swagLabs.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import Utils.configReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SwagLabsBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(configReader.readProperty("QA_swaglabs_url"));
    }
    @AfterMethod
    public void tearDown(){
//        if(!iTestResult.isSuccess()){
//            BrowserUtils.getScreenShot(driver,"blazePicture");
//        }
       // ITestResult iTestResult
        driver.quit();

    }
}
