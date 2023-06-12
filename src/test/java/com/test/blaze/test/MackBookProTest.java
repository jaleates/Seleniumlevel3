package com.test.blaze.test;

import com.test.blaze.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MackBookProTest extends BlazeTestBase {
   @Test
    public void mackBookProFunctionality() throws InterruptedException {
       HomePage home=new HomePage(driver);
       LapTopPage lapTopPage=new LapTopPage(driver);
       MackBookProPage mackBookProPage=new MackBookProPage(driver);
       home.findLaptopCategory();
       lapTopPage.findMacBookPro();
       mackBookProPage.validation("MacBook Pro","$1100 *includes tax","Product description\n" +
               "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
       mackBookProPage.Click(driver,"Product added");
       mackBookProPage.cilckcartButton();
      CartPage cartPage=new CartPage(driver);
      cartPage.clickPlaceOrder();
      cartPage.validateMassage("MacBook Pro","1100");
       OrderPage orderPage=new OrderPage(driver);

       orderPage.fillTheForm("Jale","USA","Stlouis","Visa","June","2023",
               driver,"Thank you for your purchase!");
       Assert.assertEquals(driver.getCurrentUrl(),"https://www.demoblaze.com/index.html");

   }


}
