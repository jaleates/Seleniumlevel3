package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YouTubRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
        // song.sendkeys(Keys.ARROW_DOWN
        WebElement searchbox=driver.findElement(By.xpath("//input[@id='search']"));
        searchbox.sendKeys("Justin Bieber");
        searchbox.sendKeys(Keys.ENTER);
//        WebElement searchbutton= driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
//        searchbutton.click();
        Thread.sleep(3000);
List<WebElement> songList=driver.findElements(By.xpath("//a[@id='video-title']"));
for(WebElement song:songList){
    if(song.getAttribute("title").equalsIgnoreCase("Justin Bieber - Ghost")){
        Thread.sleep(2000);
        song.sendKeys(Keys.ARROW_DOWN);
        song.click();
        break;
    }
}















    }
}
