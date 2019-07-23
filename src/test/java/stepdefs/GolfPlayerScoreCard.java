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

public class GolfPlayerScoreCard {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;


	private String ENDPOINT_GET_PlayerScoreCard = PropertyManager.getInstance().getplayerScoreCardEndpoint();
			//"https://supersport-api.azure-api.net/version/golf/tourId/scorecard/eventId/";


	@Given("a Golf Player Score Card for an event for (.*)")
	public void a_GolfPlayerScoreCard_exists(String version){
		 ExtentReportTestManager.startTest(version+" Golf Player Score Card for an event").assignCategory(ExtentReportTestManager.getTest().toString());
		
		request =given().header(PropertyManager.getInstance().getSubscriptionKey(), 
				PropertyManager.getInstance().getSubscriptionKeyValue(), "");
		 ExtentReportTestManager.getTest().log(LogStatus.INFO, "Building up the Golf Player Score Card for an event request");
		 BaseSuperSprots.endExtentReportTest();
		
	}

	@When("a user retrieves the current tour (.*) Golf Player (.*) Score Card for an event (.*)")
	public void a_user_retrieves_the_GolfPlayerScoreCard(String tourId,String player,String eventId){
		String[] strList=tourId.split(" ");
		String yearlyGolfEventEndpoint=ENDPOINT_GET_PlayerScoreCard.replace("version", strList[0])
				.replace("tourId", strList[1]).replace("eventId", eventId)
				+player;
		//Integer.parseInt(player)
		System.out.println("endpoint URL "+ yearlyGolfEventEndpoint);
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Get Season "+tourId+" golf event schedule request "+yearlyGolfEventEndpoint);
		response = request.when().get(yearlyGolfEventEndpoint);
		//.out.println("response: " + response.prettyPrint());
		ExtentReportTestManager.getTest().log(LogStatus.PASS, "Response from  "+ response.prettyPrint());
		BaseSuperSprots.endExtentReportTest();
		
		
	}
	
	@When("a user retrieves the current tour (.*) Golf Player (.*) Score Card for a leaderboard of an event (.*)")
	public void a_user_retrieves_the_GolfPlayerScoreCardV5(String tourId,String player,String eventId){

		String ENDPOINT_GET_CurrentTourScheduleV5 = "https://supersport-api.azure-api.net/version/golf/tourId/leaderboard/eventId/scorecard/";
		String[] strList=tourId.split(" ");
		String yearlyGolfEventEndpoint=ENDPOINT_GET_CurrentTourScheduleV5.replace("version", strList[0])
				.replace("tourId", strList[1]).replace("eventId", eventId)
				+player;
		//Integer.parseInt(player)
		System.out.println("endpoint URL "+ yearlyGolfEventEndpoint);
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Get Season "+tourId+" golf event schedule request "+yearlyGolfEventEndpoint);
		response = request.when().get(yearlyGolfEventEndpoint);
		//.out.println("response: " + response.prettyPrint());
		ExtentReportTestManager.getTest().log(LogStatus.PASS, "Response from  "+ response.prettyPrint());
		BaseSuperSprots.endExtentReportTest();
	}


	@Then("the Golf Player (.*) Score Card for the (.*) for an event (.*) service returns status code is (.*)")
	public void verify_GolfPlayerScoreCard_Status_Code(String tourId,String playerId,String eventId,String statusCode){
		json = response.then().statusCode(Integer.parseInt(statusCode));
		//System.out.println("Json value "+json);
		
		ExtentReportTestManager.getTest().log(LogStatus.PASS, tourId+" Golf Player Score Card for an event response Code ::: "+json.extract().statusCode());
	
		BaseSuperSprots.endExtentReportTest();
		 
	}
	}


