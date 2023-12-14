@background
Feature: Test all cases related with background keywords
  Scenario: verify launch the browser
    Given I want to launch the browser
    When I enter uname and pwd
    And i click on continue button
      | uname | pwd    |
      | Rahul | Sharma |


