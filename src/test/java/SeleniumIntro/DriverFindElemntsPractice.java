package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElemntsPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> links=driver.findElements(By.tagName("li"));
        int count=0;
//        for(int i=1;i<links.size()-1;i++){
//            System.out.println(links.get(i).getText());
//            count++;
//        } tagName de a harfini koyarsak bu loop kullana biliriz
//        for(WebElement link:links){
//            System.out.println(link.getText());
//            count++;
//        }
//        System.out.println(count);
for(WebElement link:links){
    if(link.getText().length()>=12){
        System.out.println(link.getText().trim());
        count++;
    }
}
        System.out.println(count);

















    }
}
