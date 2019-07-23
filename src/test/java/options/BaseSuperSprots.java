package options;

public class BaseSuperSprots {
	
	public static void endExtentReportTest()
	{
		 ExtentReportManager.getReporter().endTest(ExtentReportTestManager.getTest());
		  
		  ExtentReportManager.getReporter().flush();
		  
		  ExtentReportTestManager.endTest();
		 
	}
	

}
