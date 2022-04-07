package com.viacom.web.utils;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.base.Function;
  import com.viacom.web.pages.SigninVootPageV3;
 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
 

/*************************************************************************************
 * Class : Utilities Purpose : This class is used for reusable functions across
 * the framework Remarks : none Author : Roja, Ifocus Modifications: Amresh on
 * 24th May 2020 - Last Modified
 * 
 **************************************************************************************/
//UtilitiesWeb should be renamed to Utilities
public class UtilitiesWeb extends BaseTestWeb{
	public static AppiumDriverLocalService service;
	public static AppiumServiceBuilder builder;
	public static DesiredCapabilities cap;
	public static String service_url;

	public void startAppiumServer() {
		try {
			// Starting the Appium Server

			Map<String, String> env;
			if (VootConstants.OS.equalsIgnoreCase("Mac")) {
				env = new HashMap<>(System.getenv());
				env.put("PATH", "/usr/local/bin:" + env.get("PATH"));
				AppiumServiceBuilder builder = new AppiumServiceBuilder().withIPAddress(VootConstants.APPIUM_IPADDRESS)
						.usingPort(VootConstants.APPIUM_PORT).withEnvironment(env)
						.withArgument(GeneralServerFlag.LOG_LEVEL, "warn")
						.usingDriverExecutable(new File(VootConstants.NODEJS_PATH)).withAppiumJS(new File(
								VootConstants.APPIUM_JS_PATH));
				service = AppiumDriverLocalService.buildService(builder);
			}
			else {
				AppiumServiceBuilder builder = new AppiumServiceBuilder().withIPAddress(VootConstants.APPIUM_IPADDRESS)
						.usingPort(VootConstants.APPIUM_PORT)
						.withArgument(GeneralServerFlag.LOG_LEVEL, "warn")
						.usingDriverExecutable(new File(VootConstants.NODEJS_PATH)).withAppiumJS(new File(
								VootConstants.APPIUM_JS_PATH));
				service = AppiumDriverLocalService.buildService(builder);
			}
			
			if (service.isRunning() == true) {
				service.stop();
			} else {
				service.start();
			}
		} catch (AppiumServerHasNotBeenStartedLocallyException e) {
			System.out.println("Appium Server Not started Properly");


		}}

	public void stopAppiumServer() {
		service.stop();
		System.out.println("service::" + service.isRunning());
	}

	 
	// wait_until_the_page_is_loaded should be renamed waitUntilPageLoaded
	public void waitUntilPageLoaded(RemoteWebDriver driver) {
		if (!VootConstants.browser.equalsIgnoreCase("Safari")) {
			Object status = "";

			while (!status.toString().equalsIgnoreCase("complete")) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					//System.out.println("Failed due to Exception: "+e.getMessage());
 				}
				for (int i = 0; i < 3; i++) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					status = js.executeScript("return document.readyState");
				}
			}
		}
	}

	public void waitForPageLoad(RemoteWebDriver driver) {
		if (!VootConstants.browser.equalsIgnoreCase("Safari")) {
			try {
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
						.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
				wait.until(new Function<WebDriver, Boolean>() {
					JavascriptExecutor js = (JavascriptExecutor) driver;

					public Boolean apply(WebDriver driver) {

						return js.executeScript("return jQuery.active").toString().equals("0");

					}
				});
			} catch (Exception e) {
				BaseTestWeb.logger.error("Exception arised while waitForPageLoad() :: " + e);
			}
		}
	}

	// To scroll to WebElement . scroll_to_particular_element renamed to
	// scrollToParticularElement
	public void scrollToParticularElement(RemoteWebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// To select the value from List box. selectValue_from_listBox rename to
	// selectValueFromListBox
	public void selectValueFromListBox(RemoteWebDriver driver, ExtentTest test, List<WebElement> elements, String input,
			int timeout) {
		BaseTestWeb.logger.info("Clicking on the element " + elements.toString());
		if (elements.equals(null)) {
			System.out.println("No element is found with locator:" + elements.toString());
			event.log( "ERROR/WOSS", "There is no such element");
		} else {
			for (WebElement option : elements) {
				String optionText = option.getAttribute("innerText");
				if (optionText.equalsIgnoreCase(input)) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
					event.log( "INFO", "Clicked on :-" + optionText);
					break;
				} else {
					event.log( "WARNING/WOSS", "Element " + optionText + " is not present in the list");
				}
			}
		}
	}

	// To get the current time and date getTimeStamp_sec

	public String getTimeStamp_sec() {

		String timeStamp = "";
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		timeStamp = timeStamp + (c.get(Calendar.MONTH) + 1) + c.get(Calendar.DAY_OF_MONTH) + c.get(Calendar.HOUR)
				+ c.get(Calendar.MINUTE) + c.get(Calendar.SECOND) + c.get(Calendar.MILLISECOND);

		return timeStamp;
	}

	// Move to element and click on the element. move_to_element_and_click renamed
	// to moveToElementAndClick
	public void moveToElementAndClick(RemoteWebDriver driver, WebElement element, int timeout) {
		try {
			 
			if (((VootConstants.browser).equalsIgnoreCase("Safari"))&&((VootConstants.PROJECT).equalsIgnoreCase("WEB"))) {
				Thread.sleep(3000);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}
			else {
			if (VootConstants.browser.equalsIgnoreCase("Safari")) {
				element.click();
				Thread.sleep(3000);
			} else {
				BaseTestWeb.logger.info("Clicking on the element " + element.toString());
				if (element.equals(null)) {
					// Assert.assertFalse(true, "No element is found with locator:" +
					// by.toString());
					System.out.println("No element is found with locator:" + element.toString());
				} else {
					if (waitUntilElementIsVisible(driver, element, timeout)) {
						if (waitUntilElememtIsEnabled(driver, element, timeout)) {
							Actions act = new Actions(driver);
							act = act.moveToElement(element);
							waitUntilPageLoaded(driver);
							act.click().build().perform();
							BaseTestWeb.logger.info("Clicked on the element " + element.toString());
						} else {
							System.out.println("Element : " + element.toString()
									+ " is not enabled even after waiting for " + timeout + " secconds.");
						}
					} else {
						System.out.println("Element : " + element.toString() + " is not visible even after waiting for "
								+ timeout + " secconds.");
					}
				}
			}
			}
		} catch (Exception e) {
			
			//System.out.println("Failed due to Exception: "+e.getMessage());
		}
	}
	
	
	public String getWatchNowCTA(String mediaID ,Map<String, String> map) {
		
		String watchNowCTAURL = getApiUrlFromPropertyFile("watchNowCTA");	
		watchNowCTAURL=watchNowCTAURL+mediaID;
		Response responseOfWatchNowCTA=getApiResponseOfUrl(watchNowCTAURL,map) ;
		String watchNowCTA="";
		try {
			watchNowCTA = responseOfWatchNowCTA.jsonPath().getString("label");
		} catch (Exception e) {
			watchNowCTA=null;
		}
		
		
		return watchNowCTA;
	}
	
	

	// Used to get the AccessToken based on userType(eg: nonPremium ,Premium).
	// requestUtilityrecommendationdummyPostWeb renamed to
	// getAccessTokenBasedOnUsertype
	public Response getAccessTokenBasedOnUsertype(String url, String email, String pass) {
		RestAssured.urlEncodingEnabled = false;
		Response resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.headers("TEST-MODE", "auto")
				.headers("Content-Type", "application/json").headers("Content-Version", "V4")
				.body("{\r\n" + "\"type\": \"traditional\",\r\n" + "\"deviceId\": \"abcde\",\r\n"
						+ "\"deviceBrand\": \"PC/MAC\",\r\n" + "\"data\": {\r\n" + "\"email\": \"" + email + "\",\r\n"
						+ "\"password\": \"" + pass + "\"\r\n" + "}\r\n" + "}")
				.when().post(url);
		return resp;
	}
	
	public Response getAccessTokenBasedOnUsertypeforMobile(String url, String mobileNo, String pass) {
		RestAssured.urlEncodingEnabled = false;
		Response resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.headers("TEST-MODE", "auto")
				.headers("Content-Type", "application/json").headers("Content-Version", "V4")
				.body("{\r\n" + "\"type\": \"mobile\",\r\n" + "\"deviceId\": \"abcde\",\r\n"
						+ "\"deviceBrand\": \"PC/MAC\",\r\n" + "\"data\": {\r\n" + "\"mobile\": \"" + mobileNo + "\",\r\n"
						+"\"countryCode\": \"+91\",\r\n"+ "\"password\": \"" + pass + "\"\r\n" + "}\r\n" + "}")
				.when().post(url);
		return resp;
	}
	

	//removed -if any found need to change to APIEventUtils - watch next need to change bindu working so left
	public Response getApiResponseOfUrl(String url, Map<String, String> map) {
		Response resp = null;
		RestAssured.urlEncodingEnabled = false;

		if (url.contains("view")) {
			resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
					.params("responseType", "common").params("premiumTrays", VootConstants.PREMIUM_TRAY)
					.params("features", "include:buttonsTray").headers("Content-Type", "application/json").headers("Content-Version", "V4")
					.headers("usertype", VootConstants.USERTYPE_HEADER).headers(map).when().get(url);
		} else {
			resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
					.params("responseType", "common").headers("Content-Type", "application/json")
					.headers("Content-Version", "V4").headers("usertype", VootConstants.USERTYPE_HEADER).headers(map)
					.when().get(url);
			
		}
		return resp;
	}
	//removed -if any found need to change to APIEventUtils
	public Response getApiResponseOfUrl(String url) {
		Response resp = null;
		RestAssured.urlEncodingEnabled = false;

		if (url.contains("view")) {
			resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
					.params("responseType", "common").params("premiumTrays", VootConstants.PREMIUM_TRAY)
					.params("features", "include:buttonsTray").headers("Content-Type", "application/json").headers("Content-Version", "V4")
					.headers("usertype", VootConstants.USERTYPE_HEADER).when().get(url);
		} else {
			resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
					.params("responseType", "common").headers("Content-Type", "application/json")
					.headers("Content-Version", "V4").headers("usertype", VootConstants.USERTYPE_HEADER)
					.when().get(url);
			
		}
		return resp;
	}
	//removed -if any found need to change to APIEventUtils
	public Response getApiResponseOfUrlATplan(String url, Map<String, String> map) 
	{
		Response resp = null;
		RestAssured.urlEncodingEnabled = false;

		 {
			
			
			resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
					.params("responseType", "common")
					.headers(map)
					.when().get(url);
		}
		return resp;
	}
	//removed -if any found need to change to APIEventUtils
	public Response getApiResponseOfUrlforRecomendation(String url, Map<String, String> map) {
		Response resp = null;
		RestAssured.urlEncodingEnabled = false;
		resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.headers("Content-Type", "application/json").headers("Content-Version", "V4")
				.headers("usertype", VootConstants.USERTYPE_HEADER).headers(map).when().get(url);
		return resp;
	}
	//not used anywhere in class
	public Response getApiResponseOfUrlforMoreLikeThis(String url) {
		Response resp = null;
		RestAssured.urlEncodingEnabled = false;
		resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.headers("Content-Type", "application/json").headers("Content-Version", "V4")
				.headers("usertype", VootConstants.USERTYPE_HEADER).when().get(url);
		return resp;
	}
	//removed -if any found need to change to  APIEventUtils
	public Response getApiResponseOfSubscriptionPage(String url) {
		Response resp = null;
		RestAssured.urlEncodingEnabled = false;
		resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).headers("version", "v4")
					.headers("Content-Type", "application/json").headers("platform", "Web").when()
					.get(url);

		return resp;
	}
	//removed -if any found need to change to APIEventUtils
	public Response getApiResponseOfSubscriptionPagewithsandbox(String url) {
		Response resp = null;
		RestAssured.urlEncodingEnabled = false;
		resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).headers("version", "v4")
				.headers("Content-Type", "application/json").headers("submode", "sandbox")
				.headers("platform", "Web").when().get(url);

		return resp;
	}
	//removed -if any found need to change to APIEventUtils
	public Response getApiResponseOfpaymentmodes(String url, Map<String, String> map) {
		Response resp = null;
		RestAssured.urlEncodingEnabled = false;
		resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).headers("version", "v5")
				.headers("Content-Type", "application/json").param("responseType", "common") 
				.headers("platform", "Web").headers(map).when().get(url);

		return resp;
	}
	//removed -if any found need to change to APIEventUtils
	public Response getApiResponseOfOrder(String url, Map<String, String> map) {
		Response resp = null;
		RestAssured.urlEncodingEnabled = false;
		resp = RestAssured.given().relaxedHTTPSValidation()
				.headers("Content-Type", "application/json").param("responseType", "common")
				.headers(map).when().get(url);

		return resp;
	}

	// Used to switch to the latest window switch_to_latestWindow to
	// switchToLatestWindow
	public void switchToLatestWindow(RemoteWebDriver driver) {
		BaseTestWeb.logger.info("Switching to latest window");
		Set<String> windows = driver.getWindowHandles();
		for (String winHandle : windows) {
			driver.switchTo().window(winHandle);
			BaseTestWeb.logger.info("Switched to latest window");
		}
	}

	// Used to switch to the different window using name of the window
	public boolean switchToWindowByName(RemoteWebDriver driver, String windowName) {
		BaseTestWeb.logger.info("Switching to the window :" + windowName);
		Set<String> allWindowHandles = driver.getWindowHandles();
		boolean isWindowFound = false;
		for (String handle : allWindowHandles) {
			driver.switchTo().window(handle);
			String windowTitle = driver.getTitle();
			if (windowTitle.contains(windowName)) {
				isWindowFound = true;
				BaseTestWeb.logger.info("Switched to window :" + windowName);
				break;
			}
		}
		if (!isWindowFound) {

			System.out.println("Window : " + windowName + " does not exist.");
		}
		return isWindowFound;
	}

	// used to dismiss the window alerts to_dismiss_alert renamed to
	// dismissWindowAlert
	public void dismissWindowAlert(RemoteWebDriver driver, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.alertIsPresent());
		wait.pollingEvery(Duration.ofMillis(200));
		driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
	}

	// Used to click on the WebElement using locator
	public void clickButton(RemoteWebDriver driver, WebElement element, int timeout) throws Exception {
		BaseTestWeb.logger.info("Clicking on the element " + element.toString());
		try {
			if (element == null) {
				System.out.println("No element is found with locator:" + element.toString());
			} else if  (((VootConstants.browser).equalsIgnoreCase("Safari"))&&((VootConstants.PROJECT).equalsIgnoreCase("WEB"))) {
				Thread.sleep(3000);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}else {
				if (waitUntilElementIsVisible(driver, element, timeout)) {
					if (waitUntilElememtIsEnabled(driver, element, timeout)) {
						element.click();
						BaseTestWeb.logger.info("Clicked on the element " + element.toString());
					} else {
						System.out.println("Element : " + element.toString() + " is not enabled even after waiting for"
								+ timeout + "secconds.");
					}
				} else {
					System.out.println("Element : " + element.toString() + " is not visible even after waiting for "
							+ timeout + "secconds.");
					System.out.println("Element : " + element.toString() + " is not visible even after waiting for "
							+ timeout + "secconds.");
				}
			}
		} catch (ElementClickInterceptedException ecie) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	// used to enter the values into the text fields
	public void enterValue(RemoteWebDriver driver, ExtentTest test, WebElement element, String input, int timeout) {
		BaseTestWeb.logger.info("Entering the value : " + input + " into the object : " + element.toString());
		if (element == null) {
			System.out.println("No element is found with locator:" + element.toString());
		} else {
			if (waitUntilElementIsVisible(driver, element, timeout)) {
				if (waitUntilElememtIsEnabled(driver, element, timeout)) {
					element.clear();
					BaseTestWeb.logger.info("Value  : " + input + "entered into the object : " + element.toString());
					element.sendKeys(input);
					event.log( "INFO", "Entered the value '" + input + "' in the " + element.getText());
					BaseTestWeb.logger
							.info("Entering the value : " + input + " into the object : " + element.toString());
				} else {
					System.out.println(
							"Element : " + element.toString() + " is not enabled even after waiting for 20 secconds.");
					event.log( "INFO", "Entered the value '" + input + "' in the " + element.toString());
				}
			} else {
				System.out.println(
						"Element : " + element.toString() + " is not visible even after waiting for 20 secconds.");
				event.log( "ERROR", "Not able enter the value '" + input + "' in the " + element.toString());
			}
		}
	}

	// Converting duration into Minutes
	public int convertToMinutes(String duration) {
		int timeAfterSplit = 0;
		String[] time = duration.split(":");
		String[] timeAtZero = time[0].trim().split("");
		int size = time.length;
		// System.out.println("size:"+size);
		if (size == 2) {
			timeAfterSplit = (Integer.parseInt(time[0].trim())) * 60 + Integer.parseInt(time[1].trim());
		} else if (size == 3) {
			int secondToMinute = (Integer.parseInt(time[2].trim())) / 60;
			if (timeAtZero[0].contains("0")) {
				timeAfterSplit = (Integer.parseInt(timeAtZero[1])) * 60 + Integer.parseInt(time[1].trim())
						+ secondToMinute;
			} else {
				timeAfterSplit = (Integer.parseInt(time[0])) * 60 + Integer.parseInt(time[1].trim()) + secondToMinute;
			}
		} else {
			timeAfterSplit = Integer.parseInt(duration);
		}
		return timeAfterSplit;
	}

	// Wait method to wait for the element to be vissible
	public boolean explicitWaitVisible(RemoteWebDriver driver, WebElement element, int time) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			 System.out.println("[ELEMENT] not Visible: "+element);
			return false;
		} 
		
	}

	// Scroll to the end
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

	// To get the Api response
	public Response requestUtility(String url) {
		RestAssured.urlEncodingEnabled = false;
		Response resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.headers("Content-Version", "V4").when().get(url);
		return resp;
	}

	// getRecommendedTraysApiResponse
	// To get the Api response for recommended tray.
	// requestUtilityrecommendationdummy renamed to getRecommendedTraysApiResponse
	public Response getRecommendedTraysApiResponse(String url) {
		RestAssured.urlEncodingEnabled = false;
		Response resp = RestAssured.given().relaxedHTTPSValidation().params("responseType", "common")
				.headers("Content-Type", "application/json").headers("accesstoken", "dummy")
				.headers("Content-Version", "V4").when().get(url);
		return resp;
	}

	// Converting time to percentage
	public void timeConverstion(String playerTime, int durinpercentage, String percentage) {

		try {
			String[] durs = playerTime.split("\\ \\/\\ ");
			String[] mins = durs[1].split("\\:");
			String hr = mins[0].toString();
			int shrtoint = Integer.parseInt(hr);
			String min = mins[1].toString();
			int smintoint = Integer.parseInt(min);
			int smintosec = shrtoint * 60 * 60 + smintoint * 60 + (Integer.parseInt(mins[2].toString()) + 30);
			System.out.println("Total Duration of the cotent in secs: " + smintosec);
			int Percent = (smintosec * durinpercentage) / 100;
			System.out.println(percentage + " Duration of the cotent in secs: " + Percent);
			GlobalVariables.totalwaitingTime = (Percent * 1000);
		} catch (Exception e) {
			String[] durs = playerTime.split("\\ \\/\\ ");
			String[] mins = durs[1].split("\\:");
			String min = mins[0].toString();
			int smintoint = Integer.parseInt(min);
			int smintosec = smintoint * 60 + (Integer.parseInt(mins[1].toString()) + 30);
			System.out.println("Total Duration of the cotent in secs: " + smintosec);
			int Percent = (smintosec * durinpercentage) / 100;
			System.out.println(percentage + " Duration of the cotent in secs: " + Percent);
			GlobalVariables.totalwaitingTime = (Percent * 1000);
		}

		System.out.println("Total waiting time for " + percentage + " of the content in millisecond is "
				+ GlobalVariables.totalwaitingTime);
	}

	// Replacing hexadecimal values to ASCII characters
	public String replaceHexadeciValuetoUnichar(String base64String) {
		int i = 1;
		// String
		// base64String="eyJldmVudCI6ICJNYXN0aGVhZCBJbXByZXNzaW9uIiwicHJvcGVydGllcyI6IHsiJG9zIjogIldpbmRvd3MiLCIkYnJvd3NlciI6ICJDaHJvbWUiLCIkcmVmZXJyZXIiOiAiaHR0cHM6Ly93d3cudm9vdC5jb20vIiwiJHJlZmVycmluZ19kb21haW4iOiAid3d3LnZvb3QuY29tIiwiJGN1cnJlbnRfdXJsIjogImh0dHBzOi8vd3d3LnZvb3QuY29tLyIsIiRicm93c2VyX3ZlcnNpb24iOiA3MiwiJHNjcmVlbl9oZWlnaHQiOiA3NjgsIiRzY3JlZW5fd2lkdGgiOiAxMzY2LCJtcF9saWIiOiAid2ViIiwiJGxpYl92ZXJzaW9uIjogIjIuMjYuMCIsInRpbWUiOiAxNTQ4ODM3NjM0Ljk3MywiZGlzdGluY3RfaWQiOiAiMTY4OWRkMTJkMmZiLTBlYjAzZjg4MmZhMjMyLTU3YjE0M2EtMTAwMjAwLTE2ODlkZDEyZDMwMmNkIiwiJGRldmljZV9pZCI6ICIxNjg5ZGQxMmQyZmItMGViMDNmODgyZmEyMzItNTdiMTQzYS0xMDAyMDAtMTY4OWRkMTJkMzAyY2QiLCIkaW5pdGlhbF9yZWZlcnJlciI6ICJodHRwczovL3d3dy52b290LmNvbS8iLCIkaW5pdGlhbF9yZWZlcnJpbmdfZG9tYWluIjogInd3dy52b290LmNvbSIsIkZpcnN0IFRpbWUiOiBmYWxzZSwiRGV2aWNlIjogIkRlc2t0b3AiLCJVc2VyIFR5cGUiOiAiVHJhZGl0aW9uYWwiLCJHZW5yZSBTZWxlY3RlZCI6ICIiLCJMYW5ndWFnZSBTZWxlY3RlZCI6ICIgRW5nbGlzaCwgSGluZGkiLCJBZ2UiOiAiMTQiLCJHZW5kZXIiOiAiTSIsIkZpcnN0IE5hbWUiOiAiVGVzdCIsIkxhc3QgTmFtZSI6ICJUZXN0IiwiRW1haWwiOiAidGVzdDUyNzg1MkBnbWFpbC5jb20iLCJQbGF0Zm9ybSI6ICJXZWIiLCJEYXRlIjogIjIwMTktMDEtMzBUMDg6NDA6MzQuMDc0WiIsIkZpcnN0IFZpc2l0IERhdGUiOiAiMjAxOS0wMS0zMFQwODo0MDozMy4xMjVaIiwiTG9jYXRpb24iOiAiIiwiV2F0Y2ggSGlzdG9yeSBDbGVhcmVkIjogIiIsIkRheSBvZiBXZWVrIjogIldlZG5lc2RheSIsIklzIEZyb20gU2VhcmNoPyI6ICJObyIsIkNsaWNrZWQgVmlzaXQgQWQ%2FIjogZmFsc2UsIk1hc3RoZWFkIE1lbnUiOiAiaG9tZSIsIk1hc3RoZWFkIEFkIFNlcnZlciI6ICJERlAiLCJDYW1wYWlnbiBJRCI6IDI0Nzg2NTUzOTYsIkFkdmVydGlzZXIgSUQiOiA0NjMyMzIwMTExLCJ0b2tlbiI6ICJiNTdiOTJlZGNhOWRlNThjYWQ1YTYxM2E3ZDgyMDM0YiJ9fQ%3D%3D";
		for (char letter = ' '; letter < 274; letter++) {
			char asciichar = letter;
			int asciivalue = (int) asciichar;
			String hexvalue = ("%" + Integer.toHexString(asciivalue).toUpperCase());
			if (base64String.contains(hexvalue)) {
				base64String = base64String.replaceAll(hexvalue, "" + letter);
			}
			System.out.println("Base 64 String post replacing with hexa values was: " + base64String);

		}
		return base64String;

	}

	// Scroll to Bottom . scrollBottom renamed to scrollToBottom
	public void scrollToBottom(RemoteWebDriver driver) throws InterruptedException {
		if (VootConstants.PROJECT.equalsIgnoreCase("pwa")&&VootConstants.browser.equalsIgnoreCase("Safari")) {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");
			}
		}
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
	}

	// Explicit Wait till an element is clickable
	public boolean explicitWaitClickable(RemoteWebDriver driver, WebElement element, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);

			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.pollingEvery(Duration.ofMillis(200));
			return true;
		} catch (Exception e) 
		{
			 System.out.println("[ELEMENT] not Clickable: "+element);
			return false;
		}  
		
	}

	// To check whether the WebElement is displayed or not
	public boolean isDisplayed(RemoteWebDriver driver, WebElement element) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			for (int i = 0; i < 2; i++) {
				if (element.isDisplayed()) {
					break;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println("[ELEMENT] not Displayed: "+element);
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	}

	// To generate random EmailId. generateEmailid renamed to generateRandomEmailId
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
		return email;
	}

	// To capture the ScreenShot //Merge with below similar method
	public void captureScreenshot(RemoteWebDriver driver) throws IOException {
		EventFiringWebDriver e = new EventFiringWebDriver(driver);
		File srcFile = e.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		Calendar cal = Calendar.getInstance();
		String sysdate1 = dateFormat.format(cal.getTime());
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
		String sysdate2 = dateFormat1.format(cal.getTime());
		File destFile = new File("Screenshots/" + sysdate1 + "/" + "/" + sysdate2 + ".png");
		FileUtils.copyFile(srcFile, destFile);
	}

	public String createResizedCopy(String base64String, int scaledWidth, int scaledHeight, boolean preserveAlpha) {
		try {
			
			byte[] decodedBytes = Base64.getDecoder().decode(base64String);			
			BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(decodedBytes));
			// System.out.println("resizing...");
			int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
			BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
			Graphics2D g = scaledBI.createGraphics();
			if (preserveAlpha) {
				g.setComposite(AlphaComposite.Src);
			}
			g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(scaledBI, "gif", bos);
			String imageString = Base64.getEncoder().encodeToString(bos.toByteArray());
			/*
			 * byte[] imageBytes = bos.toByteArray(); BASE64Encoder encoder = new
			 * BASE64Encoder(); String imageString = encoder.encode(imageBytes);
			 */
			// System.out.println(imageString);
			g.dispose();
			return imageString;
		} catch (IOException e) {
			
			//System.out.println("Failed due to Exception: "+e.getMessage());
			return null;
		}
	}

	/*---------------------------------------------------------------------------------------------------------------------*/

	// vertical swipe using String
	// vertical swipe
	public void verticalSwipe(RemoteWebDriver driver, String end) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");
			} catch (Exception e) {
			}
			if (driver.findElements(By.xpath(end)).size() > 0)
				break;
		}
	}

	// vertical swipe using WebElement locator
	// Sudha
	// vertical swipe
	public void verticalSwipe(RemoteWebDriver driver, WebElement end) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,250)");
			} catch (Exception e) {
			}
			if (explicitWaitVisible(driver, end, 2))
				break;
		}
	}

	// Verticle swipe till mentioned height
	public void verticalSwipe(RemoteWebDriver driver) throws InterruptedException {
		// scrolling starts
		
		if(VootConstants.PROJECT.equalsIgnoreCase("WEB"))
		{
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)");
		} catch (Exception e) {
		}
		}else
		{
			if(!VootConstants.USERTYPE.equalsIgnoreCase("Premium"))
			{
				Thread.sleep(8000);
			try {
				String ad="//iframe[contains(@id,'google_ads_iframe')]";
				if(explicitWaitClickable(driver, driver.findElement(By.xpath(ad)), 10))
				{
					scrollverticalDown(0.8,0.45,driver);
					System.out.println(" scrolled ");
				}else
				{
					System.out.println("No scroll is required");
				}
			} catch (Exception e) 
			{
				 
				System.err.println("[EXCEPTION] Failed due to Exception: "+e.getMessage());
			}
			}
		}
	}
	

	public void scrollverticalDown(double heightStart , double  heightEnd ,RemoteWebDriver driver)
	{
		
		try {
			Dimension dim = driver.manage().window().getSize();
			System.out.println("Dimension: "+dim);
			
			System.out.println("dim.getHeight()"+dim.getHeight());
			Double startPosition=dim.getHeight()*heightStart;
			//this gives co ordinates after coverting height
			int startFrom=startPosition.intValue();
			System.out.println("startPosition"+startPosition);
			System.out.println("startFrom: "+startFrom);
			Double endPosition=dim.getHeight()*heightEnd;
			System.out.println("dim.getHeight()"+dim.getHeight());
			System.out.println("endPosition"+endPosition);
			int endTo=endPosition.intValue();
			System.out.println("endTo: "+endTo);
			
			 new TouchAction((PerformsTouchActions) driver)
			.press(PointOption.point(0, startFrom))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
			.moveTo((PointOption.point(0, endTo))).release().perform();
		} catch (Exception e) {
			
			System.err.println("[EXCEPTION] Failed due to Exception: "+e.getMessage());
		}
		
	}
	

	

	// Scrub the player seek bar till half. scrubtillhalf renamed to scrubTillhalf

	// Scrub the player seek bar to starting piont . scrubtoStart renamed to
	// scrubToStart

	// Scrub the player seek bar by percentage. slidebyPercentage renamed to
	// slideByPercentage


	// To check Whether the Element is present in the page or not
	public boolean isElementPresent(RemoteWebDriver driver, String locator) {
		int s = driver.findElements(By.xpath(locator)).size();
		if (s == 0)
			{
			return false;
			}
		else
			{
			return true;
			}
	}

	// to run the batch file
	public void runBatchFile(String batfileName) {
		String filePath = System.getProperty("user.dir") + "/" + batfileName;
		String pathToBatchFile = "cmd /c start" + " " + filePath;
		System.out.println(pathToBatchFile);
		final Runtime rt = Runtime.getRuntime();
		try {
			Process p = rt.exec(pathToBatchFile);
			System.out.println("inside try block");
		} catch (final IOException e) {
			throw new RuntimeException("Failed to run bat file.");
		}
	}

	// to check the image CheckImage renamed to checkImage
	public boolean checkImage(RemoteWebDriver driver, WebElement el) throws Exception {
		boolean imgflag;
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				el);
		if (!ImagePresent) {
			imgflag = false;
		} else {
			imgflag = true;
		}
		return imgflag;
	}

	// To mouse Hover on the WebElement mouseHover renamed to mouseHoverOnWebElement
	public void mouseHoverOnWebElement(RemoteWebDriver driver, WebElement el) {
		Actions action = new Actions(driver);
		action.moveToElement(el).perform();
	}

	// To double click on WebElement, DoubletimeClick renamed to doubleClick

	public void doubleClick(RemoteWebDriver driver, WebElement el) {
		el.click();
		if (el.isDisplayed()) {
			el.click();
		}
	}

	// To Click on arrow button Click_arrow renamed to clickArrowButton

	// Scroll down to mentioned height
	public void scrollDown(RemoteWebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
	}

	// Scroll down to mentioned height . scrollDown100 renamed to scrollDownBy100
	public void scrollDownBy100(RemoteWebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
	}

	// Scroll to the Top of the Page. scrollTop renamed to scrollToTop
	public void scrollToTop(RemoteWebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)", "");
	}

	// Scroll to the WebElement


	// Scroll to the WebElement
	public void horizantalScrollToElement(RemoteWebDriver driver, String Xpath) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		for (int i = 0; i <= 10; i++) {
			try {
				WebElement element = driver.findElement(By.xpath(Xpath));
				int loc = element.getLocation().getX();
				System.out.println(loc);
				((JavascriptExecutor) driver).executeScript("", "window.scrollTo(0," + loc + ")");
				break;
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("", "window.scrollBy(0,200)");
			}
		}
	}

	// sudha
	public void horizontalSwipeForCarosual(RemoteWebDriver driver, WebElement Xpath) {
		int startX = (int) ((Xpath.getSize().getWidth()));
		int startY = (int) ((Xpath.getSize().getHeight()));
		int endx = (int) (Xpath.getLocation().getX()) + startX;
		int endy = (int) (Xpath.getLocation().getY()) + startY;
		int endxx = (Xpath.getLocation().x);
		int endyy = (Xpath.getLocation().y);
		int screenwidth = (driver.manage().window().getSize().getWidth());
		int screenheight = (driver.manage().window().getSize().getHeight());
		System.out.println(startX);
		System.out.println(startY);
		System.out.println(endx);
		System.out.println(endy);
		System.out.println(endxx);
		System.out.println(endyy);
		System.out.println(screenwidth);
		System.out.println(screenheight);
		for (int i = 0; i < 3; i++) {
			try {
				TouchAction act = new TouchAction((PerformsTouchActions) driver);
				(new TouchAction((PerformsTouchActions) driver)).press(PointOption.point(endx, endy))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
						.moveTo(PointOption.point((endxx / 2), endy)).release().perform();
				break;
			} catch (Exception e) {
				try {
					TouchAction act = new TouchAction((PerformsTouchActions) driver);
					(new TouchAction((PerformsTouchActions) driver)).press(PointOption.point(660, 200))
							.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
							.moveTo(PointOption.point(43, 200)).release().perform();
					break;
				} catch (Exception e1) {
					System.err.println("[EXCEPTION] Failed Due to: " + e1.getMessage());
					System.out.println("Not able to scrub");
				}
			}
		}
	}

	public void scrollToElementb(RemoteWebDriver driver, WebElement element) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		for (int i = 0; i <= 10; i++) {
			try {
				int loc = element.getLocation().getY();
				System.out.println(loc);
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + loc + ")", "");
				break;
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
			}
		}
	}


	// Scroll to tray
	public WebElement scrollToTray(RemoteWebDriver driver, String xpath) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement element = null;
		for (int i = 0; i <= 90; i++) {
			try {
				element = driver.findElement(By.xpath(xpath));
				int loc = element.getLocation().getY();
				System.out.println(loc);
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + loc + ")", "");
				break;
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
			}
			if (i == 50) {
				break;
			}
		}
		return element;

	}

	// Scrolling 4 Times and then finding elelment
	public void fourTimesScrollAndFindElement(RemoteWebDriver driver, WebElement element) {
		for (int i = 0; i < 4; i++) {
			try {
				int loc = element.getLocation().getY();
				System.out.println(loc);
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + loc + ")", "");
				break;
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
			}
		}
	}

	// To open Charles scrollToElementNewsShows renamed to ??
	public WebElement scrollToElementNewsShows(RemoteWebDriver driver, String xpath) {
		WebElement element = null;
		for (int i = 0; i <= 30; i++) {
			try {
				element = driver.findElement(By.xpath(xpath));
				int loc = element.getLocation().getY();
				System.out.println(loc);
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + loc + ")", "");
				break;
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)", "");
			}
		}
		return element;

	}

	public void openCharles() throws IOException, InterruptedException {
		try {
			if(VootConstants.OS.equalsIgnoreCase("mac")) {
				Runtime.getRuntime().exec("open /Applications/Charles.app");
			}
			else {
				Runtime.getRuntime().exec("Charles.exe");
			}

			Thread.sleep(20000);
			VootConstants.localhost = InetAddress.getLocalHost();
			VootConstants.ipAdress = VootConstants.localhost.getHostAddress().trim();
			System.out.println("System IP Address : " + (VootConstants.localhost.getHostAddress()).trim());
			Thread.sleep(20000);
			Runtime.getRuntime()
					.exec("curl -v -x http://" + VootConstants.ipAdress + ":8888 http://control.charles/session/clear");
			Thread.sleep(2000);
			Runtime.getRuntime().exec(
					"curl -v -x http://" + VootConstants.ipAdress + ":8888 http://control.charles/recording/start");
		} catch (Exception e) {
		}

	}

	// To close charles
	public void closeCharles() {
		try {
			VootConstants.ipAddress = VootConstants.localhost.getHostAddress().trim();
			Runtime.getRuntime()
					.exec("curl -v -x http://" + VootConstants.ipAddress + ":8888 http://control.charles/quit");
		} catch (Exception e) {
		}
	}

	// To save and close charles sessoin saveandcloseCharles renamed to
	// saveAndCloseCharles
	public void saveandcloseCharles(String fileName) {
		try {
			UtilitiesWeb utilitiesWeb = new UtilitiesWeb();
			utilitiesWeb.createFolder(System.getProperty("user.dir")+ "/Reports/Charleslogs/");

 			DateFormat date = new SimpleDateFormat("ddmmyyHHMMss");
			Date date2 = new Date();
			String date1 = date.format(date2);
			VootConstants.charlesName = fileName + date1 + ".xml";
			VootConstants.charleslogsName = fileName + date1 + ".chls";
			
		 
				VootConstants.filePathxml = System.getProperty("user.dir")+ "/Reports/Charleslogs/" + VootConstants.charlesName;
				VootConstants.filePathlogs = System.getProperty("user.dir")+ "/Reports/Charleslogs/" + VootConstants.charleslogsName;
		
		 
			VootConstants.ipAdress = VootConstants.localhost.getHostAddress().trim();
			Thread.sleep(10000);
			Runtime.getRuntime().exec("curl -o " + VootConstants.filePathxml + " -x http://" + VootConstants.ipAdress
					+ ":8888 http://control.charles/session/export-xml");
			Thread.sleep(5000);
			Runtime.getRuntime().exec("curl -o " + VootConstants.filePathlogs + " -x http://"
					+ VootConstants.ipAdress + ":8888 http://control.charles/session/download");
			Thread.sleep(10000);
			Runtime.getRuntime()
					.exec("curl -v -x http://" + VootConstants.ipAdress + ":8888 http://control.charles/quit");
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Checking SBU values. sbuparams renamed to putParamsToSBUChannel
	public void sbuParams() {
		VootConstants.SBUChannel.put("Colors Hindi", "COH");
		VootConstants.SBUChannel.put("MTV", "MTV");
		VootConstants.SBUChannel.put("VOOT Originals", "VORG");
		VootConstants.SBUChannel.put("Colors Kannada", "COK");
		VootConstants.SBUChannel.put("Colors SUPER", "COS");
		VootConstants.SBUChannel.put("Colors Tamil", "TAMIL");
		VootConstants.SBUChannel.put("Colors Marathi", "COM");
		VootConstants.SBUChannel.put("Colors Bangla", "COB");
		VootConstants.SBUChannel.put("Colors Gujarati", "COG");
		VootConstants.SBUChannel.put("Colors Infinity", "COI");
		VootConstants.SBUChannel.put("Vh1", "VH1");
		VootConstants.SBUChannel.put("Nickelodeon", "NICK");
		VootConstants.SBUChannel.put("Voot eSports", "ESP");
		VootConstants.SBUChannel.put("VICE", "VIC");
		VootConstants.SBUChannel.put("CNN-News18", "CNN18");
		VootConstants.SBUChannel.put("News18 India", "NEI");
		VootConstants.SBUChannel.put("Firstpost", "FTP");
		VootConstants.SBUChannel.put("News18 Bangla", "NEB");
		VootConstants.SBUChannel.put("News18 Gujarati", "NEG");
		VootConstants.SBUChannel.put("News18 UP Uttarakhand", "NEUU");
		VootConstants.SBUChannel.put("News18 Rajasthan", "NERJ");
		VootConstants.SBUChannel.put("News18 Bihar Jharkhand", "NEBJ");
		VootConstants.SBUChannel.put("News18 MP Chhattisgarh", "NEMC");
		VootConstants.SBUChannel.put("VOOT", "VOOT");
	}

	// Fetch the properties from MP-Sheet fetchProperties renamed to
	// fetchMpProperties

	// To convert duration to minute and to hour . minandHrConversion renamed to
	// convertMinutesToHour
	public void convertMinutesToHour(String duration) {
		// String duration = "1261000";
		int durat = Integer.parseInt(duration);
		System.out.println("Duration before converting to minute: " + durat);
		int durmin = durat / 1000;
		durmin = durmin / 60;
		GlobalVariables.durminutes = Integer.toString(durmin) + "m";
		System.out.println("Duration after converting to minute: " + GlobalVariables.durminutes);
		int hour = durmin / 60;
		System.out.println("Hour: " + hour);
		durmin = durmin - hour * 60;
		String m = Integer.toString(durmin);
		String h = Integer.toString(hour);
		String newTime = h + "hr " + m + "mins";
		GlobalVariables.durhrs = newTime;
		System.out.println("Duration after converting to hr: " + GlobalVariables.durhrs);
	}

	// method to get Status code of URL StatusResponseCode renamed to
	// getResponseCodeStatus
	public int getResponseCodeStatus(String fileURL) throws Exception {
		HttpURLConnection connection = null;
		int code;
		try {
			URL url1 = new URL(fileURL);
			connection = (HttpURLConnection) url1.openConnection();
			connection.setDefaultUseCaches(false);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.connect();
		} catch (Exception e) {
		}
		code = connection.getResponseCode();
		System.out.println("Response Code of Kaltura URL is: " + code);
		return code;
	}

	// toGet the Api response requestUtilityget renamed to
	// requestUtilityGetWithParams
	public Response requestUtilityGetWithParams(String url, Map<String, String> map) {
		RestAssured.urlEncodingEnabled = false;
		Response resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.headers("Content-Type", "application/json").params(map).when().get(url);
		return resp;
	}

	// To Post with parameters. requestUtilitypost renamed to
	// requestUtilityPostWithParams
	public Response requestUtilityPostWithParams(String url, Map<String, String> map) {
		RestAssured.urlEncodingEnabled = false;
		Response resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.headers("Content-Type", "application/json").params(map).when().post(url);
		return resp;
	}

	// To Post with parameters. requestUtilitypostQuery renamed to
	// requestUtilityPostWithQuery
	public Response requestUtilityPostWithQuery(String url, Map<String, String> map) {
		RestAssured.urlEncodingEnabled = false;
		Response resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.headers("Content-Type", "application/json").queryParams(map).when().post(url);
		return resp;
	}

	// To post with body parameters requestUtilitypostBody renamed to
	// requestUtilityPostWithBody
	public Response requestUtilityPostWithBody(String url, Map<String, String> map) {
		RestAssured.urlEncodingEnabled = false;
		Response resp = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.headers("Content-Type", "application/json").body(map).when().post(url);
		return resp;
	}

	// Method to convert Minutes to Hour //Raghavendra Sir
	public String convertMinutesToHours(String duration_number) {

		String newsec = "";
		String newformat = "";
		String newMinformat = "";
		float duration = Integer.parseInt(duration_number);
		if (duration < 60) {
			int Duration = Integer.parseInt(duration_number);
			newsec = Duration + "s";
			return newsec;
		}
		float hours = (duration / 60) / 60; // since both are ints, you get an int
		int newHour = (int) hours;
		float minutes = Math.round((duration / 60) % 60);
		int newMinutes = (int) minutes;
		if (newMinutes == 60) {
			newHour++;
			newMinutes = 0;
		}
		if (newHour != 0) {
			if (newMinutes != 0) {
				newformat = newHour + "h" + " " + newMinutes + "m";
				return newformat;
			} else {
				newformat = newHour + "h";
				return newformat;
			}

		} else {
			newMinformat = newMinutes + "m";
			return newMinformat;
		}
	}
	
	
	
	

	// Method by Amresh
	// To convert the telecasted Id to date convertDatefrom_telecastedID renamed to
	// convertDateFromTelecastedID
	public static String convertDateFromTelecastedID(String DateFormat) {
		String newday = "";
		String zero = "0";
		String Year = "";
		if (DateFormat.equals(zero)) {
			String FormattedDate = zero;
			System.out.println("Telcasted Id is:" + zero);
			return FormattedDate;
		}
		String[] MonthArray = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		int date = Integer.parseInt(DateFormat);
		int day = date % 100;
		if (day < 10) {
			newday = "0" + Integer.toString(day);
		} else {
			newday = Integer.toString(day);
		}
		int month = (date % 10000) / 100;
		String monthName = MonthArray[month - 1];
		int year = (date / 10000) % 100;
		if (year < 10) {
			Year = "0" + Integer.toString(year);
		} else {
			Year = Integer.toString(year);
		}
		String FormattedDate = newday + " " + monthName + " " + Year;
		return FormattedDate;
	}

	// To convert String to Camelcase . convertCamelCase renamed to
	// convertToCamelCase
	public String convertToCamelCase(String toConvert) throws Exception {
		if (toConvert == "") {
			return "";
		} else {
			String finalString = "";
			String[] array = toConvert.toLowerCase().split(" ");
			for (int i = 0; i < array.length; i++) {
				char firstCharBefore = array[i].charAt(0);
				char firstCharAfter = Character.toUpperCase(firstCharBefore);
				String newWord = array[i].substring(1);
				newWord = firstCharAfter + newWord;
				System.out.println("////////////////////////" + newWord);
				array[i] = newWord;
				if (i == array.length - 1)
					finalString = finalString.concat(array[i]);
				else
					finalString = finalString.concat(array[i] + " ");
			}
			return finalString;
		}
	}

	// to create folder in specified path
	public void createFolder(String foldPath) {
		File f = new File(foldPath);
		if (!f.exists()) {
			f.mkdirs();
		}
	}

	// To wait until the visibility of the Element, wait_until_element_is_visible
	// renamed to waitUntilElementIsVisible
	public boolean waitUntilElementIsVisible(RemoteWebDriver driver, WebElement element, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			 System.out.println("[ELEMENT] not Visible: "+element);
			isElementEnabled = false;
		}
		return isElementEnabled;
	}

	// To wait until the element is enabled. wait_until_elememt_is_enable renamed to
	// waitUntilElememtIsEnabled
	public boolean waitUntilElememtIsEnabled(RemoteWebDriver driver, WebElement element, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			 System.out.println("[ELEMENT] not Enabled: "+element);
			isElementEnabled = false;
		}
		return isElementEnabled;
	}
	
	
	public boolean waitUntilElememtIsEnabledImplicitwait(RemoteWebDriver driver, WebElement element, int timeOut) {
		boolean isElementEnabled;
		try {
			//WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(timeOut,TimeUnit.SECONDS);
			//wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementEnabled = true;
		} catch (Exception e) {
			 System.out.println("[ELEMENT] not Enabled: "+element);
			isElementEnabled = false;
			System.out.println("element " + element.toString() + "' is not enabled even after waiting for :" + timeOut
					+ " seconds.");
		}
		return isElementEnabled;
	}
	
	
	public boolean waitUntilElementIsPresent(WebDriver driver,By locator, int timeout) {
		boolean isElementPresent=false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			isElementPresent = true;
		} catch (Exception e) {
			isElementPresent = false;
		}
		return isElementPresent;
	}
	
	
	
	

	// To switch to the parent window. switch_to_parent_window renamed to
	// switchToParentWindow
	public void switchToParentWindow(RemoteWebDriver driver) {
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(0));
	}

	// Scroll down by 2000
	public void scrollDownBy2000(RemoteWebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
	}

	// To generate random Password. generatePwd renamed to generateRandomPassword
	public String generateRandomPassword() {
		String strRandom = "";
		//String strAlpha = "abcdefghijklmnopqrstuvwxyzacvbe";
		String strAlpha = "abcdefghijklmnopqrstuvwxyzacvbe";
		String strNumerics = "0123456789";
		String strcharacters="#$@~+()%<>{}&*?";
		Random rnd = new Random();
		StringBuilder strRandomcharcter=new StringBuilder(9);
		StringBuilder strRandomNumber = new StringBuilder(9);
		StringBuilder strRandomAlpha = new StringBuilder(9);
		for (int i = 0; i < 4; i++) {
				
	         strRandomAlpha.append(strAlpha.charAt(rnd.nextInt(strAlpha.length())));
	         
	         
	        		
			strRandomNumber.append(strNumerics.charAt(rnd.nextInt(strNumerics.length())));
		}
		 strRandomcharcter.append(strcharacters.charAt(rnd.nextInt(strcharacters.length())));
		
		String capStr = strRandomAlpha.substring(0,1).toUpperCase() + strRandomAlpha.substring(1);
		strRandom = capStr + strRandomcharcter.toString() + strRandomNumber.toString();
		String pwd = strRandom;
		return pwd;
	}
	// To fetch Apiurl from property file getApiUrl_PropData renamed to
	// getApiUrlFromPropertyFile
	public String getApiUrlFromPropertyFile(String strKey) {
		FileInputStream fin = null;
		Properties prop = null;
		
//		System.out.println("Current value of apiURLs_uatFlag:  "+VootConstants.apiURLs_uatFlag);
		
		try {
			if (VootConstants.apiURLs_uatFlag) {
				if (VootConstants.OS.equalsIgnoreCase("mac")) {
					if(VootConstants.JioUrlsFlag) {
						fin = new FileInputStream(
								System.getProperty("user.dir") + "/src/com/viacom/web/properties/apiUrls_uat_Jio.properties");
					}
					else {
						fin = new FileInputStream(
								System.getProperty("user.dir") + "/src/com/viacom/web/properties/apiUrls_uat.properties");
					}
					prop = new Properties();
					prop.load(fin);
					if (VootConstants.environment.equalsIgnoreCase("stage") && strKey.equalsIgnoreCase("userTypeURL")) {
						strKey = "userTypeURL_Stage";
					}

					if (VootConstants.environment.equalsIgnoreCase("stage") && strKey.equalsIgnoreCase("PP2pageApI")) {
						strKey = "PP2pageApI_Stage";
					}

					fin.close();
					return prop.getProperty(strKey);

				} else {
					
					if(VootConstants.InternationalFlag==false)
					{
					if(VootConstants.JioUrlsFlag ) 
					{
						fin = new FileInputStream(
								System.getProperty("user.dir")+"\\src\\com\\viacom\\web\\properties\\apiUrls_uat_Jio.properties");
					}
					else  
					{
						fin = new FileInputStream(
								System.getProperty("user.dir")+"\\src\\com\\viacom\\web\\properties\\apiUrls_uat.properties");
					}
					}else
					{
						if(VootConstants.JioUrlsFlag ) 
						{
							fin = new FileInputStream(
									System.getProperty("user.dir")+"\\src\\com\\viacom\\web\\properties\\apiUrls_International_uat.properties");
						}
						else  
						{
							fin = new FileInputStream(
									System.getProperty("user.dir")+"\\src\\com\\viacom\\web\\properties\\apiUrls_International.properties");
						}
					}
					
					prop = new Properties();
					prop.load(fin);

					if (VootConstants.environment.equalsIgnoreCase("stage") && strKey.equalsIgnoreCase("userTypeURL")) {
						strKey = "userTypeURL_Stage";
					}

					if (VootConstants.environment.equalsIgnoreCase("stage") && strKey.equalsIgnoreCase("PP2pageApI")) {
						strKey = "PP2pageApI_Stage";
					}
					fin.close();
					return prop.getProperty(strKey);
				}

			} else {
				if (VootConstants.OS.equalsIgnoreCase("mac")) {
					
					if(VootConstants.JioUrlsFlag) {
						fin = new FileInputStream(
								System.getProperty("user.dir") + "/src/com/viacom/web/properties/apiUrls_Jio.properties");
					}
					else {
						fin = new FileInputStream(
								System.getProperty("user.dir") + "/src/com/viacom/web/properties/apiUrls.properties");
					}
					prop = new Properties();
					prop.load(fin);
					if (VootConstants.environment.equalsIgnoreCase("stage") && strKey.equalsIgnoreCase("userTypeURL")) {
						strKey = "userTypeURL_Stage";
					}

					if (VootConstants.environment.equalsIgnoreCase("stage") && strKey.equalsIgnoreCase("PP2pageApI")) {
						strKey = "PP2pageApI_Stage";
					}
					fin.close();
					return prop.getProperty(strKey);
				} else {
					
					if(VootConstants.InternationalFlag==false)
					{
					if(VootConstants.JioUrlsFlag) {
						fin = new FileInputStream(
								System.getProperty("user.dir")+"\\src\\com\\viacom\\web\\properties\\apiUrls_Jio.properties");
					}
					else {
						fin = new FileInputStream(
								System.getProperty("user.dir")+"\\src\\com\\viacom\\web\\properties\\apiUrls.properties");
					}
					}else
					{
						if(VootConstants.JioUrlsFlag ) 
						{
							
							fin = new FileInputStream(
									System.getProperty("user.dir")+"\\src\\com\\viacom\\web\\properties\\apiUrls_International.properties");
						
						}
						else  
						{
							fin = new FileInputStream(
									System.getProperty("user.dir")+"\\src\\com\\viacom\\web\\properties\\apiUrls_International_uat.properties");
						
						}
					}
					
					prop = new Properties();
					prop.load(fin);

					if (VootConstants.environment.equalsIgnoreCase("stage") && strKey.equalsIgnoreCase("userTypeURL")) {
						strKey = "userTypeURL_Stage";
					}

					if (VootConstants.environment.equalsIgnoreCase("stage") && strKey.equalsIgnoreCase("PP2pageApI")) {
						strKey = "PP2pageApI_Stage";
					}
					fin.close();
					return prop.getProperty(strKey);
				}
			}

		} catch (Exception e) {
			//System.out.println("Failed due to Exception: "+e.getMessage());
			return null;
		}

	}

	public String toCamelCase(final String init) {
		if (init == null)
			return null;
		final StringBuilder ret = new StringBuilder(init.length());
		for (final String word : init.split(" ")) {
			if (!word.isEmpty()) {
				ret.append(word.substring(0, 1).toUpperCase());
				ret.append(word.substring(1).toLowerCase());
			}
			if (!(ret.length() == init.length()))
				ret.append(" ");
		}
		return ret.toString();
	}

	public boolean isSubSequence(String str1[], String str2[], int m, int n) {
		// Base Cases
		if (m == 0)
			{
			return true;
			}
		if (n == 0)
			{
			return false;
			}
		// If last stirng of two strings are matching
		if (str1[m - 1].equalsIgnoreCase(str2[n - 1]))
			{
			return isSubSequence(str1, str2, m - 1, n - 1);
			}
		// If last string are not matching
		return isSubSequence(str1, str2, m, n - 1);
	}
 
	// For getting the full name of current Day of the Week - Author-Amresh
	public String getDayOfWeek() {
		Date now = new Date();
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
		// System.out.println(simpleDateformat.format(now));
		simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
		String datOfWeek = simpleDateformat.format(now);
		// System.out.println(datOfWeek);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		// System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		return datOfWeek;
	}

	// returns the OS name after trimming the version.
	public String getOSName() {
		String OS = System.getProperty("os.name");
		String[] osnames = OS.split(" ");
		String osname = osnames[0];
		return osname;
	}

	public void horizontalSwipeOnce(AppiumDriver<MobileElement> driver) {

		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();

		int startx = (int) (width * (0.8));// 0.7
		int endx = (int) (width * (0.5));// 0.5
		int starty = (int) (height * 0.25);
		int endy = (int) (height * 0.25);
		;
		// swipe from right to left//
		for (int i = 0; i < 1; i++) {
			try {

				TouchAction act = new TouchAction(driver);
				(new TouchAction(driver)).press(PointOption.point(startx, starty))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
						.moveTo(PointOption.point(endx, endy)).release().perform();
			} catch (Exception e) {
			}

		}
	}

	public void horizontalSwipeForCarosualOnce(AppiumDriver<MobileElement> driver, String end) {
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		int startx = (int) (width * (0.9));
		int endx = (int) (width * (0.05));
		int starty = (int) (height * 0.4);
		int endy = (int) (height * 0.4);
		;
		// swipe from right to left//
		for (int i = 0; i < 11; i++) {
			try {
				TouchAction act = new TouchAction(driver);
				(new TouchAction(driver)).press(PointOption.point(startx, starty))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
						.moveTo(PointOption.point(endx, endy)).release().perform();
			} catch (Exception e) {
			}
			if (driver.findElements(By.xpath(end)).size() > 0)
				break;
		}
	}

	// To close the window
	public void closeWindow(RemoteWebDriver driver) {
		try {
			Set<String> windows = driver.getWindowHandles();
			System.out.println("[Info] Window size: "+windows.size());// 2
			Iterator itr = (Iterator) windows.iterator();

			String fbWindow = "";
			String vootWindow = "";
			while (itr.hasNext()) {
				vootWindow = itr.next().toString();
				fbWindow = itr.next().toString();
			}
			for (String window : windows)
				driver.switchTo().window(window);
			driver.close();
			Thread.sleep(3000);
			driver.switchTo().window(vootWindow);
			Thread.sleep(3000);
		}

		catch (Exception e) {
			System.out.println("window is already closed");
		}
	}
 
	public void mandatoryLogin(RemoteWebDriver driver, ExtentTest test, String email, String password)
			throws Exception {
		SigninVootPageV3 signinPage = new SigninVootPageV3(driver, test);
		UtilitiesWeb utilties = new UtilitiesWeb();
		Actions action = new Actions(driver);
		event.log( "INFO", "Email : "+email);
		event.log( "INFO", "password : "+password);
		if (explicitWaitVisible(driver, signinPage.useAnotherAccount, 5)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", signinPage.useAnotherAccount);
		}
		
		if (waitUntilElememtIsEnabled(driver, signinPage.emailButton, 10)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", signinPage.emailButton);
		}
	
		if (VootConstants.PROJECT.equalsIgnoreCase("web")) {
			if (explicitWaitClickable(driver, signinPage.Email, 10)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", signinPage.Email);
			}
			if (explicitWaitClickable(driver, signinPage.emailField, 10)) {
				signinPage.emailField.sendKeys(email);
			}
			if (explicitWaitClickable(driver, signinPage.UatContinueBtn, 10)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", signinPage.UatContinueBtn);
				Thread.sleep(3000);
			}
			if (waitUntilElementIsVisible(driver, signinPage.passwordField, 10)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", signinPage.passwordField);
				signinPage.passwordField.sendKeys(password);
				Thread.sleep(2000);
			}
			if (explicitWaitClickable(driver, signinPage.UatContinueBtn, 10)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", signinPage.UatContinueBtn);
				Thread.sleep(3000);
			}
			Thread.sleep(4000);
			if (explicitWaitClickable(driver, signinPage.closeButton, 10)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", signinPage.closeButton);
				Thread.sleep(3000);
			}
			
			if(VootConstants.OS.equalsIgnoreCase("mac"))
			{
				waitUntilPageLoaded(driver);
				String cB="//button[text()='Continue']";
				if (explicitWaitClickable(driver, driver.findElement(By.xpath(cB)), 20)) 
				{
					driver.findElement(By.xpath(cB)).click();
				}
				
			}else
			{
				action.sendKeys(Keys.ENTER).perform();
				Thread.sleep(4000);
			}
			
			utilties.handleToastMessage(driver,test);
			

			if (waitUntilElementIsVisible(driver, signinPage.UserprofileafterLogin, 10)) {
				event.log( "INFO", "Logged in successfully");
			} else {
				event.log( "ERROR/WOSS", "Not Logged in successfully");
			}
		}
		if ((VootConstants.PROJECT).equalsIgnoreCase("PWA")) {

			if (explicitWaitVisible(driver, signinPage.Pwaemail, 30)) {
				signinPage.Pwaemail.clear();
				signinPage.Pwaemail.click();
				signinPage.driver.getKeyboard();
				signinPage.Pwaemail.sendKeys(email);
				
				   try {
                       ((AppiumDriver)driver).hideKeyboard();
                        Thread.sleep(2000);
                   } catch (Exception e) {
                       // TODO Auto-generated catch block
                       event.log( "EXCEPTION", "Failed Due to: " + e.getMessage());
                   } 
				if (explicitWaitVisible(driver, signinPage.Pwacontinuebutton, 30)) {

					System.out.println("[Info]: "+ signinPage.Pwacontinuebutton.isEnabled());

					signinPage.Pwacontinuebutton.click();
					if (explicitWaitVisible(driver, signinPage.Pwapassword, 30)) {
						signinPage.Pwapassword.clear();
						signinPage.Pwapassword.sendKeys(password);
						   try {
	                            ((AppiumDriver)driver).hideKeyboard();
	                             Thread.sleep(2000);
	                        } catch (Exception e) {
	                            // TODO Auto-generated catch block
	                            event.log( "EXCEPTION", "Failed Due to: " + e.getMessage());
	                        } 
						if (explicitWaitVisible(driver, signinPage.Pwacontinuebutton, 30)) {
							((JavascriptExecutor) driver).executeScript("arguments[0].click();",
									signinPage.Pwacontinuebutton);
							Thread.sleep(3000);
							
							utilties.handleToastMessage(driver,test);
							Thread.sleep(4000);
							if (explicitWaitClickable(driver, signinPage.closeButton, 10)) {
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", signinPage.closeButton);
								Thread.sleep(3000);
							}
							
							if (explicitWaitVisible(driver, signinPage.pwaHamburgermenubar, 40)) {
								((JavascriptExecutor) driver).executeScript("arguments[0].click();",
										signinPage.pwaHamburgermenubar);
								if (explicitWaitVisible(driver, signinPage.pwausername, 30)) {
									event.log( "INFO", "VOOT-PWA launched Successfully ");
									event.log( "INFO", "User logged In Successfully");
									if (explicitWaitVisible(driver, signinPage.pwacloseicon, 50)) {
										waitUntilPageLoaded(driver);
										((JavascriptExecutor) driver).executeScript("arguments[0].click();",
												signinPage.pwacloseicon);
										waitUntilPageLoaded(driver);
									}
								} else {
									event.log( "FAIL/WOSS", "login is unsuccessful");
									

								}

							}

						}

					}
				}
			}

		}
	}

	// To capture the ScreenShot. capture_screenshot renamed to
	// captureScreenshotWithName
	public String captureScreenshotWithName(RemoteWebDriver driver, boolean screenshotToFile) throws IOException {

		String screenShotFilePath = "";
		String screenShotName = "";
		String returnString = "";
		BaseTestWeb baseTest = new BaseTestWeb();
		try {
			if (!screenshotToFile) {
				TakesScreenshot ts = (TakesScreenshot) driver;
				String image = ts.getScreenshotAs(OutputType.BASE64);
				String image2 = createResizedCopy(image, 800, 600, true);
				return image2;
				// return image;
			} else if (screenshotToFile) {
				if (VootConstants.OS.equalsIgnoreCase("Windows")) {
					screenShotFilePath = baseTest.screenShotFilePath + baseTest.className + "_" + baseTest.hour + "\\";
				}

				else if (VootConstants.OS.equalsIgnoreCase("Mac")) {
					screenShotFilePath = baseTest.screenShotFilePath + baseTest.className + "_" + baseTest.hour + "/";
				}

				createFolder(screenShotFilePath);
				screenShotName = baseTest.methodName + "_" + getTimeStamp_sec() + ".png";
				TakesScreenshot ts = (TakesScreenshot) driver;
				File ScreenShot = ts.getScreenshotAs(OutputType.FILE);
				String destpath = "";

				destpath = screenShotFilePath + screenShotName;

				File destPath = new File(destpath);

				FileUtils.moveFile(ScreenShot, destPath);

				returnString = destpath;
			}
		} catch (Exception e) {
			//System.out.println("Failed due to Exception: "+e.getMessage());
		}
		return returnString;
	}

	public String getTimeStamp() {
		Instant instant = Instant.now();
		// java.util.Date date= new java.util.Date();
		Long time = instant.getEpochSecond();
		return time.toString();
	}
	


public String getUserName(String Name) throws IOException {
	FileReader fin = null;
	Properties prop = null;
	String Jenkinsusername = System.getProperty("Jusername");
	String Jenkinspassword = System.getProperty("Jpassword");
//	System.out.println("Jenkins UN : "+ Jenkinsusername);
//	System.out.println("Jenkins PW : "+ Jenkinspassword);
	String Requestedusername="";
	if (VootConstants.OS.equalsIgnoreCase("mac")) {
		fin = new FileReader(".//src/com/viacom/web/properties/credentials.properties");
		prop = new Properties();
		prop.load(fin);
		fin.close();
		if (Jenkinsusername==null || Jenkinspassword==null) {
				Requestedusername = prop.getProperty(Name);
		}
		else {
			 Requestedusername=Jenkinsusername;
			}
		System.out.println("[Property] Returning Username: "+Requestedusername);
		return Requestedusername;
	} else {
		fin = new FileReader(
				System.getProperty("user.dir") + "\\src\\com\\viacom\\web\\properties\\credentials.properties");
		prop = new Properties();
		prop.load(fin);
		fin.close();
		if (Jenkinsusername==null || Jenkinspassword==null) {
			Requestedusername = prop.getProperty(Name);
		}
		else {
			Requestedusername=Jenkinsusername;
			}
		System.out.println("[Property] Returning Username: "+Requestedusername);
		return Requestedusername;
	}
}

public String getPassWord(String Pass) throws IOException {
	FileReader fin = null;
	Properties prop = null;
	String Jenkinsusername = System.getProperty("Jusername");
	String Jenkinspassword = System.getProperty("Jpassword");
	System.out.println("[Info] Jenkins UN : "+ Jenkinsusername);
	System.out.println("[Info] Jenkins PW : "+ Jenkinspassword);
	String RequestedPassword="";
	if (VootConstants.OS.equalsIgnoreCase("mac")) {
		fin = new FileReader(".//src/com/viacom/web/properties/credentials.properties");
		prop = new Properties();
		prop.load(fin);
		fin.close();
		if (Jenkinsusername==null || Jenkinspassword==null) {
			RequestedPassword = prop.getProperty(Pass); 
		}
		else {
			RequestedPassword=Jenkinspassword;
			}
		System.out.println("[Property] Returning Password: "+RequestedPassword);
		return RequestedPassword;
	} else {
		fin = new FileReader(
				System.getProperty("user.dir") + "\\src\\com\\viacom\\web\\properties\\credentials.properties");
		prop = new Properties();
		prop.load(fin);
		fin.close();
		if (Jenkinsusername==null || Jenkinspassword==null) {
			RequestedPassword = prop.getProperty(Pass);
		}
		else {
			RequestedPassword=Jenkinspassword;
			}
		System.out.println("[Property] Returning Password: "+RequestedPassword);
		return RequestedPassword;
	}
}

//Method to convert seconds to minutes
	public String convertSectoMinute(String duration_number) {
		
//		String newMinformat = "";
//		
//		int durat = Integer.parseInt(duration_number);
//		if(durat < 60) {
//			newMinformat=durat + " sec";
//			System.out.println("newMinformat :"+newMinformat);
//		} else {
//			
//		float duration = Integer.parseInt(duration_number);
//		
//		float minutes = Math.round((duration / 60) % 60);
//		int newMinutes = (int) minutes;
//		
//		newMinformat = newMinutes + " min";
//		System.out.println("newMinformat :"+newMinformat);
//		}
//		
//		return newMinformat;
		
		String newsec = "";
		String newformat = "";
		String newMinformat = "";
		float duration = Integer.parseInt(duration_number);
		if (duration < 60) {
			int Duration = Integer.parseInt(duration_number);
			newsec = Duration + " sec";
			return newsec;
		}
		float hours = (duration / 60) / 60; // since both are ints, you get an int
		int newHour = (int) hours;
		float minutes = Math.round((duration / 60) % 60);
		int newMinutes = (int) minutes;
		if (newMinutes == 60) {
			newHour++;
			newMinutes = 0;
		}
		if (newHour != 0) {
			if (newMinutes != 0) {
				newformat = newHour + " hrs" + " " + newMinutes + " min";
				return newformat;
			} else {
				newformat = newHour + " hrs";
				return newformat;
			}

		} else {
			newMinformat = newMinutes + " min";
			return newMinformat;
		}
		
	}

	// convert seconds to hh mm ss format
	public static String formatSeconds(int timeInSeconds)
	{
	    int hours = timeInSeconds / 3600;
	    int secondsLeft = timeInSeconds - hours * 3600;
	    int minutes = secondsLeft / 60;
	    int seconds = secondsLeft - minutes * 60;

	    String formattedTime = "";
	    if (hours < 10)
	    formattedTime += hours + "h"+" ";

	    if (minutes < 10)
	        formattedTime += "";
	    formattedTime += minutes + "m";

//	    if (seconds < 10)
//	        formattedTime += "";
//	    formattedTime += seconds +"s";

	    return formattedTime;
	}


  // Buying the subscription through automate1 plan in pp2 page




     public void handleToastMessage(RemoteWebDriver driver, ExtentTest test)
     {
			SigninVootPageV3 signinPage = new SigninVootPageV3(driver, test);
			UtilitiesWeb utilitiesWeb = new UtilitiesWeb();

//    	 if (VootConstants.OS.equalsIgnoreCase("mac") ) {
			try {
				if (utilitiesWeb.explicitWaitClickable(driver, signinPage.toastMessageFrame, 10)) {
					driver.switchTo().frame(signinPage.toastMessageFrame);
					if (utilitiesWeb.waitUntilElememtIsEnabled(driver, signinPage.toastMessage, 20)) {

						((JavascriptExecutor) driver).executeScript("arguments[0].click();", signinPage.toastMessage);
						event.log( "INFO", "Toast Message Found and its closed ");
					} else {

						event.log( "INFO", "Toast Message Not Found  ");
					}
					driver.switchTo().parentFrame();
				}
			} catch (Exception e) {
				//System.out.println("Failed due to Exception: "+e.getMessage());
			} 
//     }
    	 
    }

    
	
	
	
}
