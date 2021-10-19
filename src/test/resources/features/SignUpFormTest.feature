Feature: Test Swiggy application Signup Form Functionality

  @Regression @Sanity
  Scenario: User is able to enter credentials
    Given user has opened swiggy homepage
    When user clicks on the Sign up button on homepage
    Then sign up form opens "Sign up"
    And user enters following login details
      | Name     | A Sharma       |
      | Email    | atest@test.com |
      | Password | test123        |
    And click on continue button
    Then There should be error message in phone number field "Enter your phone number"
