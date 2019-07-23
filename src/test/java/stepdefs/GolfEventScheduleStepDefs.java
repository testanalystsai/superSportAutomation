package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import options.BaseSuperSprots;
import options.ExtentReportManager;
import options.ExtentReportTestManager;
import options.PropertyManager;

public class GolfEventScheduleStepDefs{

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;


	private String ENDPOINT_GET_GolfEventSchedule =PropertyManager.getInstance().getgolfEventScheduleEndpoint();
			//"https://supersport-api.azure-api.net/version/golf/tourId/schedule/";


	@Given("a Season Golf event schedule for (.*)")
	public void a_YearlySeasonGolfEventSchedule_exists(String version){
		 ExtentReportTestManager.startTest(version+" Season Golf Event Schedule").assignCategory(ExtentReportTestManager.getTest().toString());
		
		 request =given().header(PropertyManager.getInstance().getSubscriptionKey(), 
					PropertyManager.getInstance().getSubscriptionKeyValue(), "");
		 ExtentReportTestManager.getTest().log(LogStatus.INFO, "Building up the Season Golf Event schedule request");
		 BaseSuperSprots.endExtentReportTest();
		
	}

	@When("a user retrieves the current (.*) of this year (.*)")
	public void a_user_retrieves_the_YearlySeasonGolfEventSchedule(String tourID,String year){
		String[] strList=tourID.split(" ");
		String yearlyGolfEventEndpoint=ENDPOINT_GET_GolfEventSchedule.replace("version", strList[0]).
				replace("tourId", strList[1])+year;
		//System.out.println("endpoint URL"+ yearlyGolfEventEndpoint);
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Get Season "+tourID+" golf event schedule request "+yearlyGolfEventEndpoint);
		response = request.when().get(yearlyGolfEventEndpoint);
		//.out.println("response: " + response.prettyPrint());
		ExtentReportTestManager.getTest().log(LogStatus.PASS, "Response from  "+ response.prettyPrint());
		BaseSuperSprots.endExtentReportTest();
	}

	@Then("the Season Golf event (.*) schedule service returns status code is (.*)")
	public void verify_YearlySeasonGolfEventSchedule_Status_Code(String tourID,String statusCode){
		json = response.then().statusCode(Integer.parseInt(statusCode));
		//System.out.println("Json value "+json);
		
		ExtentReportTestManager.getTest().log(LogStatus.PASS, tourID+" golf event schedule response Code ::: "+json.extract().statusCode());
	
		BaseSuperSprots.endExtentReportTest();
		 
	}
	}


