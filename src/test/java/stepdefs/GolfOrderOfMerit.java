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

public class GolfOrderOfMerit{

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;


	private String ENDPOINT_GET_OrderOfMerit = PropertyManager.getInstance().getgolfOrderofMeritEndpoint();
			//"https://supersport-api.azure-api.net/version/golf/tourId/order-of-merit";


	@Given("a Golf Order Of Merit for (.*)")
	public void a_GolfOrderOfMerit_exists(String version){
		 ExtentReportTestManager.startTest(version+" Golf Order Of Merit").assignCategory(ExtentReportTestManager.getTest().toString());
		
		request =given().header(PropertyManager.getInstance().getSubscriptionKey(), 
				PropertyManager.getInstance().getSubscriptionKeyValue(), "");
		 ExtentReportTestManager.getTest().log(LogStatus.INFO, "Building up the Golf Order Of Merit request");
		 BaseSuperSprots.endExtentReportTest();
		
	}

	@When("a user retrieves the tour (.*) Golf Order Of Merit")
	public void a_user_retrieves_the_GolfOrderOfMerit(String tourId){
		String[] strList=tourId.split(" ");
		String GolfOrderOfMeritEndpoint=ENDPOINT_GET_OrderOfMerit.replace("version", strList[0]).replace("tourId", strList[1]);
		//System.out.println("endpoint URL"+ yearlyGolfEventEndpoint);
		ExtentReportTestManager.getTest().log(LogStatus.INFO, "Get Season "+tourId+" golf event schedule request "+GolfOrderOfMeritEndpoint);
		response = request.when().get(GolfOrderOfMeritEndpoint);
		//.out.println("response: " + response.prettyPrint());
		ExtentReportTestManager.getTest().log(LogStatus.PASS, "Response from  "+ response.prettyPrint());
		BaseSuperSprots.endExtentReportTest();
	}

	@Then("the (.*) Golf Order Of Merit service returns status code is (.*)")
	public void verify_GolfOrderOfMerit_Status_Code(String tourId,String statusCode){
		json = response.then().statusCode(Integer.parseInt(statusCode));
		//System.out.println("Json value "+json);
		
		ExtentReportTestManager.getTest().log(LogStatus.PASS, tourId+" golf event schedule response Code ::: "+json.extract().statusCode());
	
		BaseSuperSprots.endExtentReportTest();
		 
	}
	}


