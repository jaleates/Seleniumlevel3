package com.test.theSpruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FishForDinner {
    public FishForDinner(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='starRating_score_4Star']")
    WebElement fourStarOption;

    @FindBy (xpath = "//input[@id='pop_search_editor']")
    WebElement editorsChoice;

    @FindBy(xpath = "//span[@class='card__underline']")
    WebElement foodName;

    public void FishForDinnervalidation(WebDriver driver,String expected) throws InterruptedException {
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.click(fourStarOption).perform();
        if(editorsChoice.isDisplayed()&&editorsChoice.isEnabled()&&!editorsChoice.isSelected()){
            editorsChoice.click();
            Assert.assertEquals(BrowserUtils.getText(foodName),expected);
        }
    }
}
