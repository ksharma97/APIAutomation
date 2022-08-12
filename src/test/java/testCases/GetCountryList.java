package testCases;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseURIsAndHeaders.BaseURI;
import BaseURIsAndHeaders.EndPoints;
import BaseURIsAndHeaders.Headers;
import utilities.Config;

public class GetCountryList extends Headers{
	
	@Test
	public  void test() {
		test = extent.createTest("Validate Get Country List API.").assignAuthor("Kundan").assignCategory("Sanity");
		BaseURI.setBaseURI("Staging");
		set_Headers_Without_Login();
		getGETResponse(EndPoints.getCountryList);	
		if(response.statusCode()==200){
			test.log(Status.PASS, "Response status code is showing correctly");
		}
	}

}
