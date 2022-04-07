package com.viacom.web.utils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
 import com.viacom.web.pages.SigninVootPageV3;

import io.appium.java_client.AppiumDriver;
import io.restassured.response.Response;

/**
 * @author Sachin M H : IFOCUS
 */
public class EventUtils extends BaseTestWeb {

	public EventUtils(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/**
	 * get element Text using WebElement
	 */
	public String getText(WebElement element, int timeOut) {
		String text = null;
		if (waitUntilElementIsPresent(element, timeOut)) {
			text = element.getAttribute("innerText");
			System.out.println("Text Of The Element:-" + text);
			event.log( "INFO", "Text of the element is:- " + text);

		} else {
			event.log( "ERROR/WOSS", "Unable to get the text of the element due to element not present");
		}
		return text;
	}

	/**
	 * getElement attribute value using Xpath
	 */
	public String getText(String xpath, int timeOut) {
		String text = null;
		if (waitUntilElementIsPresent(getElement(xpath), timeOut)) {
			text = getElement(xpath).getAttribute("innerText");
			System.out.println("Text Of The Element:-" + text);
			event.log( "INFO", "Text of the element is:- " + text);
		} else {
			event.log( "ERROR/WOSS", "Unable to get the text of the element due to element not present");
		}
		return text;
	}

	/**
	 * getElement attribute value using Element
	 */
	public String getAttributeValue(WebElement element, int timeOut, String attributeValue) {
		String text = null;
		if (waitUntilElementIsPresent(element, timeOut)) {
			text = element.getAttribute(attributeValue);
			System.out.println("Text Of The Element:-" + text);
			event.log( "INFO", "Text of the element is:- " + text);
		} else {
			event.log( "ERROR/WOSS", "Unable to get the text of the element due to element not present");
		}
		return text;
	}

	/**
	 * getElement attribute value using Xpath
	 */
	public String getAttributeValue(String xpath, int timeOut, String attributeName) {
		String text = null;
		if (waitUntilElementIsPresent(getElement(xpath), timeOut)) {
			text = driver.findElement(By.xpath(xpath)).getAttribute(attributeName);
			System.out.println("Text Of The Element:-" + text);
			event.log( "INFO", "Text of the element is:- " + text);
		} else {
			event.log( "ERROR/WOSS", "Unable to get the text of the element due to element not present");
		}
		return text;
	}

	/**
	 * used to click on element using WebElement
	 */
	public void clickOnElement(WebElement elementToClick, String typeOfElement, int timeOut) {
		boolean isElementClicked = false;
		if (elementToClick != null) {
			scrollToParticularElement(elementToClick);
			if (waitUntilElementIsVisible(elementToClick, timeOut)) {
				if (waitUntilElememtIsClickable(elementToClick, timeOut)) {
					try {
						// elementToClick.click();
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementToClick);
						isElementClicked = true;
					} catch (StaleElementReferenceException | ElementClickInterceptedException ECIR) {
						wait(1);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementToClick);
						isElementClicked = true;
					} catch (Exception e) {
						isElementClicked = false;
					}
				} else {
					event.log( "INFO", typeOfElement + " is not clickable waiting till " + timeOut + " seconds");
				}
			} else {
				event.log( "INFO", typeOfElement + " is not visible waiting till " + timeOut + " seconds");
			}
		} else {
			event.log( "INFO", "Not able to find the element");
		}
		if (isElementClicked) {
			event.log( "INFO", "User clicked on " + typeOfElement);
		} else {
			event.log( "ERROR/WOSS", "User unable to click on " + typeOfElement);
		}
	}

	/**
	 * used to click on element using Xpath
	 */
	public void clickOnElement(String xpath, String typeOfElement, int timeOut) {
		boolean isElementClicked = false;
		if (getElement(xpath) != null) {
			scrollToParticularElement(getElement(xpath));
			if (waitUntilElementIsVisible(getElement(xpath), timeOut)) {
				if (waitUntilElememtIsClickable(getElement(xpath), timeOut)) {
					try {
						// elementToClick.click();
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(xpath));
						isElementClicked = true;
					} catch (StaleElementReferenceException | ElementClickInterceptedException ECIR) {
						wait(1);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(xpath));
						isElementClicked = true;
					} catch (Exception e) {
						isElementClicked = false;
					}
				} else {
					event.log( "INFO", typeOfElement + " is not clickable waiting till " + timeOut + " seconds");
				}
			} else {
				event.log( "INFO", typeOfElement + " is not visible waiting till " + timeOut + " seconds");
			}

		} else {
			event.log( "INFO", "Not able to find the element");
		}
		if (isElementClicked) {
			event.log( "INFO", "User clicked on " + typeOfElement);
		} else {
			event.log( "ERROR/WOSS", "User unable to click on " + typeOfElement);
		}
	}

	/**
	 * used to send values using WebElement
	 */
	public void enterValue(WebElement element, String valueToEnter, String typeOfField, int timeOut) {
		boolean isValueEntered = false;
		if (element != null) {
			if (waitUntilElementIsPresent(element, 20)) {
				scrollToParticularElement(element);
				if (waitUntilElementIsVisible(element, timeOut)) {
					if (waitUntilElememtIsClickable(element, timeOut)) {
						try {
							element.clear();
							element.sendKeys(valueToEnter);
							isValueEntered = true;
						} catch (Exception e) {
							event.log( "ERROR/WOSS", "Unable to enter the value due to exception:-" + e);
						}
					} else {
						event.log( "ERROR/WOSS",
								typeOfField + " is not clickable waiting till " + timeOut + " seconds");
					}
				} else {
					event.log( "ERROR/WOSS", typeOfField + " is not visible waiting till " + timeOut + " seconds");
				}
			}
		} else {
			event.log( "ERROR/WOSS", "Not able to find the element" + typeOfField);
		}
		if (isValueEntered) {
			event.log( "INFO", "User entered the value :-  " + valueToEnter + " in " + typeOfField);
		} else {
			event.log( "ERROR/WOSS", "User unable to enter " + valueToEnter + " in " + typeOfField);
		}
	}

	/**
	 * used to send values using Xpath
	 */

	public void enterValue(String Xpath, String valueToEnter, String typeOfField, int timeOut) {
		boolean isValueEntered = false;
		WebElement element = getElement(Xpath);
		if (getElement(Xpath) != null) {
			if (waitUntilElementIsPresent(element, 20)) {
				scrollToParticularElement(element);
				if (waitUntilElementIsVisible(element, timeOut)) {
					if (waitUntilElememtIsClickable(element, timeOut)) {
						try {
							element.clear();
							element.sendKeys(valueToEnter);
							isValueEntered = true;
						} catch (Exception e) {
							event.log( "ERROR/WOSS", "Unable to enter the value due to exception:-" + e);
						}
					} else {
						event.log( "ERROR/WOSS",
								typeOfField + " is not clickable waiting till " + timeOut + " seconds");
					}
				} else {
					event.log( "ERROR/WOSS", typeOfField + " is not visible waiting till " + timeOut + " seconds");
				}
			}
		} else {
			event.log( "ERROR/WOSS", "Not able to find the element" + typeOfField);
		}
		if (isValueEntered) {
			event.log( "INFO", "User entered the value :-  " + valueToEnter + " in " + typeOfField);
		} else {
			event.log( "ERROR/WOSS", "User unable to enter " + valueToEnter + " in " + typeOfField);
		}
	}
	
	
	public void switchToLatestWindow(RemoteWebDriver driver) {
		BaseTestWeb.logger.info("Switching to latest window");
		Set<String> windows = driver.getWindowHandles();
		for (String winHandle : windows) {
			driver.switchTo().window(winHandle);
			BaseTestWeb.logger.info("Switched to latest window");
		}
	}

	/**
	 * used to refresh current page
	 */

	public void refreshPage() {
		boolean isPageRefresh = false;
		try {
			if (driver != null) {
				driver.navigate().refresh();
				isPageRefresh = true;
				event.log( "INFO", "Page refreshed ");
			}
		} catch (Exception e) {
		}
		if (!isPageRefresh) {
			event.log( "ERROR/WOSS", "Unable to refresh the page");
		}
	}

	/**
	 * used to navigate back
	 */
	public void navigateBack() {
		try {
			driver.navigate().back();
			event.log( "INFO", "Navigated to back ");
		} catch (Exception e) {
			e.printStackTrace();
			event.log( "ERROR/WOSS", "Unable to navigate back");
		}
	}

	/**
	 * used to navigate particular url
	 */
	public void navigateToGivenUrl(String url) {
		try {
			driver.navigate().to(url);
			event.log( "INFO", "user Navigated to  : " + url);
		} catch (Exception e) {
			e.printStackTrace();
			event.log( "ERROR/WOSS", "Unable to navigate specified url");
		}
	}

	/**
	 * used to click the element using Action class
	 */
	public void moveToElementAndClick(WebElement element, String typeOfElement, int timeOut) {
		boolean isElementClicked = false;
		if (element != null) {
			if (waitUntilElementIsVisible(element, timeOut)) {
				if (waitUntilElememtIsClickable(element, timeOut)) {
					try {
						Actions act = new Actions(driver);
						act = act.moveToElement(element);
						act.click().build().perform();
						isElementClicked = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					event.log( "INFO", typeOfElement + " is not clickable waiting till " + timeOut + " seconds");
				}
			} else {
				event.log( "INFO", typeOfElement + " is not visible waiting till " + timeOut + " seconds");
			}
		} else {
			event.log( "INFO", "Unable to find the element:-" + typeOfElement);
		}
		if (isElementClicked) {
			event.log( "INFO", "User clicked on " + typeOfElement);
		} else {
			event.log( "ERROR/WOSS", "User unable click " + typeOfElement);
		}
	}

 
	/**
	 * used to check the element in DOM of the page , argument element and timeOut :: return - boolean
	 */
	public boolean waitUntilElementIsPresent(WebElement element, int timeout) {
		boolean isElementPresent = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementPresent = true;
		} catch (Exception e) {
			isElementPresent = false;
			e.printStackTrace();
		}
		return isElementPresent;
	}

	/**
	 * used to check the element in DOM of the page, argument element and timeOut :: return - boolean
	 */
	public boolean waitUntilElememtIsClickable(WebElement element, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			isElementEnabled = false;
		}
		return isElementEnabled;
	}

	/**
	 * used to check the element in DOM of the page, argument element and timeOut :: return - boolean
	 */
	public boolean waitUntilElementIsVisible(WebElement element, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			isElementEnabled = false;
		}
		return isElementEnabled;
	}

	/**
	 * used to check the element in DOM of the page, argument Xpath and timeOut :: return - boolean
	 */
	public boolean waitUntilElementIsPresent(String xpath, int timeout) {
		boolean isElementPresent = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(getElement(xpath)));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementPresent = true;
		} catch (Exception e) {
			isElementPresent = false;
			e.printStackTrace();
		}
		return isElementPresent;
	}

	/**
	 * used to check the element in DOM of the page, argument Xpath and timeOut :: return - boolean
	 */
	public boolean waitUntilElememtIsClickable(String xpath, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(getElement(xpath)));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
 			isElementEnabled = false;
		}
		return isElementEnabled;
	}

	/**
	 * used to check the element in DOM of the page, argument Xpath and timeOut  :: return - boolean
	 */
	public boolean waitUntilElementIsVisible(String xpath, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(getElement(xpath)));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			isElementEnabled = false;
		}
		return isElementEnabled;
	}

	/**
	 * used to return WebElement - argument Xpath
	 */
	public WebElement getElement(String Xpath) {
		waitUntilElememtIsClickable(driver.findElement(By.xpath(Xpath)), 500);
		return driver.findElement(By.xpath(Xpath));
	}

//	 * General methods
	
	/**
	 *  Compare two string 
	 */
	public boolean compareTwoString(String string1, String string2)
	{
		return string1.equals(string2);
	}
	
	/**
	 *  Compare two string with equalsIgnoreCase
	 */
	public boolean compareTwoStringWithEqualignoreCase(String string1, String string2)
	{
		return string1.equalsIgnoreCase(string2);
	}

	/**
	 * used to check element using Xpath ,displayed or not in DOM
	 */
	public boolean IsDiplayed(String xpath) {
		return getElement(xpath).isDisplayed();
	}

	/**
	 * used to check element using Xpath ,enabled or not in DOM
	 */
	public boolean IsEnabled(String xpath) {
		return getElement(xpath).isEnabled();
	}

	/**
	 * used to check element using Xpath ,selected or not in DOM
	 */
	public boolean IsSelected(String xpath) {
		return getElement(xpath).isSelected();
	}

	/**
	 * used to check element selected or not in DOM
	 */
	public boolean IsDiplayed(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * used to check element Enabled or not in DOM
	 */
	public boolean IsEnabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * used to check element Selected or not in DOM
	 */
	public boolean IsSelected(WebElement element) {
		return element.isSelected();
	}

	/**
	 * used to send values using xpath
	 */
	public void doSendKeys(String xpath, String value) {
		WebElement ele = getElement(xpath);
		ele.click();
		ele.clear();
		ele.sendKeys(value);
	}

	/**
	 * used to send values using element
	 */
	public void doSendKeys(WebElement element, String value) {
		element.clear();
		 
		element.click();
		element.sendKeys(value);
	}
	
	public void clearInputField(WebElement element)
	{
		element.click();
		String c=Keys.BACK_SPACE.toString();	
		element.sendKeys(c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c+c);
		
	}

	/**
	 * used to get Current URL
	 */
	public String getCurrentUrl() {
		event.log( "INFO", "Current Page Url:-" + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}

	/**
	 * used to generate random email returns email in string
	 */
	public String generateRandomEmailId() {
		String strRandom = "";
		String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbeewfde";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 4; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();
		String email = strRandom + strRandom + "@" + "grr" + ".la";
		event.log( "INFO", "Randomly generated Email Id is:  " + email);
		return email;
	}

	/**
	 * used to generate random Password returns Password in string
	 */
	public String generateRandomPassword() {
		String strRandom = "";

		String strAlpha = "abcdefghijklmnopqrstuvwxyzacvbe";
		String strNumerics = "0123456789";
		String strcharacters = "#$@~+()%<>{}&*?";
		Random rnd = new Random();
		StringBuilder strRandomcharcter = new StringBuilder(9);
		StringBuilder strRandomNumber = new StringBuilder(9);
		StringBuilder strRandomAlpha = new StringBuilder(9);
		for (int i = 0; i < 4; i++) {
			strRandomAlpha.append(strAlpha.charAt(rnd.nextInt(strAlpha.length())));
			strRandomNumber.append(strNumerics.charAt(rnd.nextInt(strNumerics.length())));
		}
		strRandomcharcter.append(strcharacters.charAt(rnd.nextInt(strcharacters.length())));

		String capStr = strRandomAlpha.substring(0, 1).toUpperCase() + strRandomAlpha.substring(1);
		strRandom = capStr + strRandomcharcter.toString() + strRandomNumber.toString();
		String pwd = strRandom;
		event.log( "INFO", "Randomly generated pwd  is:  " + pwd);
		return pwd;
	}

	/**
	 * used to generate random MobileNumber returns MobileNumber in string
	 */
	public String generateMobileNumber() {
		String strRandom = "";
		String strNumbers = "0123456789";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 9; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandom = strRandomNumber.toString();
		String mobileNumber = "2" + strRandom;
		event.log( "INFO", "Randomly generated mobileNumber  is:  " + mobileNumber);
		return mobileNumber;
	}

//	 Alert Utils

	public Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	/**
	 * used to accept Alert
	 */
	public void acceptAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();
	}

	/**
	 * used to GetText of Alert
	 */
	public void dismissAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();
	}

	/**
	 * used to dismiss Alert
	 */
	public String alertGetText(int timeOut) {
		Alert alert = waitForJSAlert(timeOut);
		String text = alert.getText();
		alert.accept();
		return text;
	}

	/**
	 * used to send values to Alert pop up
	 */

	public void alertSendKeys(int timeOut, String value) {
		waitForJSAlert(timeOut).sendKeys(value);
	}

//	 Frame Utils

	/**
	 * used to switch frame using index
	 */
	public void switchToFrame(int index, int timeOut) {
		driver.switchTo().frame(index);
	}

	/**
	 * used to switch frame using name
	 */
	public void switchToFrame(String name) {
		driver.switchTo().frame(name);
	}

	/**
	 * used to switch frame using element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * used to get Title of the Page
	 */
	public String getPageTitle() {
		event.log( "INFO", "Title of the Page is  : " + driver.getTitle());
		return driver.getTitle();
	}

//	 Window Utils

	/**
	 * used to get child window URl
	 */
	public String getCurrentUrlofchildWindow() {

		String url = "";
		Set<String> windows = driver.getWindowHandles();
		String parentwindow = driver.getWindowHandle();
		for (String winHandle : windows) {
			driver.switchTo().window(winHandle);
			if (!parentwindow.equalsIgnoreCase(winHandle)) {
				url = getCurrentUrl();
				event.log( "INFO", "Fetched the current url of child window");
				driver.close();
			}
			driver.switchTo().window(parentwindow);
		}
		return url;
	}

	/**
	 * used to switch parent window
	 */
	public void switchToParentWindow() {
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(0));
	}

//	 Java wait util 

	/**
	 * java wait - using xpath
	 */
	public WebElement javaWait(String xpath, int timeOut) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < timeOut) {
			try {
				element = getElement(xpath);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("element is not found in attempt: " + attempts + ": " + element);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
			attempts++;
		}

		if (element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch (Exception e) {
				System.out.println(
						"Element is not found exception...tried for : " + timeOut + " with interval time of 500 ms");
			}
		}

		return element;

	}

	/**
	 * java wait - using WebElement
	 */
	public WebElement javaWait(WebElement element, int timeOut) {

		WebElement elemente = null;
		int attempts = 0;

		while (attempts < timeOut) {
			try {
				elemente = element;
				break;
			} catch (NoSuchElementException e) {
				System.out.println("element is not found in attempt: " + attempts + ": " + element);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
			attempts++;
		}

		if (element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch (Exception e) {
				System.out.println(
						"Element is not found exception...tried for : " + timeOut + " with interval time of 500 ms");
			}
		}

		return element;

	}

	/**
	 * java wait - Thread.sleep();
	 */
	public void wait(int seconds) {

		String sec = String.valueOf(seconds) + "000";
		Integer time = Integer.parseInt(sec);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

		}
	}

//	 Java Script Util

	/**
	 * utility helps to scroll down and up
	 */
	public void scrollDownUp() {
		try {
			scrollTillEnd(driver);
			scrollToTop(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * utility helps to scroll end of the page
	 */
	public void scrollTillEnd(RemoteWebDriver driver) throws Exception {
		for (int i = 0; i < 30; i++) {
			try {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(500);
			} catch (Exception e) {
				break;
			}
		}
	}

	/**
	 * utility helps to scroll top of the page
	 */
	public void scrollToTop(RemoteWebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)", "");
	}

	/**
	 * utility helps to scroll particular element
	 */
	public void scrollToParticularElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * utility waits till page get load
	 */
	public void waitUntilPageLoaded() {
		Object status = "";
		while (!status.toString().equalsIgnoreCase("complete")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			status = js.executeScript("return document.readyState");

		}
	}

//	 Below are the method widely used in Voot framework

	/**
	 * used to search the content
	 * 
	 */
	
	
	public String fetchContentFromPropertyFile(String contentName ,ExtentTest test)
	{
		FileInputStream fin = null;
		Properties prop = null;
		String returnValue=null; 
		try
		{
			if(VootConstants.InternationalFlag==true)
			{
				if (VootConstants.OS.equalsIgnoreCase("Windows")) {
					fin = new FileInputStream(System.getProperty("user.dir")
							+ "\\src\\com\\viacom\\web\\properties\\UKContents.properties");
				}
				else {
					fin = new FileInputStream(System.getProperty("user.dir")
							+ "/src/com/viacom//web/properties/UKContents.properties");
				}
				
			}else
			{
				if (VootConstants.OS.equalsIgnoreCase("Windows")) {
					fin = new FileInputStream(System.getProperty("user.dir")
							+ "\\src\\com\\viacom\\web\\properties\\IndianContents.properties");
				}	
				else {
					fin = new FileInputStream(System.getProperty("user.dir")
							+ "/src/com/viacom/web/properties/IndianContents.properties");
				}
			}
			
			prop = new Properties();
			prop.load(fin);
			returnValue=prop.getProperty(contentName).toString().trim();
			if(returnValue.equalsIgnoreCase("")||returnValue.equalsIgnoreCase(null))
			{
				event.log( "FAIL/WOSS", "Invalid key or no key found in Property File ");	
				
			}else
			{
				event.log( "INFO", "Searched Key found in property file and it's value is :  "+returnValue);	
			}
			
		}catch(Exception e)
		{
			event.log( "FAIL/WOSS", "Invalid key or no key found in Property File ");	
			event.log( "FAIL/WOSS", e.getMessage());	
			
		}
		
		return returnValue;
	}
	
	//this mwthod is for UK only
public void handleCookiePopUp()
{
	SigninVootPageV3 signInPage = new SigninVootPageV3(driver, test);
	if(VootConstants.InternationalFlag==true)
	{
	 if (event.waitUntilElementIsPresent(signInPage.acceptTCCTA, 10))
	 {
            
            event.clickUsingJavaScript(signInPage.acceptTCCTA);  
        }
	}
}







	/**
	 * used to hideKeyboard - only for PWA
	 * 
	 */
	public void hideKeyboard() {
		if (VootConstants.PROJECT.equalsIgnoreCase("pwa")) {
			try {
				((AppiumDriver) driver).hideKeyboard();
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				event.log( "ERROR/WOSS", "Failed Due to: " + e.getMessage());
			}
		}
	}
	
	public void clickUsingJavaScript(WebElement element)
	{
		  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
          
	}
	public void clickUsingJavaScript(String xpath)
	{
		  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(xpath));
          
	}

	public void log(String status, String msg) {
		switch (status) {
		case "PASS": {
			System.out.println("[PASS] " + msg);
			test.pass(MarkupHelper.createLabel(msg, ExtentColor.GREEN));
			break;
		}
		case "PASS/WSS": {
			logScreenShot(driver, test, "");
			System.out.println("[PASS/WSS] " + msg);
			test.pass(MarkupHelper.createLabel(msg, ExtentColor.GREEN));
			break;
		}
		case "ERROR": {
			logScreenShot(driver, test, "");
			System.err.println("[ERROR] " + msg);
			test.error(MarkupHelper.createLabel(msg, ExtentColor.PINK));
			break;
		}
		case "ERROR/WOSS": {
			System.err.println("[ERROR] " + msg);
			test.error(MarkupHelper.createLabel(msg, ExtentColor.PINK));
			break;
		}
		case "FAIL": {
			logScreenShot(driver, test, "");
			System.err.println("[FAIL] " + msg);
			test.fail(MarkupHelper.createLabel(msg, ExtentColor.RED));
			break;
		}
		case "FAIL/WOSS": {
			System.err.println("[FAIL/WOSS] " + msg);
			test.fail(MarkupHelper.createLabel(msg, ExtentColor.RED));
			break;
		}
		case "INFO": {
			test.info(MarkupHelper.createLabel(msg, ExtentColor.TRANSPARENT));
			System.out.println("[INFO] " + msg);
			break;
		}
		case "INFO/WSS": {
			logScreenShot(driver, test, "");
			System.out.println("[INFO/WSS] " + msg);
			test.info(MarkupHelper.createLabel(msg, ExtentColor.TRANSPARENT));
			break;
		}
		case "WARNING": {
			logScreenShot(driver, test, "");
			System.err.println("[WARNING] " + msg);
			test.warning(MarkupHelper.createLabel(msg, ExtentColor.ORANGE));
			break;
		}
		case "WARNING/WOSS": {
			System.err.println("[WARNING/WOSS] " + msg);
			test.warning(MarkupHelper.createLabel(msg, ExtentColor.ORANGE));
			break;
		}
		case "EXCEPTION": {
			logScreenShot(driver, test, "");
			System.err.println("[EXCEPTION] " + msg);
			test.fail(MarkupHelper.createCodeBlock(msg));
			break;
		}
		case "EXCEPTION/WOSS": {
			System.err.println("[EXCEPTION/WOSS] " + msg);
			test.fail(MarkupHelper.createCodeBlock(msg));
			break;
		}
		case "SKIP": {
			System.out.println("[SKIP] " + msg);
			test.skip(MarkupHelper.createLabel(msg, ExtentColor.GREY));
			break;
		}
		case "SKIP/WSS": {
			logScreenShot(driver, test, "");
			System.out.println("[SKIP] " + msg);
			test.skip(MarkupHelper.createLabel(msg, ExtentColor.GREY));
			break;
		}
		case "FATAL": {
			logScreenShot(driver, test, "");
			System.err.println("[FATAL] " + msg);
			test.fatal(MarkupHelper.createLabel(msg, ExtentColor.PURPLE));
			break;
		}
		case "FATAL/WOSS": {
			System.err.println("[FATAL/WOSS] " + msg);
			test.fatal(MarkupHelper.createLabel(msg, ExtentColor.PURPLE));
			break;
		}
		case "DEBUG": {
			System.out.println("[DEBUG] " + msg);
			test.debug(MarkupHelper.createLabel(msg, ExtentColor.TRANSPARENT));
			break;
		}
		case "DEBUG/WSS": {
			logScreenShot(driver, test, "");
			System.out.println("[DEBUG/WSS] " + msg);
			test.debug(MarkupHelper.createLabel(msg, ExtentColor.TRANSPARENT));
			break;
		}

		default: {
			System.out.println("[NO CASE IMPLEMENTED] " + msg);
			test.info(MarkupHelper.createLabel(msg, ExtentColor.TRANSPARENT));
			break;
		}
		}

	}

	public void log(String status, String[][] array) {
		switch (status) {
		case "PASS": {
			test.pass(MarkupHelper.createTable(array));
			break;
		}
		case "FAIL": {
			logScreenShot(driver, test, "");
			test.fail(MarkupHelper.createTable(array));
			break;
		}
		case "INFO": {
			test.info(MarkupHelper.createTable(array));
			break;
		}
		case "WARNING": {
			logScreenShot(driver, test, "");
			test.warning(MarkupHelper.createTable(array));
			break;
		}
		case "SKIP": {
			test.skip(MarkupHelper.createTable(array));
			break;
		}
		default: {
			test.info(MarkupHelper.createTable(array));
			break;
		}
		}

	}

	public void log(String status, Response json) {
		String jsonString = json.prettyPrint();
		switch (status) {
		case "PASS": {
			test.pass(MarkupHelper.createCodeBlock(jsonString));
			break;
		}
		case "FAIL": {
			logScreenShot(driver, test, "");
			test.fail(MarkupHelper.createCodeBlock(jsonString));
			break;
		}
		case "INFO": {
			test.info(MarkupHelper.createCodeBlock(jsonString));
			break;
		}
		case "WARNING": {
			logScreenShot(driver, test, "");
			test.warning(MarkupHelper.createCodeBlock(jsonString));
			break;
		}
		case "SKIP": {
			test.skip(MarkupHelper.createCodeBlock(jsonString));
			break;
		}
		default: {
			test.info(MarkupHelper.createCodeBlock(jsonString));
			break;
		}
		}

	}

	public void log(String status, Map<String, String> map) {
		String mapString = map.toString();

		switch (status) {
		case "PASS": {
			test.pass(MarkupHelper.createCodeBlock(mapString));
			break;
		}
		case "FAIL": {
			logScreenShot(driver, test, "");
			test.fail(MarkupHelper.createCodeBlock(mapString));
			break;
		}
		case "INFO": {
			test.info(MarkupHelper.createCodeBlock(mapString));
			break;
		}
		case "WARNING": {
			logScreenShot(driver, test, "");
			test.warning(MarkupHelper.createCodeBlock(mapString));
			break;
		}
		case "SKIP": {
			test.skip(MarkupHelper.createCodeBlock(mapString));
			break;
		}
		default: {
			test.info(MarkupHelper.createCodeBlock(mapString));
			break;
		}
		}

	}
	
	public void log(String status, List<String> lst) {
		String lstString = lst.toString();
		System.out.println("[INFO] "+ lstString);
		switch (status) {
		case "PASS": {
			test.pass(MarkupHelper.createCodeBlock(lstString));
			break;
		}
		case "FAIL": {
			logScreenShot(driver, test, "");
			test.fail(MarkupHelper.createCodeBlock(lstString));
			break;
		}
		case "INFO": {
			test.info(MarkupHelper.createCodeBlock(lstString));
			break;
		}
		case "WARNING": {
			logScreenShot(driver, test, "");
			test.warning(MarkupHelper.createCodeBlock(lstString));
			break;
		}
		case "SKIP": {
			test.skip(MarkupHelper.createCodeBlock(lstString));
			break;
		}
		default: {
			test.info(MarkupHelper.createCodeBlock(lstString));
			break;
		}
		}

	}
	 
	
	public void printStackTrace(Exception e) {
		e.printStackTrace();
		test.info(MarkupHelper.createCodeBlock(e.toString()));
	}

	public void prettyPrint(Response resp) {
		resp.prettyPrint();
		
	}

}
