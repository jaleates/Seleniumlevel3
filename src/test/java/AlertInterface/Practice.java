package AlertInterface;

import Utils.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice {
    @Test
    public void practiceJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement alertclick= driver.findElement(By.cssSelector("#alertBox"));
        alertclick.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am an alert box!");
        alert.accept();
        WebElement message1= driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowersUtils.getText(message1),"You selected alert popup");

        WebElement confirmbox=driver.findElement(By.cssSelector("#confirmBox"));
        confirmbox.click();
        Assert.assertEquals(alert.getText(),"Press a button!");
        alert.dismiss();
        WebElement message2= driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowersUtils.getText(message2),"You pressed Cancel in confirmation popup");

        WebElement box= driver.findElement(By.cssSelector("#promptBox"));
        box.click();
        alert.sendKeys("Accepted");
        alert.accept();
        WebElement message3= driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowersUtils.getText(message3),"You entered text Accepted in propmt popup");
    }

}
