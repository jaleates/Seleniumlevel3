package GetWindowHandle;

import Utils.BrowersUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SitchMultipleWindows {
    @Test
    public void switchwindows(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        Set <String> allpages=driver.getWindowHandles();
        for(String id:allpages){
            if(!id.equals(driver.getWindowHandle())){
                driver.switchTo().window(id);
                break;

            }
        }
        System.out.println(driver.getTitle());
  BrowersUtils.switchByTitle(driver,"Contact");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        BrowersUtils.switchByTitle(driver,"Kickstart Your");
        System.out.println(driver.getTitle());
        BrowersUtils.switchByTitle(driver,"Courses");
        System.out.println(driver.getTitle());



    }
                /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */
    @Test
    public void realTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button4= driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowersUtils.ScrollWithJS(driver,button4);
        button4.click();
        BrowersUtils.switchByTitle(driver,"Basic Controls" );
        WebElement firstName= driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys("Alex");
        WebElement lastName= driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys("Alex");

        WebElement gender=driver.findElement(By.xpath("//input[@id='malerb']"));
        BrowersUtils.ScrollWithJS(driver,gender);
        gender.click();
        WebElement checkbox=driver.findElement(By.xpath("//input[@id='englishchbx']"));
        checkbox.click();
        WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("alex234@gmail.com");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("12345");
        Thread.sleep(3000);
        WebElement register=driver.findElement(By.xpath("//button[@id='registerbtn']"));
      BrowersUtils.ScrollWithJS(driver,register);
        register.click();
        WebElement massage= driver.findElement(By.xpath("//label[@id='msg']"));
        Assert.assertEquals(BrowersUtils.getText(massage),"Registration is Successful");
        BrowersUtils.switchByTitle(driver,"Window Handles");
        WebElement header= driver.findElement(By.xpath("//h1[@itemprop='name']"));
        Assert.assertEquals(BrowersUtils.getText(header),"Window Handles Practice");
        BrowersUtils.switchByTitle(driver,"AlertsDemo");
        WebElement button= driver.findElement(By.xpath("//button[@id='promptBox']"));
        BrowersUtils.ScrollWithJS(driver,button);
        button.click();
        driver.quit();



    }
}
