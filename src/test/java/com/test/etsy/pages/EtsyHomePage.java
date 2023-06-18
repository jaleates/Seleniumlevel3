package com.test.etsy.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EtsyHomePage {
    public EtsyHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "#global-enhancements-search-query")
    WebElement searchBox;

    @FindBy(xpath = "//h3[contains(@class,'listing-card__title')]")
    List<WebElement> headers;
    public void searchBoxword(String phone){
        searchBox.sendKeys(phone,Keys.ENTER);
    }
    public void searchKeywords(WebDriver driver,String phoneName,String phoneVersion,String phoneType){


        for(WebElement header:headers){
            BrowserUtils.ScrollWithJS(driver,header);
            String text=BrowserUtils.getText(header).toLowerCase();
            Assert.assertTrue(text.contains(phoneName)||text.contains(phoneVersion)||text.contains(phoneType));
        }
    }
}
