package com.thetestingacademy.testng;

import com.beust.ah.A;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab265 {

    @Description("TC#1")
    @Test
    public void testcase(){

        //Assertion ->  Expect Result = Actual Result
        // 200 == 200

        // Two Types Assertions
        // 1.Soft Assertions

        SoftAssert s = new SoftAssert();
        s.assertEquals("yogita","Yogita", "Not Equal");
        System.out.println("End of the Program");
        s.assertAll();

        // Hard Assertion

        //Assert.assertEquals("yogi","Yogi");
        //System.out.println("End of the program");



    }
}
