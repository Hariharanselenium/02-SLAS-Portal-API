package com.thinktimetechno.Warehouse.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoanOfficerEndPoints extends BaseEndpoints{

public static String LoanOfficertoken;
	
	RequestSpecification requestSpecification;
	public Response result;
	
	
	private  String application_ENDPOINT_PATH="";
  
	public Response applicationSalesCreatePayload(String jsonFile) throws IOException {


			
		requestSpecification = getRequestWithJSONHeaders();

		switch (jsonFile){
			case "Login.json":
				application_ENDPOINT_PATH="/api/staff/auth/login";
				
				break;
			
			
		}
		File jsonDataInFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Payloads"+File.separator+"LoanOfficerPayloads"+File.separator+jsonFile);
		result=requestSpecification.body(jsonDataInFile).post(getBaseUrl() + application_ENDPOINT_PATH);
		String responseBody = result.getBody().asString();
	     JSONObject postResponseJson = new JSONObject(responseBody);
	     LoanOfficertoken = postResponseJson.getJSONObject("data").getString("token");
		return result;
		
	}
	
	public Response applicationSalesfetchPayload(String name ) {

		requestSpecification =getRequestWithJSONHeadersToken(LoanOfficertoken);
		
	
		switch (name){
		case "Loan Analytics":
			application_ENDPOINT_PATH="/api/staff/loans/analytics";
		
			break;
		case "Get all loan applications":
			application_ENDPOINT_PATH="/api/staff/loans?page=1&limit=10&to=2023-09-29&from=2023-01-01&status=pending&institute_id=12";
			break;
		case "Get loan details":
			application_ENDPOINT_PATH="/api/staff/loans/?id=15/details";
			break;
		
		}
			result=requestSpecification.get(getBaseUrl() + application_ENDPOINT_PATH);
	     	return result;
	
}
	

}