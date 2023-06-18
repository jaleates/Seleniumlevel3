package com.test.swagLabs.tests;

import Utils.configReader;
import com.test.swagLabs.pages.SwagLoginPage;
import com.test.swagLabs.pages.SwagMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class swagLoginTest extends SwagLabsBase{
    @Test(dataProvider = "loginInformation",dataProviderClass = SwagData.class)
    public void logInFunctionality(String Username,String Password,String url){
        SwagLoginPage swagLoginPage=new SwagLoginPage(driver);
        swagLoginPage.loginInData(Username,Password);
        swagLoginPage.urlValidation(driver,url);


    }

    @Test(dataProvider = "loginInformationNegative",dataProviderClass = SwagData.class)
    public void negativeLoginFunctionality(String username,String password,String massage){
        SwagLoginPage swagLoginPage=new SwagLoginPage(driver);
        swagLoginPage.loginInData(username,password);
        swagLoginPage.negativeLogInData(massage);

    }



    }

