package com.test.swagLabs.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SwagMainPage {
    public SwagMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement>  allHeader;
    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement headers;
    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement description;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement price;
    public void validateHeader(String header){
      for(int i=0;i<allHeader.size();i++){
          if(BrowserUtils.getText(allHeader.get(i)).contains(header)){
              allHeader.get(i).click();
              break;
          }
      }
    }

    public void validateInformation(WebDriver driver,String excpectedHeader,String excepectedDescription,String excpectedprice){
        BrowserUtils.switchById(driver);
        Assert.assertEquals(BrowserUtils.getText(headers),excpectedHeader);
        Assert.assertEquals(BrowserUtils.getText(description),excepectedDescription);
        Assert.assertEquals(BrowserUtils.getText(price),excpectedprice);
    }

}
