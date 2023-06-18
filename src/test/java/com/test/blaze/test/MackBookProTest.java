package com.test.blaze.test;

import com.test.blaze.page.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MackBookProTest extends BlazeTestBase {
    @Parameters({"category","Brand","name","price1","expected","price",
    "name1","country","city","card","month","year","massage","url"})
   @Test
    public void mackBookProFunctionality(String category,String brand, String name,String price1,String expected,
                                         String price,String name1,String country,String city, String card, String month,String year,
                                         String massage,String url) throws InterruptedException {
       HomePage home=new HomePage(driver);
       LapTopPage lapTopPage=new LapTopPage(driver);
       MackBookProPage mackBookProPage=new MackBookProPage(driver);
       home.findLaptopCategory(category);
       lapTopPage.findMacBookPro(brand);
       mackBookProPage.validation(name,price1,"Product description\n"  +"Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");

       mackBookProPage.Click(driver,expected);
       mackBookProPage.cilckcartButton();
      CartPage cartPage=new CartPage(driver);
      cartPage.clickPlaceOrder();
      cartPage.validateMassage(name,price);
       OrderPage orderPage=new OrderPage(driver);

       orderPage.fillTheForm(name1,country,city,card,month,year,driver,massage);
       Assert.assertEquals(driver.getCurrentUrl(),url);

   }


}
