package TestNG;

import org.testng.annotations.Test;

public class testNGIntro {
    /*
    We can not make main method 2 times instead of this we have aspecial annotation
    @Test--> this called test annotation
    to be able to create as many as main method to create
    the test is run base on assending order of the refernce name
    to be able to run the tests in order we use the(priority) with test annotation
    if you don't put priority by default it will be 0, and it will run first
    to run the test multiple time we use invocationCount
     */
    @Test(priority = 1, invocationCount = 5)
    public void test1(){
        System.out.println("test1");
    }
    @Test(priority = 2)
    public void test2(){
        System.out.println("test 2");
    }
    @Test(priority = 3)
    public void test3(){
        System.out.println("test 3");
    }

















}
