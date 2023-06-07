package AlertInterface;

import Utils.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HTMLPractice {
    @Test
    public void practiceBoth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");
        WebElement leftPreview= driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        leftPreview.click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement rightPreview= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        rightPreview.click();
        Thread.sleep(2000);
        WebElement htmltext= driver.findElement(By.xpath("//div[@class='swal-modal']"));
        System.out.println(BrowersUtils.getText(htmltext));
        String actual= htmltext.getText().trim();
        String expected="Something went wrong";
        Assert.assertTrue(actual.contains(expected));
//        WebElement classTitle=driver.findElement(By.xpath("//div[@class='swal-title']"));
//        System.out.println(BrowersUtils.getText(classTitle));
//        Thread.sleep(2000);
//        WebElement classText= driver.findElement(By.xpath("//div[@class='swal-text']"));
//        System.out.println(BrowersUtils.getText(classText));
        WebElement okButton= driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        okButton.click();
        driver.close();




    }
}
