package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class ClientsPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;

	public ClientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement addNewClientBtn;
	
	public void addNewClient() {
		elementUtils.clickOnElement(addNewClientBtn, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@FindBy(name = "name")
	private WebElement clientName;
	
	public void enterClientName(String client_name) {		
		elementUtils.typeTextIntoElement(clientName, client_name, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@FindBy(name = "email")
	private WebElement clientEmail;
	
	public void enterClientEmail(String client_email) {
		elementUtils.typeTextIntoElement(clientEmail, client_email, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@FindBy(name = "address")
	private WebElement clientAddress;
	
	public void enterClientAddress(String client_address) {
		elementUtils.typeTextIntoElement(clientAddress, client_address, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath = "(//div[@class='relative ']//select)[1]")
	private WebElement clientCountryOptions;
	
	public void selectClientCountryOptions(String client_country) {
		elementUtils.selectOptionInDropdown(clientCountryOptions, client_country, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath = "(//div[@class='relative ']//select)[2]")
	private WebElement clientStateOptions;
	
	public void selectClientStateOrProvinceOptions(String client_state) {
		elementUtils.selectOptionInDropdown(clientStateOptions, client_state, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath = "//input[@type='tel']")
	private WebElement clientPhone;
	
	public void enterClientPhoneNumber(String client_phone) {
		clientPhone.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		
		elementUtils.typeTextIntoElement(clientPhone, client_phone, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;
	
	public void submitAllClientInformations() {
		elementUtils.clickOnElement(submitBtn, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement closeAlert;
	
	@FindBy(xpath = "(//span[text()='Active'])[3]")
	private WebElement activeStatus;

	@FindBy(xpath = "//div[text()='New client is created successfully!']")
	private WebElement addSuccessClientAlert;
	
	public String verifyNewClientAdded() {
		String successAlert = elementUtils.getTextFromElement(addSuccessClientAlert, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(closeAlert, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return successAlert;
	}
	
	public boolean verifyActiveStatus() {
		return elementUtils.visibleTextFromElement(activeStatus, 10);
	}
	
	@FindBy(xpath = "(//main[@class='card-body p-6']//p)[1]")
	private WebElement firstClient;
	
	@FindBy(xpath = "//div[text()='Client details are successfully updated!']")
	private WebElement editedSuccessClientAlert;
	
	public void selectFirstClient() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(firstClient, 10);
	}
	
	public void editClientName(String select_client_name) {
		elementUtils.typeTextIntoElement(clientName, select_client_name, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String verifyEditedClientStatus() {
		String updatedAlert = elementUtils.getTextFromElement(editedSuccessClientAlert, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(closeAlert, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return updatedAlert;
	}
}
