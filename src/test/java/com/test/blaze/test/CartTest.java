package com.test.blaze.test;

import com.test.blaze.page.*;
import org.testng.annotations.Test;

public class CartTest extends BlazeTestBase {
    @Test
    public void CartButtonFunctionality() throws InterruptedException {
        HomePage home=new HomePage(driver);
        LapTopPage lapTopPage=new LapTopPage(driver);
        MackBookProPage mackBookProPage=new MackBookProPage(driver);
        home.findLaptopCategory();
        lapTopPage.findMacBookPro();
        mackBookProPage.Click(driver,"Product added");
        mackBookProPage.cilckcartButton();
        CartPage cartPage=new CartPage(driver);
        cartPage.validateMassage("MacBook Pro","1100");
        cartPage.clickPlaceOrder();

    }
}
