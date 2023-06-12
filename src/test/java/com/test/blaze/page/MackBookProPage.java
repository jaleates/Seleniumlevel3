package com.test.blaze.page;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MackBookProPage {
    public MackBookProPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "h2")
    WebElement header;
    @FindBy(tagName = "h3")
    WebElement price;
    @FindBy(css = "#myTabContent")
    WebElement description;
    @FindBy(xpath = "//a[@onclick='addToCart(15)']")
    WebElement addToCartButton;

    public void validation(String Name, String Price, String Information) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(header),Name);
        Assert.assertEquals(BrowserUtils.getText(price),Price);
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(description),Information);

    }
    public void Click(WebDriver driver,String expected) throws InterruptedException {
        Thread.sleep(2000);
        addToCartButton.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        Assert.assertEquals(alert.getText(),expected);
        alert.accept();
    }
    @FindBy(css = "#cartur")
    WebElement cartButton;

    public void cilckcartButton(){
        cartButton.click();
    }

}
