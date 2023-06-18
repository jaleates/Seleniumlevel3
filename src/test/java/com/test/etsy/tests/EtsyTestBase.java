package com.test.etsy.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import Utils.configReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class EtsyTestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(configReader.readProperty("QA-Etsy-url"));

    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"Etsy Picture");
        }

driver.quit();
    }

}
