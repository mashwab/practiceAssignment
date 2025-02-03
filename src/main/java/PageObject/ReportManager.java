package PageObject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
    public static ExtentReports extent;
    public static ExtentReports getReportInstance(){


        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reportFolder\\extentReport.html");

        reporter.config().setReportName("Test Report");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        return extent;

    }
}
