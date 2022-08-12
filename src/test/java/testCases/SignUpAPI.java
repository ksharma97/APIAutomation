package testCases;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseURIsAndHeaders.BaseURI;
import BaseURIsAndHeaders.EndPoints;
import BaseURIsAndHeaders.Headers;
import io.restassured.path.json.JsonPath;
import utilities.Config;

public class SignUpAPI extends Headers{
	
	@Test
	public  void test() {
		test = extent.createTest("Validate Sign Up API.").assignAuthor("Kundan").assignCategory("Sanity");
		BaseURI.setBaseURI("WEB");
		set_Headers_Without_Login();
		LocalTime reqTime = LocalTime.now();
		getPOSTResponse(Config.getConfigValue("SignUpReq"),EndPoints.signup);
		LocalTime resTime = LocalTime.now();
		test.log(Status.INFO, "Time taken "+resTime +" - "+reqTime+" = "+reqTime.until(resTime, ChronoUnit.MILLIS)+"milliseconds");
		if(response.statusCode()==200){
			test.log(Status.PASS, "Response status code is showing correctly");
		}
	    JsonPath jsnPath = response.jsonPath();
	    String leadId =jsnPath.get("data.leadId");
	    Config.setConfigValue("leadId", leadId);
	    if(leadId!=null) 
	    	test.log(Status.PASS, "leadId parameter is present in response string and value is "+leadId);

	}

}
