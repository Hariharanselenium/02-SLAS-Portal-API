package com.thinktimetechno.projects.website.Warehouse.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;

import com.thinktimetechno.Warehouse.endpoints.HigherInstitutionsEndPoints;



public class HigherInstitutionsStepDefinitions {

	private HigherInstitutionsEndPoints higherinstitutions;

	String responseBody;
	io.restassured.response.Response response;

	public HigherInstitutionsStepDefinitions(HigherInstitutionsEndPoints higherinstitutions) {
		this.higherinstitutions = higherinstitutions;
	}


	@Given("I send a Post request for Higher Institutions from {string} and capture the response body")
	public void i_send_a_post_request_for_higher_institutions_from_and_capture_the_response_body(String jsonFile) throws IOException {
		higherinstitutions.post(jsonFile);
		
	}

	@Given("I send a GET request for Higher Institutions from {string} and capture the response body")
	public void i_send_a_get_request_for_higher_institutions_from_and_capture_the_response_body(String name) {

		Response r=higherinstitutions.get(name);
		System.out.println( r );
	}


	@When("The order request response for Higher Institutions has a {string} response code")
	public void the_order_request_response_for_higher_institutions_has_a_response_code(String value) {
		int intValue = Integer.parseInt(value);
		higherinstitutions.verifyResponseStatusValue(higherinstitutions.result, intValue);
	}
	
	@Then("the response body for Higher Institutions should contain key {string} with value {string}")
	public void the_response_body_for_higher_institutions_should_contain_key_with_value(String key,String value) {
		higherinstitutions.verifyResponseKeyValues(key, value, higherinstitutions.result);
	}
}
