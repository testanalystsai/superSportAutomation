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
import options.ExtentReportTestManager;
import options.PropertyManager;

public class CurrentSeasonEventScheduleStepDefs{

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	//String baseURL = PropertyManager.getInstance().getURL();
	private String ENDPOINT_GET_CurrentTourSchedule = PropertyManager.getInstance().getCurrentSeasonEventEndpoint();
			//"https://supersport-api.azure-api.net/v4/golf/tourId/schedule";


	@Given("a Golf event schedule by current season for (.*)")
	public void a_european_tour_exists(String version){
		 ExtentReportTestManager.startTest(version+" Golf event schedule by current season").
		assignCategory(ExtentReportTestManager.getTest().toString());
		 System.out.println("Key *** "+ PropertyManager.getInstance().getSubscriptionKey());
		 System.out.println("Key Value *** "+ PropertyManager.getInstance().getSubscriptionKeyValue());
		request =given().header(PropertyManager.getInstance().getSubscriptionKey(), 
				PropertyManager.getInstance().getSubscriptionKeyValue(), "");
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Building up the Golf event schedule by current season request");
		BaseSuperSprots.endExtentReportTest();
	}

	@When("a user retrieves the current (.*) schedule details")
	public void a_user_retrieves_the_CurrentTourSchedule(String tourId){
		String[] strList=tourId.split(" ");
		String currentTourScheduleEndpoint=ENDPOINT_GET_CurrentTourSchedule.replace("version", strList[0]).replace("tourId", strList[1]);
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Get Season "+tourId+
				" golf event schedule request "+currentTourScheduleEndpoint);
		response = request.when().get(currentTourScheduleEndpoint);
		ExtentReportTestManager.getTest().log(LogStatus.PASS, "Response from  "+ response.prettyPrint());
		
		BaseSuperSprots.endExtentReportTest();
	}

	@Then("the current (.*) schedule service returns status code is (.*)")
	public void verify_Tour_Schedule_Status_Code(String tourId,String statusCode){
		json = response.then().statusCode(Integer.parseInt(statusCode));
		ExtentReportTestManager.getTest().log(LogStatus.PASS, tourId+
				" Golf Event Round Score Card service Code ::: "+json.extract().statusCode());
		
		BaseSuperSprots.endExtentReportTest();
	}
	}


