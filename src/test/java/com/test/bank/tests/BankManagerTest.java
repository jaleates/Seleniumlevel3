package com.test.bank.tests;

import Utils.configReader;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BankTestBase{
    @Test
    public void validateAddCustomerFunctionality() {

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, configReader.readProperty("QA_BankMAnager_firstname"),
                configReader.readProperty("QA-BAnkmanager_Lastname"),
                configReader.readProperty("QA_BankManager_zipcode"),
                configReader.readProperty("QA_BankManager_Massage"));

    }

    @Test
    public void ValidateOpenAccout() {

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Jale", "Ates", "53462", "Customer added successfully with customer");
        bankManagerPage.openAccountFunctionality(driver, "Jale Ates", "Dollar", "Account created successfully with account Number");

    }
    @Test
    public void customersFunctionality() throws InterruptedException {

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Jale", "Ates", "53462", "Customer added successfully with customer");
        bankManagerPage.openAccountFunctionality(driver, "Jale Ates", "Dollar", "Account created successfully with account Number");
       bankManagerPage.customersFunctionalityValidation("Jale","Ates","53462");
        BankLoginPage bankLoginPage1=new BankLoginPage(driver);
        bankLoginPage1.clickCustomerLogin();
    }

    @Test
    public void customerLoginFunctionality() throws InterruptedException {

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Jale", "Ates", "53462", "Customer added successfully with customer");
        bankManagerPage.openAccountFunctionality(driver, "Jale Ates", "Dollar", "Account created successfully with account Number");
        bankManagerPage.customersFunctionalityValidation("Jale","Ates","53462");
        BankLoginPage bankLoginPage1=new BankLoginPage(driver);
        bankLoginPage1.clickCustomerLogin();
        bankLoginPage1.selectYourName("6","value");
    }

    @Test
    public void validationCustomerLoginFunctionality() throws InterruptedException {
//
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Jale", "Ates", "53462", "Customer added successfully with customer");
        bankManagerPage.openAccountFunctionality(driver, "Jale Ates", "Dollar", "Account created successfully with account Number");
        bankManagerPage.customersFunctionalityValidation("Jale","Ates","53462");

    }


}