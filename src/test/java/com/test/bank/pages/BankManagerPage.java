package com.test.bank.pages;

import Utils.BrowersUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {
    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//button[contains(text(),'Add ')]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@ng-model='fName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@ng-model='lName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomerButton;

    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    WebElement openAcountButton;

    @FindBy(css = "#userSelect")
    WebElement selectCustomer;

    @FindBy(css = "#currency")
    WebElement selectCurrency;
@FindBy(xpath = "//button[.='Process']")
WebElement processButton;

@FindBy(xpath = "//button[@ng-click='showCust()']")
WebElement customersButton;
@FindBy(xpath = "//input[@placeholder='Search Customer']")
WebElement searchName;
@FindBy(xpath = "//td[@class='ng-binding']")
List<WebElement> allInformations;
@FindBy(xpath = "//button[@class='btn home']")
WebElement homeButton;



    public void addCustomerFunctionality(WebDriver driver,String firstName,String lastName,String postCode,String expectedMassage){

        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitAddCustomerButton.submit();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMassage));
        alert.accept();
    }
    public void openAccountFunctionality(WebDriver driver,String name, String currency,String expectedMassage){
        openAcountButton.click();
        BrowersUtils.selectBy(selectCustomer,name,"text");
        BrowersUtils.selectBy(selectCurrency,currency,"value");
        processButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMassage));
        alert.accept();

    }
   public void customersFunctionalityValidation(String customername, String lastName, String postCode) throws InterruptedException {
        customersButton.click();
        Thread.sleep(2000);
        searchName.sendKeys(customername);
        List<String> expected=Arrays.asList(customername,lastName,postCode);
       Thread.sleep(2000);
       for (int i=0;i<allInformations.size();i++) {
           Assert.assertEquals(BrowersUtils.getText(allInformations.get(i)), expected.get(i));
       }
       homeButton.click();

   }





}
