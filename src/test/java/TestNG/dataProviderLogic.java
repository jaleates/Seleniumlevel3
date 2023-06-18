package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderLogic extends AllDataPractice{
//    @DataProvider(name="allNames")
////    public Object[][] getData(){
//    return new Object[][]{
//                {"Jale ","Leyla"},
//                {"Ahmet ", "Melih"},
//                {"Oguzhan ","Erdal"},
//                {"Melek ","Rahme"},
//                {"Metin ","Harun"}
//        };
//    }
    @Test(dataProvider = "allNames")
    public void test1(String firstPerson,String SecondPerson){
        System.out.println(firstPerson+SecondPerson);
    }
//    @Test
//    public void test2(){
//        System.out.println("Ahmet "+"Melih");
//    }
//    @Test
//    public void test3(){
//        System.out.println("Oguzhan "+"Erdal");
//    }
//
//    @Test
//    public void test4(){
//        System.out.println("Melek "+"Rahme");
//    }
//    @Test
//    public void test5(){
//        System.out.println("Metin "+"Harun");
//    }
}
