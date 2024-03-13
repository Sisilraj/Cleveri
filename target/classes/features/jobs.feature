@jobs
Feature: Jobs' page functionality

  Scenario Outline: Verify jobs page's elements and it's functionality
    Given User navigate to cleveri employer Jobs page
    And I create a new job
    When I put the "<job_title>" and select the "<client>", "<department>", and "<job_type>"
    And I click on create button
    Then I should see created "<job_title>" with pending status
    
    When I select the "<department>" and "<seniority>" and "<job_location>" and "<client>" under job basic info
    And I set the "<min_salary>" and  "<max_salary>" and "<salary_terms>"
    Then I update the job information
    
    When I go to job description section
    And I write the job_introduction and responsibilities_duties and qualification_skills and benifits
    Then I update the job description 
    And I should see all the information in preview job
    
    When I go to screening interview questions section
    Then I add a question in dropdown with using "<question_keyword>" and should see left side
    And I write the question in input field and should see left side
    
    When I go to Assesments section
    Then I add personality assessment and see successfullty added status
    And I add coginitive assessement and see successfullty added status
    And I remove one assessment and see removed status
    
    When I go to publish and share section
    And I publish the job and see successfull alert message
    And I should see options are copy, invite via email, twitter, facebook, linkedin and working its functionality
    Then I should see published label of that particular job in jobs category
    
    Then Assert all Jobs page soft assertions

    Examples: 
      | job_title                      | client | department  | job_type  | seniority | job_location | min_salary | max_salary | salary_terms | question_keyword |
      | Software Engineer(For Testing) | bradx  | Engineering | Full Time | Associate | colombo      |      12000 |      15000 | month        | self	 				   |
