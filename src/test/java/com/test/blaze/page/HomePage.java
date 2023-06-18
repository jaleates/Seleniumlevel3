package com.test.blaze.page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

//    @FindBy(xpath = "//a[contains(text(),'Phones')]")
//    WebElement phones;
//
//    @FindBy(xpath = "//a[contains(text(),'Laptops')]")
//    WebElement laptops;
//
//    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
//    WebElement monitors;


//    public void ClickCategory(String categoryName){
//        switch (categoryName){
//            case "phones":
//                phones.click();break;
//            case "laptops":
//                laptops.click();
//                break;
//            case "monitors":
//                monitors.click();
//            default:
//                System.out.println("The category name is not correct ");
//                Assert.assertTrue(false);
//        }

    @FindBy(css = "#itemc")
    List<WebElement>  categories;




   public void findLaptopCategory(String lap){
        for ( int i=0;i< categories.size();i++){
            if(BrowserUtils.getText(categories.get(i)).contains(lap)){
                categories.get(i).click();
                break;
            }
        }
    }}

