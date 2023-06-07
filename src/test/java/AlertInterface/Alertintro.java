package AlertInterface;

import Utils.BrowersUtils;
import com.beust.ah.A;
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

public class Alertintro {
    @Test
    public void AlertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickforJSAlert= driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
        clickforJSAlert.click();
        Alert alert=driver.switchTo().alert();
        String actual= alert.getText();
        String expcet="I am a JS Alert";
        Assert.assertEquals(actual,expcet);
        alert.accept();
        WebElement result= driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowersUtils.getText(result),"You successfully clicked an alert");

    }
    @Test
    public void AlertDismiss(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement JSconfirm= driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        JSconfirm.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        WebElement message= driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowersUtils.getText(message),"You clicked: Cancel");

    }




    @Test
    public void AletSendkeys(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clicksend= driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt()')]"));
        clicksend.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("I am JS pop Up");
        alert.accept();
        WebElement message=driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowersUtils.getText(message),"You entered: I am JS pop Up");

    }
}
