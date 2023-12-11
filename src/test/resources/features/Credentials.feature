@tag3
Feature: Test all login related testcases

  Scenario Outline: Test with valid login credentials
    Given I entered valid uname as <Username>
    And I entered valid pwd as <Password>
    Examples:
      | Username | Password |
      | Sanju    | sharma   |
      | Sunil    | Shetty   |
      | Sharma   | Sharma   |

  @sanity
  Scenario: Test credentials in tabular format
    Given I have added following uname and pwd
      | varinder | Bedi  |
      | Rohit    | Janky |

  Scenario: Test Browsers
      # This below structucter is without header and it is consider as list of strings
    Given I have below browsers
      | Browsers |
      | IE       |
      | Edge     |
      | Chrome   |

  Scenario: test assets
    Given I have following assets
      | Mobile ,Android,ipad,watch |

  @sanity @regression
  Scenario Outline: Test following format
    Given I have horizontal data to display for the employee
      | Name        | <NAME>        |
      | City        | <City>        |
      | Job PROFILE | <Job PROFILE> |
      | Salary      | <Salary>      |


    Examples:
      | NAME  | City | Job PROFILE | Salary |
      | vARI  | BANE | qa          | 110000 |
      | rahul | pune | qa          | 10000  |




