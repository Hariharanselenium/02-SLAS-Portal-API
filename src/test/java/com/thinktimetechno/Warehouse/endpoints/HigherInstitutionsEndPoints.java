package com.thinktimetechno.Warehouse.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HigherInstitutionsEndPoints extends BaseEndpoints{


	
	RequestSpecification requestSpecification;
	public Response result;
	
	private  String application_ENDPOINT_PATH="";

   boolean istoken=false;
   public static String highertoken ;
	public Response post(String jsonFile) throws IOException {

		
		requestSpecification =getRequestWithJSONHeaders();
		
		switch (jsonFile){
			case "Login.json":
				application_ENDPOINT_PATH="/api/institute/auth/login";
				istoken=true;
				break;
				
			case "Student upload.json":
				File testUploadFile = new File(System.getProperty("user.dir")+"/src/test/resources/TestDoc.csv");
//				requestSpecification.header("Authorization", "Bearer "+ highertoken)
//				 .multiPart("level", "100", "text/plain")
//				.multiPart("institution_programme_id", "3", "text/plain")
//		        .multiPart("file",testUploadFile,"text/csv");
				application_ENDPOINT_PATH="/api/institute/upload/students";
				result= RestAssured.given()
			   .contentType("multipart/form-data")
                 .header("Authorization", "Bearer "+ highertoken)
                .multiPart("level", "100","text/plain")
                .multiPart("institution_programme_id","3","text/plain")
                .multiPart("file", testUploadFile,"application/csv").post(getBaseUrl() + application_ENDPOINT_PATH);

				
				break;
				
			case "Courses upload.json":
				application_ENDPOINT_PATH="/api/institute/upload/courses";
				File testUploadFile1 = new File(System.getProperty("user.dir")+"/src/test/resources/TestDoc.csv");
//				requestSpecification.header("Authorization", "Bearer "+ highertoken)
//				 .contentType("multipart/form-data")
				result= RestAssured.given()
						
		                 .header("Authorization", "Bearer "+ highertoken)
		             
			 .multiPart("level", "100")
			 .multiPart("file", testUploadFile1).post(getBaseUrl() + application_ENDPOINT_PATH);
				
				break;
				
		}
		
		if(istoken) {
			File jsonDataInFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Payloads"+File.separator+"HigherInstitutionsPayloads"+File.separator+jsonFile);
			
			result=requestSpecification.body(jsonDataInFile).post(getBaseUrl() + application_ENDPOINT_PATH);
		String responseBody = result.getBody().asString();
	    JSONObject postResponseJson = new JSONObject(responseBody);
	    highertoken= postResponseJson.getJSONObject("data").getString("token");
		}
	    return result;
	
	
	}

	public Response get(String name ) {
		
	requestSpecification = getRequestWithJSONHeadersToken(highertoken);
		switch (name){
		case "Loan Analytics":
			application_ENDPOINT_PATH="/api/institute/loans/analytics";
			break;
		case "Get all loan applications":
			application_ENDPOINT_PATH="/api/institute/loans/?page=1&status=pending&limit=10&to=2023-10-31&from=2023-01-01";
			break;
		case "Get loan details":
			application_ENDPOINT_PATH="/api/institute/loans/15/details";
			break;
		
		}
			result=requestSpecification.get(getBaseUrl() + application_ENDPOINT_PATH);
	     	return result;
	
}
	

}