@APIsfromCBN
@SLASTest
Feature: APIs from CBN

 Scenario: TC-01 NIN APIs Authentication
Given I send a Post request for APIs from CBN from "NIN APIs Authentication.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "status" with value "200"

 Scenario: TC-02 Validate with NIN
Given I send a Post request for APIs from CBN from "Validate with NIN.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "result.lastName" with value "IFEORA"

 Scenario: TC-03 Validate with Phone
Given I send a Post request for APIs from CBN from "Validate with Phone.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "responseMessage" with value "norecord"

 Scenario: TC-04 Validate with Phone Copy
Given I send a Post request for APIs from CBN from "Validate with Phone Copy.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "responseMessage" with value "norecord"

 Scenario: TC-05 eNaira NIP Authentication
Given I send a Post request for APIs from CBN from "eNaira NIP Authentication.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "status" with value "200"

Scenario: TC-06 Get Bank list
 Given I send a GET request for APIs from CBN from "Get Bank list" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "status" with value "200"

 Scenario: TC-07 Name Enquiry
Given I send a Post request for APIs from CBN from "Name Enquiry.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "status" with value "true"

 Scenario: TC-08 Disbursement API Authentication
Given I send a Post request for APIs from CBN from "Disbursement API Authentication.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "status" with value "true"

 Scenario: TC-09 Disbursement Post
Given I send a Post request for APIs from CBN from "Disbursement Post.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "status" with value "true"

 Scenario: TC-10 Disbursement Status
Given I send a Post request for APIs from CBN from "Disbursement Status.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "status" with value "true"

 Scenario: TC-11 BVN APIs Authentication
Given I send a Post request for APIs from CBN from "BVN APIs Authentication.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "status" with value "200"

 Scenario: TC-12 BVN with Account Number Validation
Given I send a Post request for APIs from CBN from "BVN with Account Number Validation.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "status" with value "true"

 Scenario: TC-13 Validate BVN with BVN
Given I send a Post request for APIs from CBN from "Validate BVN with BVN.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "status" with value "true"

 Scenario: TC-14 studentsloanapi GetAdmittedCandidateDetails
Given I send a Post request for APIs from CBN from "studentsloanapi GetAdmittedCandidateDetails.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "status" with value "true"

 Scenario: TC-15 studentsloantestapi GetAdmittedCandidateDetails
Given I send a Post request for APIs from CBN from "studentsloantestapi GetAdmittedCandidateDetails.json" and capture the response body
When The order request response for APIs from CBN has a '200' response code
Then the response body for APIs from CBN should contain key "status" with value "true"
