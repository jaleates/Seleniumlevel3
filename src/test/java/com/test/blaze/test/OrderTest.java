package com.test.blaze.test;

import com.test.blaze.page.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderTest extends BlazeTestBase {
    @Test
    public void OrderTestFunctionality() throws InterruptedException {
        HomePage home=new HomePage(driver);
        LapTopPage lapTopPage=new LapTopPage(driver);
        MackBookProPage mackBookProPage=new MackBookProPage(driver);
        home.findLaptopCategory("Laptop");
        lapTopPage.findMacBookPro("MacBook Pro");
        mackBookProPage.Click(driver,"Product added");
        mackBookProPage.cilckcartButton();
        CartPage cartPage=new CartPage(driver);
        cartPage.clickPlaceOrder();
        OrderPage orderPage=new OrderPage(driver);
        orderPage.fillTheForm("Jale","USA","St louis","Visa","June","2023",driver,"Thank you for your purchase!");

    }
    @Test(dataProvider = "orderData",dataProviderClass = BlazeData.class)
    public void OrderTestFunctionalityPhone(String category,String Brand,String expected,String name,String country,String city,String card,String month,String year,String massage) throws InterruptedException {
        HomePage home=new HomePage(driver);
        LapTopPage lapTopPage=new LapTopPage(driver);
        MackBookProPage mackBookProPage=new MackBookProPage(driver);
        home.findLaptopCategory(category);
        lapTopPage.findMacBookPro(Brand);
        mackBookProPage.Click(driver,expected);
        mackBookProPage.cilckcartButton();
        CartPage cartPage=new CartPage(driver);
        cartPage.clickPlaceOrder();
        OrderPage orderPage=new OrderPage(driver);
        orderPage.fillTheForm(name,country,city,card,month,year,driver,massage);

    }
    @Parameters({"category","Brand","Product","name1","country","city","card","month","year","massage"})
    @Test
    public void OrderTestFunctionalityParameter(String category,String Brand,String Product,String name,String country,String city,String card,String month,String year,String massage1) throws InterruptedException {
        HomePage home=new HomePage(driver);
        LapTopPage lapTopPage=new LapTopPage(driver);
        MackBookProPage mackBookProPage=new MackBookProPage(driver);
        home.findLaptopCategory(category);
        lapTopPage.findMacBookPro(Brand);
        mackBookProPage.Click(driver,Product);
        mackBookProPage.cilckcartButton();
        CartPage cartPage=new CartPage(driver);
        cartPage.clickPlaceOrder();
        OrderPage orderPage=new OrderPage(driver);
        orderPage.fillTheForm(name,country,city,card,month,year,driver,massage1);

    }
}
