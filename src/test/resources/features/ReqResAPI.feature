Feature: verify reqres api response

  @ReqRes
  Scenario: jsonpath expression examples
    Given I setup the request structure to fetch all user information
    When I hit a get all user api
    Then I verify response