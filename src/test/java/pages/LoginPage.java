package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utility.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	private SoftAssert softAssert;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		softAssert = new SoftAssert();
	}

	//enter email and password
	@FindBy(name = "email")
	private WebElement emailField;
	
	public void enterCompanyEmail() {
		elementUtils.typeTextIntoElement(emailField, "sisilraj@moneta.lk", 10);
	}
	
	@FindBy(name = "password")
	private WebElement passwordField;
	
	public void enterPassword() {
		elementUtils.typeTextIntoElement(passwordField, "Sisil@1998", 10);
	}
	
	//click keep Me Signed In check box and sign in button
	@FindBy(xpath = "//span[contains(@class,'h-4 w-4')]")
	private WebElement keepMeCheckbox;
	
	public void selectKeepmeSignedinCheckbox() {
		elementUtils.clickOnElement(keepMeCheckbox, 10);
	}
	
	@FindBy(tagName = "button")
	private WebElement signInButton;
	
	public DashboardPage clickOnSignInButton() {
		elementUtils.clickOnElement(signInButton, 10);
		return new DashboardPage(driver);
	}
	
	public SoftAssert getSoftAssert() {
		return softAssert;
	}

}
