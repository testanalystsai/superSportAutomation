package options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" }, glue = { "stepdefs" }, features = {
		"src/test/features/"},
		tags= {"@V5"} )
public class TestRunner {
	//glue = { "classpath:src/test/java/cucumber/stepdefs" }
	/*
	 * @Before public static void setup() { System.out.println("Ran the before");
	 * 
	 * //ExtentManager.getReporter();
	 * 
	 * ExtentReportTestManager.startTest("Sample Test Case").assignCategory();
	 * ExtentReportTestManager.getTest().toString(); }
	 * 
	 * @After public static void teardown() { System.out.println("Ran the after");
	 * 
	 * ExtentReportManager.getReporter().endTest(ExtentReportTestManager.getTest());
	 * 
	 * ExtentReportManager.getReporter().flush();
	 * 
	 * ExtentReportTestManager.endTest();
	 * 
	 * }
	 */
	 
}
