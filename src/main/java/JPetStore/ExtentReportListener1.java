package JPetStore;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
 
public class ExtentReportListener1 implements ITestListener {
    private static final Logger logger = LogManager.getLogger(ExtentReportListener1.class);
    private static ExtentReports extent = ExtentManager.getReportInstance();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
 
    public static ExtentTest getTest() {
        return testThread.get();
    }
 
    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Executing Test Scenario Pipeline: " + result.getMethod().getMethodName());
        if (extent == null) {
            extent = ExtentManager.getReportInstance();
        }
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThread.set(test);
    }
 
    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("PASSED: " + result.getMethod().getMethodName());
    }
 
    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("FAILED: " + result.getMethod().getMethodName());
        result.getThrowable().printStackTrace();
        if (getTest() != null) {
            getTest().log(Status.FAIL, result.getThrowable());
        }
    }
 
 
    @Override
    public void onFinish(ITestContext context) {
        logger.info("Compiling and generating final HTML report dashboard...");
        if (extent != null) {
            extent.flush();
        }
    }
}