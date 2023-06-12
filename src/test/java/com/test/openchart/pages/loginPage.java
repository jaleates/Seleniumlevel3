package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginPage {
    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-username")
    WebElement userName;

    @FindBy(css = "#input-password")
    WebElement password;
@FindBy(css = "#alert")
WebElement errorMassage;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
     @FindBy(xpath = "//button[@class='btn-close']")
WebElement closeButton;





    public void loginfunvtionality(String username, String password) throws InterruptedException {
        userName.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
       // Thread.sleep(2000);
        //closeButton.click();

    }
    public String errormassage(){
        return BrowserUtils.getText(errorMassage);
    }
    public void validateTitle(WebDriver driver,String expected){
        Assert.assertEquals(BrowserUtils.getTitlewithJS(driver),expected);
    }
}
