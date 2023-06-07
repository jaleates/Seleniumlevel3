package SelectClass;

import Utils.BrowersUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MidLevelPractice {

     /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */















    @Test
    public void validateOrderMessage(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWay= driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();

        WebElement selectPassenger= driver.findElement(By.xpath("//select[@name='passCount']"));
        //selectPassenger.click();
        Select passenger=new Select(selectPassenger);
        passenger.selectByValue("4");

        WebElement DepartingFromSelect= driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingfrom=new Select(DepartingFromSelect);
        Assert.assertEquals(departingfrom.getFirstSelectedOption().getText(),"Acapulco");
departingfrom.selectByValue("Paris");

WebElement Month= driver.findElement(By.xpath("//select[@name='fromMonth']"));
Select dateMonth=new Select(Month);
dateMonth.selectByValue("8");

WebElement Day= driver.findElement(By.xpath("//select[@name='fromDay']"));
Select dateDay=new Select(Day);
dateDay.selectByVisibleText("15");

WebElement Arriving=driver.findElement(By.xpath("//select[@name='toPort']"));
Select arrive=new Select(Arriving);
arrive.selectByVisibleText("San Francisco");

WebElement arriveMonth= driver.findElement(By.xpath("//select[@name='toMonth']"));
Select Arrivemonth=new Select(arriveMonth);
Arrivemonth.selectByValue("12");

WebElement arriveDay= driver.findElement(By.xpath("//select[@name='toDay']"));
Select Arriveday=new Select(arriveDay);
Arriveday.selectByValue("15");

WebElement serviceClass= driver.findElement(By.xpath("//input[@value='First']"));
serviceClass.click();

WebElement airline=driver.findElement(By.xpath("//select[@name='airline']"));
airline.sendKeys(Keys.ARROW_DOWN);
Select airlineList=new Select(airline);
        List<WebElement> actualOptions=airlineList.getOptions();
        List<String> expectedOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for(int i=0;i<actualOptions.size();i++){
            Assert.assertEquals(actualOptions.get(i).getText().trim(),expectedOptions.get(i).trim());
        }

        airlineList.selectByVisibleText("Unified Airlines");

WebElement continueButton=driver.findElement(By.xpath("//input[@name='findFlights']"));
continueButton.click();

WebElement messageValidate=driver.findElement(By.xpath("//font[@size='4']"));

String acutalMessage=messageValidate.getText().trim();
String expectedmessage="After flight finder - No Seats Available";
Assert.assertEquals(acutalMessage,expectedmessage);
        System.out.println(acutalMessage);
        System.out.println(expectedmessage);

//Assert.assertEquals(messageValidate.getText().trim(),"After flight finder - No Seats Avaialble");



    }


    @Test
    public void validateOrderMessageSHORTCUT(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWay= driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();
        WebElement selectPassenger= driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowersUtils.selectBy(selectPassenger,"4","value");
        WebElement DepartingFromSelect= driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingfrom=new Select(DepartingFromSelect);
        Assert.assertEquals(departingfrom.getFirstSelectedOption().getText(),"Acapulco");
     BrowersUtils.selectBy(DepartingFromSelect,"Paris","value");
        WebElement Month= driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowersUtils.selectBy(Month,"8","value");
        WebElement Day= driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowersUtils.selectBy(Day,"15","text");
        WebElement Arriving=driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowersUtils.selectBy(Arriving,"San Francisco","text");
        WebElement arriveMonth= driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowersUtils.selectBy(arriveMonth,"12","value");
        WebElement arriveDay= driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowersUtils.selectBy(arriveDay,"15","value");
        WebElement serviceClass= driver.findElement(By.xpath("//input[@value='First']"));
        serviceClass.click();
        WebElement airline=driver.findElement(By.xpath("//select[@name='airline']"));
        airline.sendKeys(Keys.ARROW_DOWN);
        Select airlineList=new Select(airline);
        List<WebElement> actualOptions=airlineList.getOptions();
        List<String> expectedOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for(int i=0;i<actualOptions.size();i++){
            Assert.assertEquals(BrowersUtils.getText( actualOptions.get(i)),expectedOptions.get(i).trim());
        }
        airlineList.selectByVisibleText("Unified Airlines");
        WebElement continueButton=driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        WebElement messageValidate=driver.findElement(By.xpath("//font[@size='4']"));
        String acutalMessage=BrowersUtils.getText(messageValidate);
        String expectedmessage="After flight finder - No Seats Avaialble";
        Assert.assertEquals(acutalMessage,expectedmessage);
        System.out.println(acutalMessage);
        System.out.println(expectedmessage);
}}
