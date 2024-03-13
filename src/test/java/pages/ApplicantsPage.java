package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class ApplicantsPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public ApplicantsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	// auto suggestion jobs
	@FindBy(xpath = "//div[@class='select-job__input-container css-1fsrxng-Tr']")
	private WebElement jobSearchField;

	@FindBy(id = "react-select-2-input")
	private WebElement jobSearchInputField;

	public void searchJobTitle(String job_title) {
		filterSearchBtn.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtils.clickOnElement(jobSearchField, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jobSearchInputField.sendKeys(job_title, Keys.ENTER);
	}

	// typed job's candidates
	@FindBy(xpath = "//div[@class='select-job__single-value css-1dimb5e-singleValue']")
	private WebElement jobTitleOfExistingTypedField;

	@FindBy(xpath = "//button[@class='text-[22px]']")
	private WebElement jobCardCloseBtn;

	@FindBy(xpath = "//div[contains(@class,'relative overflow-hidden')]//h2")
	private WebElement jobTitleOfSelectCandidate;

	@FindBy(xpath = "//div[@data-rbd-droppable-id='all-lists']//main//button")
	private List<WebElement> candidatesOfTypedJob;

	public boolean viewCandidate(int candidateIndex) {
		if (candidateIndex >= 0 && candidateIndex < candidatesOfTypedJob.size()) {
			WebElement candidate = candidatesOfTypedJob.get(candidateIndex);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			candidate.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String candidateJob = jobTitleOfSelectCandidate.getText();

			jobCardCloseBtn.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			String typedJob = jobTitleOfExistingTypedField.getText();

			return candidateJob.equals(typedJob);

		} else {
			System.out.println("Invalid candidate index provided");
		}
		return false;

	}

	// Jobs's status
	@FindBy(xpath = "(//span[@class='inline-flex items-center'])[1]")
	private WebElement jobStatusElement;

	public String getServiceStatus() {
		return elementUtils.getTextFromElement(jobStatusElement, 10);
	}

	public boolean verifyServiceStatus(String status) {
		String actualStatus = getServiceStatus();
		return actualStatus.equals(status);
	}

	// invite candidate
	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement inviteCandidateBtn;

	public void clickOnInviteCandidateBtn() {
		elementUtils.clickOnElement(inviteCandidateBtn, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//div[@class='dropdown__input-container css-1fsrxng-Tr']")
	private WebElement selectJobField;

	@FindBy(xpath = "//input[@class='dropdown__input']")
	private WebElement selectJobInputField;

	public void selectJobTitle(String currently_active_job) {
		elementUtils.clickOnElement(selectJobField, 10);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selectJobInputField.sendKeys(currently_active_job);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		elementUtils.autoSuggestion(selectJobInputField, 10);
	}

	@FindBy(name = "name")
	private WebElement candidateName;

	public void typeCandidateName(String candidate_name) {
		candidateName.sendKeys(candidate_name);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(name = "email")
	private WebElement candidateEmail;

	public void typeCandidateEmail(String candidate_email) {
		candidateEmail.sendKeys(candidate_email);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//button[text()='Invite']")
	private WebElement inviteBtn;

	public void clickOnInviteBtn() {
		elementUtils.clickOnElement(inviteBtn, 10);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//tbody[contains(@class,'bg-white divide-y')]//tr[1]//p")
	private WebElement statusOfCandidateEmail;

	@FindBy(xpath = "//tbody[contains(@class,'bg-white divide-y')]//tr[1]//span/span")
	private WebElement statusOfCandidateInvited;

	public String getCandidateEmailStatus() {
		return statusOfCandidateEmail.getText();
	}

	public boolean verifyCandidateEmailStatus(String candidate_email) {
		String actualStatus = getCandidateEmailStatus();
		return actualStatus.equals(candidate_email);
	}

	public String getCandidateInvitedStatus() {
		return statusOfCandidateInvited.getText();
	}

	public boolean verifyCandidateInvitedStatus(String candidate_status) {
		String actualStatus = getCandidateInvitedStatus();
		return actualStatus.equals(candidate_status);
	}

	public void closeInviteCandidatePopup() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtils.clickOnElement(jobCardCloseBtn, 10);
	}

	// Search candidates
	@FindBy(xpath = "//input[@type='react-text text']")
	private WebElement candidateSearchField;

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void searchCandidate(String search_candidate) {
		elementUtils.typeTextIntoElement(candidateSearchField, search_candidate, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//div[contains(@class,'flex space-x-0')])//div[contains(@class,'px-2 py-4 h-full space-y-1  false')]//button[@title='View Details']")
	private List<WebElement> searchResults;

	public boolean showSearchedResult() {
		for (WebElement searchResult : searchResults) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return searchResults.contains(searchResult);
		}
		return false;
	}

	// Filter flow
	@FindBy(xpath = "//div[@class='select__input-container css-1fsrxng-Tr']")
	private WebElement filterSearchField;

	public void filterOptionsByDate() {
		elementUtils.autoSuggestion(filterSearchField, 10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//button[contains(@class,'btn btn')])[2]")
	private WebElement filterSearchBtn;

	public void clickFilterSearchBtn() {
		elementUtils.clickOnElement(filterSearchBtn, 10);
	}

	@FindBy(xpath = "(//div[@role='button'])//button[@class='truncate']")
	public List<WebElement> appliedCandidates;

	public List<String> getFirstFiveCandidateNames() {
		List<String> candidates = new ArrayList<>();
		List<WebElement> candidateElements = appliedCandidates;
		for (int i = 0; i < 5 && i < candidateElements.size(); i++) {
			candidates.add(candidateElements.get(i).getText().trim());
		}
		return candidates;
	}

	@FindBy(xpath = "(//div[contains(@class,'w-[210px] flex-none')])[2]//span[@class='inline-flex items-center']")
	private List<WebElement> appliedScores;

	@FindBy(xpath = "(//div[contains(@class,'w-[210px] flex-none')])[3]//span[@class='inline-flex items-center']")
	private List<WebElement> qualifiedScores;

	@FindBy(xpath = "(//div[contains(@class,'w-[210px] flex-none')])[4]//span[@class='inline-flex items-center']")
	private List<WebElement> firstInterviewedScores;

	@FindBy(xpath = "(//div[contains(@class,'w-[210px] flex-none')])[5]//span[@class='inline-flex items-center']")
	private List<WebElement> secondInterviewedScores;

	@FindBy(xpath = "(//div[contains(@class,'w-[210px] flex-none')])[6]//span[@class='inline-flex items-center']")
	private List<WebElement> offeredScores;
	
	public List<Float> getScores(List<WebElement> scoreElements) {
        List<Float> scores = new ArrayList<>();
        for (WebElement element : scoreElements) {
            float score = Float.parseFloat(element.getText());
            scores.add(score);
        }
        return scores;
    }
	
	public List<Float> getAppliedScores() {
        return getScores(appliedScores);
    }

    public List<Float> getQualifiedScores() {
        return getScores(qualifiedScores);
    }

    public List<Float> getFirstInterviewedScores() {
        return getScores(firstInterviewedScores);
    }

    public List<Float> getSecondInterviewedScores() {
        return getScores(secondInterviewedScores);
    }

    public List<Float> getOfferedScores() {
        return getScores(offeredScores);
    }
    
    public boolean verifyScoresSorted(List<Float> scores) {
        for (int i = 0; i < scores.size() - 1; i++) {
            if (scores.get(i) < scores.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

	// Last job's statistic
	@FindBy(xpath = "(//div[contains(@class,'relative flex')])[2]//span")
	private WebElement appliedStatistic;

	@FindBy(xpath = "(//div[contains(@class,'relative flex')])[3]//span")
	private WebElement qualifiedStatistic;

	@FindBy(xpath = "(//div[contains(@class,'relative flex')])[4]//span")
	private WebElement firstInterviewStatistic;

	@FindBy(xpath = "(//div[contains(@class,'relative flex')])[5]//span")
	private WebElement secondInterviewStatistic;

	@FindBy(xpath = "(//div[contains(@class,'relative flex')])[6]//span")
	private WebElement offeredStatistic;

	public int totalApplicant() {
		int totalApplied = Integer.parseInt(appliedStatistic.getText());
		int totalQualified = Integer.parseInt(qualifiedStatistic.getText());
		int totalFirstInterview = Integer.parseInt(firstInterviewStatistic.getText());
		int totalSecondInterview = Integer.parseInt(secondInterviewStatistic.getText());
		int totalOffered = Integer.parseInt(offeredStatistic.getText());

		int totalApplicants = totalApplied + totalQualified + totalFirstInterview + totalSecondInterview + totalOffered;

		return totalApplicants;
	}

	public int totalQualified() {
		return Integer.parseInt(qualifiedStatistic.getText());
	}

	public int totalInterviewed() {
		int totalFirstInterview = Integer.parseInt(firstInterviewStatistic.getText());
		int totalSecondInterview = Integer.parseInt(secondInterviewStatistic.getText());
		int totalOffered = Integer.parseInt(offeredStatistic.getText());

		int totalIntervieweds = totalFirstInterview + totalSecondInterview + totalOffered;

		return totalIntervieweds;
	}

	public DashboardPage navigateBack() {
		driver.navigate().back();
		return new DashboardPage(driver);
	}
	
	// In progress section candidate
	@FindBy(xpath = "(//div[@data-rbd-draggable-context-id='0'])[1]//main")
	private WebElement inProgressFirstCandidate;
	
	public void clickOnInProgressFirstCandidate() {
		elementUtils.clickOnElement(inProgressFirstCandidate, 10);
	}
	
	@FindBy(xpath = "//main[@class='card-body p-6']//h4")
	private WebElement inProgressCandidateName;
	
	@FindBy(xpath = "(//div[@class='card-subtitle mt-0'])/strong")
	private List<WebElement> EmailPhoneLocation;
	
	public boolean verifyCandidateNameAndReleventDetails() {
		inProgressCandidateName.isDisplayed();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(WebElement EmailPhoneLocationOptions : EmailPhoneLocation) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return EmailPhoneLocation.contains(EmailPhoneLocationOptions);
		}
		return false;
	}
	
	@FindBy(xpath = "//div[contains(@class,'flex-2 flex')]/button")
	private List<WebElement> linkedinSendReminder;
	
	public boolean verifyLinkedinSendReminderOptions() {
		for(WebElement linkedinSendReminderOptions : linkedinSendReminder) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return linkedinSendReminder.contains(linkedinSendReminderOptions);
		}
		return false;
	}
	
	@FindBy(xpath = "//button[@class='text-[22px]']")
	public WebElement inProgressPopupClose;
	
	public void closeInProgressPopup() {
		driver.findElement(By.xpath("//button[@class='text-[22px]']")).click();
	}
	
	// without in progress section candidate
	@FindBy(xpath = "//div[@data-rbd-droppable-id='S']/div[1]")
	private WebElement appliedFirstCandidate;
	
	public void clickOnAppliedFirstCandidate() {
		elementUtils.clickOnElement(appliedFirstCandidate, 10);
	}
	
	@FindBy(xpath = "(//main[@class='card-body p-6']//div)[1]//p")
	private List<WebElement> technologiesAndAbout;
	
	public boolean verifyTechnologiesAndAboutOfCandidate() {
		for(WebElement technologyAndAbout : technologiesAndAbout) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return technologiesAndAbout.contains(technologyAndAbout);
		}
		return false;
	}
	
	@FindBy(xpath = "(//main[@class='card-body p-6']//div)[1]//button")
	private List<WebElement> resumeLinkedinBookmark;
	
	public boolean verifyResumeLinkedinBookmarkOfCandidate() {
		for(WebElement ResumeLinkedinBookmark : resumeLinkedinBookmark) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return resumeLinkedinBookmark.contains(ResumeLinkedinBookmark);
		}
		return false;
	}
	
	@FindBy(xpath = "(//div[@role='button'])[1]//main//span[@class='inline-flex items-center']")
	private WebElement selectCandidateScore;

	@FindBy(xpath = "//span[contains(@class,'block mb-')]")
	private WebElement popupCandidateScore;
	
	public boolean verifyCandidatesScore() {
		if(selectCandidateScore.getText().equals(popupCandidateScore.getText())) {
			return true;
		}
		return false;
	}
	
	// Personality
	@FindBy(xpath = "(//main[@class='card-body p-6'])[2]/span/span")
	private List<WebElement> personalityAssesments;
	
	public boolean verifyPersonalityAssesments() {
		for(WebElement personalityAssesment : personalityAssesments) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return personalityAssesments.contains(personalityAssesment);
		}
		return false;
	}
	
	// Cognitive Skills
	@FindBy(xpath = "(//main[@class='card-body p-6'])[3]//strong")
	private List<WebElement> cognitiveSkillsAssesments;
		
	public boolean verifyCognitiveSkillsAssesments() {
		for(WebElement cognitiveSkillsAssesment : cognitiveSkillsAssesments) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
			return cognitiveSkillsAssesments.contains(cognitiveSkillsAssesment);
		}
		return false;
	}
	
	// Screening Interview
	@FindBy(xpath = "(//main[@class='card-body p-6'])[4]//video")
	private List<WebElement> screeningInterviews;
	
	public boolean verifyScreeningInterviews() {
		for(WebElement screeningInterview : screeningInterviews) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return screeningInterviews.contains(screeningInterview);
		}
		return false;
	}
	
	// Profile
	@FindBy(xpath = "(//main[@class='card-body p-6'])[5]/div/header")
	private List<WebElement> profiles;
	
	public boolean verifyProfiles() {
		for(WebElement profile : profiles) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return profiles.contains(profile);
		}
		return false;
	}
	
}
