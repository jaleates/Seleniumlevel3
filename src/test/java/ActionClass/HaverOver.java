package ActionClass;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HaverOver {
    @Test
    public void HoverOver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> alllimages=driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<WebElement> Allname=driver.findElements(By.tagName("h5"));
        List<String> actualenames=new ArrayList<>();
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        Actions actions=new Actions(driver);
        for(int i=0;i<alllimages.size();i++){
            actions.moveToElement(alllimages.get(i)).perform();
            actualenames.add(BrowserUtils.getText(Allname.get(i)));
        }
        Assert.assertEquals(actualenames,expectedNames);
        System.out.println(actualenames);
        System.out.println(expectedNames);






    }
}
