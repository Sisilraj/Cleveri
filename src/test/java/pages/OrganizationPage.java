package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class OrganizationPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;

	public OrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//img[@alt='Logo']")
	private WebElement companyLogo;
	
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement uploadLogo;
	
	@FindBy(xpath = "//h2[text()='Image Upload']")
	private WebElement imageUploadTitle;
	
	@FindBy(xpath = "//button[@class='text-[22px]']")
	private WebElement closeImgUploadPopup;
	
	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement closeAlert;
	
	public boolean visibleCompanyLogo() {
		return elementUtils.visibleTextFromElement(companyLogo, 10);
	}
	
	public String funcOfUploadLogo() {
		elementUtils.clickOnElement(uploadLogo, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String title = elementUtils.getTextFromElement(imageUploadTitle, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(closeImgUploadPopup, 10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return title;
	}
	
	@FindBy(name = "name")
	private WebElement legalName;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;
	
	public boolean verifyEditLegalName(String legal_name) {
		legalName.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.typeTextIntoElement(legalName, legal_name, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(submitBtn, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(closeAlert, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(legalName.getAttribute("value").equals(legal_name)) {
			return true;
		}
		return false;
	}
	
	@FindBy(name = "description")
	private WebElement companyDescription;
	
	public boolean verifyEditCompanyDescription(String company_description) {
		companyDescription.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.typeTextIntoElement(companyDescription, company_description, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(submitBtn, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(closeAlert, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String comDesc = driver.findElement(By.name("description")).getText();
		
		if(comDesc.equals(company_description)) {
			return true;
		}
		return false;
	}
	
	@FindBy(name = "address")
	private WebElement companyAddress;
	
	public boolean verifyEditCompanyAddress(String company_address) {
		companyAddress.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.typeTextIntoElement(companyAddress, company_address, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(submitBtn, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(closeAlert, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(companyAddress.getAttribute("value").equals(company_address)) {
			return true;
		}
		return false;
	}
	
	@FindBy(name = "organization_email")
	private WebElement companyEmail;
	
	public boolean verifyEditCompanyEmail(String company_email) {
		companyEmail.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.typeTextIntoElement(companyEmail, company_email, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(submitBtn, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(closeAlert, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(companyEmail.getAttribute("value").equals(company_email)) {
			return true;
		}
		return false;
	}
	
	@FindBy(xpath = "//input[@type='tel']")
	private WebElement companyPhone;
	
	public boolean verifyEditCompanyPhone(String company_phone) {
		companyPhone.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.typeTextIntoElement(companyPhone, company_phone, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(submitBtn, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtils.clickOnElement(closeAlert, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(companyPhone.getAttribute("value").equals(company_phone)) {
			return true;
		}
		return false;
	}

}
