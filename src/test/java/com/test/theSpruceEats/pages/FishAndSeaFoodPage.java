package com.test.theSpruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishAndSeaFoodPage {
    public FishAndSeaFoodPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#search-form-input")
    WebElement searchBox;

    public void searchBoxfood(WebDriver driver,String foodName) throws InterruptedException {
        Thread.sleep(3000);
        BrowserUtils.ScrollWithJS(driver,searchBox);

        searchBox.sendKeys(foodName, Keys.ENTER);
    }
}
