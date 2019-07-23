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

public class GolfEventScoreCardStepDefs{

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;


	private String ENDPOINT_GET_GolfEventScoreCardStepDefs = PropertyManager.getInstance().getGolfEventScoreCardEndpoint();
			//"https://supersport-api.azure-api.net/v4/golf/tourId/scorecard/";


	@Given("a Golf Event Score Card for (.*)")
	public void a_GolfEventScoreCardStepDefs_exists(String version){
		 ExtentReportTestManager.startTest(version+" Golf Event Score Card").assignCategory(ExtentReportTestManager.getTest().toString());
		request =given().header(PropertyManager.getInstance().getSubscriptionKey(), 
				PropertyManager.getInstance().getSubscriptionKeyValue(), "");
		 ExtentReportTestManager.getTest().log(LogStatus.INFO, "Building up the a Golf Event Score Card request");
		 BaseSuperSprots.endExtentReportTest();
		
	}

	@When("a user retrieves the tour (.*) Golf Event Score Card (.*)")
	public void a_user_retrieves_the_GolfEventScoreCardStepDefs(String tourId,String season){
		
		String GolfEventScoreCardEndpoint=ENDPOINT_GET_GolfEventScoreCardStepDefs.replace("tourId", tourId)+season;
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Get Season "+tourId+" Golf Event Score Card "+GolfEventScoreCardEndpoint);
		response = request.when().get(GolfEventScoreCardEndpoint);
		ExtentReportTestManager.getTest().log(LogStatus.PASS, "Response from  "+ response.prettyPrint());
		BaseSuperSprots.endExtentReportTest();
	}

	@Then("the (.*) Golf Event Score Card service returns status code is (.*)")
	public void verify_GolfEventScoreCardStepDefs_Status_Code(String tourId,String statusCode){
		json = response.then().statusCode(Integer.parseInt(statusCode));
		
		ExtentReportTestManager.getTest().log(LogStatus.PASS, tourId+" Golf Event Score Card response Code ::: "+
		json.extract().statusCode());
	
		BaseSuperSprots.endExtentReportTest();
		 
	}
	}


