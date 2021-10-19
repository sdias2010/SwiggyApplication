Feature: Test Swiggy application Delivery Location functionality

  @Regression
  Scenario Outline: User is able to successfully enter the location
    Given user has opened swiggy homepage
    When user enters the location from the sheet "<SheetName>" and <RowNumber>
    Then user selects the first location from dropdown list
    And user lands on the restaurants page "<SheetName>" and <RowNumber>

    Examples:
      | SheetName | RowNumber |
      | Location  | 0         |