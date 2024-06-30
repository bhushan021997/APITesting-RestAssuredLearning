package ex_25062024;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab280 {



    @Test(groups = {"Sanity"}, priority = 1)
    public void createBookingPositiveTestcase() {
        System.out.println("Sanity");
        System.out.println("QA");
    }

    @Test(groups = {"Sanity"},priority = 2)
    public void RegRun() {
        System.out.println("Reg");
    }

    @Test(groups = {"smoke"},priority = 3)
    public void SmokeRun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

    @Test(groups = {"qa", "prod"},priority = 3)
    public void QARun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

    @Test(groups = {"prod"},priority = 3)
    public void ProdRun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}
