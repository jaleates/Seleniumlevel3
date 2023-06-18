package com.test.blaze.test;

import org.testng.annotations.DataProvider;

public class BlazeData {
    @DataProvider(name="orderData")
    public Object[][] getData() {
        return new Object[][]{
                {"phones", "Nokia lumia 1520", "Product added", "Jale","USA", "St louis", "Visa", "June", "2023", "Thank you for your purchase!"}
        };
    }
}
