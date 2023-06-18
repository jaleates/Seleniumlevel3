package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {
    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        // it does the same logic like driver.findelemnt
    }
    @FindBy(css=".mainHeading")
    WebElement header;
    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;


    @FindBy(xpath = "//button[contains(text(),'Bank')]")
    WebElement ManagerLogin;

    @FindBy(css = "#userSelect")
    WebElement yourName;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//div//strong//span")
    WebElement massage;
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement depositeButton;
    @FindBy(xpath = "//input[@type='number']")
    WebElement depositeAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitDeposite;

    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement successfulMassage;
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement withDrawlButton;
    @FindBy(xpath = "//input[@type='number']")
    WebElement withDrawlAmount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitWithinDrawl;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement withMassage;
    public void LoginPAgeComponentValidation(String expectedHeader){
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertTrue(customerLogin.isDisplayed()&& customerLogin.isEnabled());
        Assert.assertTrue(customerLogin.isDisplayed()&& customerLogin.isEnabled());
    }
    public void clickManagerButton(){
        ManagerLogin.click();
    }

    public void clickCustomerLogin(){
        customerLogin.click();
    }
    public void selectYourName(String attributeValue, String attributeName){
        BrowserUtils.selectBy(yourName,attributeValue,attributeName);
        loginButton.submit();
    }

    public void validateMassage(String expected){
        Assert.assertEquals(BrowserUtils.getText(massage),expected);

    }
    public void clickDepositeButton(String amountDeposite,String expected){
        depositeButton.click();
        depositeAmount.sendKeys(amountDeposite);
        submitDeposite.submit();
        Assert.assertEquals(BrowserUtils.getText(successfulMassage),expected);

    }
    public void clickwithDrawl(String withindrawl,String expected) throws InterruptedException {
        withDrawlButton.click();
        Thread.sleep(2000);
        withDrawlAmount.sendKeys(withindrawl);
        Thread.sleep(2000);
        submitWithinDrawl.submit();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(withMassage),expected);

    }





}
