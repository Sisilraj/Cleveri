package pages;

import java.util.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class DashboardPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	// dashboard title
	@FindBy(xpath = "(//div[text()='Dashboard'])[2]")
	private WebElement dashboardTitle;

	public void verifyDashBoardTitleInDashboardPage() {
		dashboardTitle.getText().equalsIgnoreCase("Dashboard");
	}
	
	// dashboard nav bar
	@FindBy(xpath = "(//div[@class='simplebar-content']//li)[3]")
	private WebElement applicantsOptions;
	
	public ApplicantsPage clickOnApplicantsOption() {
		elementUtils.clickOnElement(allCandidatesForRA, 10);
		return new ApplicantsPage(driver);
	}
	
	@FindBy(xpath = "(//div[@class='simplebar-content']//li)[5]")
	private WebElement organizationOptions;
	
	public OrganizationPage clickOnOrganizationOption() {
		elementUtils.clickOnElement(organizationOptions, 10);
		return new OrganizationPage(driver);
	}
	
	@FindBy(xpath = "(//div[@class='simplebar-content']//li)[6]")
	private WebElement clientsOptions;
	
	public ClientsPage clickOnClientsOption() {
		elementUtils.clickOnElement(clientsOptions, 10);
		return new ClientsPage(driver);
	}

	// Recent Applications section
	@FindBy(xpath = "//table[contains(@class,'min-w-full divide-y')]")
	private WebElement recentAppSection;

	public void scrollIntoRecentApplicationsSection() {
		elementUtils.javascriptScrollIntoElement(recentAppSection, 10);
	}

	// Top five recent applicants
	@FindBy(xpath = "(//tbody[contains(@class,'bg-white divide-y')])[1]//h4")
	private List<WebElement> topFiveRecentApplications;

	@FindBy(xpath = "(//a[@class='black'])[1]")
	private WebElement allCandidatesForRA;

	public ApplicantsPage clickOnAllCandidatesOptionInDashboard() {
		elementUtils.clickOnElement(allCandidatesForRA, 10);
		return new ApplicantsPage(driver);
	}
	
	public List<String> getRecentlyAppliedCandidates() {
        List<String> candidates = new ArrayList<>();
        List<WebElement> candidateElements = topFiveRecentApplications;
        for (WebElement element : candidateElements) {
            candidates.add(element.getText().trim().split(" ")[0]);
        }
        return candidates;
    }

	// Top performance section
	@FindBy(xpath = "//h6[text()='Top Performences']")
	private WebElement topPerformanceSection;

	public void scrollIntoTopPerformanceSection() {
		elementUtils.javascriptScrollIntoElement(topPerformanceSection, 10);
	}
	
	@FindBy(xpath = "(//tbody[contains(@class,'bg-white divide-y')])[2]//span/span")
	private List<WebElement> topPerformanceScores;
	
	public boolean getTopPerformanceScores() {
		List<Double> scores = new ArrayList<>();
        boolean isDescending = true;

        for (WebElement element : topPerformanceScores) {
            String scoreText = element.getText().replace("%", "").trim();
            double score = Double.parseDouble(scoreText);
            scores.add(score);
        }
        
        // Sort scores in descending order
        Collections.sort(scores, Collections.reverseOrder());

        for (int i = 1; i < scores.size(); i++) {
            if (scores.get(i) > scores.get(i - 1)) {
            	isDescending = false;
                break;
            }
        }

        if (isDescending) {
            return true;
        }
		return isDescending;
    }

	// Published Jobs
	@FindBy(xpath = "//h6[text()='Published Jobs']")
	private WebElement publishedJobSection;

	public void scrollIntoPublishedJobsSection() {
		elementUtils.javascriptScrollIntoElement(publishedJobSection, 10);
	}

	@FindBy(xpath = "(//main[@class='card-body p-6']//a)[1]")
	private WebElement firstPublishedJob;

	public void scrollIntoFirstPublishedJob() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
	}

	public ApplicantsPage clickOnOnePublishedJobInDashboard() {
		elementUtils.clickOnElement(firstPublishedJob, 10);
		return new ApplicantsPage(driver);
	}

	// first Published Jobs
	@FindBy(xpath = "(//div[@class='mt-8'])[1]//div[4]")
	private WebElement firstPublishedJobOfApplicantsStatistic;
	
	public int getFirstPublishedJobOfApplicantsStatisticValue() {
		return Integer.parseInt(firstPublishedJobOfApplicantsStatistic.getText());
	}

	@FindBy(xpath = "(//div[@class='mt-8'])[1]//div[5]")
	private WebElement firstPublishedJobOfQualifiedStatistic;
	
	public int getFirstPublishedJobOfQualifiedStatisticValue() {
		return Integer.parseInt(firstPublishedJobOfQualifiedStatistic.getText());
	}

	@FindBy(xpath = "(//div[@class='mt-8'])[1]//div[6]")
	private WebElement firstPublishedJobOfInterviewedStatistic;

	public int getFirstPublishedJobOfInterviewedStatisticValue() {
		return Integer.parseInt(firstPublishedJobOfInterviewedStatistic.getText());
	}

	@FindBy(xpath = "(//div[@class='mt-8'])//a")
	private List<WebElement> publishedJobs;
	
	// Jobs nav
	@FindBy(xpath = "(//a[@class='menu-link'])[2]")
	private WebElement jobsNav;
		
	public JobsPage clickOnJobs() {
		elementUtils.clickOnElement(jobsNav, 10);
		return new JobsPage(driver);
	}

}
