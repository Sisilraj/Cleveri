package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.DashboardPage;
import pages.LoginPage;

public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	
	@Given("User navigate to Cleveri login page")
	public void user_navigate_to_cleveri_login_page() {
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
	}

	@And("User enter thier company email")
	public void user_enter_thier_company_email() {
		loginPage.enterCompanyEmail();
	}

	@And("User enter their password")
	public void user_enter_their_password() {
		loginPage.enterPassword();
	}

	@When("User select Keep Me Signed In checkbox")
	public void user_select_keep_me_signed_in_checkbox() {
		loginPage.selectKeepmeSignedinCheckbox();
	}

	@And("User click on sign in button")
	public void user_click_on_sign_in_button() {
		loginPage.clickOnSignInButton();
	}

	@Then("User successfully navigate to cleveri dashbord page")
	public void user_successfully_navigate_to_cleveri_dashbord_page() {
		dashboardPage.verifyDashBoardTitleInDashboardPage();
	}
	
	@And("Assert all Login page soft assertions")
	public void assert_all_login_page_soft_assertions() {
		// Assert all soft assertions
		SoftAssert softAssert = loginPage.getSoftAssert();
		softAssert.assertAll();
	}

}
