@MyRegression

Feature: user should login to the website.


  Background: user opens browser.
    And user navigates to login page.

  # Test Scenario 3
  Scenario: user login with valid email & password.
    # << Login Steps: (Free to use in other test scenarios manual running) >>
    When user enters valid  email.
    And user enters valid password.
    And user press on login button.
  # Expected Result
    Then user login successfully.
    And returned to home page.


  # Test Scenario 4
  Scenario: user login with invalid email & password.
    When user enters invalid email.
    And user enters invalid password.
    And user press on login button.
  # Expected Result
    Then user could not login successfully.
