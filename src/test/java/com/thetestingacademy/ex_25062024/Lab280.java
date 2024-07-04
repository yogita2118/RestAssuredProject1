package com.thetestingacademy.ex_25062024;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab280 {
    // Grouping of Test cases

    @Test(groups = {"Sanity"},priority = 0)
    public void sanityRun(){
        System.out.println("Sanity");

    }

    @Test(groups = {"Reg"},priority = 1)
    public void RegRun(){
        System.out.println("Reg");
    }

    @Test(groups = {"Smoke"},priority = 2)
    public void SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Qa"},priority = 3)
    public void QARun(){
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Prod"},priority = 4)
    public void ProdRun(){
        System.out.println("Prod");
        Assert.assertTrue(true);
    }

}
