package com.test.swagLabs.tests;

import org.testng.annotations.DataProvider;

public class SwagData {
    @DataProvider(name="loginInformation")
    public Object[][] getData(){
        return new Object[][]{
                {"standard_user","secret_sauce","https://www.saucedemo.com/inventory.html"},
                {"problem_user","secret_sauce","https://www.saucedemo.com/inventory.html"},
                {"performance_glitch_user","secret_sauce","https://www.saucedemo.com/inventory.html"}


        };
    }
    @DataProvider(name="loginInformationNegative")
    public Object[][] ngetData(){
        return new Object[][]{
                {"wrongusername","secret_sauce","Epic sadface: Username and password do not match any user in this service"},
                {"","secret","Epic sadface: Username is required"},
                {"standard_user","","Epic sadface: Password is required"},
                {"","","Epic sadface: Username is required"},
                {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."}


        };
    }
    @DataProvider(name="mainPageInformation")

    public Object[][] mainData(){
        return new Object[][]{
            //    {"Sauce Labs Backpack"},{"Sauce Labs Bike Light"},{"Sauce Labs Bolt T-Shirt"},{"Sauce Labs Onesie"},{"Test.allTheThings() T-Shirt (Red)"}
               {"Sauce Labs Backpack","Sauce Labs Backpack","carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.","$29.99"},
             {"Sauce Labs Bike Light","Sauce Labs Bike Light","A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.","$9.99"},
               {"Sauce Labs Bolt T-Shirt","Sauce Labs Bolt T-Shirt","Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.","$15.99"},
                {"Sauce Labs Fleece Jacket","Sauce Labs Fleece Jacket","It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.","$49.99"},
               {"Sauce Labs Onesie","Sauce Labs Onesie","Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.","$7.99"},
              {"Test.allTheThings() T-Shirt (Red)","Test.allTheThings() T-Shirt (Red)","This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.","$15.99"}

        };
    }
}
