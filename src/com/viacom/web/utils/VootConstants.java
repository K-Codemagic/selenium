package com.viacom.web.utils;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.remote.RemoteWebDriver;

/*************************************************************************************
 * Class : GlobalVariables Author : Amresh Purpose : This class is used for
 * storing all the global constants
 **************************************************************************************/
public class VootConstants {
	/*************************************************************************************
	 * 1.0 If using Windows Machine, Comment Mac os, if using Mac Machine, comment Windows os.
	 **************************************************************************************/
//	public static String PROJECT= "WEB", OS = "Windows", PLATFORM_NAME = "Desktop", browser = "Chrome";
//	public static String PROJECT= "WEB", OS = "Mac", PLATFORM_NAME = "Desktop", browser = "Chrome";

	public static String PROJECT= "WEB", OS = "Mac", PLATFORM_NAME = "Desktop", browser = "Safari";
	
	/*************************************************************************************
	 * 2.0 Select the Card Size and Season Size that you want to validate for API.
	 **************************************************************************************/
	public static int CARD_SIZE = 2;
	public static int Season_Size = 2;

	/*************************************************************************************
	 * 3.0 Below is the Environment and the URLs that you are planning to run the Suite or Class.
	 **************************************************************************************/
	public static String LOCALE="IN";
//	public static String LOCALE="UK";
	 
	public static String URL="https://www.voot.com/"; public static boolean apiURLs_uatFlag = false; public static String environment = "Prod";public static boolean JioUrlsFlag=true;;public static boolean InternationalFlag=false;
	
	
	/*************************************************************************************
	 * 4.0 Select the type of user that you want to run the whole suite.
	 **************************************************************************************/
 
	public static   String USERTYPE = "nonPremium";	public static  String USERTYPE_HEADER = "avod"; public static  String PREMIUM_TRAY = "false";

	/*************************************************************************************
	 * 5.0 If you want to Update Voot Web Regression suite , you can make it True.
	 **************************************************************************************/
	public static  boolean REGRESSION_SHEET_UPDATE_FLAG = false; public static boolean KLOV_FLAG = false;	public boolean SCREENSHOT_TO_FOLDER = false;

	/*************************************************************************************
	 * 6.0 Change the below files as required for a Suite Run.
	 **************************************************************************************/

	public static String APP_VERSION = "2.13.0";
	public static String APP_VERSION_UAT = "2.13.0";
	public static final String HUB_URL = "http://127.0.0.1:4723/wd/hub";
	public static final String APPIUM_IPADDRESS = "127.0.0.1";
	public static final int PORT_NUMBER = 4724;
	public static final String XLS_TEST_RESULT_SHEET = "RegressionResult";
	public static final String XLS_SMOKE_TEST_RESULT_SHEET = "SmokeSuiteRunResult";

	public static final String REPORT_PATH_MAC =  System.getProperty("user.dir")+ "/Reports/Html/";
	public static final String SCREENSHOT_PATH_MAC =  System.getProperty("user.dir")+ "/Reports/Screenshots/";

	public static final String REPORT_PATH = System.getProperty("user.dir")+ "/Reports/Html/";
	public static final String SCREENSHOT_PATH = System.getProperty("user.dir")+ "/Reports/Screenshots/";
	
	public static final String REPORT_EMAIL_SUBJECT = "[Automation] Voot Web/Pwa Reports";
	public static final String EXCEL_PATHWEBSANITY = ".//data//V3-Web-Testcases - FINAL.xlsx" + "";
	public static final String EXCEL_PATHWEBSANITY_MAC = ".//data//V3-Web-Testcases - FINAL.xlsx" + "";
	public static final String EXCEL_PATHWEBMP = ".//data//MixPanel_Web_Execution_Report.xlsx";
	public static RemoteWebDriver driver;
	public static String charleslogsName = "";
	public static String charlesName = "";
	public static String ipAdress = "";
	public static InetAddress localhost;
	public static String filePath = "";
	public static String filePathxml = System.getProperty("user.dir")+ "/Reports/Charleslogs/";
	public static String filePathlogs = System.getProperty("user.dir")+ "/Reports/Charleslogs/";

	public static final String AUTOMATION_NAME = "XCUITest";
	public static final String XCODE_ORG_ID = "7GZEJ5HA3G";
	public static String ipAddress;
	public static boolean REPORT_EMAIL = false;
	public static boolean Result = false;;
	public static boolean vastCall = false;
	public static Map<String, String> SBUChannel = new HashMap<String, String>();
	public static String MP_EXCEL_EVENTS_PATH = ".//data//Mixpanel Report_Web.xlsx";
	public static ArrayList<String> MPProperties = new ArrayList<String>();
	public static String EventName = "";
	public static final String EMAIL_SUBJECT = "Voot_Web_PWA - Automation";
	public static final String sheet = "VOOT_USERS";
	public static String charlesResponse = "";
	public static final boolean REGRESSION_GOOGLESHEET_UPDATE_FLAG = false;
	public static String spreadsheetId = "1qzDeBQpc9y3YRUOVnQxHhE6yIgd0A5t_uqmI-6Za-N4";
	public static final String EXCEL_PATHWEBV2 = ".//data//TestDataWeb.xlsx";

	public static final String CHROME_DRIVER_DMG = ".//drivers/chromedriver";

	public static final boolean UAT_METHODS=false;
	public static final int APPIUM_PORT = 4723;
	/*************************************************************************************
	 * 7.0 If you want to Update Voot Pwa Regression Google suite , you can make it True.
	 **************************************************************************************/
	/*************************************************************************************
	 * 8.0 Below Set up is Required for the PWA Project
	 **************************************************************************************/

	/*************************************************************************************
	 * 9.0 Select the proper Node.exe path according to the system that you are working on
	 **************************************************************************************/
//	Windows
//	public static String NODEJS_PATH = "C:\\Program Files\\nodejs\\node.exe";
//	MAC
	public static String NODEJS_PATH = "/usr/local/bin/node";
	/*************************************************************************************
	 * 10.0 Select the proper Appium.JS paths based on the system that you are working on.
	 **************************************************************************************/

//  Default APPIUM_JS_PATH 
//    public static String APPIUM_JS_PATH = "C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
 
//	Mac APPIUM_JS_PATH
	public static String APPIUM_JS_PATH = "/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js";

	/*************************************************************************************
	 * 11.0 Select the proper UDID based on the Device that you are working on.
	 **************************************************************************************/
	public static  String UDID = "PD21BDD464040961"; public static  String DEVICE_NAME = "Nokia5.4"; public static  String DEVICE_VERSION = "11";
//	public static String UDID = "00008030-000A110126E0402E"; public static String DEVICE_NAME = "iPhone 11"; public static String DEVICE_VERSION = "14.0.1"; //Office
	
	/*************************************************************************************
	 * Thanks. Regards, iFocus Systec.
	 **************************************************************************************/
	
public void vootConstants(String project,String environment,String OS,String browser,String userType, String apiUrlsFlag, String udid, String klovflag, String JioFlag, String JInternationalFlag, String J_REPORT_EMAIL) {
		try {
			VootConstants.PROJECT=project;
			VootConstants.DEVICE_NAME=GlobalVariables.GetDeviceName(udid);
			VootConstants.DEVICE_VERSION=GlobalVariables.GetDeviceVersion(udid);
			VootConstants.UDID=udid;
			VootConstants.KLOV_FLAG=Boolean.parseBoolean(klovflag);
			System.out.println("[CONSTANTS] PROJECT: "+VootConstants.PROJECT);
			System.out.println("[CONSTANTS] DEVICE_NAME: "+VootConstants.DEVICE_NAME);
			System.out.println("[CONSTANTS] DEVICE_VERSION: "+VootConstants.DEVICE_VERSION);
			System.out.println("[CONSTANTS] UDID: "+VootConstants.UDID);
			System.out.println("[CONSTANTS] KLOV_FLAG: "+VootConstants.KLOV_FLAG);

			
			switch (environment.toLowerCase()) {
			case "prod":{
				VootConstants.environment="Prod";
				VootConstants.URL="https://www.voot.com/";
				break;
			}
			case "uat":{
				VootConstants.environment="Uat";
				VootConstants.URL="https://unity-uat.voot.com/";
				break;
			}
			case "beta":{
				VootConstants.environment="Beta";
				VootConstants.URL="https://unitybeta.voot.com/";
				break;
			}
			
			case "origin":{
				VootConstants.environment="Origin";
				VootConstants.URL="https://unity-beta-origin.voot.com/";
				break;
			}
			
			case "stage":{
				VootConstants.environment="Stage";
				VootConstants.URL="https://unity-stage.voot.com/";
				break;
			}
			case "gamma":{
				VootConstants.environment="Gamma";
				VootConstants.URL="https://unity-gamma.voot.com/";
				break;
			}
			case "alpha":{
				VootConstants.environment="Alpha";
				VootConstants.URL="https://unity-alpha.voot.com/";
				break;
			}
			default:
				System.out.println("[CONSTANTS] Default.");
				break;
			}
			System.out.println("[CONSTANTS] URL: "+VootConstants.URL);
			switch (OS.toLowerCase()) {
			case "windows":{
				VootConstants.OS="Windows";
				break;
			}
			case "mac":{
				VootConstants.OS="Mac";
				break;
			}
			default:
				System.out.println("[CONSTANTS] Default.");
				break;
			}
			System.out.println("[CONSTANTS] OS: "+VootConstants.OS);
			switch (browser.toLowerCase()) {
			case "chrome":{
				VootConstants.browser="Chrome";
				break;
			}
			case "firefox":{
				VootConstants.browser="firefox";
				break;
			}
			case "safari":{
				VootConstants.browser="safari";
				break;
			}
			case "safaritechnologypreview":{
				VootConstants.browser="safaritechnologypreview";
				break;
			}

			default:
				System.out.println("[CONSTANTS] Default.");
				break;
			}
			System.out.println("[CONSTANTS] BROWSER: "+VootConstants.browser);
			switch (userType.toLowerCase()) {
			case "nonpremium":{
				USERTYPE="nonPremium";
				USERTYPE_HEADER="avod";
				PREMIUM_TRAY = "false";
				break;
			}
			case "premium":{
				USERTYPE="Premium";
				USERTYPE_HEADER="svod";
				PREMIUM_TRAY = "true";
				break;
			}
			case "guest":{
				USERTYPE="Guest";
				USERTYPE_HEADER="avod";
				PREMIUM_TRAY = "false";
				break;
			}
			default:
				System.out.println("[CONSTANTS] Default.");
				break;
			}
			System.out.println("[CONSTANTS] USERTYPE: "+ VootConstants.USERTYPE);
			System.out.println("[CONSTANTS] USERTYPE_HEADER: "+ VootConstants.USERTYPE_HEADER);
			System.out.println("[CONSTANTS] PREMIUM_TRAY: "+ VootConstants.PREMIUM_TRAY);
			switch (apiUrlsFlag.toLowerCase()) {
			case "true":{
				apiURLs_uatFlag=true;
				break;
			}
			case "false":{
				apiURLs_uatFlag=false;
				break;
			}
			default:
				break;
			}
			System.out.println("[CONSTANTS] APIURLS_UATFLAG: "+VootConstants.apiURLs_uatFlag);
			
			switch (JioFlag.toLowerCase()) {
			case "true":{
				JioUrlsFlag=true;
				break;
			}
			case "false":{
				JioUrlsFlag=false;
				break;
			}
			default:
				break;
			}
			System.out.println("[CONSTANTS] JIOURLS_FLAG: "+VootConstants.JioUrlsFlag);
			
			switch (JInternationalFlag.toLowerCase()) {
			case "true":{
				InternationalFlag=true;
				break;
			}
			case "false":{
				InternationalFlag=false;
				break;
			}
			default:
				break;
			}
			System.out.println("[CONSTANTS] INTERNATIONAL_FLAG: "+VootConstants.InternationalFlag);
			
			switch (J_REPORT_EMAIL.toLowerCase()) {
			case "true":{
				REPORT_EMAIL=true;
				break;
			}
			case "false":{
				REPORT_EMAIL=false;
				break;
			}
			default:
				break;
			}
			System.out.println("[CONSTANTS] REPORT_EMAIL: "+VootConstants.REPORT_EMAIL);
			System.out.println("[CONSTANTS] BUILD_URL: "+System.getProperty("BUILD_URL"));

		 
		} catch (NullPointerException npe) {
			
		}
	}
}
