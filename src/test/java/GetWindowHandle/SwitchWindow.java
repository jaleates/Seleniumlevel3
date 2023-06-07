package GetWindowHandle;

import Utils.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickhere= driver.findElement(By.linkText("Click Here"));
        clickhere.click();
        WebElement title= driver.findElement(By.tagName("h3"));
        title.getText();
        System.out.println(BrowersUtils.getText(title));
        System.out.println(driver.getWindowHandle());
        Set<String> allpageIDS=driver.getWindowHandles();
        for(String id:allpageIDS){
            if(!id.equals(driver.getWindowHandle())){
                driver.switchTo().window(id);
                break;
            }
        }
        title= driver.findElement(By.tagName("h3"));
        System.out.println(BrowersUtils.getText(title));

    }

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button2= driver.findElement(By.cssSelector("#newTabBtn"));
        BrowersUtils.ScrollWithJS(driver,button2);
        button2.click();
        WebElement header1=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
      //driver.getwindowhadle() will give the first pages id
        Set<String> pagesId=driver.getWindowHandles();
        for(String PID:pagesId) {
            if (!PID.equals(driver.getWindowHandle())) {
                driver.switchTo().window(PID);
                break;
            }


        }
        header1=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Assert.assertEquals(BrowersUtils.getText(header1),"AlertsDemo");
        Assert.assertEquals(driver.getTitle(),"AlertsDemo - H Y R Tutorials");
        WebElement clikme = driver.findElement(By.cssSelector("#alertBox"));
        clikme.click();


    }
}
