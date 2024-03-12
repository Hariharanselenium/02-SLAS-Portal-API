package com.thinktimetechno.projects.website.Warehouse.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import com.thinktimetechno.Warehouse.endpoints.ServiceEndPoints;




public class ServiceStepDefinitions {

	private ServiceEndPoints Service;

	String responseBody;

	
	public ServiceStepDefinitions(ServiceEndPoints Service) {
		this.Service = Service;
	}


	@Given("I send a POST request for Service with the request body from {string} and capture the response body")
	public void PutRequest(String jsonFile) throws IOException {
		Service.applicationSalesCreatePayload(jsonFile);
	

	}

	

	@Given("I send a GET request for Service from {string} and capture the response body")
	public void GetRequest(String name)
			throws IOException {

		 Service.applicationSalesfetchPayload(name);

	}

	

	@When("The order request response for Service has a {string} response code")
	public void VerifyResponseCode(String value) {
		int intValue = Integer.parseInt(value);
		Service.verifyResponseStatusValue(Service.result, intValue);
	}
	
	@Then("the response body for Service should contain key {string} with value {string}")
	public void verifyResposeResult(String key,String value) {
		Service.verifyResponseKeyValues(key, value, Service.result);
	}
}
