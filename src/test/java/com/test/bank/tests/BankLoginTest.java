package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankLoginTest extends BankTestBase{
    @Parameters("ExpectedHeader")
    @Test
    public void validatePageComponents(String expectedHeader){


        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.LoginPAgeComponentValidation(expectedHeader);
        bankLoginPage.clickCustomerLogin();
    }
    @Test
    public void validationDepositeFunctionality() throws InterruptedException {

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

    }
    @Test
    public void validationwithinDrawlFunctionality() throws InterruptedException {

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

    }






}
