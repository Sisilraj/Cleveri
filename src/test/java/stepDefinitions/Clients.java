package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.ClientsPage;
import pages.DashboardPage;
import pages.LoginPage;

public class Clients {

	WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private ClientsPage clientsPage;
	private SoftAssert softAssert;

	@Given("User navigate to cleveri employer Clients page")
	public void user_navigate_to_cleveri_employer_clients_page() {
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		softAssert = new SoftAssert();

		loginPage.enterCompanyEmail();
		loginPage.enterPassword();
		loginPage.clickOnSignInButton();

		dashboardPage.clickOnClientsOption();
	}

	@When("I add new client")
	public void i_add_new_client() {
		clientsPage = new ClientsPage(driver);
		clientsPage.addNewClient();
	}

	@And("I enter {string} in client name field")
	public void i_enter_in_client_name_field(String client_name) {
		clientsPage.enterClientName(client_name);
	}

	@And("I enter {string} in client email field")
	public void i_enter_in_client_email_field(String client_email) {
		clientsPage.enterClientEmail(client_email);
	}

	@And("I enter {string} in client address field")
	public void i_enter_in_client_address_field(String client_address) {
		clientsPage.enterClientAddress(client_address);
	}

	@And("I select {string} in client country field")
	public void i_select_in_client_country_field(String client_country) {
		clientsPage.selectClientCountryOptions(client_country);
	}

	@And("I select {string} in client state or province field")
	public void i_select_in_client_state_or_province_field(String client_state) {
		clientsPage.selectClientStateOrProvinceOptions(client_state);
	}

	@And("I enter {string} in contact number field")
	public void i_enter_in_contact_number_field(String client_phone) {
		clientsPage.enterClientPhoneNumber(client_phone);
	}

	@Then("I submit all client information")
	public void i_submit_all_client_information() {
		clientsPage.submitAllClientInformations();
	}

	@And("I should see added client and see status as active")
	public void i_should_see_added_client_and_see_status_as_active() {
		softAssert.assertEquals(clientsPage.verifyNewClientAdded(), "New client is created successfully!",
				"we can't see any New client is created successfully alert message.");

		softAssert.assertEquals(true, clientsPage.verifyActiveStatus(),
				"we can't see any active status on the newly created client");
	}

	@When("I select existing one client")
	public void i_select_existing_one_client() {
		clientsPage.selectFirstClient();
	}

	@And("I edit selected client's {string}")
	public void i_edit_selected_client_s(String select_client_name) {
		clientsPage.editClientName(select_client_name);
	}

	@Then("I submit edited client information")
	public void i_submit_edited_client_information() {
		clientsPage.submitAllClientInformations();
	}

	@And("I should see edited client")
	public void i_should_see_edited_client() {
		softAssert.assertEquals(clientsPage.verifyEditedClientStatus(), "Client details are successfully updated!",
				"we can't see any Client details are successfully updated alert message.");
	}

	@Then("Assert all clients page soft assertions")
	public void assert_all_clients_page_soft_assertions() {
		// Assert all soft assertions
		softAssert.assertAll();
	}

}
