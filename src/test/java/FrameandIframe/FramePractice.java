package FrameandIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FramePractice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header= driver.findElement(By.tagName("h3"));
        Assert.assertEquals(header.getText(),"An iFrame containing the TinyMCE WYSIWYG Editor");
        System.out.println(header.getText());
        driver.switchTo().frame("mce_0_ifr");
        WebElement box=driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        System.out.println(BrowserUtils.getText(header));

        /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Phyton" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Python Tutorial"
  5-Print out(NO validation) all the links from website
  6-Wait for Second task
 */



    }
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        Actions actions=new Actions(driver);
        WebElement clickpavilion= driver.findElement(By.linkText("Pavilion"));
clickpavilion.click();
BrowserUtils.switchByTitle(driver,"qavalidation");
    WebElement selenium= driver.findElement(By.linkText("Selenium"));
                actions.moveToElement(selenium).perform();
                WebElement seleniumPython= driver.findElement(By.linkText("Selenium-Python"));
        actions.click(seleniumPython).perform();
        WebElement hearder= driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(hearder),"Selenium-Python Tutorial");
        List<WebElement> linksName=driver.findElements(By.xpath("//p//a"));
        for(int i=0;i< linksName.size();i++){
            System.out.println(linksName.get(i).getText());

        }
        System.out.println("=======");
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement catagpry1=driver.findElement(By.linkText("Category1"));
        catagpry1.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting");
        WebElement header1=driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getText(header1),"Category Archives: SeleniumTesting");
      //  Thread.sleep(3000);
        List<WebElement> allHeadrers=driver.findElements(By.xpath("//h3[@class='entry-title']"));
        for(int i=0;i<allHeadrers.size();i++){
            System.out.println(BrowserUtils.getText(allHeadrers.get(i)));
        }

       BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement text= driver.findElement(By.cssSelector("#frametext"));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(BrowserUtils.getText(text));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement Catagory3= driver.findElement(By.linkText("Category3"));
        Catagory3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        WebElement header2= driver.findElement(By.xpath("//h1"));
        System.out.println(BrowserUtils.getText(header2));



    }
}
