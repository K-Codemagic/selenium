package com.viacom.web.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.viacom.web.pages.SigninVootPageV3;

public class BaseTestWeb extends Base_Test_Web_Utils {
	// @Parameters({ "browserName" })
	// As of now we are not passing browser name from testNG , if required we will
	// uncomment the above line and also in testng.xml and pass "String browser" as
	// parameter to setup() below.
	public static String className = "";
	public static XSSFWorkbook wb;
	public static XSSFSheet firstSheet;
	public static FileOutputStream fileOut = null;
	public static String NewFileName = "";
	public static String methodName;
	public static String hour = "";
	public static String screenShotFilePath = "";
	public static String OldUrl = "";
	public static boolean OldEnv;
	public static String NewUrl = "";
	public static boolean NewEnv;
	public static File dest;
	public static String timeStamp;
	public static String Workspacepath="";
 
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(@Optional ITestContext ctx) {

		VootConstants vootConstants = new VootConstants();

		String klovflag = System.getProperty("Jklovflag");
		if (klovflag == null) {
			klovflag = String.valueOf(VootConstants.KLOV_FLAG);
		}

		String project = System.getProperty("project");
		if (project == null) {
			project = VootConstants.PROJECT;
		}

		String environment = System.getProperty("environment");
		if (environment == null) {
			environment = VootConstants.environment;
		}

		String OS = System.getProperty("OS");
		if (OS == null) {
			OS = VootConstants.OS;
		}

		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = VootConstants.browser;
		}

		String userType = System.getProperty("userType");
		if (userType == null) {
			userType = VootConstants.USERTYPE;
		}

		String apiUrlsFlag = System.getProperty("uatApiUrlsFlag");
		if (apiUrlsFlag == null) {
			apiUrlsFlag = String.valueOf(VootConstants.apiURLs_uatFlag);
		}

		String Judid = System.getProperty("Judid");
		if (Judid == null) {
			Judid = VootConstants.UDID;
		}
		String J_JioFlag = System.getProperty("J_JioFlag");
		if (J_JioFlag == null) {
			J_JioFlag = String.valueOf(VootConstants.JioUrlsFlag);
		}
		
		String J_InternationalFlag = System.getProperty("J_InternationalFlag");
		if (J_InternationalFlag == null) {
			J_InternationalFlag = String.valueOf(VootConstants.InternationalFlag);
		}
		
		String J_REPORT_EMAIL = System.getProperty("J_REPORT_EMAIL");
		if (J_REPORT_EMAIL == null) {
			J_REPORT_EMAIL = String.valueOf(VootConstants.REPORT_EMAIL);
		}

		vootConstants.vootConstants(project, environment, OS, browser, userType, apiUrlsFlag, Judid, klovflag,
				J_JioFlag, J_InternationalFlag, J_REPORT_EMAIL);

		try {
			suiteName = ctx.getCurrentXmlTest().getSuite().getName().replace(" ", "_");

			initializeReportSuiteLevel(suiteName);

			String IP_adress = systemAddress.getHostAddress().replace(".", "_");

			if (VootConstants.OS.equalsIgnoreCase("Windows")) {
				screenShotFilePath = VootConstants.SCREENSHOT_PATH + IP_adress + "\\" + getDateStamp() + "\\";
			}

			else if (VootConstants.OS.equalsIgnoreCase("Mac")) {
				screenShotFilePath = VootConstants.SCREENSHOT_PATH_MAC + IP_adress + "/" + getDateStamp() + "/";
			}

			timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String fileName = "ExecutionLog_" + timeStamp + ".log";
			String filePath = "";
			filePath = System.getProperty("user.dir")+"/Reports/Logs/" + fileName;
			 

			File f = new File(filePath);
			System.setProperty("log.file", filePath);
			System.setProperty("log.parent.path", f.getParent());
			System.setProperty("log.file.name", FilenameUtils.getBaseName(f.getName()));
			logger = LogManager.getRootLogger();
			org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);

			logger.trace("Initializing the log file in before suite.");
			logger.trace("Executing the suite file : " + suiteName);

			 
		} catch (UnknownHostException e1) {

			event.log( "EXCEPTION", "Failed Due to: " + e1.getMessage());
		}
		if (VootConstants.PROJECT.equalsIgnoreCase("PWA") && VootConstants.PLATFORM_NAME.equalsIgnoreCase("Android")) {
			try {
				Runtime.getRuntime().exec("adb uninstall com.tv.v18.viola");
				System.out.println("[Event] Voot App if present, then Uninstalled or Not Present Now");
			} catch (Exception g) {
				System.err.println("[EXCEPTION] Unable to Uninstall Voot App");
				event.printStackTrace(g);
			}
		}
		// Amresh Code Ends
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest(ITestContext ctx) {
		logger.trace("Executing the test file : " + ctx.getCurrentXmlTest().getName());
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass(ITestContext ctx) {
		testName = ctx.getCurrentXmlTest().getSuite().getName() + " : " + ctx.getCurrentXmlTest().getName();
		logger.trace("Executing the class : " + this.getClass().getSimpleName());
		mainTest = report.createTest(testName + " : " + this.getClass().getSimpleName());
		mainTest.assignCategory(ctx.getCurrentXmlTest().getName());
		className = this.getClass().getSimpleName();
		hour = hourStamp();

	}

	@BeforeMethod(alwaysRun = true)
	public void setup(Method testName) throws InterruptedException {
		System.err.println("[BEFORE-METHOD] Starting Test execution of: " + testName.getName());
		testCaseName = testName.getName();
		logger.trace("Executing the test case : " + testCaseName);
		test = mainTest.createNode(testCaseName);
		methodName = testCaseName;
		OldUrl = VootConstants.URL;
		OldEnv = VootConstants.apiURLs_uatFlag;

	}

	@AfterMethod(alwaysRun = true)
	public void getResult(Method testName, ITestResult result) throws IOException {
		System.out.println("[AFTER-METHOD] Ending Test execution of: " + testName.getName());

		testCaseName = testName.getName();
		UtilitiesWeb utilitiesWeb = new UtilitiesWeb();
		SigninVootPageV3 signinPage = new SigninVootPageV3(driver, test);

		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.trace("Test Case Pass : " + testCaseName);
		} else if (result.getStatus() == ITestResult.FAILURE) {

			event.log( "FAIL", "Test Case Failed is " + result.getThrowable());
			logScreenShot(driver, test, "");
		} else {
			event.log( "FAIL", "Test Case Failed is " + result.getThrowable());
			logScreenShot(driver, test, "");
			logger.trace(
					"Completed the test case : " + testCaseName + " Having an exception of " + result.getThrowable());
		}

		try {
//			if (!(className.toLowerCase().startsWith("dfp") || className.toLowerCase().startsWith("mix"))) {
				// verticle swipe reverse to header
				utilitiesWeb.scrollToTop(driver);
				Thread.sleep(1000);
				utilitiesWeb.waitUntilPageLoaded(driver);
				// SignOut Function
				signinPage.logout();
				
//			}

		} catch(NoSuchElementException nse) {
			event.log( "DEBUG", "User Is not logged in");
		}
		
		catch(NullPointerException e) {
			event.log( "INFO", "Unable to SignOut.");
		}
		
		
		catch (Exception e) {
			event.printStackTrace(e);
			event.log( "INFO", "Unable to SignOut.");
			logScreenShot(driver, test, "");
		}
		finally {
			VootConstants.URL = OldUrl;
			VootConstants.apiURLs_uatFlag = OldEnv;
		}
	

		if (report != null) {
			report.flush();
			logger.trace("Completed the class : " + testCaseName);
		}
		killProcess();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() throws IOException {
		if (report != null) {
			report.flush();
			logger.trace("Completed the class : " + testCaseName);
//			killProcess();
		}
		
	}

	@AfterTest(alwaysRun = true)
	public void quitbrowser(ITestContext ctx) throws Exception {
		System.out.println("[AFTER-TEST] Ending the execution of @test: "+ this.getClass().getSimpleName());

		if (report != null) {
			report.flush();
		}
		logger.trace("Completed the test  : " + ctx.getCurrentXmlTest().getName());
//		killProcess();
	}

	public static String WORKSPACE="";
	
	@AfterSuite(alwaysRun = true)
	public void teardown() throws Exception {
		Thread.sleep(1000);
		if (report != null) {
			mainTest = report.createTest("After Suite");
			mainTest.log(status.INFO, "SuiteRun is Completed");
			report.flush();
 //			killProcess();
		}
		
//		File source = new File(report_filePath);
//		System.out.println(report_filePath);
		String copyReportFile=report_filePath;
		String replaceString; 
		if (VootConstants.OS.equalsIgnoreCase("Windows")) {
			replaceString = copyReportFile.replace(VootConstants.REPORT_PATH, "");
			Workspacepath = VootConstants.REPORT_PATH + replaceString;
		}
		else {
			replaceString = copyReportFile.replace(VootConstants.REPORT_PATH_MAC, "");
			Workspacepath = VootConstants.REPORT_PATH_MAC + replaceString;
		}
		dest = new File(Workspacepath);
		
		String url = System.getProperty("BUILD_URL");
		
		if(url==null) {
			WORKSPACE=Workspacepath;
		}
		else {
//			String last= url.substring(0, url.lastIndexOf('/'));
//			url = last=last.substring(0, last.lastIndexOf('/'));
			WORKSPACE=url+"ws/Reports/Html/" + replaceString;
		}
		System.err.println("Report is Generated at: "+ WORKSPACE);
		
//		try {
//			FileUtils.copyFile(source, dest);
//		} catch (IOException e) {
//			System.err.println("[EXCEPTION] Failed due to Exception: "+e.getMessage());
//		}		


		
	
		
		logger.trace("Execution has been completed for the : " + suiteName);

	}

	public void logScreenShot(RemoteWebDriver driver, ExtentTest test, String details) {
		UtilitiesWeb utilities = new UtilitiesWeb();
		VootConstants vootConstants = new VootConstants();

		if (vootConstants.SCREENSHOT_TO_FOLDER) {
			try {

				test.info(details,
						MediaEntityBuilder
								.createScreenCaptureFromPath(
										utilities.captureScreenshotWithName(driver, vootConstants.SCREENSHOT_TO_FOLDER))
								.build());
			} catch (Exception e) {
				// System.out.println("Failed due to Exception: "+e.getMessage());
				event.log("INFO", "Unable to take a screenshot");
			}
		} else if (!vootConstants.SCREENSHOT_TO_FOLDER) {
			try {

				test.info(details,
						MediaEntityBuilder
								.createScreenCaptureFromBase64String(
										utilities.captureScreenshotWithName(driver, vootConstants.SCREENSHOT_TO_FOLDER))
								.build());
			} catch (Exception e) {
				// System.out.println("Failed due to Exception: "+e.getMessage());
				event.log("INFO", "Unable to take a screenshot");
			}
		}
	}

	public String getDateStamp() {
		DateFormat dfor = new SimpleDateFormat("ddMMyyyy");
		Date obj = new Date();
		String date = dfor.format(obj);
		return date;
	}

	public String hourStamp() {
		Date d = new Date();
		String hour = String.valueOf(d.getHours());
		return hour;
	}

}
