package SeleniumLocatores;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    /*
    LinkText Locator
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/atesj/Downloads/Techtorial.html");
        // LinkedText
        /*
        to use linktext th element must have the <a> </a> the a tag
         */
        WebElement javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaheader= driver.findElement(By.tagName("h1"));
        String actualheader=javaheader.getText().trim();
        String ecpectedheader="Java";
        System.out.println(actualheader.equals(ecpectedheader)?"Correct":"Not correct");
        
        driver.navigate().back();
     WebElement seleniumLink= driver.findElement(By.linkText("Selenium"));
     seleniumLink.click();
     WebElement seleniumHeader= driver.findElement(By.tagName("h1"));
     String actualSeleniumHeader=seleniumHeader.getText().trim();
     String expectedheader1="Selenium automates browsers. That's it!";
        System.out.println(actualSeleniumHeader.equals(expectedheader1)?"selenium correct":"selenium incorrect");

        driver.get("file:///C:/Users/atesj/Downloads/Techtorial.html");
        WebElement CucumberLink=driver.findElement(By.linkText("Cucumber"));
        CucumberLink.click();
        WebElement cucumberHeader=driver.findElement(By.tagName("h1"));
        String actualcucumberHeader=cucumberHeader.getText().trim();
        String expectedcucmberHeader="Tools & techniques that elevate teams to greatness";
        System.out.println(actualcucumberHeader.equals(expectedcucmberHeader)?"Cucumber correct":"Cucumber false");

        driver.get("file:///C:/Users/atesj/Downloads/Techtorial.html");
        WebElement testNG= driver.findElement(By.linkText("TestNG"));
        testNG.click();
        WebElement testHeader= driver.findElement(By.tagName("h2"));
        String actualtestHeader=testHeader.getText().trim();
        String expectedteastHeader="TestNG";
        System.out.println(actualtestHeader.equals(expectedteastHeader)?"Test Correct":"Test InCorrect");
        // LOCATOR PARTIALLINKTEXT:
        driver.get("file:///C:/Users/atesj/Downloads/Techtorial.html");
        WebElement restApi=driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());






























    }
}
