package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumdDiverMethods {
    /*
    driver.get()
    driver.manage.window.maximize()
    driver.getTitle()
    driver.getCurrentUrl
    driver.navigate.to()
    driver.navigate,refresh)
    driver.navigate.back()
    driver.navigate.forward()
    driver.getPageSource()
    driver.close()
    driver.quit()

     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getTitle());
        driver.navigate().forward();
        System.out.println(driver.getTitle());
        driver.navigate().refresh();
        Thread.sleep(3000);
       System.out.println( driver.getPageSource());
        driver.quit();// close all open webbr


    }
}
