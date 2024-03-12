package com.thinktimetechno.projects.website.Warehouse.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import com.thinktimetechno.Warehouse.endpoints.SuperAdminEndPoints;




public class SuperAdminStepDefinitions {

	private SuperAdminEndPoints superadmin;

	String responseBody;

	
	public SuperAdminStepDefinitions(SuperAdminEndPoints superadmin) {
		this.superadmin = superadmin;
	}


	@Given("I send a POST request for SuperAdmin with the request body from {string} and capture the response body")
	public void PutRequest(String jsonFile) throws IOException {
		superadmin.applicationSalesCreatePayload(jsonFile);
	

	}

	

	@Given("I send a GET request for SuperAdmin from {string} and capture the response body")
	public void GetRequest(String name)
			throws IOException {

		 superadmin.applicationSalesfetchPayload(name);

	}

	

	@When("The order request response for SuperAdmin has a {string} response code")
	public void VerifyResponseCode(String value) {
		int intValue = Integer.parseInt(value);
		superadmin.verifyResponseStatusValue(superadmin.result, intValue);
	}
	
	@Then("the response body for SuperAdmin should contain key {string} with value {string}")
	public void verifyResposeResult(String key,String value) {
		superadmin.verifyResponseKeyValues(key, value, superadmin.result);
	}
}
