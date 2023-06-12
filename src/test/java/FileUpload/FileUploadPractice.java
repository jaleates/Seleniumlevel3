package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions Options=new ChromeOptions();
        Options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(Options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement choosefile= driver.findElement(By.cssSelector("#file-upload"));
        choosefile.sendKeys("C:\\Users\\atesj\\Desktop\\usa.png");
        WebElement upload= driver.findElement(By.cssSelector("#file-submit"));
        upload.click();
        WebElement usapng= driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertTrue(BrowserUtils.getText(usapng).contains("usa.png"));

    }
    @Test
    public void Task(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions Options=new ChromeOptions();
        Options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(Options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chosseButton= driver.findElement(By.cssSelector(".upload_txt"));
        chosseButton.sendKeys("C:\\Users\\atesj\\Desktop\\Java videos\\se.pdf");
        WebElement message= driver.findElement(By.xpath("//span//b[contains(text(),'Select file ')]"));
        Assert.assertEquals(BrowserUtils.getText(message),"Select file to send(max 196.45 MB)");
        WebElement checkBox=driver.findElement(By.cssSelector("#terms"));
        if(!checkBox.isSelected()){
            checkBox.click();
        }

        WebElement submitButton= driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();
        WebElement message2= driver.findElement(By.xpath("//div//h3"));
        Assert.assertTrue(BrowserUtils.getText(message2).contains("has been successfully uploaded"));

    }
}
