package FrameandIframe;

import Utils.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class nestedFrame {
    @Test
    public void nestedFramePractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        WebElement iframeLeft=driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iframeLeft);
        WebElement left= driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));

        System.out.println(BrowersUtils.getText(left));
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        WebElement middle= driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowersUtils.getText(middle));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowersUtils.getText(right));
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();// this will take youto the main html
        driver.switchTo().frame("frame-bottom");
        WebElement buttom=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowersUtils.getText(buttom));
    }
}
