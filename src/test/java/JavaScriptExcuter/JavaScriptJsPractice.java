package JavaScriptExcuter;

import Utils.BrowserUtils;
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
import java.util.Arrays;
import java.util.List;

public class JavaScriptJsPractice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement yesButton= driver.findElement(By.xpath("//input[@id='yesRadio']"));
       // yesButton.click();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",yesButton);
        WebElement selectedvalidate= driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualselect= selectedvalidate.getText();
        String expectedselect="You have selected Yes";
        Assert.assertEquals(actualselect,expectedselect);
WebElement impressiveButton=driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        js.executeScript("arguments[0].click()",impressiveButton);
        WebElement impressiveText=driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualimp=impressiveText.getText();
        String expecteimp="You have selected Impressive";
        Assert.assertEquals(actualimp,expecteimp);
WebElement noButton= driver.findElement(By.cssSelector("#noRadio"));
Assert.assertTrue(!noButton.isEnabled());




    }

    @Test
    public void ScrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

WebElement findOutCource= driver.findElement(By.xpath("//span[contains(text(),'which course ')]//.."));
JavascriptExecutor js=(JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView(true)",findOutCource);
Thread.sleep(2000);
findOutCource.click();

            }
            @Test
    public void practice2() throws InterruptedException {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origin=*");
                WebDriver driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.get("https://www.techtorialacademy.com/");

                WebElement copyright= driver.findElement(By.xpath("//div[contains(text(),'Copyright ')]"));
Thread.sleep(2000);
                BrowserUtils.ScrollWithJS(driver,copyright);
Assert.assertEquals(BrowserUtils.getText(copyright),"Copyright © 2023");
                WebElement apply= driver.findElement(By.linkText("Apply Now"));
//                BrowersUtils.ScrollWithJS(driver,apply);
       BrowserUtils.clickWithJS(driver,apply);
              Assert.assertEquals(  BrowserUtils.getTitlewithJS(driver),"Apply Now");
List<WebElement> Alltext= driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
List<String> expected= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");
                for (int i=0;i<Alltext.size();i++){
                  Assert.assertEquals(BrowserUtils.getText(Alltext.get(i)), expected.get(i));
                }

            }

}
