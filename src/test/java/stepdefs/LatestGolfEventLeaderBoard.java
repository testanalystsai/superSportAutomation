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

public class LatestGolfEventLeaderBoard {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;


	private String ENDPOINT_GET_LatestGolfEventLeaderBoard = PropertyManager.getInstance().getlatestGolfEventLeaderBoardEndpoint();
			//"https://supersport-api.azure-api.net/v4/golf/tourId/leaderboard";


	@Given("a Latest Golf Event Leader Board for (.*)")
	public void a_LatestGolfEventLeaderBoard_exists(String version){
		 ExtentReportTestManager.startTest(version+" Latest Golf Event Leader Board").assignCategory(ExtentReportTestManager.getTest().toString());
		request =given().header(PropertyManager.getInstance().getSubscriptionKey(), 
				PropertyManager.getInstance().getSubscriptionKeyValue(), "");
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Building up the Latest Golf Event Leader Board request");
		BaseSuperSprots.endExtentReportTest();
		
				
	}

	@When("a user retrieves the (.*) Latest Golf Event Leader Board")
	public void a_user_retrieves_the_LatestGolfEventLeaderBoard(String tourId){
		String LatestGolfEventLeaderBoardService=ENDPOINT_GET_LatestGolfEventLeaderBoard.replace("tourId", tourId);
		
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Get Season "+tourId+
				" golf event schedule request "+LatestGolfEventLeaderBoardService);
		response = request.when().get(LatestGolfEventLeaderBoardService);
	
		ExtentReportTestManager.getTest().log(LogStatus.PASS, "Response from  "+ response.prettyPrint());
		BaseSuperSprots.endExtentReportTest();
	}

	@Then("the Latest Golf Event Leader Board for an (.*) service returns status code is (.*)")
	public void verify_LatestGolfEventLeaderBoard_Status_Code(String tourId,String statusCode){
		json = response.then().statusCode(Integer.parseInt(statusCode));		
		ExtentReportTestManager.getTest().log(LogStatus.PASS, tourId+
				" Latest Golf Event Leader Board service Code ::: "+json.extract().statusCode());
		
		BaseSuperSprots.endExtentReportTest();
	}
	}


