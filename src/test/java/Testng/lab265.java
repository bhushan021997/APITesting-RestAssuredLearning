package Testng;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class lab265 {

    @Description("TC#1")
    @Test
    public void testCase() {

        // Assertion ->  Expect Result = Actual Result
        // 200 == 200

        // Two Types Assertions

        // Soft Assertions
//
//        SoftAssert s= new SoftAssert();
//        s.assertEquals("Pramod","Bhushan", "Not Equal");
//        s.assertEquals("Pramod","pramod", "Not Equal");
//        System.out.println("End of the Program");

        Assert.assertEquals("Bhushan","Bhushan");
        System.out.println("End of the Program fro hard Assertion");
    }

}
