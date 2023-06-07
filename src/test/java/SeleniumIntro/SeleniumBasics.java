package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {

  // the frist step is setting up the automation
  public static void main(String[] args) {
      WebDriverManager.chromedriver().setup();// this step to setup the chrom here
      ChromeOptions options=new ChromeOptions();// these two line because of the bug that found, and this will be not used after few months
      options.addArguments("--remote-allow-origins=*");
      // the create the drive to start automation
      WebDriver driver=new ChromeDriver(options);// it is a wya to connect the driver with the website
      // this is like a key to start the automation
      // it is a way to manipulate the data from the website
      // without the driver you can not connect the website
      driver.get("https://www.amazon.com/");
      System.out.println(driver.getTitle());
      String actualTitle= driver.getTitle();
      String expectTitle= "Amazon.com. Spend less. Smile more.";
      if(actualTitle.equals(expectTitle)){
          System.out.println("Passed");
      }else{
          System.out.println("Failed");
      }
      String actualUrl= driver.getCurrentUrl();
      String expectedUrl="https://www.amazon.com/";
      if(actualUrl.equals(expectedUrl)){
          System.out.println("Passed");
      }else{
          System.out.println("Failed");
      }

      driver.close();

  }

}
