package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@class='btn-close']")
    WebElement closeButton;
    @FindBy(linkText = "Customers")
    WebElement clickCustomersButton;

    @FindBy(xpath = "//ul[@id='collapse-5']//li//a[.='Customers']")
    WebElement subCustomersButton;

    public void clickButtons(){
        closeButton.click();
        clickCustomersButton.click();
        subCustomersButton.click();
    }
}
