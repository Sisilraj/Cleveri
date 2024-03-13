package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.ApplicantsPage;
import pages.DashboardPage;
import pages.LoginPage;

public class Dashboard {

	WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private ApplicantsPage applicantsPage;
	private SoftAssert softAssert;
	private List<String> recentlyAppliedCandidates;
	private List<String> firstFiveCandidateNames;

	@Given("User navigate to cleveri employer dashboard page")
	public void user_navigate_to_cleveri_employer_dashboard_page() {
		driver = DriverFactory.getDriver();
		this.loginPage = new LoginPage(driver);
		this.dashboardPage = new DashboardPage(driver);
		this.applicantsPage = new ApplicantsPage(driver);
		softAssert = new SoftAssert();

		loginPage.enterCompanyEmail();
		loginPage.enterPassword();
		loginPage.clickOnSignInButton();
	}

	@When("User go to Recent Applications section")
	public void user_go_to_recent_applications_section() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dashboardPage.scrollIntoRecentApplicationsSection();
	}

	@Then("User verify the Recent Applications list has to be accurate")
	public void user_verify_the_recent_applications_list_has_to_be_accurate() {

		// retrieve the recently applied candidates list from the dashboard
		recentlyAppliedCandidates = dashboardPage.getRecentlyAppliedCandidates();

		// go to applicants page
		dashboardPage.clickOnAllCandidatesOptionInDashboard();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		applicantsPage.filterOptionsByDate();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		applicantsPage.clickFilterSearchBtn();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// retrieve the first five candidate names from the applicants page
		firstFiveCandidateNames = applicantsPage.getFirstFiveCandidateNames();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// first five candidate names from the applicants page should match the recently
		// applied candidates list from the dashboard
		for (int i = 0; i < 5; i++) {
			softAssert.assertEquals(recentlyAppliedCandidates.get(i), firstFiveCandidateNames.get(i).split(" ")[0]);
		}

		// go to dashboard page
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		applicantsPage.navigateBack();
	}

	@When("User go to Top Performences section")
	public void user_go_to_top_performences_section() {
		dashboardPage.scrollIntoTopPerformanceSection();
	}

	@Then("User verify the Top Performers list has to be accurate")
	public void user_verify_the_top_performers_list_has_to_be_accurate() {
		softAssert.assertEquals(true, dashboardPage.getTopPerformanceScores(),
				"Candidates are not properly align based on Top perfomance scores");
	}

	@When("User go to Published Jobs section")
	public void user_go_to_published_jobs_section() {
		dashboardPage.scrollIntoPublishedJobsSection();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User verify the Published jobs list has to be accurate and statistics has to maintain properly")
	public void user_verify_the_published_jobs_list_has_to_be_accurate_and_statistics_has_to_maintain_properly() {
		dashboardPage.scrollIntoFirstPublishedJob();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// get dashboard statistics
		int dashboardApplicantsStatistics = dashboardPage.getFirstPublishedJobOfApplicantsStatisticValue();
		int dashboardQualifiedStatistics = dashboardPage.getFirstPublishedJobOfQualifiedStatisticValue();
		int dashboardInterviewedStatistics = dashboardPage.getFirstPublishedJobOfInterviewedStatisticValue();
		
		dashboardPage.clickOnOnePublishedJobInDashboard();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// get applicants statistics
		int applicants = applicantsPage.totalApplicant();
		int qualified = applicantsPage.totalQualified();
		int interviewed = applicantsPage.totalInterviewed();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// the statistics on dashboard should match the statistics on applicants
		softAssert.assertEquals(applicants, dashboardApplicantsStatistics, "Applicants statistics do not match");
		softAssert.assertEquals(qualified, dashboardQualifiedStatistics, "Qualified statistics do not match");
		softAssert.assertEquals(interviewed, dashboardInterviewedStatistics, "Interviewed statistics do not match");
	}

	@Then("Assert all Dashboard page soft assertions")
	public void assert_all_dashboard_page_soft_assertions() {
		// Assert all soft assertions
		softAssert.assertAll();
	}

}
