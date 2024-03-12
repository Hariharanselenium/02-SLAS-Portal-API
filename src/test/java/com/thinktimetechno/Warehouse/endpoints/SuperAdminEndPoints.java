package com.thinktimetechno.Warehouse.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SuperAdminEndPoints extends BaseEndpoints{


	
	RequestSpecification requestSpecification;
	public Response result;
	public static int applicationNameId;
	public static String SuperAdmintoken;
	private  String application_ENDPOINT_PATH="";
   boolean isApplicationId=false;
   int id=5;
	public Response applicationSalesCreatePayload(String jsonFile) throws IOException {


			
		requestSpecification = getRequestWithJSONHeaders();

		switch (jsonFile){
			case "Login.json":
				application_ENDPOINT_PATH="/api/admin/auth/login";
				
				break;
			
			
		}
		File jsonDataInFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Payloads"+File.separator+"SuperAdminPayloads"+"/"+jsonFile);
		result=requestSpecification.body(jsonDataInFile).post(getBaseUrl() + application_ENDPOINT_PATH);
		String responseBody = result.getBody().asString();
	     JSONObject postResponseJson = new JSONObject(responseBody);
	     SuperAdmintoken = postResponseJson.getJSONObject("data").getString("token");
		return result;
		
	}
	
	public Response applicationSalesfetchPayload(String name ) {

		requestSpecification = getRequestWithJSONHeadersToken(SuperAdmintoken);
		
	
		switch (name){
		case "Loan Analytics":
			application_ENDPOINT_PATH="/api/admin/loans/analytics";
		
			break;
		case "Get all loan applications":
			application_ENDPOINT_PATH="/api/admin/loans?page=1&limit=10";
			break;
		case "Get All Students":
			application_ENDPOINT_PATH="/api/admin/students?page=1&limit=10";
			
			break;
		case "Get Students analytics":
			application_ENDPOINT_PATH="/api/admin/students/analytics";
			break;
		case "Get loan officers":
			application_ENDPOINT_PATH="/api/admin/staffs?page=1&limit=10";
			break;
		case "Get institutes":
			application_ENDPOINT_PATH="/api/admin/institute?page=1&limit=10";
			break;
		}
			result=requestSpecification.get(getBaseUrl() + application_ENDPOINT_PATH);
	     	return result;
	
}
	

}