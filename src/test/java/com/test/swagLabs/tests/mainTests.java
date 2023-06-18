package com.test.swagLabs.tests;

import Utils.configReader;
import com.test.swagLabs.pages.SwagLoginPage;
import com.test.swagLabs.pages.SwagMainPage;
import org.testng.annotations.Test;

public class mainTests extends SwagLabsBase {
    @Test(dataProvider = "mainPageInformation",dataProviderClass = SwagData.class)
    public void swagmainPage(String header,String headerin,String description,String price){
        SwagLoginPage swagLoginPage=new SwagLoginPage(driver);
        swagLoginPage.loginInData(configReader.readProperty("QA_swagUsername"),configReader.readProperty("QA_swagpassword"));
        SwagMainPage swagMainPage=new SwagMainPage(driver);
        swagMainPage.validateHeader(header);
        swagMainPage.validateInformation(driver,headerin,description,price);
    }
}
