@client
Feature: Clients page functionality

  Scenario Outline: Verify clients page's elements and it's functionality
    Given User navigate to cleveri employer Clients page
    When I add new client
    And I enter "<client_name>" in client name field
    And I enter "<client_email>" in client email field
    And I enter "<client_address>" in client address field
    And I select "<client_country>" in client country field
    And I select "<client_state>" in client state or province field
    And I enter "<client_phone>" in contact number field
    Then I submit all client information
    And I should see added client and see status as active
    
    When I select existing one client
    And I edit selected client's "<select_client_name>"
    Then I submit edited client information
    And I should see edited client
    
    Then Assert all clients page soft assertions

    Examples: 
      | client_name | client_email     | client_address | client_country | client_state     | client_phone  | select_client_name |
      | moneta      | moneta@gmail.com | moneta address | Sri Lanka - LK | Colombo District | +94 701111011 | PickMe             |
