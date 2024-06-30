package Testng;

import org.testng.annotations.*;

public class Lab264 {

    @BeforeSuite
    void demo1(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    void demo2(){
        System.out.println("Before Test");
    }

    @BeforeClass
    void demo3(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    void demo4(){
        System.out.println("Before Method");
    }

    @Test
    void demo5(){
        System.out.println("Test");
    }

    @AfterSuite
    void demo6(){
        System.out.println("After Suite");
    }

    @AfterTest
    void demo7(){
        System.out.println("After Test");
    }

    @AfterClass
    void demo8(){
        System.out.println("After Class");
    }

    @AfterMethod
    void demo9(){
        System.out.println("After Method");
    }

}

