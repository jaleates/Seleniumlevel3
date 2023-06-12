package com.test.blaze.page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
@FindBy(xpath = "//td")
List< WebElement> information;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement placeOrder;

      public void validateMassage(String Name,String Price){
          List<String> expected= Arrays.asList("",Name,Price,"");
          for(int i=1;i<information.size()-1;i++){
              Assert.assertEquals(BrowserUtils.getText(information.get(i)),expected.get(i));
          }


     }
     public void clickPlaceOrder(){
         placeOrder.click();
     }
}
