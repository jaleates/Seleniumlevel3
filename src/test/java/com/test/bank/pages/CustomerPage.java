package com.test.bank.pages;

import Utils.BrowersUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//div[@class='center']//strong[2]")
    WebElement customerBalance;

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement transactionButton;

    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement amount500;

    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement amount300;

    public void customervalidation(String expected) throws InterruptedException {
        Assert.assertEquals(BrowersUtils.getText(customerBalance),expected);
        String balance=BrowersUtils.getText(customerBalance);
        int balanceint=Integer.parseInt(balance);
        transactionButton.click();
        String deposite=BrowersUtils.getText(amount500);
        String withindrawl=BrowersUtils.getText(amount300);
        Thread.sleep(2000);

        int depositeint=Integer.parseInt(deposite);
        int withindrawlint=Integer.parseInt(withindrawl);

        Assert.assertEquals((depositeint-withindrawlint),balanceint);
    }

}
