package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addSign;

    @FindBy(css = "#input-store")
    WebElement store;

    @FindBy(xpath = "//select[@name='customer_group_id']")
    WebElement customerGroup;

    @FindBy(css = "#input-firstname")
    WebElement firstName;

    @FindBy(css = "#input-lastname")
    WebElement lastName;

    @FindBy(css = "#input-email")
    WebElement email;

    @FindBy(css = "#input-telephone")
    WebElement phone;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(css = "#input-confirm")
    WebElement confirm;

    @FindBy(css = "#input-newsletter")
    WebElement newsletter;

    @FindBy(css = "#input-status")
    WebElement status;

    @FindBy(css = "#input-safe")
    WebElement safe;

    @FindBy(xpath = "//i[@class='fas fa-save']")
    WebElement saveButton;

    @FindBy(xpath = "//div//div[@id='alert']")
    WebElement massageAlert;
    public void customerPageFunctionality(String firstName, String lastName, String email, String phone,
     String password,String confirm, WebDriver driver                                   ){
        addSign.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        BrowserUtils.ScrollWithJS(driver, this.password);
        this.password.sendKeys(password);
        this.confirm.sendKeys(confirm);
           }
           public void custumerCheckbox(String expected,WebDriver driver) throws InterruptedException {
               Actions actions=new Actions(driver);
               BrowserUtils.ScrollWithJS(driver,newsletter);
               Thread.sleep(3000);
               if(newsletter.isDisplayed()&& !newsletter.isSelected()){
                   actions.click(newsletter).perform();
               }
               if(status.isDisplayed()&&!status.isSelected()){
                 actions.click(status).perform();
               }
               if(safe.isDisplayed()&&!safe.isSelected()){
                   actions.click(safe).perform();
               }


               BrowserUtils.ScrollWithJS(driver,saveButton);
               Thread.sleep(3000);
             saveButton.click();
             Thread.sleep(3000);
             BrowserUtils.ScrollWithJS(driver,massageAlert);
               Assert.assertEquals(BrowserUtils.getText(massageAlert),expected);

           }
}
