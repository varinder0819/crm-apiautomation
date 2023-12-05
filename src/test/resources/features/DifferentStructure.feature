@set1
Feature: The objective of this feature to check different structures and how to use them

  Scenario: Verify the browsers
    # No header, simple coloumn with multiple rows and this structre is called list of strings
    Given I have following browsers
      | Browsers |
      | Chrome   |
      | Firefox  |
      | Edge     |
      | IE       |

    Scenario: Verify all the Gadgets
      Given : I have following gadgets
        | Mobile,  Book, Ipad, Watch |

