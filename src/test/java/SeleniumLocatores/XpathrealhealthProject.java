package SeleniumLocatores;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathrealhealthProject {
    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

         */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com");

//        WebElement Appointment= driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
//        Appointment.click();
        //CSS
        WebElement appointmentcss=driver.findElement(By.cssSelector("#btn-make-appointment"));
        appointmentcss.click();
        WebElement username= driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");
        WebElement password= driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement login=driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();
        WebElement facility= driver.findElement(By.xpath("//select[@name='facility']"));
        facility.sendKeys("Seoul CURA Healthcare Center");
        WebElement Apply= driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));// this is a bug miss spelling
        if(Apply.isDisplayed()&&!Apply.isSelected()){
            Apply.click();
        }

        WebElement Medicaid= driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        Medicaid.click();
        WebElement date= driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("17/05/2023");
        WebElement command=driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        command.sendKeys("I want an appointment on May 20 at 3:30 pm");
        WebElement bookButton=driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookButton.click();
        WebElement Appointmentconfirm=driver.findElement(By.xpath("//h2[contains(text(),'Confirm')]"));
        String actualappointmentconfirm=Appointmentconfirm.getText().trim();
        String expected="Appointment Confirmation";
        System.out.println(actualappointmentconfirm.equals(expected)?"Pass":"Fail");
        WebElement facilitytext=driver.findElement(By.xpath("//p[contains(text(),'Seoul')]"));
        System.out.println(facilitytext.getText());
        WebElement ApplyforHospital=driver.findElement(By.xpath("//p[.='Yes']"));
        System.out.println(ApplyforHospital.getText());
        WebElement Healthprogram= driver.findElement(By.xpath("//p[.='Medicaid']"));
        System.out.println(Healthprogram.getText());
        WebElement dateprint=driver.findElement(By.xpath("//p[.='17/05/2023']"));
        System.out.println(dateprint.getText());
        WebElement commandtext=driver.findElement(By.xpath("//p[.='I want an appointment on May 20 at 3:30 pm']"));
        System.out.println(commandtext.getText());
        WebElement gohomepage= driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        gohomepage.click();
        String Url= driver.getCurrentUrl();
        System.out.println(Url);
        driver.close();

























    }
}
