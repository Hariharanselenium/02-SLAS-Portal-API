@SLASTest
@ServiceTest
Feature: Service Tests
This feature includes Service tests using RESTFul services



Scenario: TC-01 Contact Us
Given I send a POST request for Service with the request body from "Contact-Us.json" and capture the response body
When The order request response for Service has a '200' response code
Then the response body for Service should contain key "status" with value "true"

Scenario: TC-02 All Institutions
 Given I send a GET request for Service from "All Institutions" and capture the response body
When The order request response for Service has a '200' response code
Then the response body for Service should contain key "status" with value "true"

Scenario: TC-03 All States
 Given I send a GET request for Service from "All States" and capture the response body
When The order request response for Service has a '200' response code
Then the response body for Service should contain key "status" with value "true"

Scenario: TC-04 LGAs by StateID
 Given I send a GET request for Service from "LGAs by StateID" and capture the response body
When The order request response for Service has a '200' response code
Then the response body for Service should contain key "status" with value "true"

Scenario: TC-05 All Banks
 Given I send a GET request for Service from "All Banks" and capture the response body
When The order request response for Service has a '200' response code
Then the response body for Service should contain key "status" with value "true"

Scenario: TC-06 Courses by Institutions
 Given I send a GET request for Service from "Courses by Institutions" and capture the response body
When The order request response for Service has a '200' response code
Then the response body for Service should contain key "status" with value "true"

Scenario: TC-07 Course Details
 Given I send a GET request for Service from "Course Details" and capture the response body
When The order request response for Service has a '200' response code
Then the response body for Service should contain key "status" with value "true"



