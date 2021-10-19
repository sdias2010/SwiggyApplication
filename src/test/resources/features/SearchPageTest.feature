Feature: Checks Swiggy Application Search page Functionality

  @Regression
  Scenario Outline: User is able to search the food item
    Given user has opened swiggy homepage
    When user enters the location "Mumbai"
    And user selects the first location from dropdown list
    Then user clicks on the search link
    And user enters the search item from the sheet "<SheetName>" and <RowNumber>
    Then user clicks on first restaurant
    And user validates the restaurant name

    Examples:
      | SheetName | RowNumber |
      | FoodItems  | 0         |