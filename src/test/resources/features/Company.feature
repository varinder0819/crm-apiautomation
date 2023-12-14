
Feature: verify company module api's

  @GetAllCompany
  Scenario: Verify all company info in get all api #001
    Given I setup the request structure
    When I hit a get all company api
    Then I verify all companies information in response
    And Print company ids whos start values are greater than zero
    * I print the name of company with id



  Scenario: Verify different set of response validation #002
    Given I setup the request structure
    When I hit a get all company api
    Then I verify all companies information in response
    And print company ids whose tag has some value
   # And print all the property value of the company
    * print company ids whose lead_scores are greater then zero




