package BaseURIsAndHeaders;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Headers extends Reports{
	
	protected static Map<String,String> requestHeaders;
	protected static RequestSpecification httpRequest;
	protected static Response response;
	
	public static void set_Headers_Without_Login() {
		
		httpRequest = RestAssured.given();
		requestHeaders = new HashMap<>();
		requestHeaders.put("X-CSRF-TOKEN", "qQGcVhDm4AHjwb6k4HclUmqUCgjTo8ufwz22egXm");
		requestHeaders.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		requestHeaders.put("Cookie", "_gcl_au=1.1.28367030.1658385012; _fbp=fb.1.1658385012110.1341932654; _gaexp=GAX1.2.2I-NeY4tSO25MvDwMMeFPw.19253.1; ajs_anonymous_id=760fe657-8e59-4c94-819d-499b2e51f0cb; _ga=GA1.3.243064687.1658385012; _ga=GA1.2.243064687.1658385012; _ga_XHGK4CG6Q0=GS1.1.1658747546.3.0.1658747546.0; _hjSessionUser_2886983=eyJpZCI6IjViZWQ1ZDdkLWI0ZGEtNWUzOS04MjRkLTNlYjlhNGU4NDQ1NyIsImNyZWF0ZWQiOjE2NTgzODU3ODA1MjAsImV4aXN0aW5nIjp0cnVlfQ==; twk_uuid_5fd1c5a0a1d54c18d8f23869=%7B%22uuid%22%3A%221.485BS9lFTyqfqE865hnfkbPQeUzVYeGBMIpVlniyAo3aeCtI6eZTdQvPDZHSIkDMRnc8v8Yvf1mAnzIlBcl0GU9RaExuMh7a0jgAHNN2FhVAXINuxwPNw0KXBaKff1jHJhbQuZg4mNObZby%22%2C%22version%22%3A3%2C%22domain%22%3A%22credenc.com%22%2C%22ts%22%3A1659604539124%7D; _gid=GA1.2.509994949.1659941253; _gid=GA1.3.509994949.1659941253; _gat_UA-107667447-1=1; _gat_gtag_UA_107667447_1=1; XSRF-TOKEN=eyJpdiI6ImJ0cysySlwvXC9EVENBdHgwMDFRXC9sUlE9PSIsInZhbHVlIjoiUTQwRTN4dWZwS1ZIb3pJZlhQS2d3OTMrV2dyS3ozaGhiTHlmMkdVZVQzekxzM0tWTmZJQU10VTNtNFgxVkN0T0U2M3htQ20yaUFmZmUxZzdZR1NLR3c9PSIsIm1hYyI6IjhlYjRiNzM2OGY4MWIyOGJiYzNlYmQ0M2JlMDM5MTY2Nzc5YzY1MDQ0YTExN2Q5NTlkNGYwNWE3MmJiMzljYTgifQ%3D%3D; laravel_session=eyJpdiI6ImFWVE5RNXhRZ1wvR2V5c3lIT3VSK1d3PT0iLCJ2YWx1ZSI6ImJ6SW4wemw5SFloZ0c3Zk9XYlVYMVFXUGRxTmZ1TjZPelJNc2J5dHVNNmxPS1NIU0hXbXFqeDd0aktZSkVRVUdTQjR3Q1hoVDlrZDdXbnZvMlNkRGxBPT0iLCJtYWMiOiJlMWU4MzJiMDI2NGZhMDllYjkzODc2MDY2NzBkOTRkMDA1NmI5MDU0OGRlMzU1NjE2NzUwZjg4MDcyMTA4OWRlIn0%3D");
		requestHeaders.put("X-Requested-With", "XMLHttpRequest");
		httpRequest.headers(requestHeaders);
		test.log(Status.PASS, "Headers have been setup");
	}
	
	public static void set_Headers_With_Login() {

		httpRequest = RestAssured.given();		
		requestHeaders = new HashMap<>();
		
	}
	
	public static void getPOSTResponse(String payload, String endPoint) {
		try {
			test.log(Status.INFO, "Request is "+ payload);
			LocalTime reqTime = LocalTime.now();
			response = httpRequest.body(payload).post(endPoint);
			LocalTime resTime = LocalTime.now();
			test.log(Status.INFO, "Time taken "+resTime +" - "+reqTime+" = "+reqTime.until(resTime, ChronoUnit.MILLIS)+"milliseconds");
			test.log(Status.INFO, "Response is "+response.jsonPath().prettify());
		}catch(Exception e) {
			test.log(Status.FAIL, "Connection Time Out or error occured "+e.getLocalizedMessage());
		}
	}
	
	public static void getGETResponse(String endPoint) {
		try {
			LocalTime reqTime = LocalTime.now();
			response = httpRequest.get(endPoint);
			LocalTime resTime = LocalTime.now();
			test.log(Status.INFO, "Time taken "+resTime +" - "+reqTime+" = "+reqTime.until(resTime, ChronoUnit.MILLIS)+"milliseconds");
			test.log(Status.INFO, "Response string is "+response.jsonPath().prettify());
		}catch(Exception e) {
			test.log(Status.FAIL, "Connection Time Out or error occured");
		}
	}

}
