
Feature: verify company module api's

  @GetAllCompany
  Scenario: Verify all company info in get all api #001
    Given I setup the request structure
    When I hit a get all company api
    Then I verify all companies information in response
    And Print company ids whos start values are greater than zero
    * I print the name of company with id
    * I paint the name of company along with id


@companyscenario2
  Scenario: Verify different set of response validation #002
   Given I setup the request structure
   When I hit a get all company api
   Then I verify all companies information in response
    And print company ids whose tag has some value
   # And print all the property value of the company
  #  * print company ids whose lead_scores are greater then zero
    And I print id along with owners id

  @extractdata
  Scenario: verify extracting the data #003
    Given I setup the request structure
    When I hit a get all company api
    * I want to display all the list of objects one by one
    And I want to get the first id
    And I want to print the reposnse
    And Need company id along with owner id
    * I want data of viewed attributes without hitting viewed data
    And I want viewer_id where time has some particular value


    @CreateCompany
    Scenario: verify create company with valid details using string req body
      Given I setup the request structure to create company
        | compName | Google                 |
        | url      | https://www.google.com |
      When I hit an api to create company
      Then I verify company created successfully









