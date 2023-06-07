package SeleniumLocatores;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathPracticemidlevel {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName= driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Jale");
WebElement LastName= driver.findElement(By.xpath("//input[@id='input-lastname']"));
LastName.sendKeys("Ates");
WebElement email= driver.findElement(By.xpath("//input[@id='input-email']"));
email.sendKeys("atesj2342al12e2004@hotmail.com");

WebElement Phone= driver.findElement(By.xpath("//input[@id='input-telephone']"));
Phone.sendKeys("2673456");
WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
password.sendKeys("Jale1234");
WebElement confirm=driver.findElement(By.xpath("//input[@id='input-confirm']"));
confirm.sendKeys("Jale1234");
WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
checkbox.click();
WebElement submit1= driver.findElement(By.xpath("//input[@type='submit']"));
submit1.click();

WebElement text= driver.findElement(By.xpath("/html/body/div[2]/div/div/h1"));
String actualtext=text.getText();
        String expecttext="Your Account Has Been Created!";
        if(actualtext.equals(expecttext)){
            System.out.println("Your Account Has Been Created!");
        }else{
            System.out.println("Please fill all requested area");
        }
        WebElement submit= driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
        submit.click();
        String currentUrl= driver.getCurrentUrl();
        String expectedUrl="https://tutorialsninja.com/demo/index.php?route=account/account";
        if(currentUrl.equals(expectedUrl)){
            System.out.println("Passed");
        }else {
            System.out.println("Faild");
        }



















    }
}
