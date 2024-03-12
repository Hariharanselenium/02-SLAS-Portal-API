package com.thinktimetechno.projects.website.Warehouse.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import com.thinktimetechno.Warehouse.endpoints.LoanOfficerEndPoints;






public class LoanOfficerStepDefinitions {

	private LoanOfficerEndPoints LoanOfficer;

	String responseBody;

	
	public LoanOfficerStepDefinitions(LoanOfficerEndPoints LoanOfficer) {
		this.LoanOfficer = LoanOfficer;
	}


	@Given("I send a POST request for LoanOfficer with the request body from {string} and capture the response body")
	public void PutRequest(String jsonFile) throws IOException {
		LoanOfficer.applicationSalesCreatePayload(jsonFile);
	

	}

	

	@Given("I send a GET request for LoanOfficer from {string} and capture the response body")
	public void GetRequest(String name)
			throws IOException {

		 LoanOfficer.applicationSalesfetchPayload(name);

	}

	

	@When("The order request response for LoanOfficer has a {string} response code")
	public void VerifyResponseCode(String value) {
		int intValue = Integer.parseInt(value);
		LoanOfficer.verifyResponseStatusValue(LoanOfficer.result, intValue);
	}
	
	@Then("the response body for LoanOfficer should contain key {string} with value {string}")
	public void verifyResposeResult(String key,String value) {
		LoanOfficer.verifyResponseKeyValues(key, value, LoanOfficer.result);
	}
}
