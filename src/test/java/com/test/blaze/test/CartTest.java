package com.test.blaze.test;

import Utils.configReader;
import com.test.blaze.page.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CartTest extends BlazeTestBase {
    @Parameters({"category","Brand","expected","key1","key2"})
    @Test
    public void CartButtonFunctionality(String category,String brand,String expected,String key1, String key2) throws InterruptedException {
        HomePage home=new HomePage(driver);
        LapTopPage lapTopPage=new LapTopPage(driver);
        MackBookProPage mackBookProPage=new MackBookProPage(driver);
        home.findLaptopCategory(category);
        lapTopPage.findMacBookPro(brand);
        mackBookProPage.Click(driver,expected);
        mackBookProPage.cilckcartButton();
        CartPage cartPage=new CartPage(driver);
        cartPage.validateMassage(configReader.readProperty(key1),configReader.readProperty(key2));
        cartPage.clickPlaceOrder();

    }
}
