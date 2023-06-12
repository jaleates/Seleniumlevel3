package com.test.blaze.page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#name")
    WebElement name;
    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#card")
    WebElement card;

    @FindBy(css = "#month")
    WebElement month;

    @FindBy(css = "#year")
    WebElement year;
    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[.='Thank you for your purchase!']")
    WebElement massage;
    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    WebElement OKbutton;

    public void fillTheForm(String Name,String Country, String City, String Card,String Month,String Year,WebDriver driver,String Mssage) throws InterruptedException {
        Thread.sleep(3000);
        name.sendKeys(Name);
        Thread.sleep(1000);
        country.sendKeys(Country);
        Thread.sleep(1000);
        city.sendKeys(City);
        Thread.sleep(1000);
        card.sendKeys(Card);
        Thread.sleep(1000);
        month.sendKeys(Month);
        Thread.sleep(1000);
        year.sendKeys(Year);
        Thread.sleep(1000);
        BrowserUtils.ScrollWithJS(driver,purchaseButton);
        Thread.sleep(2000);
        purchaseButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(massage),Mssage);
        OKbutton.click();



    }

}
