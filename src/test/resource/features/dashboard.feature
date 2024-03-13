@dashboard
Feature: Dashboard top Performers list, recent Applications list, published jobs list view

  Scenario: verify of dashboard page elements and it's functionality
    Given User navigate to cleveri employer dashboard page
    
    When User go to Recent Applications section
    Then User verify the Recent Applications list has to be accurate
    
    When User go to Top Performences section
    Then User verify the Top Performers list has to be accurate
    
    When User go to Published Jobs section
    Then User verify the Published jobs list has to be accurate and statistics has to maintain properly
    
    Then Assert all Dashboard page soft assertions
