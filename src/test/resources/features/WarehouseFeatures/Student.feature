@SLASTest

@StudentsTest
Feature: Students Tests
This feature includes Students tests using RESTFul services
@Student
Scenario: TC-01 Jamb Verify
Given I send a POST request for Students with the request body from "Jamb-Verify.json" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"
@Student
Scenario: TC-02 Registration
Given I send a POST request for Students with the request body from "Registration.json" and capture the response body
When The order request response for Students has a '201' response code
Then the response body for Students should contain key "status" with value "true"
@Student
Scenario: TC-03 Reset Password Email
Given I send a POST request for Students with the request body from "Reset-Password-Email.json" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"
@Student
Scenario: TC-04 Reset Password
Given I send a POST request for Students with the request body from "Reset-Password.json" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"
@Student
Scenario: TC-05 Email Verify
Given I send a POST request for Students with the request body from "Email-Verify.json" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"
@Student
Scenario: TC-06 Verify NIN
Given I send a POST request for Students with the request body from "Verify-NIN.json" and capture the response body
When The order request response for Students has a '201' response code
Then the response body for Students should contain key "status" with value "true"

@Student
Scenario: TC-07 Resend Verification Email
Given I send a POST request for Students with the request body from "Resend-Verification-Email.json" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-08 Login
Given I send a POST request for Students with the request body from "Login.json" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"
@Student
Scenario: TC-09 Refresh token
Given I send a POST request for Students with the request body from "Refresh-token.json" and capture the response body
When The order request response for Students has a '201' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-10 get dashboard data
Given I send a GET request for Students from "get dashboard data" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-11 Get profile details
 Given I send a GET request for Students from "Get profile details" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"
@Student
Scenario: TC-12 Update Profile - personal details
Given I send a POST request for Students with the request body from "Update-Profile-personal-details.json" and capture the response body
When The order request response for Students has a '201' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-13 Update Profile - contact details
Given I send a POST request for Students with the request body from "Update-Profile-contact-details.json" and capture the response body
When The order request response for Students has a '201' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-14 Update Profile - Educational details
Given I send a POST request for Students with the request body from "Update-Profile-Educational-details.json" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-15 Update Profile - Account details (BVN)
Given I send a POST request for Students with the request body from "Update-Profile-Account-details-(BVN).json" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"
@Student
Scenario: TC-16 Update Profile - Account details (bank verificaiton)
Given I send a POST request for Students with the request body from "Update-Profile-Account-details(bank-verificaiton).json" and capture the response body
When The order request response for Students has a '201' response code
Then the response body for Students should contain key "status" with value "true"
@Student
Scenario: TC-17 Update Password
Given I send a POST request for Students with the request body from "Update-Password.json" and capture the response body
When The order request response for Students has a '201' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-18 Get media
 Given I send a GET request for Students from "Get media" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"


Scenario: TC-19 Upload documents
Given I send a POST request for Students with the request body from "Upload-documents.json" and capture the response body
When The order request response for Students has a '201' response code
Then the response body for Students should contain key "status" with value "true"
@Student
Scenario: TC-20 Create loan application
Given I send a POST request for Students with the request body from "Create-loan-application.json" and capture the response body
When The order request response for Students has a '201' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-21 Loan analytics
 Given I send a GET request for Students from "Loan analytics" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-22 Get all Loans
 Given I send a GET request for Students from "Get all Loans" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"
@Student
Scenario: TC-23 Get Loan
Given I send a GET request for Students from "Get Loan" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-24 Create ticket
Given I send a POST request for Students with the request body from "Create-ticket.json" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-25 List all tickets
 Given I send a GET request for Students from "List all tickets" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-26 Get ticket
 Given I send a GET request for Students from "Get ticket" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"

Scenario: TC-27 Ticket Analysis
 Given I send a GET request for Students from "Ticket Analysis" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "true"

@Student
Scenario: TC-28 BVN Verification
Given I send a POST request for Students with the request body from "BVN Verification.json" and capture the response body
Given I send a Post request for Students from "BVN Verification.json" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "fail"
@Student
 Scenario: TC-29 NIN Verification
 Given I send a POST request for Students with the request body from "NIN Verification.json" and capture the response body
Given I send a Post request for Students from "NIN Verification.json" and capture the response body
When The order request response for Students has a '200' response code
Then the response body for Students should contain key "status" with value "fail"


