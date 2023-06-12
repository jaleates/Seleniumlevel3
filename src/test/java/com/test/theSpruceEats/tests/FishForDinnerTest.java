package com.test.theSpruceEats.tests;

import com.test.theSpruceEats.pages.FishAndSeaFoodPage;
import com.test.theSpruceEats.pages.FishForDinner;
import com.test.theSpruceEats.pages.HomePage;
import org.testng.annotations.Test;

public class FishForDinnerTest extends SpruceEatsTestBase{
    @Test
    public void FishForDinnerFunctionality() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        homePage.clickIngredientsButton(driver);
        FishAndSeaFoodPage fishAndSeaFoodPage=new FishAndSeaFoodPage(driver);
        fishAndSeaFoodPage.searchBoxfood(driver,"Fish for dinner");
        FishForDinner fishForDinner=new FishForDinner(driver);
        fishForDinner.FishForDinnervalidation(driver,"6-Ingredient Roasted Salmon Fillets");
    }
}
