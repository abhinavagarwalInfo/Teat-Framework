
package awesomecucumber.pages;

import awesomecucumber.utils.ConfigLoader;
import org.openqa.selenium.*;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static awesomecucumber.constants.FrameworkConstants.ATTRIBUTE_VALUE;
import static awesomecucumber.constants.FrameworkConstants.EXPLICIT_WAIT;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		PageFactory.initElements(driver, this);
	}

	public void load(String endPoint) {
		driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
	}

	public String getURL(){
		return driver.getCurrentUrl();
	}

	public void waitForOverlaysToDisappear(By overlay) {
		List<WebElement> overlays = driver.findElements(overlay);
		System.out.println("OVERLAY SIZE" + overlays.size());
		if (overlays.size() > 0) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAYS INVISIBLE");
		} else {
			System.out.println("OVERLAY NOT FOUND");
		}
	}

	public void clearAndSendKeys(WebElement element, String value) {
		element = waitForElementVisibility(element);
		element.clear();
		element.sendKeys(value);
	}

	public void click(WebElement element) {
		waitForElementToBeClickable(element).click();
	}

	public void click(By by) {
		waitForElementToBeClickable(by).click();
	}

	public WebElement waitForElementVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public Boolean waitForElementInvisibility(WebElement element) {
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public Boolean waitForTextToBePresentInElement(WebElement element, String text){
		return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public Alert waitForAlertIsPresent(){
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void clearLocalStorage(){
		LocalStorage ls = ((WebStorage)driver).getLocalStorage();
		ls.clear();
		sleep(1000);
		driver.navigate().refresh();
	}

	public void sleep(int sTime){
		try{
			Thread.sleep(sTime);
		}catch(InterruptedException e){
			System.out.println(e);
		}
	}

	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForElementToBeClickable(By by) {
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getElementText(WebElement element) {
		return waitForElementVisibility(element).getText();
	}

	public String getElementElementAttribute_Value(WebElement element) {
		return waitForElementVisibility(element).getAttribute(ATTRIBUTE_VALUE);
	}

	public String getElementElementCustomAttribute(WebElement element, String customAttribute) {
		return waitForElementVisibility(element).getAttribute(customAttribute);
	}

	public void scrollDownByDefiningNumberOfPixels(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)", "");
	}

	public void ByVisibleElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollDownToBottom(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public boolean isElementPresent(WebElement we){
		try{
			driver.findElement((By) we);
			return true;
		}catch (NoSuchElementException e){
			return false;
		}
	}

	public boolean isElementDisplayed(WebElement e){
		return driver.findElement((By) e).isDisplayed();
	}
}
