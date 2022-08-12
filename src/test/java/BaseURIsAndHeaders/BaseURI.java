package BaseURIsAndHeaders;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import utilities.Config;

public class BaseURI extends Reports{
	
	public static void setBaseURI(String uritype) {
		
		if(Config.getConfigValue("APIENV").equalsIgnoreCase("Staging")) {
			if(uritype.equalsIgnoreCase("WEB")) {
				RestAssured.baseURI = Config.getConfigValue("WebTestURI");
				test.log(Status.PASS,"Base URI has been set as "+Config.getConfigValue("WebTestURI"));
			}
			else if(uritype.equalsIgnoreCase("CRM")) {
				RestAssured.baseURI = Config.getConfigValue("CRMTestURI");
				test.log(Status.PASS,"Base URI has been set as "+Config.getConfigValue("CRMTestURI"));
			}
			else if(uritype.equalsIgnoreCase("Staging")) {
				RestAssured.baseURI = Config.getConfigValue("StagingTestURI");
				test.log(Status.PASS,"Base URI has been set as "+Config.getConfigValue("StagingTestURI"));
			}
	
		}else if(Config.getConfigValue("APIENV").equalsIgnoreCase("QA")) {
			if(uritype.equalsIgnoreCase("WEB")) {
				RestAssured.baseURI = Config.getConfigValue("WebUATURI");
				test.log(Status.PASS,"Base URI has been set as "+Config.getConfigValue("WebUATURI"));
			}
			else if(uritype.equalsIgnoreCase("CRM")) {
				RestAssured.baseURI = Config.getConfigValue("CRMUATURI");
				test.log(Status.PASS,"Base URI has been set as "+Config.getConfigValue("CRMUATURI"));
			}
			else if(uritype.equalsIgnoreCase("Staging")) {
				RestAssured.baseURI = Config.getConfigValue("StagingUATURI");
				test.log(Status.PASS,"Base URI has been set as "+Config.getConfigValue("StagingUATURI"));
			}

		}else if(Config.getConfigValue("APIENV").equalsIgnoreCase("Prod")) {
			if(uritype.equalsIgnoreCase("WEB")) {
				RestAssured.baseURI = Config.getConfigValue("WebProdURI");
				test.log(Status.PASS,"Base URI has been set as "+Config.getConfigValue("WebProdURI"));
			}
			else if(uritype.equalsIgnoreCase("CRM")) {
				RestAssured.baseURI = Config.getConfigValue("CRMTProdURI");
				test.log(Status.PASS,"Base URI has been set as "+Config.getConfigValue("CRMProdURI"));
			}
			else if(uritype.equalsIgnoreCase("Staging")) {
				RestAssured.baseURI = Config.getConfigValue("StagingProdURI");
				test.log(Status.PASS,"Base URI has been set as "+Config.getConfigValue("StagingProdURI"));
			}
			
		}else {
			System.out.println("Base URI is incorrect");
			test.log(Status.FAIL,"Invalid Base URI");
			System.exit(0);
		}
		
	}
}