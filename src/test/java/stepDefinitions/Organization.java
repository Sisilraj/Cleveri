package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.DashboardPage;
import pages.LoginPage;
import pages.OrganizationPage;

public class Organization {

	WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private OrganizationPage organizationPage;
	private SoftAssert softAssert;

	@Given("User navigate to cleveri employer Organization page")
	public void user_navigate_to_cleveri_employer_organization_page() {
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		softAssert = new SoftAssert();

		loginPage.enterCompanyEmail();
		loginPage.enterPassword();
		loginPage.clickOnSignInButton();

		dashboardPage.clickOnOrganizationOption();
	}

	@When("We can see company_logo and upload logo functionality")
	public void we_can_see_company_logo_and_upload_logo_functionality() {
		organizationPage = new OrganizationPage(driver);

		softAssert.assertEquals(true, organizationPage.visibleCompanyLogo(), "Company logo is not visible");

		softAssert.assertEquals(true, organizationPage.funcOfUploadLogo().equals("Image Upload"),
				"Image upload popup is not visible.");
	}

	@Then("I edit the {string} and save it and see correct attribute value of legal name")
	public void i_edit_the_and_save_it_and_see_correct_attribute_value_of_legal_name(String legal_name) {
		softAssert.assertEquals(true, organizationPage.verifyEditLegalName(legal_name),
				"There are incorrect attribute value of legal name");
	}

	@And("I edit the {string} and save it and see correct attribute value of company description")
	public void i_edit_the_and_save_it_and_see_correct_attribute_value_of_company_description(
			String company_description) {
		softAssert.assertEquals(true, organizationPage.verifyEditCompanyDescription(company_description),
				"There are incorrect company description");
	}

	@And("I edit the {string} and save it and see correct attribute value of company address")
	public void i_edit_the_and_save_it_and_see_correct_attribute_value_of_company_address(String company_address) {
		softAssert.assertEquals(true, organizationPage.verifyEditCompanyAddress(company_address),
				"There are incorrect attribute value of company address");
	}

	@And("I edit the {string} and save it and see correct attribute value of company email")
	public void i_edit_the_and_save_it_and_see_correct_attribute_value_of_company_email(String company_email) {
		softAssert.assertEquals(true, organizationPage.verifyEditCompanyEmail(company_email),
				"There are incorrect attribute value of company email");
	}

	@And("I edit the {string} and save it and see correct attribute value of company phone")
	public void i_edit_the_and_save_it_and_see_correct_attribute_value_of_company_phone(String company_phone) {
		softAssert.assertEquals(true, organizationPage.verifyEditCompanyPhone(company_phone),
				"There are incorrect attribute value of company phone");
	}

	@Then("Assert all organization page soft assertions")
	public void assert_all_organization_page_soft_assertions() {
		// Assert all soft assertions
		softAssert.assertAll();
	}

}
