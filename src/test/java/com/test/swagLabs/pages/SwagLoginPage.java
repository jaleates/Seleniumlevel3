package com.test.swagLabs.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SwagLoginPage {
    public  SwagLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css="#login-button")
    WebElement loginButton;
    @FindBy(tagName = "h3")
    WebElement Massage;
    public void loginInData(String UserName,String Password){
        userName.sendKeys(UserName);
        password.sendKeys(Password);
        loginButton.click();

    }
    public void urlValidation(WebDriver driver,String url){
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    public void negativeLogInData(String massage){
        Assert.assertEquals(BrowserUtils.getText(Massage),massage);

    }
}
