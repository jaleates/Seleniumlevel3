package com.test.blaze.page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LapTopPage {
    public LapTopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='hrefch']")
    List<WebElement> laptopNames;

    public void findMacBookPro() throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < laptopNames.size(); i++) {
            if (BrowserUtils.getText(laptopNames.get(i)).equals("MacBook Pro")) {
                laptopNames.get(i).click();
                break;
            }
        }
    }}
