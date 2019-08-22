Feature: Login Feature
  Verify if user is able to Login in to the site

  Scenario: Login as a authenticated user
    When user navigates to Login Page
    And user signs up
    When user is on account page
    Then user navigates to personal information page
    And user verify that personal information is expected

