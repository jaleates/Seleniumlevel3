package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homwork2testcase3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement FullName= driver.findElement(By.id("user-name"));
        FullName.sendKeys("standard_user");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement button=driver.findElement(By.id("login-button"));
        button.click();

        String currentUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        if(currentUrl.equals(expectedUrl)){
            System.out.println("Test case3 passed");
        }else {
            System.out.println("Test case3 Failed");
        }























    }
}
