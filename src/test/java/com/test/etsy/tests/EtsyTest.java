package com.test.etsy.tests;

import com.test.etsy.pages.EtsyHomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyTest extends EtsyTestBase {
  @Parameters({"phone","phoneName","phoneVersion","phoneType"})
    @Test
    public void etsySearchFunctionality(String phone,String phoneName,String phoneVersion,String phoneType){
        EtsyHomePage etsyHomePage=new EtsyHomePage(driver);
        etsyHomePage.searchBoxword(phone);
        etsyHomePage.searchKeywords(driver,phoneName,phoneVersion,phoneType);
    }
}
