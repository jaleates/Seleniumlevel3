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
import java.util.Arrays;
import java.util.List;

public class SelectBasics {
    @Test
    public void SelectMethods() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dropdown= driver.findElement(By.linkText("Dropdown"));
        dropdown.click();
        WebElement optionbox=driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select choise=new Select(optionbox);// i will vhoose an option from that list

        String actualdefaultoption=choise.getFirstSelectedOption().getText().trim();
        String expecteddefualtoption="Please select an option";
        Assert.assertEquals(actualdefaultoption,expecteddefualtoption);

choise.selectByVisibleText("Option 2");// this most usage
        Thread.sleep(2000);
        choise.selectByValue("1");
        Thread.sleep(2000);
        choise.selectByIndex(2);
        Thread.sleep(2000);
        // validation list from dropdown list
List<WebElement> actualOptions=choise.getOptions();
//List<String> actualOption=new ArrayList<>();
List<String> expectedOption= Arrays.asList("Please select an option","Option 1","Option 2");
for(int i=0;i<actualOptions.size();i++){
    Assert.assertEquals(actualOptions.get(i).getText().trim(),expectedOption.get(i).trim());
}

/*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Available"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
 */





    }






























}
