package com.thinktimetechno.Warehouse.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class APIsfromCBNEndPoints extends BaseEndpoints{


	
	RequestSpecification requestSpecification;
	public Response result;
	
	private  String application_ENDPOINT_PATH="";

   boolean istoken=false;
   public static String highertoken ;
	public Response post(String jsonFile) throws IOException {

		
		requestSpecification =getRequestWithJSONHeaders();
		
		switch (jsonFile){
			case "NIN APIs Authentication.json":
				requestSpecification.header("user_id", "studentloansys");
				requestSpecification.header("password", "QWNjZXNzUEBzc3dvcmQxMjM$=");
				application_ENDPOINT_PATH="https://camltest.azurewebsites.net/camluam/api/v1/auth/login";
				 istoken=true;
				break;
			case "Validate with NIN.json":
				requestSpecification.header("userId", "studentloansys");
				requestSpecification.header("Authorization", highertoken);
				application_ENDPOINT_PATH="https://camltest.azurewebsites.net/camlsystem/api/v1/getNINDetailsByNIN";
				 
				break;
			case "Validate with Phone.json":
				requestSpecification.header("userId", "studentloansys");
				requestSpecification.header("Authorization", highertoken);
				application_ENDPOINT_PATH="https://camltest.azurewebsites.net/camlsystem/api/v1/getNINDetailsByPhone";
				
				break;
			case "Validate with Phone Copy.json":
				requestSpecification.header("userId", "studentloansys");
				requestSpecification.header("Authorization", highertoken);
				application_ENDPOINT_PATH="https://camltest.azurewebsites.net/camlsystem/api/v1/getNINDetailsByPhone";
				 
				break;
			case "eNaira NIP Authentication.json":
				requestSpecification.header("user_id", "studentloansys");
				requestSpecification.header("password", "QWNjZXNzUEBzc3dvcmQxMjM$=");
				application_ENDPOINT_PATH="https://camltest.azurewebsites.net/camluam/api/v1/auth/login";
				istoken=true;
				break;
			case "Name Enquiry.json":
				application_ENDPOINT_PATH="https://camltest.azurewebsites.net/nipservice/api/v1/util/get-nip-fi-list";
				 
				break;
			case "Disbursement API Authentication.json":
				application_ENDPOINT_PATH="https://camltest.azurewebsites.net/nipservice/api/v1/app/name-enquiry";
				 
				break;
			case "Disbursement Post.json":
				application_ENDPOINT_PATH="http://20.160.120.249/api/v1/student_loan/";
			
				break;
			case "Disbursement Status.json":
				application_ENDPOINT_PATH="http://20.160.120.249/api/v1/student_loan/status";
				 
				break;
			case "BVN APIs Authentication.json":
				requestSpecification.header("user_id", "studentloansys");
				requestSpecification.header("password", "QWNjZXNzUEBzc3dvcmQxMjM$=");
				application_ENDPOINT_PATH="https://camltest.azurewebsites.net/camluam/api/v1/auth/login";
				 
				break;
			case "BVN with Account Number Validation.json":
				application_ENDPOINT_PATH="https://camltest.azurewebsites.net/camlsystem/api/v1/bvntoaccountnumbervalidation";
				 
				break;
			case "Validate BVN with BVN.json":
				application_ENDPOINT_PATH="https://camltest.azurewebsites.net/camlsystem/api/v1/getBvnDetailsWithImage";
				 
				break;
			case "studentsloanapi GetAdmittedCandidateDetails.json":
				application_ENDPOINT_PATH="https://studentsloanapi.jamb.gov.ng/api/LoanAPP/GetAdmittedCandidateDetails";
				 
				break;
			case "studentsloantestapi GetAdmittedCandidateDetails.json":
				application_ENDPOINT_PATH="https://studentsloanapi.jamb.gov.ng/api/LoanAPP/GetAdmittedCandidateDetails";
				
				break;
				
			
		}
		File jsonDataInFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Payloads"+File.separator+"APIsfromCBNPayloads"+File.separator+jsonFile);
		
		result=requestSpecification.body(jsonDataInFile).post(application_ENDPOINT_PATH);
		if(istoken) {
		String responseBody = result.getBody().asString();
	    JSONObject postResponseJson = new JSONObject(responseBody);
	    highertoken= postResponseJson.getString("token");
		}
	    return result;
	
	}

	public Response get(String name ) {
		
	requestSpecification = getRequestWithJSONHeaders();
		switch (name){
		case "Get Bank list":
			requestSpecification.header("userId", "studentloansys");
			requestSpecification.header("Authorization", highertoken);
			application_ENDPOINT_PATH="https://camltest.azurewebsites.net/nipservice/api/v1/util/get-nip-fi-list";
			break;
		
		
		}
		
			result=requestSpecification.get(application_ENDPOINT_PATH);
	     	return result;
	
}
	

}