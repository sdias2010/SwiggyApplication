Feature: Test Apis for Swiggy Search Restaurant

  @Regression
  Scenario Outline: search api returns correct restaurant
    Given user opens the swiggy home page
    When user hits search restaurant api by using data from "<SheetName>" and <RowNumber>
    Then user validates the response code from "<SheetName>" and <RowNumber>
    And user validates the response message from "<SheetName>" and <RowNumber>

    Examples:
      | SheetName | RowNumber |
      | RestAPI   | 0         |