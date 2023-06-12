package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankCustomerTest extends BankTestBase {
    @Test
    public void validationwithinDrawlFunctionality() throws InterruptedException {
//
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Jale", "Ates", "53462", "Customer added successfully with customer");
        bankManagerPage.openAccountFunctionality(driver, "Jale Ates", "Dollar", "Account created successfully with account Number");
        bankManagerPage.customersFunctionalityValidation("Jale","Ates","53462");
        BankLoginPage bankLoginPage1=new BankLoginPage(driver);
        bankLoginPage1.clickCustomerLogin();
        bankLoginPage1.selectYourName("6","value");
        bankLoginPage1.validateMassage("Jale Ates");
        bankLoginPage1.clickDepositeButton("500","Deposit Successful");
        bankLoginPage1.clickwithDrawl("300","Transaction successful");
        CustomerPage customerPage=new CustomerPage(driver);
        customerPage.customervalidation("200");

    }
}
