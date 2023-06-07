package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        System.out.println("===> https://kahoot.com/ <=== " );
        driver.get("https://kahoot.com/");
        System.out.println(driver.getTitle());
        String actualTitle= driver.getTitle();
        String expectTitle= "Kahoot! | Learning games | Make learning awesome!";
        String resul=actualTitle.equals(expectTitle)?"Kahoot Passed":"Kahoot Failed";
        System.out.println(resul);
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://kahoot.com/";
        String result=actualUrl.equals(expectedUrl)?"Kahoot URL is Passed":"Kahoot URL is Failed";
        System.out.println(result);
       driver.close();
        System.out.println("===> www.facebook.com <=== " );
         driver=new ChromeDriver(options);
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        String actualTitle1= driver.getTitle();
        String expectTitle1= "Facebook - log in or sign up";
        String result1=actualTitle1.equals(expectTitle1)?"Facebook Passed":"Facebook Failed";
        System.out.println(result1);
        String actualUrl1= driver.getCurrentUrl();
        String expectedUrl1="https://www.facebook.com/";
        String result3=actualUrl1.equals(expectTitle1)?"facebook URL Passed":"Facebook URL Failed";
        System.out.println(result3);
        driver.close();
        System.out.println("===> www.typing.academy <=== " );
         driver=new ChromeDriver(options);
        driver.get("https://www.typing.academy/typing-tutor/lessons");
        System.out.println(driver.getTitle());
        String actualTitle2= driver.getTitle();
        String expectTitle2= "Typing lessons - Practice your typing speed - TypingAcademy";

        String result2=actualTitle2.equals(expectTitle2)?"Typing Passed":"Typing Failed";
        System.out.println(result2);
        String actualUrl2= driver.getCurrentUrl();
        String expectedUrl2="https://www.typing.academy/typing-tutor/lessons";
        String result4=actualUrl2.equals(expectTitle2)?"Typing URL Passed":"Typing URL Failed";
        System.out.println(result4);
        driver.close();




    }
}
