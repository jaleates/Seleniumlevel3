package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {
    public  int multiplication(int number1, int number2){
        return number1*number2;
    }
    @Test
    public void validateMultiplication(){
        int actualresult=multiplication(3,4);
        int expected=12;
//        if(actualresult==expected){
//            System.out.println("Passed");
//        }else {
//            System.out.println("Faild");
//        }

        Assert.assertEquals(actualresult,expected);
    }
    @Test
    public void validateZero(){
int actual=multiplication(0,999);
int expected=0;
Assert.assertTrue(actual==expected);
    }
     @Test
    public void validateNegativeWithPosetive(){
int actual=multiplication(-1,9);
int expected=-9;
Assert.assertFalse(actual!=expected);

     }
    @Test
    public void validateNegativeWithNegative(){
int actual=multiplication(-5,-4);
int expected=20;
Assert.assertEquals(actual,expected);


    }

/*
TEST CASE: FOR OPEN CARTTESTNGPRACTICE

1-You will click the productName button
2-You should create 2 arraylist
  *-One of them will be actualData
  *-Another will be expectedData
3-For(int i=1)
  *store all the names for both of the
  list.Please use at the end .toUpperCase or toLowerCase
4-For expected List -->you will use Collections.sort(expectedList)
                    -->Collections.reverse(expected)
                    Assert.equals(actualList,expectedlist)
 */













}
