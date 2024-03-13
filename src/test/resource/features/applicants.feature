@applicants
Feature: Applicants' page functionality

  Scenario Outline: Verify applicants page's elements and it's functionality
    Given User navigate to cleveri employer Applicants page
    When I type "<job_title>" in the auto-suggestion dropdown
    Then I should see candidate profiles for the selected job
    And I should see the status of the service as "<status>"
    
    When I invite new Candidate
    And I Select a Job with "<currently_active_job>" in our company
    And I type "<candidate_name>" in name filed
    And I type "<candidate_email>" in email field
    And I confirm to invite
    Then I should see invited "<candidate_email>" and "<candidate_status>" under Invited Candidates section
    
    When I search the "<search_candidate>"
    Then I should see the searched candidate
    
    When I filter based on score and see appropriate candidates
    And I filter based on date and see appropriate candidates
    
    When I select a candidate profile in In progress section
    And I should see candidate name and relevent informaion
    And I should see Linkedin or Send Reminder or both button
    Then I close the candidate profile popup
    
    When I select a candidate profile without In progress section
    And I should see candidate name and relevent informaion same like In progress section
    And I should see Technologies known to the candidate and about candidate
    And I should see Resume, Linkedin, and Bookmark button and it's functionality
    And I should see candidate's score
    And I should see Personality, Cognitive Skills, Screening Interview, and Profile it's functionality
    
    Then Assert all Applicants page soft assertions

    Examples: 
      | job_title | status  | currently_active_job | candidate_name | candidate_email      | candidate_status | search_candidate |
      | react     | Active  | react                | Candidate1     | Candidate1@Gmail.Com | Invited          | mohamed          |
