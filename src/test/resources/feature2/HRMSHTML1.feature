Feature: Login to OrangeHRMS application
 
@smoke
Scenario Outline: login with credentials
Given User is on HRMSLogin page
When User enters username as "<username>" and "<password>"
Then user login validation should be "<result>"
 
Examples:
|username|password|result|
|Admin|admin123|pass|
|Wrong|Wrong123|pass|