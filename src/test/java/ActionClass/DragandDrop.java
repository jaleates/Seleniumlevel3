package ActionClass;

import Utils.BrowersUtils;
import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

public class DragandDrop {
    @Test
    public void dragandDrop(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Actions action=new Actions(driver);
        action.scrollByAmount(200,200);
        WebElement orangebox= driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actualmaasage= BrowersUtils.getText(orangebox);
        String expectedmaasage="... Or here.";
        Assert.assertEquals(actualmaasage,expectedmaasage);
String actualbackground=orangebox.getCssValue("background-color");
String expextedbackgroundcolor="rgba(238, 111, 11, 1)";
Assert.assertEquals(actualbackground,expextedbackgroundcolor);
WebElement drag= driver.findElement(By.xpath("//div[@id='draggable']"));
       action.dragAndDrop(drag,orangebox).perform();
WebElement afterecute=driver.findElement(By.xpath("//div[@class='test2']"));
String actual=BrowersUtils.getText(afterecute);
String expected="You did great!";
Assert.assertEquals(actual,expected);

    }

    @Test
    public void DargAndDropPractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Actions action=new Actions(driver);
        action.scrollByAmount(200,200);
        WebElement bliebox= driver.findElement(By.xpath("//div[@class='test1']"));
        String actual=BrowersUtils.getText(bliebox);
        String expect="Drag the small circle here ...";
        Assert.assertEquals(actual,expect);
        String actualcolor= bliebox.getCssValue("background-color").trim();
        String expectedcolor="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualcolor,expectedcolor);
        WebElement dragable= driver.findElement(By.xpath("//div[@id='draggable']"));
        action.clickAndHold(dragable).moveToElement(bliebox).release().perform();
        bliebox= driver.findElement(By.xpath("//div[@class='test1']"));
        String actualafteraction=BrowersUtils.getText(bliebox);
        String expectedafteraction="You did great!";
        Assert.assertEquals(actualafteraction,expectedafteraction);
    }
    @Test
    public void PracticeDragandDrop(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Actions action=new Actions(driver);
        action.scrollByAmount(200,200);
        WebElement dragme= driver.findElement(By.cssSelector("#draggable"));
        WebElement Drophere=driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));
       String actualtext=BrowersUtils.getText(Drophere);
       String expectedtext="Drop here";
       Assert.assertEquals(actualtext,expectedtext);
        action.dragAndDrop(dragme,Drophere).perform();
        Drophere=driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));
String actualmassage=BrowersUtils.getText(Drophere);
String expectedMassage="Dropped!";
Assert.assertEquals(actualmassage,expectedMassage);
String actualcolor= Drophere.getCssValue("background-color");
String expectedcolor="rgba(70, 130, 180, 1)";
Assert.assertEquals(actualcolor,expectedcolor);


    }
@Test
    public void ClickAndHoldPractice(){
    WebDriverManager.chromedriver().setup();
    ChromeOptions options=new ChromeOptions();
    options.addArguments("--remote-allow-origin=*");
    WebDriver driver=new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://demoqa.com/droppable");

    WebElement acceptButton= driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
    acceptButton.click();
    WebElement notAccept= driver.findElement(By.xpath("//div[@id='notAcceptable']"));
    String actualtext=BrowersUtils.getText(notAccept);
    String exceptedtext="Not Acceptable";
    Assert.assertEquals(actualtext,exceptedtext);
    WebElement dropHere=driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
    String actualmassage=BrowersUtils.getText(dropHere);
    String expectedmassage="Drop here";
    Assert.assertEquals(actualmassage,expectedmassage);
    Actions action=new Actions(driver);
    action.clickAndHold(notAccept).moveToElement(dropHere).release().perform();
      // dropHere=driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));

       String Afterdragactual=BrowersUtils.getText(dropHere);
       String AfterExcpected="Drop here";
       Assert.assertEquals(Afterdragactual,AfterExcpected);
}



}
