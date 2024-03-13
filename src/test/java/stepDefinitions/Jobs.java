package stepDefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.JobsPage;
import pages.LoginPage;

public class Jobs {

	WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private JobsPage jobsPage;
	private SoftAssert softAssert;

	@Given("User navigate to cleveri employer Jobs page")
	public void user_navigate_to_cleveri_employer_jobs_page() {
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		jobsPage = new JobsPage(driver);
		softAssert = new SoftAssert();

		loginPage.enterCompanyEmail();
		loginPage.enterPassword();
		loginPage.clickOnSignInButton();

		dashboardPage.clickOnJobs();
	}

	@And("I create a new job")
	public void i_create_a_new_job() {
		jobsPage.clickOnAddNewJob();
	}

	@When("I put the {string} and select the {string}, {string}, and {string}")
	public void i_put_the_and_select_the_and(String job_title, String client, String department, String job_type) {
		jobsPage.enterJobTitle(job_title);
		jobsPage.enterClient(client);
		jobsPage.enterDepartment(department);
		jobsPage.enterJobType(job_type);
	}

	@And("I click on create button")
	public void i_click_on_create_button() {
		jobsPage.clickOnCreateBtn();
	}

	@Then("I should see created {string} with pending status")
	public void i_should_see_created_with_pending_status(String job_title) {
		softAssert.assertTrue(jobsPage.getTextOfJobTitle().equals(job_title),
				"We can't see created Job title in appearing page");
		softAssert.assertTrue(jobsPage.getTextOfJobStatus().equals("Pending"),
				"We can't see pending status in appearing page");
	}

	@When("I select the {string} and {string} and {string} and {string} under job basic info")
	public void i_select_the_and_and_and_under_job_basic_info(String department, String seniority, String job_location,
			String client) {
		jobsPage.selectDepartment(department);
		jobsPage.selectSeniority(seniority);
		jobsPage.selectLocation(job_location);
		jobsPage.selectClient(client);
	}

	@And("I set the {string} and  {string} and {string}")
	public void i_set_the_and_and(String min_salary, String max_salary, String salary_terms) {
		jobsPage.setMinSalary(min_salary);
		jobsPage.setMaxSalary(max_salary);
		jobsPage.selectSalaryTerms(salary_terms);
	}

	@Then("I update the job information")
	public void i_update_the_job_information() {
		jobsPage.salaryTermsInput.sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);
	}

	@When("I go to job description section")
	public void i_go_to_job_description_section() {
		jobsPage.selectOnJobDescription();
	}

	@And("I write the job_introduction and responsibilities_duties and qualification_skills and benifits")
	public void i_write_the_job_introduction_and_responsibilities_duties_and_qualification_skills_and_benifits() {
		jobsPage.enterJobIntroductionText();
		jobsPage.enterResponsiblitiesDutiesText();
		jobsPage.enterQualificationsSkillsText();
		jobsPage.enterBenefitsText();
	}

	@Then("I update the job description")
	public void i_update_the_job_description() {
		jobsPage.clickOnUpdateDesc();
	}

	@And("I should see all the information in preview job")
	public void i_should_see_all_the_information_in_preview_job() {
		jobsPage.clickOnPreviewJobBtn();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String verificationResult = jobsPage.verifyJobBasic();

		softAssert.assertEquals(true, verificationResult.contains("Job title is displayed"));
		softAssert.assertEquals(true, verificationResult.contains("Company name is displayed"));
		softAssert.assertEquals(true, verificationResult.contains("Job department is displayed"));
		softAssert.assertEquals(true, verificationResult.contains("Job types are displayed"));
		softAssert.assertEquals(true, verificationResult.contains("Job introduction is displayed"));
		softAssert.assertEquals(true, verificationResult.contains("Job responsibility is displayed"));
		softAssert.assertEquals(true, verificationResult.contains("Job Qualifications are displayed"));
		softAssert.assertEquals(true, verificationResult.contains("Job Benefits are displayed"));
		softAssert.assertEquals(true, verificationResult.contains("About the company is displayed"));
		softAssert.assertEquals(true, verificationResult.contains("Job Open date is displayed"));
		softAssert.assertEquals(true, verificationResult.contains("Job expiry date is displayed"));

		jobsPage.closeJobPreviewPopup();
	}

	@When("I go to screening interview questions section")
	public void i_go_to_screening_interview_questions_section() {
		jobsPage.selectScreenInterviewQuestion();
	}

	@Then("I add a question in dropdown with using {string} and should see left side")
	public void i_add_a_question_in_dropdown_with_using_and_should_see_left_side(String question_keyword) {
		jobsPage.addQuestions(question_keyword);

		softAssert.assertEquals(true, jobsPage.verifyAddedQuestions(), "Add a question doesn't show the left side");

		jobsPage.closeAlert.click();
	}

	@And("I write the question in input field and should see left side")
	public void i_write_the_question_in_input_field_and_should_see_left_side() {
		jobsPage.writeQuestion();

		softAssert.assertEquals(true, jobsPage.verifyWriteQuestions(), "Write the question doesn't show the left side");

		jobsPage.closeAlert.click();
	}

	@When("I go to Assesments section")
	public void i_go_to_assesments_section() {
		jobsPage.selectAssessments();
	}

	@Then("I add personality assessment and see successfullty added status")
	public void i_add_personality_assessment_and_see_successfullty_added_status() {
		jobsPage.addPersonalityAssessement();

		softAssert.assertEquals(jobsPage.verifySuccessfullyAddAssessement(),
				"Assessment has been succesfully added to this job!",
				"We can not see any questions that are created in personality.");

		jobsPage.closeAlert.click();
	}

	@And("I add coginitive assessement and see successfullty added status")
	public void i_add_coginitive_assessement_and_see_successfullty_added_status() {
		jobsPage.addCoginitiveAssessement();

		softAssert.assertEquals(jobsPage.verifySuccessfullyAddAssessement(),
				"Assessment has been succesfully added to this job!",
				"We can not see any questions that are created in coginitive.");

		jobsPage.closeAlert.click();
	}

	@And("I remove one assessment and see removed status")
	public void i_remove_one_assessment_and_see_removed_status() {
		jobsPage.removeAssessment();

		softAssert.assertEquals(jobsPage.verifySuccessfullyRemovedAssessement(),
				"Assessment has been removed from this job!", "We can not see any questions that are removed.");

		jobsPage.closeAlert.click();
	}

	@When("I go to publish and share section")
	public void i_go_to_publish_and_share_section() {
		jobsPage.selectPublicShare();
	}

	@And("I publish the job and see successfull alert message")
	public void i_publish_the_job_and_see_successfull_alert_message() {
		jobsPage.publishJob();

		softAssert.assertEquals(jobsPage.verifyJobPublishedSuccesfullyAlert(), "Job Published succesfully!",
				"We can not see successful alert message that was we published.");
		
		jobsPage.closeAlert.click();
	}

	@And("I should see options are copy, invite via email, twitter, facebook, linkedin and working its functionality")
	public void i_should_see_options_are_copy_invite_via_email_twitter_facebook_linkedin_and_working_its_functionality() {		
		// copy option and its functionality
		softAssert.assertEquals(true, jobsPage.visibleCopyOption(), "Copy option was not visible");

		softAssert.assertEquals(jobsPage.funcOfCopyOption(), "Job URL copied succesfully!",
				"copy functionality did not work.");

		jobsPage.closeAlert.click();

		// Invite via private email and its functionality
		softAssert.assertEquals(true, jobsPage.visibleInviteViaPrivateEmailOption(),
				"Invite Via Private Email option was not visible");

		softAssert.assertEquals(true, jobsPage.funcOfInviteViaPrivateEmail(),
				"Invite Via Private Email option popup box was not visible");

		jobsPage.closeInvitePopup.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Twitter and its functionality
		softAssert.assertEquals(true, jobsPage.visibleShareWithTwitterOption(), "Twitter option was not visible");

		softAssert.assertEquals(true, jobsPage.funcOfShareWithTwitter(),
				"Share with Twitter functionality didn't work");

		// Facebook and its functionality
		softAssert.assertEquals(true, jobsPage.visibleShareWithFaceBookOption(), "Facebook option was not visible");

		softAssert.assertEquals(true, jobsPage.funcOfShareWithFaceBook(),
				"Share with Facebook functionality didn't work");

		// Linkedin and its functionality
		softAssert.assertEquals(true, jobsPage.visibleShareWithLinkedinOption(), "Linkedin option was not visible");

		softAssert.assertEquals(true, jobsPage.funcOfShareWithLinkedin(),
				"Share with Linkedin functionality didn't work");

	}

	@Then("I should see published label of that particular job in jobs category")
	public void i_should_see_published_label_of_that_particular_job_in_jobs_category() {
		jobsPage.goToJobsCategory();

		softAssert.assertEquals(jobsPage.verifyLabelNameOfPublished(), "Published", "Published label is not visible");

	}

	@Then("Assert all Jobs page soft assertions")
	public void assert_all_jobs_page_soft_assertions() {
		// Assert all soft assertions
		softAssert.assertAll();
	}

}
