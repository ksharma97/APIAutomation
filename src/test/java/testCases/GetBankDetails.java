package testCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseURIsAndHeaders.BaseURI;
import BaseURIsAndHeaders.EndPoints;
import BaseURIsAndHeaders.Headers;

public class GetBankDetails extends Headers{

	@Test
	public  void test() {
		test = extent.createTest("Validate Get Bank Details API.").assignAuthor("Kundan").assignCategory("Sanity");
		BaseURI.setBaseURI("Staging");
		set_Headers_Without_Login();
		getGETResponse(EndPoints.GET_BANK_DETAILS);
		if(response.statusCode()==200){
			test.log(Status.PASS, "Response status code is showing correctly");
		}
	}
}
