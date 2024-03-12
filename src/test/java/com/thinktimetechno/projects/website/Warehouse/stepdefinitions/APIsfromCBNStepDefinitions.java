package com.thinktimetechno.projects.website.Warehouse.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import com.thinktimetechno.Warehouse.endpoints.APIsfromCBNEndPoints;



public class APIsfromCBNStepDefinitions {

	private APIsfromCBNEndPoints apifromcbn;

	String responseBody;
	

	public APIsfromCBNStepDefinitions(APIsfromCBNEndPoints apifromcbn) {
		this.apifromcbn = apifromcbn;
	}
	@Given("I send a GET request for APIs from CBN from {string} and capture the response body")
	public void i_send_a_get_request_for_ap_is_from_cbn_from_and_capture_the_response_body(String name) {
		apifromcbn.get(name);
	}
	
	@Given("I send a Post request for APIs from CBN from {string} and capture the response body")
	public void i_send_a_post_request_for_ap_is_from_cbn_from_and_capture_the_response_body(String jsonFile) throws IOException {
		apifromcbn.post(jsonFile);
}
	@When("The order request response for APIs from CBN has a {string} response code")
	public void the_order_request_response_for_ap_is_from_cbn_has_a_response_code(String value) {
		int intValue = Integer.parseInt(value);
		apifromcbn.verifyResponseStatusValue(apifromcbn.result, intValue);
	}
	

	@Then("the response body for APIs from CBN should contain key {string} with value {string}")
	public void the_response_body_for_ap_is_from_cbn_should_contain_key_with_value(String key, String value) {
		apifromcbn.verifyResponseKeyValues(key, value, apifromcbn.result);
	}
	}
	
	