package JPetStore;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
public class ExtentManager {
    private static ExtentReports extent;
 
    public synchronized static ExtentReports getReportInstance() {
        if (extent == null) {
            // Generates the report file 
            ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/JPetStore_ExecutionReport.html");
            // Customizing dashboard
            spark.config().setReportName("JPetStore End-to-End Regression Result");
            spark.config().setDocumentTitle("Automation Execution Dashboard");
            spark.config().setTheme(Theme.STANDARD);
 
            extent = new ExtentReports();
            extent.attachReporter(spark);
            // System environment metrics metadata
            extent.setSystemInfo("Automation Engineer", "Nisha");
            extent.setSystemInfo("Target Environment", "Stage-QA");
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
        return extent;
    }
}