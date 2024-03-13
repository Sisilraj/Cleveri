@organization
Feature: Organization page functionality

  Scenario Outline: Verify organization page's elements and it's functionality
    Given User navigate to cleveri employer Organization page
    When We can see company_logo and upload logo functionality
    Then I edit the "<legal_name>" and save it and see correct attribute value of legal name
    And I edit the "<company_description>" and save it and see correct attribute value of company description
    And I edit the "<company_address>" and save it and see correct attribute value of company address
    And I edit the "<company_email>" and save it and see correct attribute value of company email
    And I edit the "<company_phone>" and save it and see correct attribute value of company phone
    
    Then Assert all organization page soft assertions

    Examples: 
      | legal_name             | company_description           | company_address                                     | company_email          | company_phone |
      | FinTech Hive (Pvt) Ltd | IT Services and IT Consulting | No 309 High Level Road, Colombo 06, 00600 Sri Lanka | support@getcleveri.com | +94 770417781 |
