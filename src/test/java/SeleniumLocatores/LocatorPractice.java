package SeleniumLocatores;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {

  /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
WebElement firstname=driver.findElement(By.name("firstname"));
firstname.sendKeys("FirstName");
WebElement LastName= driver.findElement(By.name("lastname"));
LastName.sendKeys("LastName");
Thread.sleep(3000);
WebElement gender= driver.findElement(By.id("sex-1"));
if(gender.isDisplayed() && !gender.isSelected()){
    gender.click();
}
WebElement Experience= driver.findElement(By.id("exp-4"));
if(Experience.isDisplayed()&& !Experience.isSelected()){
    Experience.click();
}
WebElement date= driver.findElement(By.id("datepicker"));
date.sendKeys("16/05/2023");
WebElement profession= driver.findElement(By.id("profession-0"));
if(profession.isDisplayed()&&!profession.isSelected()){
    profession.click();
}
WebElement profession1=driver.findElement(By.id("profession-1"));
if(profession1.isDisplayed()&& !profession1.isSelected()){
    profession1.click();
}
WebElement tool= driver.findElement(By.id("tool-2"));
if(tool.isDisplayed()&&!tool.isSelected()){
    tool.click();
}
WebElement continent=driver.findElement(By.id("continents"));
continent.sendKeys("Asia");
Thread.sleep(2000);
WebElement submit=driver.findElement(By.id("submit"));
if(submit.isDisplayed()&&!submit.isSelected()){
    submit.click();
    String actualUrl= driver.getCurrentUrl();
    String expectedUrl="https://www.techlistic.com/p/selenium-practice-form.html";
    if(actualUrl.equals(expectedUrl)){
        System.out.println("URL is Passed");
    }else{
        System.out.println("URL is Failed");
    }
}







    }
}
