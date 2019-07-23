package options;
import java.util.HashMap;
import java.util.Map;import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
public class ExtentReportTestManager { 

    static Map extentTestMap = new HashMap();

    static ExtentReports extent = ExtentReportManager.getReporter();

    public static ExtentTest logger; 

    public static synchronized ExtentTest getTest() {

        return (ExtentTest) extentTestMap.get((int)(long)(Thread.currentThread().getId()));

    } 

    public static synchronized void endTest() {

        extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));    

    }

 

    public static synchronized ExtentTest startTest(String testName) {

        return startTest(testName, "");      

    } 

    public static synchronized ExtentTest startTest(String testName, String desc) {

        ExtentTest test = extent.startTest(testName, desc);

        logger=test;

        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

        return test;

    }

}
