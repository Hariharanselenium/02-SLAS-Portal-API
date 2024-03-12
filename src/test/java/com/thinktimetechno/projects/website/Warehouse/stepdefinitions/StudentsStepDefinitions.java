package com.thinktimetechno.projects.website.Warehouse.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import com.thinktimetechno.Warehouse.endpoints.StudentsEndPoints;

public class StudentsStepDefinitions {

	private StudentsEndPoints student;

	String responseBody;
	io.restassured.response.Response response;

	public StudentsStepDefinitions(StudentsEndPoints student) {
		this.student = student;
	}

//	AuthExample auth =new AuthExample();
	@Given("I send a POST request for Students with the request body from {string} and capture the response body")
	public void PostRequest(String jsonFile) throws IOException {
		student.applicationSalesCreatePayload(jsonFile);
		System.out.println(student.result.getBody().asString());
	}

	

	@Given("I send a GET request for Students from {string} and capture the response body")
	public void GetRequest(String name)
			throws IOException {

		 student.applicationSalesfetchPayload(name);
		 System.out.println(student.result.getBody().asString());
	}

	

	@When("The order request response for Students has a {string} response code")
	public void VerifyResponseCode(String value) {
		int intValue = Integer.parseInt(value);
		student.verifyResponseStatusValue(student.result, intValue);
	}
	
	@Then("the response body for Students should contain key {string} with value {string}")
	public void verifyResposeResult(String key,String value) {
		student.verifyResponseKeyValues(key, value, student.result);
	}
}
