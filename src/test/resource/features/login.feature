@login
Feature: From Employer side - login to the system

  Scenario: verify of login page elements and it's functionality
    Given User navigate to Cleveri login page
    And User enter thier company email
    And User enter their password
    When User select Keep Me Signed In checkbox
    And User click on sign in button
    Then User successfully navigate to cleveri dashbord page
    And Assert all Login page soft assertions
