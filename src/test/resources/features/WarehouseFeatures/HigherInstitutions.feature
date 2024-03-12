@HigherInstitutions
@SLASTest
Feature: Higher Institutions

 Scenario: TC-01 Login
Given I send a Post request for Higher Institutions from "Login.json" and capture the response body
When The order request response for Higher Institutions has a '200' response code
Then the response body for Higher Institutions should contain key "status" with value "true"

Scenario: TC-02 Loan Analytics
 Given I send a GET request for Higher Institutions from "Loan Analytics" and capture the response body
When The order request response for Higher Institutions has a '200' response code
Then the response body for Higher Institutions should contain key "status" with value "true"

Scenario: TC-03 Get all loan applications
 Given I send a GET request for Higher Institutions from "Get all loan applications" and capture the response body
When The order request response for Higher Institutions has a '200' response code
Then the response body for Higher Institutions should contain key "status" with value "true"

Scenario: TC-04 Get loan details
 Given I send a GET request for Higher Institutions from "Get loan details" and capture the response body
When The order request response for Higher Institutions has a '200' response code
Then the response body for Higher Institutions should contain key "status" with value "true"

 Scenario: TC-05 Student upload
Given I send a Post request for Higher Institutions from "Student upload.json" and capture the response body
When The order request response for Higher Institutions has a '201' response code
Then the response body for Higher Institutions should contain key "type" with value "success"

 Scenario: TC-06 Courses upload
Given I send a Post request for Higher Institutions from "Courses upload.json" and capture the response body
When The order request response for Higher Institutions has a '201' response code
Then the response body for Higher Institutions should contain key "type" with value "success"