package com.viacom.web.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.viacom.web.pages.BasePage;
import com.viacom.web.pages.SigninVootPageV3;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class Base_Test_Web_Utils {
	public static RemoteWebDriver driver;
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public ExtentTest mainTest;
	public static ExtentTest test;
 	public static Status status;
 	public static Properties prop;
	public static FileReader reader;
	public String testName;
	public String testCaseName;
	public String suiteName;
	public static Logger logger;
	public static InetAddress systemAddress;
	public static File file;
	public static String report_filePath;
	public static DesiredCapabilities capabilities;
//	public static ThreadLocal parent = new ThreadLocal();
//	public static ThreadLocal child = new ThreadLocal();
	public static String mainWindow;
	public static EventUtils event=new EventUtils(driver, test);


	// To Launch the browser and navigate to url
	public void launchWeb(String os_Type, String bType) throws Exception {

		UtilitiesWeb utilities = new UtilitiesWeb();

		// launch the PWA
		if ((VootConstants.PROJECT).equalsIgnoreCase("PWA")) {

			UtilitiesWeb utilitiesWeb = new UtilitiesWeb();

			utilitiesWeb.startAppiumServer();
			if (VootConstants.OS.equalsIgnoreCase("windows")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				options.addArguments("--disable-infobars");
				options.addArguments("androidPackage", "com.android.chrome");
//			    options.addArguments("--enable-popup-blocking");
				options.addArguments("--disable-popup-blocking");
				options.setExperimentalOption("w3c", false);
				capabilities.setCapability(MobileCapabilityType.PLATFORM, VootConstants.PLATFORM_NAME);
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, VootConstants.DEVICE_VERSION);
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, VootConstants.DEVICE_NAME);
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, VootConstants.browser);
				capabilities.setCapability(MobileCapabilityType.UDID, VootConstants.UDID);
				capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
				capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
				capabilities.setCapability("deviceOrientation", "portrait");
				capabilities.setCapability("unlockType", "pin");
				capabilities.setCapability("unlockKey", "1111");
				capabilities.setCapability("autoAcceptAlerts", true);

				capabilities.setCapability(ChromeOptions.CAPABILITY, options);

				capabilities.setCapability(MobileCapabilityType.SUPPORTS_APPLICATION_CACHE, true);
				capabilities.setCapability(MobileCapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, false);
//				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
				capabilities.setCapability("newCommandTimeout", 60 * 5);
				System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
				
				
				try {
					driver = new AndroidDriver<MobileElement>(new URL(VootConstants.HUB_URL), capabilities);
				
					try {
						SigninVootPageV3 signinPage = new SigninVootPageV3(driver, test);
						signinPage.deviceToportrait();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						event.log( "EXCEPTION", "Failed Due to: " + e.getMessage());
					}
				
				
				} catch (Exception e) {
					System.out.println("Desired Capabilities not Set Properly" + e.getMessage());
				}
			} else {

				DesiredCapabilities capabilities = new DesiredCapabilities();
				ChromeOptions options = new ChromeOptions();
				capabilities.setCapability("platformName", VootConstants.PLATFORM_NAME);
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, VootConstants.DEVICE_VERSION);
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, VootConstants.DEVICE_NAME);
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, VootConstants.browser);
				capabilities.setCapability(MobileCapabilityType.UDID, VootConstants.UDID);
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, VootConstants.AUTOMATION_NAME);
				capabilities.setCapability("xcodeSigningId", "iPhone Developer");
				capabilities.setCapability("xcodeOrgId", VootConstants.XCODE_ORG_ID);
				capabilities.setCapability("newCommandTimeout", 60 * 5);

				if (VootConstants.PLATFORM_NAME.equalsIgnoreCase("android")) {
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					options.addArguments("--disable-notifications");
					options.addArguments("--disable-infobars");
					options.addArguments("androidPackage", "com.android.chrome");
//			        options.addArguments("--enable-popup-blocking");
					options.addArguments("--disable-popup-blocking");
					options.setExperimentalOption("w3c", false);
					capabilities.setCapability("newCommandTimeout", 60 * 5);
					try {
						driver = new AndroidDriver<MobileElement>(new URL(VootConstants.HUB_URL), capabilities);
					} catch (MalformedURLException e) {
						System.out.println("Desired Capabilities not Set Properly" + e.getMessage());
					}
				} else {
					capabilities.setCapability("useNewWDA", false);
//					capabilities.setCapability("startIWDP", true);
					capabilities.setCapability("usePrebuiltWDA", true);
//					capabilities.setCapability("clearSystemFiles", true);
//					capabilities.setCapability("shouldUseSingletonTestManager", false);
//					capabilities.setCapability("clearSystemFiles", true);
//					capabilities.setCapability("useJSONSource", true);
//					capabilities.setCapability("waitForQuiescence", false);
//					capabilities.setCapability("AUTO_WEBVIEW", true);
//					capabilities.setCapability("NATIVE_APP", true);
					try {
						driver = new IOSDriver<WebElement>(new URL(VootConstants.HUB_URL), capabilities);
					} catch (Exception e) {
						System.out.println("Desired Capabilities not Set Properly" + e.getMessage());
					}
				}

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			}

			driver.get(VootConstants.URL);
			// driver.navigate().to(VootConstantsWeb.URL);
			// Thread.sleep(10000);

			if (driver.getCurrentUrl().equals(VootConstants.URL)) {
				System.out.println("Voot PWA launched successfully");
			} else {
				System.out.println("Browser did not launch as network connectivity dropped");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
		}

		if ((VootConstants.PROJECT).equalsIgnoreCase("WEB")) {
			System.setProperty("webdriver.chrome.silentOutput", "true");
			java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
			
			BrowserDriver bDriver = new BrowserDriver();
			if (os_Type.equalsIgnoreCase("Mac")) {
				switch (bType.toLowerCase()) {
				case "Firefox":
					// WebDriverManager.firefoxdriver().setup();
					// FirefoxProfile ffprofile = new FirefoxProfile();
					// ffprofile.setPreference("dom.webnotifications.enabled", false);
					driver = new FirefoxDriver();
					bDriver.set(driver);
					bDriver.get().manage().deleteAllCookies();

					break;
				case "chrome":
					/*
					 * ChromeOptions options = new ChromeOptions();
					 * 
					 * options.addArguments("--disable-notifications"); driver= new
					 * ChromeDriver(options);
					 */
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-notifications");
					// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					// capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					// capabilities.setCapability("pageLoadStrategy", "normal");
 
					driver = new ChromeDriver(options);
					bDriver.set(driver);
					bDriver.get().manage().window().maximize();
					bDriver.get().manage().deleteAllCookies();
					break;
				case "ie":
					WebDriverManager.iedriver().setup();
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);

					capabilities.setCapability("requireWindowFocus", true);
					driver = new InternetExplorerDriver();
					bDriver.set(driver);
					bDriver.get().manage().window().maximize();
					break;
				case "safari":
//					// System.setProperty("webdriver.ie.driver", VootConstantsWeb.IE_DRIVER_EXE);
//					// FirefoxProfile ffprofile = new FirefoxProfile();
//					// ffprofile.setPreference("dom.webnotifications.enabled", false);
//					Runtime.getRuntime().exec("killall safaridriver");
//					capabilities = DesiredCapabilities.safari();
//					// capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
//					// true);
//					 capabilities.setCapability("requireWindowFocus", true);
//					driver = new SafariDriver(capabilities);
//					bDriver.set(driver);
//					bDriver.get().manage().window().maximize();
					
					
					
					
					
					/* ************************Srini Changes Starts ********************************/
					
					Runtime.getRuntime().exec("killall safaridriver");
					//capabilities = DesiredCapabilities.safari();
					// capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					// true);
					try {
					DriverManagerType safari = DriverManagerType.SAFARI;
					WebDriverManager.getInstance(safari).setup();
					Class<?> safariClass =  Class.forName(safari.browserClass());
					driver = (RemoteWebDriver) safariClass.getDeclaredConstructor().newInstance();
					//driver = new SafariDriver();
					bDriver.set(driver);
					bDriver.get().manage().window().maximize();
					}catch(Exception a) {
						System.out.println("Error ::: "+a);
					}
					/* ************************Srini Changes Ends ********************************/

			 	
					
					break;
				case "safaritechnologypreview":

					Runtime.getRuntime().exec("killall safaridriver");
					SafariOptions safariOptions = new SafariOptions();
					safariOptions.setUseTechnologyPreview(true);
					driver = new SafariDriver(safariOptions);
					capabilities = DesiredCapabilities.safari();
					capabilities.setCapability("requireWindowFocus", true);
					bDriver.set(driver);
					bDriver.get().manage().window().maximize();
					break;
				default:
					event.log( "FAIL", "Given OS : '" + os_Type + "'or Given Browser :'" + bType + "' is invalid");
					break;
				}
			} else if (os_Type.equalsIgnoreCase("windows")) {
				switch (bType.toLowerCase()) {
				case "firefox":

					WebDriverManager.firefoxdriver().setup();
					FirefoxOptions ffoptions = new FirefoxOptions();
					ffoptions.addArguments("--start-maximized");

					if(VootConstants.KLOV_FLAG) {
						ffoptions.addArguments("--headless");
						ffoptions.addArguments("--window-size=1920,1080");

					}
//					ffoptions.addArguments("--disable-extensions");

					driver = new FirefoxDriver(ffoptions);
					bDriver.set(driver);
					bDriver.get().manage().deleteAllCookies();
//					bDriver.get().manage().window().maximize();
					break;
					
				case "chrome":
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					
					if(VootConstants.KLOV_FLAG) {
						options.addArguments("--headless");
						options.addArguments("--window-size=1920,1080");
					}
// 					options.addArguments("--incognito");
					options.addArguments("--start-maximized");
//					options.addArguments("--ignore-certificate-errors");
//					options.addArguments("--disable-popup-blocking");
//  				options.addArguments("--enable-precise-memory-info");
// 					options.addArguments("--disable-default-apps");
// 					options.addArguments("--disable-notifications");
// 					options.addArguments("--ignore-certificate-errors");
// 					options.addArguments("--disable-extensions");
					driver = new ChromeDriver(options);
					bDriver.set(driver);
					bDriver.get().manage().deleteAllCookies();
//					bDriver.get().manage().window().maximize();
					break;
				case "ie":
					WebDriverManager.iedriver().setup();
					// FirefoxProfile ffprofile = new FirefoxProfile();
					// ffprofile.setPreference("dom.webnotifications.enabled", false);
					capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);

					capabilities.setCapability("requireWindowFocus", true);
					driver = new InternetExplorerDriver(capabilities);
					bDriver.set(driver);
					bDriver.get().manage().window().maximize();
					break;
				 
				default:
					event.log( "FAIL", "Given OS : '" + os_Type + "'or Given Browser :'" + bType + "' is invalid");
					break;
				}
			}
			utilities.waitUntilPageLoaded(driver);

//			bDriver.get().manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			try {
				bDriver.get().get(VootConstants.URL);
				utilities.waitUntilPageLoaded(driver);
			} catch (TimeoutException e) {
				try {
					bDriver.get().navigate().to(VootConstants.URL);
					utilities.waitUntilPageLoaded(driver);
				} catch (TimeoutException ex) {

					try {
						bDriver.get().navigate().to(VootConstants.URL);
						utilities.waitUntilPageLoaded(driver);
					} catch (TimeoutException exe) {
						System.out.println("[INFO] Page is not loaded for long time.");
					}
				}
			}
			utilities.waitUntilPageLoaded(driver);
			event.log( "INFO" ,String.format("Opened %s in %s Browser.", VootConstants.URL, bType));
 		}

		// To load and read the property files

	}
	
	

	public FileReader loadPropertyFile(String propfilename) throws Exception {
		if (VootConstants.OS.equalsIgnoreCase("mac")) {
			prop = new Properties();
			String propUrl = System.getProperty("user.dir") + "/src/com/viacom/web/properties/" + propfilename;
			System.out.println();
			file = new File(propUrl);
			reader = new FileReader(file);

		} else {
			prop = new Properties();
			String propUrl = System.getProperty("user.dir") + "\\src\\com\\viacom\\web\\properties\\" + propfilename;
			file = new File(propUrl);
			reader = new FileReader(file);
		}
		return reader;
	}

	// To generate the report at class level
	public void initializeReportClassLevel(String executionType) throws UnknownHostException {

		UtilitiesWeb utilities = new UtilitiesWeb();
		if (VootConstants.OS.equalsIgnoreCase("mac")) {
			utilities.createFolder(VootConstants.REPORT_PATH_MAC + "//Class//");
			report_filePath = VootConstants.REPORT_PATH_MAC + "//Class//" + VootConstants.PROJECT + "_"
					+ VootConstants.USERTYPE + "_" + VootConstants.environment + "_" + VootConstants.browser + "_"
					+ this.getClass().getSimpleName() + "_" + getTimeStamp() + ".html";
			reporter = new ExtentHtmlReporter(report_filePath);
			reportConfigurations();
		} else {
			utilities.createFolder(VootConstants.REPORT_PATH + "//Class//");
			report_filePath = VootConstants.REPORT_PATH + "//Class//" + VootConstants.PROJECT + "_"
					+ VootConstants.USERTYPE + "_" + VootConstants.environment + "_" + VootConstants.browser + "_"
					+ this.getClass().getSimpleName() + "_" + getTimeStamp() + ".html";
			reporter = new ExtentHtmlReporter(report_filePath);
			reportConfigurations();
		}
	}

	static String Report_Name = "";

	// To generate the report at suite level
	public void initializeReportSuiteLevel(String name) throws UnknownHostException {
		UtilitiesWeb utilities = new UtilitiesWeb();
		String device_Name = "NA", device_os = "NA";
		if (VootConstants.PROJECT.equalsIgnoreCase("PWA")) {
			device_Name = VootConstants.DEVICE_NAME;
			device_os = VootConstants.DEVICE_VERSION;
		}

		Report_Name = VootConstants.PROJECT + "_" + name + "_" + VootConstants.USERTYPE + "_" + VootConstants.environment
				+ "_" + VootConstants.OS + "_" + VootConstants.PLATFORM_NAME + "_" + VootConstants.browser + "_"
				+ device_Name + "_" + device_os + "_" + getTimeStamp() + ".html";

		if (VootConstants.OS.equalsIgnoreCase("mac")) {
			utilities.createFolder(VootConstants.REPORT_PATH_MAC);

			report_filePath = VootConstants.REPORT_PATH_MAC + Report_Name;
			reporter = new ExtentHtmlReporter(report_filePath);
			reportConfigurations();

		} else {
			utilities.createFolder(VootConstants.REPORT_PATH);
			report_filePath = VootConstants.REPORT_PATH + Report_Name;
			reporter = new ExtentHtmlReporter(report_filePath);
			reportConfigurations();
			 
		}
	}

	// Configure report with Klov
	public void reportConfigurations() throws UnknownHostException {
		reporter.setAppendExisting(true);
		reporter.config().setChartVisibilityOnOpen(true);
		reporter.config().setDocumentTitle("Voot_Web " + suiteName + VootConstants.browser);
		reporter.config().setProtocol(Protocol.HTTPS);
		reporter.config().setEncoding("UTF-8");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Suite_" + VootConstants.browser + getTimeStamp());
		report = new ExtentReports();
		
		// Amresh Code starts
//			if (VootConstants.KLOV_FLAG) {
//				try {
//				KlovReporter klovReporter = new KlovReporter();
//				klovReporter.initMongoDbConnection("192.168.12.48", 27017);
//				klovReporter.setProjectName(VootConstants.EMAIL_SUBJECT);
//				klovReporter.setReportName(Report_Name);
//				klovReporter.setKlovUrl("http://192.168.12.48/");
//				report.attachReporter(klovReporter, reporter);
//				} catch (Exception e) {
//					report = new ExtentReports();
//					report.attachReporter(reporter);
//				}
//			} else {
//				report.attachReporter(reporter);
//			}
			
		// Amresh Code ends
		report.attachReporter(reporter);
		systemAddress = Inet4Address.getLocalHost();
		report.setSystemInfo("Build Version",  VootConstants.APP_VERSION);
		report.setSystemInfo("IP Address", systemAddress.getHostAddress());
		report.setSystemInfo("Host Name", systemAddress.getHostName());
		report.setSystemInfo("User Name", System.getProperty("user.name"));
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
	}

	// To Kill the crome browser
	public void killProcess() throws IOException {
		if (driver != null) {
			if (VootConstants.OS.equalsIgnoreCase("windows")) {
 				try {
					driver.quit();
					System.out.println("[EVENT] Quiting Driver.");

				} catch (Exception e) {
				}
			}
			if (VootConstants.OS.equals("Mac")) {
				try {
					clearCookies();
					driver.manage().deleteAllCookies();
					System.out.println("[EVENT] Quiting Driver.");
					driver.quit();

				} catch (Exception e) {
					System.out.println("[EVENT] Quiting Driver.");
					driver.quit();
				}
			}
		}
	}

	// To get current time
	public String getTimeStamp() {
		Date d = new Date();
		return d.toString().replace(":", "_").replace(" ", "_");
	}

	public static void main(String[] args) {
		String name = "ie";
		String report_filePath = VootConstants.REPORT_PATH_MAC + "\\Suite\\" + "Suite_" + VootConstants.browser + "_"
				+ name + "_" + ".html";
		System.out.println(report_filePath);
	}
	public void clearCookies( ){
		((JavascriptExecutor)driver).executeScript(
		" var cookies = document.cookie.split(';');								"
		+ " for (var i = 0; i < cookies.length; i++) {							"
		+ " var cookie = cookies[i];      										"
		+ " var eqPos = cookie.indexOf('=');  									"
		+ " var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;			"
		+ " document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:00 GMT';	"
		+ " };");
		}
}
