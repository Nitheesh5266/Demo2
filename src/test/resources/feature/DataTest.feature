Feature: About Testers
 
In order to get a high paid job in IT,
As a Tester I want to learn Automation concepts
 
Scenario Outline: Tester job outcome
Given I am a "<testerType>" tester
When I apply for a job
Then I got "<salary>" paid job
And I am "<satisfaction>" satisfied with my salary
But my parents are "<parentSatisfaction>" satisfied
 
Examples:
| testerType | salary  | satisfaction  | parentSatisfaction |
| manual     | less    | not           | still              |
| Automation | high    | highly        | also more          |
| API        | decent  | very much     | also more          |