Feature: Login to OrangeHRMS application
 
Scenario Outline: login with credentials

Given User is on HRMSLogin page

When User enters username as "<username>" and "<password>"

Then user should be able to login if valid credentials are passed
 
Examples:

|username|password|

|Admin|admin123|

|admin|test123|
