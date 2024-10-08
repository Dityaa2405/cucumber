@tag
Feature: 
Employee Registration as admin user create multiple employees
@employee
Scenario Outline:
As Admin user add employees
Given Launch url "http://orangehrm.qedgetech.com"
When user Enter username as "Admin"
And user Enter password as "Qedge123!@#"
And user Click login button
Then user verify test in url
When  user navigate to  Add employee page
When  user Enter fname as "<FirstName>"
And user Enter Mname as "<MiddleName>"
And user enter Lname as "<LastName>"
And user capture Employee id
And user click save button
Then Validate Employee id
When user close browser
Examples:
|FirstName|MiddleName|LastName|
|Apparao|btech|Developer|
|Aruna|btech|Manual|
|Dityaa|class|Manual1|
|raji|degree|Manual2|
|Charan|inter|Manual3|
|Lasya|tenth|Manual4|
|deechu|seventh|Manual5|
|sami|third|Manual6|

