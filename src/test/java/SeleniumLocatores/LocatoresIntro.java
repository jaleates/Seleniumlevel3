package SeleniumLocatores;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatoresIntro {
    /*
    Locatores means locate(find) element and manipulate on it
    IDlocatore
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.navigate().to("file:///C:/Users/atesj/Downloads/Techtorial.html");
        driver.manage().window().maximize();
        WebElement hearder=driver.findElement(By.id("techtorial1"));
        String actualHeader= hearder.getText().trim();
        String expectedHeader="Techtorial Academy";
        System.out.println(hearder.getText());
        System.out.println(actualHeader.equals(expectedHeader)?"Correct":"wrong");
        WebElement paragraph=driver.findElement(By.id("details2"));
        //String actualHeader1= paragraph.getText().trim();
        System.out.println(paragraph.getText());
        // NAME LOCATOR
        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Jale");
        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Ates");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("1233456");
        WebElement email=driver.findElement(By.id("userName"));
        email.sendKeys("jshdfg@kjshdfjk");
        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("hjjsdfuhiufhhdv");
        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("St louise");
        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("state");
        WebElement postalCode=driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("12345");
        // Class Locatore
        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());
WebElement javaBox=driver.findElement(By.id("cond1"));
if(javaBox.isDisplayed()&& !javaBox.isSelected()){
    javaBox.click();
}
        System.out.println(javaBox.isSelected()?"selected":"not selected");
WebElement testNG=driver.findElement(By.id("cond3"));
if(testNG.isDisplayed()&&!testNG.isSelected()){
    testNG.click();
}
        System.out.println(testNG.isSelected()?"TestNG Selected":"TestNG is not selected");

WebElement cucumber=driver.findElement(By.id("cond4"));
if(cucumber.isDisplayed()&&!cucumber.isSelected()){
    cucumber.click();
}
        System.out.println(cucumber.isSelected()?"cucmber is selected":"cucumber is not selected");
// tagName Locator<h1> the thing inside diamond brackets are tagnames
WebElement header=driver.findElement(By.tagName("h1"));
        System.out.println(header.getText());
WebElement usejavabox=driver.findElement(By.tagName("u"));
        System.out.println(usejavabox.getText());















    }
}
