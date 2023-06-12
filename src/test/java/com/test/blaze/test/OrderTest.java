package com.test.blaze.test;

import com.test.blaze.page.*;
import org.testng.annotations.Test;

public class OrderTest extends BlazeTestBase {
    @Test
    public void OrderTestFunctionality() throws InterruptedException {
        HomePage home=new HomePage(driver);
        LapTopPage lapTopPage=new LapTopPage(driver);
        MackBookProPage mackBookProPage=new MackBookProPage(driver);
        home.findLaptopCategory();
        lapTopPage.findMacBookPro();
        mackBookProPage.Click(driver,"Product added");
        mackBookProPage.cilckcartButton();
        CartPage cartPage=new CartPage(driver);
        cartPage.clickPlaceOrder();
        OrderPage orderPage=new OrderPage(driver);
        orderPage.fillTheForm("Jale","USA","St louis","Visa","June","2023",driver,"Thank you for your purchase!");

    }
}
