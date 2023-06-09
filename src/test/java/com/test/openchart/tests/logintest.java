package com.test.openchart.tests;

import com.test.openchart.pages.loginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class logintest extends OpenChartTestBase{
    @Test
    public void LoginFunctionality() throws InterruptedException {
        loginPage loginPage=new loginPage(driver);
        loginPage.loginfunvtionality("demo","demo");
        loginPage.validateTitle(driver,"Dashboard");
    }

    @Test
    public void LoginNegative() throws InterruptedException {
        loginPage test=new loginPage(driver);
        test.loginfunvtionality("wrong","wrong");
        Assert.assertEquals(test.errormassage(),"No match for Username and/or Password.");
    }


}
