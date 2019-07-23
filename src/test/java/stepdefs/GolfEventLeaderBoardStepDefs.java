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

public class GolfEventLeaderBoardStepDefs{

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;


	private String ENDPOINT_GET_GolfEventLeaderBoard = PropertyManager.getInstance().getGolfEventLeaderBoardEndpoint();
			//"https://supersport-api.azure-api.net/version/golf/tourId/leaderboard/";


	@Given("a (.*) Golf event leader board")
	public void a_LeaderBoard_Event_exists(String version){
			ExtentReportTestManager.startTest(version+" Golf event leader board").assignCategory(
					ExtentReportTestManager.getTest().toString());
		request =given().header(PropertyManager.getInstance().getSubscriptionKey(), 
				PropertyManager.getInstance().getSubscriptionKeyValue(), "");
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Building up the Season Golf Event leader board");
		BaseSuperSprots.endExtentReportTest();
	
		
				
	}

	@When("a user retrieves (.*) Golf Event leader board (.*)")
	public void a_user_retrieves_the_CurrentTourScheduleaderBoard(String tourId,String leaderBoardId){
		String[] strList=tourId.split(" ");
		String leaderboarEndpoint=ENDPOINT_GET_GolfEventLeaderBoard.replace("version", strList[0]).replace("tourId", strList[1])+leaderBoardId;
		//System.out.println("V5  lboad endpoint "+leaderboarEndpoint);
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Get Season "+tourId+
				" golf event schedule request "+leaderboarEndpoint);
		response = request.when().get(leaderboarEndpoint);
		ExtentReportTestManager.getTest().log(LogStatus.PASS, "Response from  "+ response.prettyPrint());
		BaseSuperSprots.endExtentReportTest();
		}

	@Then("the current (.*) leader board service returns status code is (.*)")
	public void verify_LeaderBoard_Status_Code(String tourId,String statusCode){
		json = response.then().statusCode(Integer.parseInt(statusCode));
		ExtentReportTestManager.getTest().log(LogStatus.PASS, tourId+
				" Golf Event Round Score Card service Code ::: "+json.extract().statusCode());
		
		BaseSuperSprots.endExtentReportTest();
	}
	}


