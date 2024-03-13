package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class JobsPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public JobsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "(//a[@class='black'])[1]")
	public WebElement setJob;

	// add new job
	@FindBy(xpath = "//span[text()='Add New Job']")
	private WebElement addNewJobBtn;

	public void clickOnAddNewJob() {
		elementUtils.clickOnElement(addNewJobBtn, 10);
	}

	@FindBy(name = "job_title")
	private WebElement jobTitleField;

	public void enterJobTitle(String job_title) {
		elementUtils.typeTextIntoElement(jobTitleField, job_title, 10);
	}

	@FindBy(name = "client")
	private WebElement clientField;

	public void enterClient(String client) {
		elementUtils.selectOptionInDropdown(clientField, client, 10);
	}

	@FindBy(name = "department")
	private WebElement departmentField;

	public void enterDepartment(String department) {
		elementUtils.selectOptionInDropdown(departmentField, department, 10);
	}

	@FindBy(name = "job_type")
	private WebElement job_typeField;

	public void enterJobType(String job_type) {
		elementUtils.selectOptionInDropdown(job_typeField, job_type, 10);
	}

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createBtn;

	public void clickOnCreateBtn() {
		elementUtils.clickOnElement(createBtn, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(tagName = "h5")
	private WebElement jobTitle;

	@FindBy(xpath = "//span[@class='inline-flex items-center']")
	private WebElement jobStatus;

	public String getTextOfJobTitle() {
		return elementUtils.getTextFromElement(jobTitle, 10);
	}

	public String getTextOfJobStatus() {
		return elementUtils.getTextFromElement(jobStatus, 10);
	}

	// job basic info
	@FindBy(xpath = "(//div[@class='dropdown__input-container css-1fsrxng-Tr'])[1]")
	private WebElement departmentBox;

	@FindBy(id = "react-select-2-input")
	private WebElement departmentInput;

	public void selectDepartment(String department) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtils.clickOnElement(departmentBox, 10);
		elementUtils.clickOnElement(departmentBox, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		departmentInput.sendKeys(department, Keys.ENTER);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//div[@class='dropdown__input-container css-1fsrxng-Tr'])[2]")
	private WebElement seniorityBox;

	@FindBy(id = "react-select-3-input")
	private WebElement seniorityInput;

	public void selectSeniority(String seniority) {
		elementUtils.clickOnElement(seniorityBox, 10);
		elementUtils.clickOnElement(seniorityBox, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		seniorityInput.sendKeys(seniority, Keys.ENTER);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//div[@class='dropdown__input-container css-1fsrxng-Tr'])[3]")
	private WebElement locationBox;

	@FindBy(id = "react-select-4-input")
	private WebElement locationInput;

	public void selectLocation(String job_location) {
		elementUtils.clickOnElement(locationBox, 10);
		elementUtils.clickOnElement(locationBox, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		locationInput.sendKeys(job_location, Keys.ENTER);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//div[@class='dropdown__input-container css-1fsrxng-Tr'])[6]")
	private WebElement clientBox;

	@FindBy(id = "react-select-7-input")
	private WebElement clientInput;

	public void selectClient(String client) {
		elementUtils.clickOnElement(clientBox, 10);
		elementUtils.clickOnElement(clientBox, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clientInput.sendKeys(client, Keys.ENTER);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "job_salary_min_currency")
	private WebElement lkrOption;

	@FindBy(id = "job_salary_min")
	private WebElement minSalary;

	@FindBy(id = "job_salary_max")
	private WebElement maxSalary;

	@FindBy(xpath = "(//div[@class='dropdown__input-container css-1fsrxng-Tr'])[5]")
	private WebElement salaryTermsBox;

	@FindBy(id = "react-select-6-input")
	public WebElement salaryTermsInput;

	public void setMinSalary(String min_salary) {
		elementUtils.selectOptionInDropdown(lkrOption, "LKR", 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		minSalary.sendKeys(min_salary);

	}

	public void setMaxSalary(String max_salary) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		maxSalary.sendKeys(max_salary);

	}

	public void selectSalaryTerms(String salary_terms) {
		elementUtils.clickOnElement(salaryTermsBox, 10);
		elementUtils.clickOnElement(salaryTermsBox, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		salaryTermsInput.sendKeys(salary_terms, Keys.ENTER);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//button[text()='Update Job Info']")
	private WebElement updateJobBtn;

	public void clickOnUpdateInfo() {
		elementUtils.clickOnElement(updateJobBtn, 10);
	}

	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement closeJobDetailsAlert;

	@FindBy(xpath = "//button[text()='Job Description']")
	private WebElement jobDescSec;

	// job description
	public void selectOnJobDescription() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollTo(0, 0);");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jobDescSec.click();
	}

	@FindBy(xpath = "(//div[@class='ql-editor ql-blank'])[1]")
	private WebElement jobIntroductionBox;

	public void enterJobIntroductionText() {
		jobIntroductionBox.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtils.typeTextIntoElement(jobIntroductionBox,
				"We are currently seeking a skilled and experienced "
						+ "Software Engineer specializing in testing to join "
						+ "our dynamic team. As a key member of our software "
						+ "development team, you will be responsible for ensuring "
						+ "the quality and reliability of our software products through "
						+ "comprehensive testing and quality assurance processes. "
						+ "If you are passionate about software testing and have a strong "
						+ "attention to detail, we would love to hear from you.",
				10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//div[@class='ql-editor ql-blank'])[1]")
	private WebElement responsiblitiesDutiesBox;

	public void enterResponsiblitiesDutiesText() {
		responsiblitiesDutiesBox.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtils.typeTextIntoElement(responsiblitiesDutiesBox,
				"Develop and implement test plans, test cases, and test scripts for software applications\r\n"
						+ "Execute manual and automated tests to identify bugs, defects, and performance issues\r\n"
						+ "Collaborate with software developers to identify and resolve issues in a timely manner\r\n"
						+ "Document and report test results and provide recommendations for improvements\r\n"
						+ "Stay up-to-date on industry best practices and emerging technologies in software testing",
				10);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//div[@class='ql-editor ql-blank'])[1]")
	private WebElement qualificationsSkillsBox;

	public void enterQualificationsSkillsText() {
		qualificationsSkillsBox.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtils.typeTextIntoElement(qualificationsSkillsBox,
				"Bachelor's degree in Computer Science, Engineering, or related field\r\n"
						+ "Proven experience in software testing and quality assurance\r\n"
						+ "Strong knowledge of software testing methodologies, tools, and techniques\r\n"
						+ "Experience with automated testing tools such as Selenium, JUnit, or TestNG\r\n"
						+ "Excellent problem-solving and analytical skills\r\n"
						+ "Strong communication and collaboration abilities",
				10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//div[@class='ql-editor ql-blank'])[1]")
	private WebElement benefitsBox;

	public void enterBenefitsText() {
		benefitsBox.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtils.typeTextIntoElement(benefitsBox, "Competitive salary and benefits package\r\n"
				+ "Opportunities for professional development and career growth\r\n"
				+ "Collaborative and supportive work environment\r\n" + "Flexible work arrangements\r\n"
				+ "Health and wellness programs\r\n" + "Company-sponsored social events and team-building activities",
				10);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//div[contains(@class,'grid grid-cols-1')]/following-sibling::div[1]/button")
	private WebElement updateDescBtn;

	public void clickOnUpdateDesc() {
		try {
			// Find the button element outside the iframe
			WebElement button = updateDescBtn;

			// Scroll to the button using JavaScript executor
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

			// Click the button
			button.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//div[text()='Job Descriptions are updated!']")
	private WebElement successDescMessage;

	public boolean verifySuccesfullyJobDescUpdated() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Retrieve the text of the success message
		String actualMessage = successDescMessage.getText();

		// Define the expected success message
		String expectedMessage = "Job Descriptions are updated!";

		if (actualMessage == expectedMessage) {
			return true;
		}
		return false;
	}

	@FindBy(xpath = "//button[contains(@class,'btn btn')]")
	public WebElement previewJobBtn;

	public void clickOnPreviewJobBtn() {
		elementUtils.clickOnElement(closeJobDetailsAlert, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.javascriptScrollIntoElement(previewJobBtn, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.clickOnElement(previewJobBtn, 10);
	}

	// preview job
	@FindBy(xpath = "//div[@class='px-6 py-8 ']//iframe[1]")
	private WebElement previewIframe;

	@FindBy(xpath = "//div[@class='card-body']//h2")
	private WebElement jobTitlePr;

	@FindBy(xpath = "//div[@class='card-body']//span[1]")
	private WebElement companyNamePr;

	@FindBy(xpath = "//div[@class='card-body']//span[3]")
	private WebElement jobDepartmentPr;

	@FindBy(xpath = "//div[@class='card-body']//a")
	private List<WebElement> jobTypesPr;

	@FindBy(xpath = "//div[@class='card-body']/p[2]")
	private WebElement jobIntroductionPr;

	@FindBy(xpath = "//div[@class='card-body']/h4")
	private List<WebElement> jobDescriptions;

	@FindBy(xpath = "//div[@class='mb-4']/h5")
	private List<WebElement> jobOpenExpiry;

	@FindBy(xpath = "//button[@class='text-[22px]']")
	private WebElement previewCloseBtn;

	public String verifyJobBasic() {
		// Switch to the iframe
		driver.switchTo().frame(previewIframe);

		StringBuilder verificationResult = new StringBuilder();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (jobTitlePr.isDisplayed()) {
			verificationResult.append("Job title is displayed");
		} else {
			verificationResult.append("Job title is not displayed");
		}

		if (companyNamePr.isDisplayed()) {
			verificationResult.append("Company name is displayed");
		} else {
			verificationResult.append("Company name is not displayed");
		}

		if (jobDepartmentPr.isDisplayed()) {
			verificationResult.append("Job department is displayed");
		} else {
			verificationResult.append("Job department is not displayed");
		}

		for (WebElement jobTypes : jobTypesPr) {
			if (jobTypesPr.contains(jobTypes)) {
				verificationResult.append("Job types are displayed");
			} else {
				verificationResult.append("Job types are not displayed");
			}
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.javascriptScrollIntoElement(jobIntroductionPr, 10);

		if (jobIntroductionPr.isDisplayed()) {
			verificationResult.append("Job introduction is displayed");
		} else {
			verificationResult.append("Job introduction is not displayed");
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.javascriptScrollIntoElement(jobDescriptions.get(0), 10);

		if (jobDescriptions.contains(jobDescriptions.get(0))) {
			verificationResult.append("Job responsibility is displayed");
		} else {
			verificationResult.append("Job responsibility is not displayed");
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.javascriptScrollIntoElement(jobDescriptions.get(1), 10);

		if (jobDescriptions.contains(jobDescriptions.get(1))) {
			verificationResult.append("Job Qualifications are displayed");
		} else {
			verificationResult.append("Job Qualifications are not displayed");
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.javascriptScrollIntoElement(jobDescriptions.get(2), 10);

		if (jobDescriptions.contains(jobDescriptions.get(2))) {
			verificationResult.append("Job Benefits are displayed");
		} else {
			verificationResult.append("Job Benefits are not displayed");
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (jobDescriptions.contains(jobDescriptions.get(3))) {
			verificationResult.append("About the company is displayed");
		} else {
			verificationResult.append("About the company is not displayed");
		}

		if (jobOpenExpiry.contains(jobOpenExpiry.get(0))) {
			verificationResult.append("Job Open date is displayed");
		} else {
			verificationResult.append("Job Open date is not displayed");
		}

		if (jobOpenExpiry.contains(jobOpenExpiry.get(1))) {
			verificationResult.append("Job expiry date is displayed");
		} else {
			verificationResult.append("Job expiry date is not displayed");
		}

		return verificationResult.toString();
	}

	public void closeJobPreviewPopup() {

		// Switch back to the main content
		driver.switchTo().defaultContent();

		// Create JavascriptExecutor instance
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll to the top of the page
		js.executeScript("window.scrollTo(0, 0);");

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		previewCloseBtn.click();
	}

	// Screening Interview Questions
	@FindBy(xpath = "//button[text()='Screening Interview Questions']")
	private WebElement scIntQuSec;

	public void selectScreenInterviewQuestion() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtils.clickOnElement(scIntQuSec, 10);
	}

	@FindBy(xpath = "//div[@class='select__input-container css-1fsrxng-Tr']")
	private WebElement addQuestionBoxField;

	@FindBy(id = "react-select-8-input")
	private WebElement addQuestionInputField;

	@FindBy(xpath = "//button[text()='Create Question']")
	private WebElement createQuestionBtn;

	@FindBy(xpath = "//div[contains(@class,'grid grid-cols-8')]//p")
	private List<WebElement> addedQuestions;

	public void addQuestions(String question_keyword) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.clickOnElement(addQuestionBoxField, 10);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.typeTextIntoElement(addQuestionInputField, question_keyword, 10);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		addQuestionInputField.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.clickOnElement(createQuestionBtn, 10);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean verifyAddedQuestions() {
		for (WebElement addedQuestion : addedQuestions) {
			if (addedQuestions.contains(addedQuestion)) {
				return true;
			}
		}
		return false;
	}

	@FindBy(id = "question")
	private WebElement writeQuestionTextField;

	public void writeQuestion() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.typeTextIntoElement(writeQuestionTextField, "Tell me about your previous work experience.", 10);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.clickOnElement(createQuestionBtn, 10);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean verifyWriteQuestions() {
		for (WebElement addedQuestion : addedQuestions) {
			if (addedQuestions.contains(addedQuestion)) {
				return true;
			}
		}
		return false;
	}

	// Assesments section
	@FindBy(xpath = "//button[text()='Assessments']")
	private WebElement assesmentSection;

	@FindBy(xpath = "(//div[@class='mt-6']//button)[1]")
	private WebElement perAddBtn;

	@FindBy(xpath = "(//div[@class='mt-6']//button)[2]")
	private WebElement cogAddBtn;

	@FindBy(xpath = "//div[text()='Assessment has been succesfully added to this job!']")
	private WebElement assesmentAddSuccess;

	@FindBy(xpath = "//div[text()='Assessment has been removed from this job!']")
	private WebElement assesmentRemoved;

	@FindBy(xpath = "//button[@aria-label='close']")
	public WebElement closeAlert;

	@FindBy(xpath = "(//div[@class='mt-6']//button)[1]")
	private WebElement removeAssessment;

	public void selectAssessments() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.clickOnElement(assesmentSection, 10);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addPersonalityAssessement() {
		elementUtils.clickOnElement(perAddBtn, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addCoginitiveAssessement() {
		elementUtils.clickOnElement(cogAddBtn, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String verifySuccessfullyAddAssessement() {
		return elementUtils.getTextFromElement(assesmentAddSuccess, 10);
	}

	public String verifySuccessfullyRemovedAssessement() {
		return elementUtils.getTextFromElement(assesmentRemoved, 10);
	}

	public void removeAssessment() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.clickOnElement(removeAssessment, 10);
	}

	// Publish & Share section
	@FindBy(xpath = "//button[text()='Publish & Share']")
	private WebElement publicAndShareSec;

	public void selectPublicShare() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtils.clickOnElement(publicAndShareSec, 10);
	}

	@FindBy(xpath = "(//button[contains(@class,'btn btn')])[2]")
	private WebElement publishNowBtn;

	@FindBy(xpath = "(//div[contains(@class,'px-4 py-3')]//button)[2]")
	private WebElement confirmPublishNowBtn;

	public void publishJob() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtils.clickOnElement(publishNowBtn, 10);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtils.clickOnElement(confirmPublishNowBtn, 10);
	}

	@FindBy(xpath = "//div[text()='Job Published succesfully!']")
	private WebElement successJobPublished;

	public String verifyJobPublishedSuccesfullyAlert() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return elementUtils.getTextFromElement(successJobPublished, 10);
	}

	@FindBy(xpath = "//button[text()='Copy']")
	private WebElement copyBtn;

	@FindBy(xpath = "//div[@class='col-span-3']//button[1]")
	private WebElement inviteViaPrivateEmailBtn;

	@FindBy(xpath = "(//button[@quote='Apply Now'])[1]")
	private WebElement twitter;

	@FindBy(xpath = "(//button[@quote='Apply Now'])[2]")
	private WebElement facebook;

	@FindBy(xpath = "(//button[@quote='Apply Now'])[3]")
	private WebElement linkedin;

	@FindBy(xpath = "//div[text()='Job URL copied succesfully!']")
	private WebElement copiedSuccessful;

	@FindBy(tagName = "h2")
	private WebElement inviteCandidateTitle;

	@FindBy(xpath = "//button[@class='text-[22px]']")
	public WebElement closeInvitePopup;

	public boolean visibleCopyOption() {
		return elementUtils.visibleTextFromElement(copyBtn, 10);
	}

	public String funcOfCopyOption() {
		elementUtils.clickOnElement(copyBtn, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return elementUtils.getTextFromElement(copiedSuccessful, 10);
	}

	public void closeInviteViaEmailPopup() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.clickOnElement(closeInvitePopup, 10);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean visibleInviteViaPrivateEmailOption() {
		return elementUtils.visibleTextFromElement(inviteViaPrivateEmailBtn, 10);
	}

	public boolean funcOfInviteViaPrivateEmail() {
		elementUtils.clickOnElement(inviteViaPrivateEmailBtn, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return elementUtils.visibleTextFromElement(inviteCandidateTitle, 10);
	}

	public boolean visibleShareWithTwitterOption() {
		return elementUtils.visibleTextFromElement(twitter, 10);
	}

	public boolean funcOfShareWithTwitter() {
		String firstWindow = driver.getWindowHandle();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.clickOnElement(twitter, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> itr = windows.iterator();

		while (itr.hasNext()) {
			String twitterWindow = itr.next();

			driver.switchTo().window(twitterWindow);

			if (driver.getTitle().equals("X")) {
				driver.close();
			}
		}

		driver.switchTo().window(firstWindow);

		return true;
	}

	public boolean visibleShareWithFaceBookOption() {
		return elementUtils.visibleTextFromElement(facebook, 10);
	}

	public boolean funcOfShareWithFaceBook() {
		String secondWindow = driver.getWindowHandle();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.clickOnElement(facebook, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> itr = windows.iterator();

		while (itr.hasNext()) {
			String facebookWindow = itr.next();

			driver.switchTo().window(facebookWindow);

			if (driver.getTitle().equals("Facebook")) {
				driver.close();
			}
		}

		driver.switchTo().window(secondWindow);

		return true;
	}

	public boolean visibleShareWithLinkedinOption() {
		return elementUtils.visibleTextFromElement(linkedin, 10);
	}

	public boolean funcOfShareWithLinkedin() {
		String thirdWindow = driver.getWindowHandle();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.clickOnElement(linkedin, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> itr = windows.iterator();

		while (itr.hasNext()) {
			String linkedinWindow = itr.next();

			driver.switchTo().window(linkedinWindow);

			if (driver.getTitle().equals(
					"LinkedIn Login, Sign in | LinkedIn")) {
				driver.close();
			}
		}

		driver.switchTo().window(thirdWindow);

		return true;
	}

	@FindBy(xpath = "//a[.='Jobs']")
	private WebElement jobsDash;

	public void goToJobsCategory() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.clickOnElement(jobsDash, 10);
		
		driver.navigate().refresh();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//span[text()='Published'])[1]")
	private WebElement publishedLabel;

	public String verifyLabelNameOfPublished() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return elementUtils.getTextFromElement(publishedLabel, 10);
	}

	// testing purpose
	@FindBy(xpath = "(//h4[@class='text-base'])[1]")
	public WebElement setj;

	@FindBy(xpath = "(//button[@role='tab'])[2]")
	public WebElement jd;

}
