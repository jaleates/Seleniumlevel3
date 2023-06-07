package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SelectPArctice {
    @Test
    public void parctice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/atesj/Downloads/Techtorial.html");
        WebElement dropdown= driver.findElement(By.xpath("//select[@name='country']"));
       // dropdown.click();
        Select option=new Select(dropdown);
       Assert.assertEquals( option.getFirstSelectedOption().getText().trim(),"UNITED STATES");
//List<WebElement> allOptions=option.getOptions();
//int count=0;
//for(int i=0;i<allOptions.size();i++){
//    System.out.println(allOptions.get(i).getText().trim());;
//    count++;
//}
//        System.out.println(count);
        option.selectByVisibleText("IRAQ ");
        Thread.sleep(3000);
        option.selectByValue("207");
        Thread.sleep(3000);
        option.selectByIndex(5);






    }


}
