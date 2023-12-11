@tag4
Feature: Test all login flows with negative and positive case

  Background: launch browser {pre-condition}
    Given I launch the browser
    Then I navigate to website

  Scenario Outline: 3. Verify Invalid credentials
    Given I have valid username as <username> and empty password as <password>
    Examples:
      | username | password |
      | rahul    |          |
      |          |          |

#  Scenario Outline: 4. Verify Invalid credentials
#    Given I have added username as blank <username> and password also blank as <password>
#    Examples:
#      | username | password |
#      |          |          |

  Scenario: 4. Verify valid credentials without header
    Given I have following valid credentials
      | Sanay  |
      | Rahul  |
      | Gautam |

  Scenario: 5. Verify valid credentials without header
    Given I have following valid credentials structure
      | username | password |
      | Rahul    | Gandhi   |
      | Gautam   | Gambheer |

  Scenario: 6. Verify strings
    Given I have following login usernames
      | Rahul , Sanjay ,Rohit, Sharma |




