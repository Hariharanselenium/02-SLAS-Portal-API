@SLASTest
@LoanOfficerTest
Feature: LoanOfficer Tests
This feature includes LoanOfficer tests using RESTFul LoanOfficers



Scenario: TC-01 Login
Given I send a POST request for LoanOfficer with the request body from "Login.json" and capture the response body
When The order request response for LoanOfficer has a '200' response code
Then the response body for LoanOfficer should contain key "status" with value "true"

Scenario: TC-02 Loan Analytics
 Given I send a GET request for LoanOfficer from "Loan Analytics" and capture the response body
When The order request response for LoanOfficer has a '200' response code
Then the response body for LoanOfficer should contain key "status" with value "true"

Scenario: TC-03 Get all loan applications
 Given I send a GET request for LoanOfficer from "Get all loan applications" and capture the response body
When The order request response for LoanOfficer has a '200' response code
Then the response body for LoanOfficer should contain key "status" with value "true"

Scenario: TC-04 Get loan details
 Given I send a GET request for LoanOfficer from "Get loan details" and capture the response body
When The order request response for LoanOfficer has a '200' response code
Then the response body for LoanOfficer should contain key "status" with value "true"





