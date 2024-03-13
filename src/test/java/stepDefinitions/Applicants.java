package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.ApplicantsPage;
import pages.DashboardPage;
import pages.LoginPage;

public class Applicants {

	WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private ApplicantsPage applicantsPage;
	private SoftAssert softAssert;

	@Given("User navigate to cleveri employer Applicants page")
	public void user_navigate_to_cleveri_employer_applicants_page() {
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		applicantsPage = new ApplicantsPage(driver);
		softAssert = new SoftAssert();

		loginPage.enterCompanyEmail();
		loginPage.enterPassword();
		loginPage.clickOnSignInButton();

		dashboardPage.clickOnApplicantsOption();
	}

	@When("I type {string} in the auto-suggestion dropdown")
	public void i_type_in_the_auto_suggestion_dropdown(String job_title) {
		applicantsPage.searchJobTitle(job_title);
	}

	@Then("I should see candidate profiles for the selected job")
	public void i_should_see_candidate_profiles_for_the_selected_job() {
		softAssert.assertEquals(applicantsPage.viewCandidate(0), true,
				"candidate job title is do not match with selected job");
	}

	@And("I should see the status of the service as {string}")
	public void i_should_see_the_status_of_the_service_as(String status) {
		softAssert.assertEquals(applicantsPage.verifyServiceStatus(status), true,
				"job's status is do not match with selected job");
	}

	@When("I invite new Candidate")
	public void i_invite_new_candidate() {
		applicantsPage.clickOnInviteCandidateBtn();
	}

	@And("I Select a Job with {string} in our company")
	public void i_select_a_job_with_in_our_company(String currently_active_job) {
		applicantsPage.selectJobTitle(currently_active_job);
	}

	@And("I type {string} in name filed")
	public void i_type_in_name_filed(String candidate_name) {
		applicantsPage.typeCandidateName(candidate_name);
	}

	@And("I type {string} in email field")
	public void i_type_in_email_field(String candidate_email) {
		applicantsPage.typeCandidateEmail(candidate_email);
	}

	@And("I confirm to invite")
	public void i_confirm_to_invite() {
		applicantsPage.clickOnInviteBtn();
	}

	@Then("I should see invited {string} and {string} under Invited Candidates section")
	public void i_should_see_invited_and_under_invited_candidates_section(String candidate_email,
			String candidate_status) {
		boolean emailStatus = applicantsPage.verifyCandidateEmailStatus(candidate_email);
		boolean invitedStatus = applicantsPage.verifyCandidateInvitedStatus(candidate_status);
		
		System.out.println(applicantsPage.getCandidateEmailStatus());
		System.out.println(candidate_email);
		System.out.println(emailStatus);
		System.out.println(invitedStatus);

		softAssert.assertTrue(emailStatus, "Candidate's email status is not displayed properly");
		softAssert.assertTrue(invitedStatus, "Candidate's invited status is not displayed properly");
	}

	@When("I search the {string}")
	public void i_search_the(String search_candidate) {
		applicantsPage.closeInviteCandidatePopup();
		applicantsPage.refreshPage();
		applicantsPage.searchCandidate(search_candidate);
	}

	@Then("I should see the searched candidate")
	public void i_should_see_the_searched_candidate() {
		applicantsPage.clickFilterSearchBtn();
		softAssert.assertTrue(applicantsPage.showSearchedResult(),
				"The searched candidate's result is didn't work. Because we can't see any searched candidate.");
	}

	@When("I filter based on score and see appropriate candidates")
	public void i_filter_based_on_score_and_see_appropriate_candidates() {
		applicantsPage.refreshPage();
		applicantsPage.clickFilterSearchBtn();

		softAssert.assertTrue(applicantsPage.verifyScoresSorted(applicantsPage.getAppliedScores()),
				"Applied candidate's scores are not sorted");
		softAssert.assertTrue(applicantsPage.verifyScoresSorted(applicantsPage.getQualifiedScores()),
				"Qualified candidate's scores are not sorted");
		softAssert.assertTrue(applicantsPage.verifyScoresSorted(applicantsPage.getFirstInterviewedScores()),
				"First Interviewed candidate's scores are not sorted");
		softAssert.assertTrue(applicantsPage.verifyScoresSorted(applicantsPage.getSecondInterviewedScores()),
				"Second Interviewed candidate's scores are not sorted");
		softAssert.assertTrue(applicantsPage.verifyScoresSorted(applicantsPage.getOfferedScores()),
				"Offered candidate's scores are not sorted");
	}

	@And("I filter based on date and see appropriate candidates")
	public void i_filter_based_on_date_and_see_appropriate_candidates() {
		applicantsPage.filterOptionsByDate();
		applicantsPage.clickFilterSearchBtn();

		softAssert.assertTrue(!applicantsPage.verifyScoresSorted(applicantsPage.getAppliedScores()),
				"Applied candidates are not sorted by date");
		softAssert.assertTrue(!applicantsPage.verifyScoresSorted(applicantsPage.getQualifiedScores()),
				"Qualified candidates are not sorted by date");
		softAssert.assertTrue(!applicantsPage.verifyScoresSorted(applicantsPage.getFirstInterviewedScores()),
				"First Interviewed candidates are not sorted by date");
		softAssert.assertTrue(!applicantsPage.verifyScoresSorted(applicantsPage.getSecondInterviewedScores()),
				"Second Interviewed candidates are not sorted by date");
		softAssert.assertTrue(!applicantsPage.verifyScoresSorted(applicantsPage.getOfferedScores()),
				"Offered candidates are not sorted by date");
	}

	@When("I select a candidate profile in In progress section")
	public void i_select_a_candidate_profile_in_in_progress_section() {
		applicantsPage.clickOnInProgressFirstCandidate();
	}

	@And("I should see candidate name and relevent informaion")
	public void i_should_see_candidate_name_and_relevent_informaion() {
		softAssert.assertTrue(applicantsPage.verifyCandidateNameAndReleventDetails(),
				"We can't see any candidate name and relevent informaion in progress person");
	}

	@And("I should see Linkedin or Send Reminder or both button")
	public void i_should_see_linkedin_or_send_reminder_or_both_button() {
		softAssert.assertTrue(applicantsPage.verifyLinkedinSendReminderOptions(),
				"We can't see Linkedin or Send Reminder or both button");
	}

	@Then("I close the candidate profile popup")
	public void i_close_the_candidate_profile_popup() {
		applicantsPage.inProgressPopupClose.click();
	}

	@When("I select a candidate profile without In progress section")
	public void i_select_a_candidate_profile_without_in_progress_section() {
		applicantsPage.clickOnAppliedFirstCandidate();
	}

	@And("I should see candidate name and relevent informaion same like In progress section")
	public void i_should_see_candidate_name_and_relevent_informaion_same_like_in_progress_section() {
		softAssert.assertTrue(applicantsPage.verifyCandidateNameAndReleventDetails(),
				"We can't see any candidate name and relevent informaion in applied person");
	}

	@And("I should see Technologies known to the candidate and about candidate")
	public void i_should_see_technologies_known_to_the_candidate_and_about_candidate() {
		softAssert.assertTrue(applicantsPage.verifyTechnologiesAndAboutOfCandidate(),
				"We can't see any candidate Technologies and about candidate");
	}

	@And("I should see Resume, Linkedin, and Bookmark button and it's functionality")
	public void i_should_see_resume_linkedin_and_bookmark_button_and_it_s_functionality() {
		softAssert.assertTrue(applicantsPage.verifyResumeLinkedinBookmarkOfCandidate(),
				"We can't see any candidateResume, Linkedin, and Bookmark");
	}

	@And("I should see candidate's score")
	public void i_should_see_candidate_s_score() {
		softAssert.assertTrue(applicantsPage.verifyCandidatesScore(),
				"We can't see proper candidate's score both popup and applicants page's candidate profile");
	}

	@And("I should see Personality, Cognitive Skills, Screening Interview, and Profile it's functionality")
	public void i_should_see_personality_cognitive_skills_screening_interview_and_profile_it_s_functionality() {
		softAssert.assertTrue(applicantsPage.verifyPersonalityAssesments(),
				"We can't see proper candidate's Personality scores");
		softAssert.assertTrue(applicantsPage.verifyCognitiveSkillsAssesments(),
				"We can't see proper candidate's Cognitive Skills scores");
		softAssert.assertTrue(applicantsPage.verifyScreeningInterviews(),
				"We can't see proper candidate's Screening Interviews");
		softAssert.assertTrue(applicantsPage.verifyProfiles(),
				"We can't see proper candidate's Profiles");
		
		applicantsPage.closeInProgressPopup();
	}

	@Then("Assert all Applicants page soft assertions")
	public void assert_all_applicants_page_soft_assertions() {
		// Assert all soft assertions
		softAssert.assertAll();
	}
}
