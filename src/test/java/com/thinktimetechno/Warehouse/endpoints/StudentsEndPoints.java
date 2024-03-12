package com.thinktimetechno.Warehouse.endpoints;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StudentsEndPoints extends BaseEndpoints{


	
	RequestSpecification requestSpecification;
	public Response result;

	public static boolean isjambtoken=false;
	public static boolean isemailverify=false;
	public static boolean isStudentlogintoken=false;
	public static boolean isdocuments=false;
	
	public static boolean isurl=false;
	public static String emailverifytoken;
    public static String jambtoken;
	
	private  String application_ENDPOINT_PATH="";
  
	public Response applicationSalesCreatePayload(String jsonFile) throws IOException {

		requestSpecification =getRequestWithJSONHeadersToken(Studentlogintoken);
		String bvntoken = "RVSEC-7466350c5989bd5064fed2196e766721ded9ba39bf6b62664aeed9e3aab8d92ee0dd6e13b4c4d74fb04765351a97cb81-1694187039251";

		switch (jsonFile){
		case "Reset-Password-Email.json":
			requestSpecification =getRequestWithJSONHeaders();
			application_ENDPOINT_PATH="/api/student/password/reset/email";
			isjambtoken=false;
			break;
		case "Reset-Password.json":
			requestSpecification =getRequestWithJSONHeadersToken(jambtoken);
			application_ENDPOINT_PATH="/api/student/password/reset";
			isjambtoken=false;
			break;
			
			case "Jamb-Verify.json":
				requestSpecification =getRequestWithJSONHeaders();
				application_ENDPOINT_PATH="/api/student/register/jamb/verify";
				isjambtoken=true;
				break;
			case "Registration.json":
				application_ENDPOINT_PATH="/api/student/register";
				requestSpecification =getRequestWithJSONHeadersToken(jambtoken);
				isjambtoken=false;
				break;
			case "Login.json":
				requestSpecification =getRequestWithJSONHeaders();
				application_ENDPOINT_PATH="/api/student/login";
				isStudentlogintoken=true;
				
				break;
			case "Refresh-token.json":
				requestSpecification =getRequestWithJSONHeaders();
				application_ENDPOINT_PATH="/api/student/refresh-token";
				break;
			case "Email-Verify.json":
				requestSpecification =getRequestWithJSONHeaders();
				application_ENDPOINT_PATH="/api/student/verify";
				String requestBody1 = "{ \"token\": [ \"" + jambtoken + "\" ] }";
				requestSpecification.body(requestBody1);
				isemailverify=true;
				isjambtoken=false;
				
				break;
			case "Verify-NIN.json":
				requestSpecification =getRequestWithJSONHeadersToken(emailverifytoken);
				application_ENDPOINT_PATH="/api/student/verify/nin-details";
				break;
			case "Resend-Verification-Email.json":
				requestSpecification =getRequestWithJSONHeadersToken(emailverifytoken);
				application_ENDPOINT_PATH="/api/student/resend/email";
				isemailverify=false;
				break;
			
			case "Update-Profile-personal-details.json":
				
				application_ENDPOINT_PATH="/api/profile/update";
				isStudentlogintoken=false;
				break;
			case "Update-Profile-contact-details.json":
				application_ENDPOINT_PATH="/api/profile/update";
				isStudentlogintoken=false;
				break;
			case "Update-Profile-Educational-details.json":
				application_ENDPOINT_PATH="/api/profile/update/institute-details";
				isStudentlogintoken=false;
				break;
			case "Update-Profile-Account-details-(BVN).json":
				application_ENDPOINT_PATH="/api/profile/update/bvn-details";
				break;
			case "Update-Profile-Account-details(bank-verificaiton).json":
				application_ENDPOINT_PATH="/api/profile/update/bank-details";
				break;
			case "Update-Password.json":
				application_ENDPOINT_PATH="/api/student/password/update";
				break;
			case "Upload-documents.json":
				application_ENDPOINT_PATH="/api/media";
				isdocuments=true;
				break;
			case "Create-loan-application.json":
				application_ENDPOINT_PATH="/api/loans/apply";
				break;
			case "Create-ticket.json":
				application_ENDPOINT_PATH="/api/tickets";
				break;
			case "BVN Verification.json":
				application_ENDPOINT_PATH = "https://integrations.getravenbank.com/v1/bvn/verify";
				requestSpecification = getRequestWithJSONHeadersToken(bvntoken);
				isurl = true;
				break;

			case "NIN Verification.json":
				application_ENDPOINT_PATH = "https://integrations.getravenbank.com/v1/nin/verify";
				requestSpecification = getRequestWithJSONHeadersToken(bvntoken);
				isurl = true;
				break;
			
			
		}
		if(isemailverify) {
			 JSONObject postRequestBody = new JSONObject();
		        postRequestBody.put("token",jambtoken);
		result=requestSpecification.body(postRequestBody.toString()).post(getBaseUrl() + application_ENDPOINT_PATH);
		String responseBody = result.getBody().asString();
	    JSONObject postResponseJson = new JSONObject(responseBody);
	   emailverifytoken= postResponseJson.getJSONObject("data").getString("token");
	
	
		}else if(isdocuments) {
			File testUploadFile = new File(System.getProperty("user.dir")+"/src/test/resources/TestDoc.csv");
			requestSpecification.multiPart("name", "Admissionl letter","text/plain")
            .multiPart("file", testUploadFile,"application/csv");
			result=requestSpecification.post(getBaseUrl() + application_ENDPOINT_PATH);
		}
		
		
		else {
			if (isurl) {
				File jsonDataInFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator
						+ "test" + File.separator + "resources" + File.separator + "Payloads" + File.separator
						+ "StudentsPayloads" + File.separator + jsonFile);
				result = requestSpecification.body(jsonDataInFile).post(application_ENDPOINT_PATH);
			} else {
				File jsonDataInFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator
						+ "test" + File.separator + "resources" + File.separator + "Payloads" + File.separator
						+ "StudentsPayloads" + File.separator + jsonFile);
				result = requestSpecification.body(jsonDataInFile).post(getBaseUrl() + application_ENDPOINT_PATH);
			}
//		File jsonDataInFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Payloads"+File.separator+"StudentsPayloads"+File.separator+jsonFile);
//		result=requestSpecification.body(jsonDataInFile).post(getBaseUrl() + application_ENDPOINT_PATH);
		}if(isjambtoken) {
//			 JsonPath js=result.jsonPath();
//			 jambtoken =js.getString("data.token");
			 String responseBody = result.getBody().asString();
			    JSONObject postResponseJson = new JSONObject(responseBody);
//			    jsonObject.getJSONObject("data").getJSONObject("designation").getString("name");
			    jambtoken= postResponseJson.getJSONObject("data").getString("token");
		}
		if(isStudentlogintoken) {
			String responseBody = result.getBody().asString();
		    JSONObject postResponseJson = new JSONObject(responseBody);
			 Studentlogintoken =postResponseJson.getJSONObject("data").getString("token");;
			 
		}
		return result;
		
	}
	
	public Response applicationSalesfetchPayload(String name ) {

		requestSpecification =getRequestWithJSONHeadersToken(Studentlogintoken);
		
	
		switch (name){
		case "Get media":
			application_ENDPOINT_PATH="/api/media";
		
			break;
		case "get dashboard data":
			application_ENDPOINT_PATH="/api/dashboard/";
		
			break;
		case "Get profile details":
			application_ENDPOINT_PATH="/api/profile/";
			break;
		case "Loan analytics":
			application_ENDPOINT_PATH="/api/loans/analytics";
			
			break;
		case "Get all Loans":
			application_ENDPOINT_PATH="/api/loans?page=1&limit=2";
			break;
		case "Get Loan":
			application_ENDPOINT_PATH="/api/loans/16";
			break;
		case "List all tickets":
			application_ENDPOINT_PATH="/api/tickets";
			break;
		case "Get ticket":
			application_ENDPOINT_PATH="/api/tickets/7052";
			break;
		case "Ticket Analysis":
			application_ENDPOINT_PATH="/api/tickets/analysis";
			break;
		}
			result=requestSpecification.get(getBaseUrl() + application_ENDPOINT_PATH);
	     	return result;
	
}
	

}