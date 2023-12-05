@set2
Feature: Login to the CRM Application
  # Keywords in Cucumber:
  # 1.Scenario: This should indicate what scenario need to be executed followed by steps
  Scenario: Verify valid test case for login feature
    Given I launch the browser and navigate to the website
    When I entered username and pasword
    And I clicked on login button
    Then I logged into the application
    * I clicked on Logo

  Scenario: Verify invalid test case for login feature
    Given I launch the browser and navigate to the website
    When I entered incorret username and pasword
    And I clicked on login button
    Then I got error message

    Scenario: Verify employee data creation
      Given All employee information is added
        | EmployeeID | Name  | Department | Age |
        | 1009       | Rahul | HR         | 20  |
        | 2110       | Sunil | QA         | 30  |

      Scenario Outline: : Verify multiple set of data
        Given I enter unames as <unames>
        And I enter pwds as <Pwd>
        Examples:
          | unames | Pwd |
          | var    | 123 |
          | TEST   | 345 |

        Scenario Outline: Verify create employee
          Given I create employee using following information
            | name | <name> |
            | age  | <age>  |
            | dept | <dept> |


          Examples:
            | name | age | dept |
            | var  | 39  | QA   |
            | sanju | 42 | sw   |


















