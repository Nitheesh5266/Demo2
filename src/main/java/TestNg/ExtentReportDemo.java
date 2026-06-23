package TestNg;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

    ExtentReports extent;   // Main report object
    ExtentTest test;        // For logging each test

    @BeforeSuite
    public void beforeSuite() {

        // Create HTML Reporter
        ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/Extent-Report.html");
        reporter.config().setReportName("Automation Test Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Wipro");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Test
    public void skipTest() {
        test = extent.createTest("Sample Skip Test");
        test.skip("This test is skipped");
    }

    @Test
    public void passTest() {
        test = extent.createTest("Sample Pass Test");
        test.pass("Test passed successfully");
    }

    @Test
    public void failTest() {
        test = extent.createTest("Sample Fail Test");
        test.fail("Test failed");
    }

    @Test
    public void validationTest() {
        test = extent.createTest("Validation Test");
        Assert.assertEquals(10, 12); // This will FAIL
    }

    @AfterMethod
    public void getResult(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");

        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());

        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped");
        }
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush(); // Important → generates report
    }
}