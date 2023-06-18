package TestNG;

import org.testng.annotations.*;

public class testNGAnnotations {
    @BeforeClass// used to deletcookies
    public void beforeClass(){
        System.out.println("I am Before class annotation");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am After Class annotation");
    }
    @BeforeTest
    public void beforTest(){
        System.out.println("I am before test annotation");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am after test annotation");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I am before Suite");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("I am After suite");
    }
  @BeforeMethod
  public void beforeMethod(){
      System.out.println("Iam before method annotation");
  }
    @Test
    public void test1(){
        System.out.println("I am test 1 annotation");
    }

    @Test
    public void test2(){
        System.out.println("IU am test 2 annotation");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method annotation");
    }


}
