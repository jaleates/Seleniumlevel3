package com.test.theSpruceEats.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li//a//span[.='Ingredients']")
    WebElement IngredientsButton;

    @FindBy(xpath = "//li//li//a[contains(text(),'Fish & Seafood')]")
    WebElement fishandSeaFood;

public void clickIngredientsButton(WebDriver driver) throws InterruptedException {
    Actions actions=new Actions(driver);
    Thread.sleep(1000);
    actions.click(IngredientsButton).moveToElement(fishandSeaFood).perform();

        }
    }

