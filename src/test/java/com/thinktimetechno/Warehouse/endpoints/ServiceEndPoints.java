package com.thinktimetechno.Warehouse.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServiceEndPoints extends BaseEndpoints{


	
	RequestSpecification requestSpecification;
	public Response result;
	
	
	private  String application_ENDPOINT_PATH="";
  
	public Response applicationSalesCreatePayload(String jsonFile) throws IOException {


			
		requestSpecification = getRequestWithJSONHeaders();

		switch (jsonFile){
			case "Contact-Us.json":
				application_ENDPOINT_PATH="/api/services/contact";
				
				break;
			
			
		}
		File jsonDataInFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Payloads"+File.separator+"ServicePayloads"+File.separator+jsonFile);
		result=requestSpecification.body(jsonDataInFile).post(getBaseUrl() + application_ENDPOINT_PATH);
		
		return result;
		
	}
	
	public Response applicationSalesfetchPayload(String name ) {

		requestSpecification =getRequestWithJSONHeaders();
		
	
		switch (name){
		case "All Institutions":
			application_ENDPOINT_PATH="/api/services/institutions";
		
			break;
		case "All States":
			application_ENDPOINT_PATH="/api/services/states";
			break;
		case "LGAs by StateID":
			application_ENDPOINT_PATH="/api/services/lgas/2";
			
			break;
		case "All Banks":
			application_ENDPOINT_PATH="/api/services/banks";
			break;
		case "Courses by Institutions":
			application_ENDPOINT_PATH="/api/services/courses/10";
			break;
		case "Course Details":
			application_ENDPOINT_PATH="/api/services/courses/details/45";
			break;
		}
			result=requestSpecification.get(getBaseUrl() + application_ENDPOINT_PATH);
	     	return result;
	
}
	

}