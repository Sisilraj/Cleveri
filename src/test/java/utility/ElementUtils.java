package utility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}

	public void clickOnElement(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);

		webElement.click();

	}

	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);

		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);

	}

	public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);

		Select select = new Select(webElement);
		select.selectByVisibleText(dropDownOption);

	}

	public void acceptAlert(long durationInSeconds) {
		
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();

	}
	
	public void dismissAlert(long durationInSeconds) {
		
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();

	}

	public Alert waitForAlert(long durationInSeconds) {
		Alert alert = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return alert;

	}
	
	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityElemet(element, durationInSeconds);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
		
	}
	
	public void autoSuggestion(WebElement element, long durationInSeconds) {
			
		WebElement webElement = waitForVisibilityElemet(element, durationInSeconds);
			
		Actions actions = new Actions(driver);
		actions.sendKeys(webElement, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			
	}
	
	public void autoSuggestionWithName(WebElement element, String textToBeTyped, long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityElemet(element, durationInSeconds);
			
		Actions actions = new Actions(driver);
		webElement.sendKeys(textToBeTyped);
		actions.sendKeys(webElement, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			
	}
	
	public WebElement waitForVisibilityElemet(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
	}
	
	public void javascriptScrollIntoElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisibilityElemet(element, durationInSeconds);
		
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].scrollIntoView();", webElement);
	}
	
	public void javascriptClick(WebElement element, long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityElemet(element, durationInSeconds);
		
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", webElement);
		
	}
	
	public void javascriptType(WebElement element, String textToBeTyped, long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityElemet(element, durationInSeconds);
		
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value = '"+textToBeTyped+"'", webElement);
	}
	
	public boolean visibleTextFromElement(WebElement element, long durationInSeconds) {
		
		try {
			WebElement webElement = waitForVisibilityElemet(element, durationInSeconds);
			return webElement.isDisplayed();
		}catch (Throwable e) {
			return false;
		}
	}
	
	public String getTextFromElement(WebElement element, long durationInSeconds) {
		
		WebElement webElement = waitForElement(element, durationInSeconds);
		
		return webElement.getText();
		
	}

}
