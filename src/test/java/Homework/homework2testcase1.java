package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.cert.X509Certificate;

public class homework2testcase1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        WebElement FullName= driver.findElement(By.xpath("//input[@id='userName']"));
        FullName.sendKeys("John");
        if(FullName.isDisplayed()){
            System.out.println("Your name is registered to the system");
        }
       WebElement email= driver.findElement(By.id("userEmail"));
        email.sendKeys("john@gmail.com");
        if(email.isDisplayed()){
            System.out.println("your email is regisyered to the system ");
        }
        WebElement CurrentAddress=driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        CurrentAddress.sendKeys("6576 Smiley AveSt.Louis,MO 63139");
        if(CurrentAddress.isDisplayed()){
            System.out.println("Your current address has been registered");
        }
        WebElement PermanentAddress= driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        PermanentAddress.sendKeys("6576 Smiley AveSt.Louis,MO 63139");
        if(PermanentAddress.isDisplayed()){
            System.out.println("Your permanent address has been registered");
        }
        Thread.sleep(2000);
        WebElement Button= driver.findElement(By.id("submit"));
        Button.click();

        String curentUrl=driver.getCurrentUrl();
        String Url="https://demoqa.com/text-box";
        System.out.println(curentUrl.equals(Url)?"Passed":"Failed");


    }
}
