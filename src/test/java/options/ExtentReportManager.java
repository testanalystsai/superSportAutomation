package options;

import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManager {
	
	static ExtentReports extent;

	 

    public static String reportLocation = null;

	/*
	 * final public static String filePath ="E:/Reports"; //+ "/SummaryReport.html";
	 */
    public static String filePath ="E:/Reports";
    //+ "/SummaryReport.html";
    public static String emailReports ="";

    public static String  projectLocation="E:/";



    public static String getReportLocation() {

           if(reportLocation==null) {

           reportLocation = projectLocation + "Reports//SuperSports_Automation_Report_"

                        + (new Date()).toString().replace(":", "_").replace(" ", "_");

           return reportLocation;

           }else {

                  return reportLocation;

           }
           }

    public synchronized static ExtentReports getReporter() {
           if (extent == null) {

                       // extent = new ExtentReports(filePath, true);
			/*
			 * filePath=filePath+"//SuperSports_Automation_Report_"
			 * 
			 * + (new Date()).toString().replace(":", "_").replace(" ",
			 * "_")+"//SummaryReport.html";
			 */
        	   filePath=getReportLocation()+"//SummaryReport.html";
        	   extent = new ExtentReports(filePath, true);
                        getReportLocation();

                        emailReports =filePath;
                        		//ExtentReportManager.filePath;

                        Logs.info("Reports Location :"+emailReports);

                  }

                  //extent.loadConfig(PortFinder.class, "extent-config.xml");

                  Logs.info("************************************************************************************\n");

                        Logs.info("Extent Reports Location : " + System.getProperty("user.dir") + "/" + emailReports

                                      + "\n");
                  Logs.info("************************************************************************************\n");
           return extent;
           
    }
}


