package com.test.openchart.tests;

import com.test.openchart.pages.CustomerPage;
import com.test.openchart.pages.HomePage;
import com.test.openchart.pages.loginPage;
import org.testng.annotations.Test;

public class CustomerTest extends OpenChartTestBase {
    @Test
    public void CustomerPageFunctionality() throws InterruptedException {
        loginPage loginPage=new loginPage(driver);
        loginPage.loginfunvtionality("demo","demo");
        HomePage homePage=new HomePage(driver);
        homePage.clickButtons();
        CustomerPage customerPage=new CustomerPage(driver);
        customerPage.customerPageFunctionality("Jale","Ates","jaleates@gmail.com","1234567","qwert","qwert",driver);
        customerPage.custumerCheckbox("Warning: You do not have permission to modify customers!",driver);
    }


}
