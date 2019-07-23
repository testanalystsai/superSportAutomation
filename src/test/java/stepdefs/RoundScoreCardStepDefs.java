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

public class RoundScoreCardStepDefs{

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;


	private String ENDPOINT_GET_RoundScoreCardSchedule = PropertyManager.getInstance().getroundScoreCardEndpoint();
			//"https://supersport-api.azure-api.net/v4/golf/tourId/scorecard/eventId/round/";


	@Given("request to a Golf Event Round Score Card for (.*)")
	public void a_RoundScoreCard_Event_exists(String version){
		 ExtentReportTestManager.startTest(version+" Golf Event Round Score Card").assignCategory(ExtentReportTestManager.getTest().toString());
		request =given().header(PropertyManager.getInstance().getSubscriptionKey(), 
				PropertyManager.getInstance().getSubscriptionKeyValue(), "");
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Building up the Season Golf Event schedule request");
		BaseSuperSprots.endExtentReportTest();
		
				
	}

	@When("a user retrieves tour (.*) golf event round (.*) score card of a leaderboard (.*)")
	public void a_user_retrieves_the_RoundScoreCard(String tourId,String round,String eventId){
		String RoundScoreCardService=ENDPOINT_GET_RoundScoreCardSchedule.replace("tourId", tourId).replace("eventId", eventId)+round;
		
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Get Season "+tourId+
				" golf event schedule request "+RoundScoreCardService);
		response = request.when().get(RoundScoreCardService);
	
		ExtentReportTestManager.getTest().log(LogStatus.PASS, "Response from  "+ response.prettyPrint());
		BaseSuperSprots.endExtentReportTest();
	}

	@Then("the (.*) Golf Event Round Score Card service returns status code is (.*)")
	public void verify_RoundScoreCard_Status_Code(String tourId,String statusCode){
		json = response.then().statusCode(Integer.parseInt(statusCode));		
		ExtentReportTestManager.getTest().log(LogStatus.PASS, tourId+
				" Golf Event Round Score Card service Code ::: "+json.extract().statusCode());
		
		BaseSuperSprots.endExtentReportTest();
	}
	}


