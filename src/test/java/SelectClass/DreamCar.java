package SelectClass;

import Utils.BrowersUtils;
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
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public void HeadersOfCAr() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
        WebElement brand= driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowersUtils.selectBy(brand,"new","value");
        WebElement makePart=driver.findElement(By.xpath("//select[@id='makes']"));
        BrowersUtils.selectBy(makePart,"lexus","value");
        WebElement model=driver.findElement(By.xpath("//select[@id='models']"));
BrowersUtils.selectBy(model,"lexus-rx_350","value");
WebElement price=driver.findElement(By.cssSelector("#make-model-max-price"));
        Select Price=new Select(price);
        String actualPrice=BrowersUtils.getText(Price.getFirstSelectedOption());
        String expectedPrice="No max price";
        Assert.assertEquals(actualPrice,expectedPrice);
WebElement distance= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
BrowersUtils.selectBy(distance,"40","value");
WebElement zip=driver.findElement(By.xpath("//input[@id='make-model-zip']"));
zip.clear(); zip.sendKeys("60056");
WebElement searchButton= driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
searchButton.click();
WebElement headText=driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
Assert.assertEquals(BrowersUtils.getText(headText),"New Lexus RX 350 for sale");
WebElement priceLevel= driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
BrowersUtils.selectBy(priceLevel,"list_price","value");
        Thread.sleep(2000);
List<WebElement> namesOfBrands=driver.findElements(By.xpath("//h2[@class='title']"));

        for (WebElement namesOfBrand : namesOfBrands) {
            Assert.assertTrue(namesOfBrand.getText().contains("Lexus RX 350"));

        }
Thread.sleep(2000);
List<WebElement> allPrices=driver.findElements(By.xpath("//span[@class='primary-price']"));
List<Integer> ActualPrice=new ArrayList<>();
List<Integer>ExpectedPrice=new ArrayList<>();
Thread.sleep(2000);
        for (WebElement allPrice : allPrices) {
            String carPrice = BrowersUtils.getText(allPrice).replace("$", "").replace(",", "");
            ActualPrice.add(Integer.parseInt(carPrice));
            ExpectedPrice.add(Integer.parseInt(carPrice));
        }
        System.out.println(ActualPrice);
        System.out.println("---------------");
        System.out.println(ExpectedPrice);
Collections.sort(ExpectedPrice);
Assert.assertEquals(ActualPrice,ExpectedPrice);





    }
}
