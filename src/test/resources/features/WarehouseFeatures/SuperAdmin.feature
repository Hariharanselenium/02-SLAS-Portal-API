@SLASTest
@SuperAdminTest
Feature: SuperAdmin Tests
This feature includes SuperAdmin tests using RESTFul services



Scenario: TC-01 Login
Given I send a POST request for SuperAdmin with the request body from "Login.json" and capture the response body
When The order request response for SuperAdmin has a '200' response code
Then the response body for SuperAdmin should contain key "status" with value "true"

Scenario: TC-02 Loan Analytics
 Given I send a GET request for SuperAdmin from "Loan Analytics" and capture the response body
When The order request response for SuperAdmin has a '200' response code
Then the response body for SuperAdmin should contain key "status" with value "true"

Scenario: TC-03 Get all loan applications
 Given I send a GET request for SuperAdmin from "Get all loan applications" and capture the response body
When The order request response for SuperAdmin has a '200' response code
Then the response body for SuperAdmin should contain key "status" with value "true"

Scenario: TC-04 Get All Students
 Given I send a GET request for SuperAdmin from "Get All Students" and capture the response body
When The order request response for SuperAdmin has a '200' response code
Then the response body for SuperAdmin should contain key "status" with value "true"

Scenario: TC-05 Get Students analytics
 Given I send a GET request for SuperAdmin from "Get Students analytics" and capture the response body
When The order request response for SuperAdmin has a '200' response code
Then the response body for SuperAdmin should contain key "status" with value "true"

Scenario: TC-06 Get loan officers
 Given I send a GET request for SuperAdmin from "Get loan officers" and capture the response body
When The order request response for SuperAdmin has a '200' response code
Then the response body for SuperAdmin should contain key "status" with value "true"

Scenario: TC-07 Get institutes
 Given I send a GET request for SuperAdmin from "Get institutes" and capture the response body
When The order request response for SuperAdmin has a '200' response code
Then the response body for SuperAdmin should contain key "status" with value "true"



