Feature: Check Swiggy Application Offers Page Functionality

  @Regression
  Scenario Outline: User is able to check the offers page
    Given user has opened swiggy homepage
    When user enters the location from the sheet "<SheetName>" and <RowNumber>
    And user selects the first location from dropdown list
    Then user clicks on the offers link
    And user validates the offers page by checking "Offers for you"

    Examples:
      | SheetName | RowNumber |
      | Location  | 0         |
