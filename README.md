## Welcome to Voot Web and PWA Automation Project. (Doc Ver 1.0)
**Summary:** This Repository aims to Execute Automation for the Regression Suite of www.voot.com in Web Browsers as well as PWA Mobile browsers in the following Environments.
This also covers Mixpanel Event Validation as well as Double Click for Publishers Calls Validations.
 

**WEB:** (Checking Suite Run Compatibility on more browsers)

- **Windows:** Chrome, Firefox.
- **Mac:** Safari, Chrome.

**PWA:**(Checking Suite Run Compatibility on more browsers)
- **Android:** Chrome.
- **iOS:** Safari.

### Pre-Requisites:
- Java, Appium/Selenium
- Eclipse Editor
- Charles Proxy
- NodeJS

### Framework:
We have flags to run on either Windows or Mac OS.
We have flags to run either or Web Browsers or Mobile Browsers(PWA).
This is a Maven Project and using Extent Report as the Reporting tool.
We have a flag to write the Regression Report into an Google Spreadsheet Online.
We have also integrated KLOV to see all suite run results at a common place.

### Run Configurations

**VootConstants.java** : (Constant File) -We have the VootConstants.java file where we have the below flags that we can change when required. 
- **OS:** We can choose the OS we want yo run.
- **browser:** We can choose the browser that we want to run.
- **CARD_SIZE:** We can edit this count of trays required to test.
- **Season_Size:** We can edit this count of Seasons that we want to test.
- **URL:** We can select either UAT/BETA/LIVE url for the test run.
- **apiURLs_uatFlag:** We can select which api urls to use for the test run.
- **USERTYPE:** We can select from SVOD/AVOD/WithoutLogin to run the Suite files.
- **executionMode:** If running an individual class, reports get stored in a separate folder, while running in a suite will store in a separate Suite folder. 
- **REGRESSION_SHEET_UPDATE_FLAG:** We make it true to see the test case id which are either PASS of FAIL in a Google Spreadsheet Online that can be shared with the manual team to recheck the same issue.
- **KLOV_FLAG:** We make it true to capture each suite run result in a server where we can see the health of all suites run with this flag on.
- **PROJECT:** If we are working on PWA, we need to select PWA or WEB if we are working on a Web project.


### Files and Folders and Paths:
- **REPORT_PATH/ REPORT_PATH_MAC:** To store the Reports in the local machine so that the size of the repository doesn't increase while we run the classes or suites everytime.
- **SCREENSHOT_PATH / SCREENSHOT_PATH_MAC:** To store the screenshots generated while failures are there in the class/suite run.
- **NODEJS_PATH:** NodeJS is used to Install the Appium Server on Node so that we don't want the Appium Desktop to be started manually.
- **APPIUM_JS_PATH** We need to specify the path of appium.js path in Node Modules in order to start the Appium Server.
-  **UDID**: We need to mention the UDID if the mobile device that we want to run the class or suite. 

### Maven Dependencies List:
1. TestNg, Log4J
2. io.appium/java-client
3. selenium-java
4. RestAssured
5. WebDriverManager
6. Google Api
7. aventstack/extentreports
8. gson / json
9. mongodb
10. mail
11. Apache poi
12. monte-screen-recorder
13. google-api-client

### Suite Files:
- DFP_Suite.xml - We need Charles Proxy Configured in order to run this Suite.
- MixPanel_Suite.xml - We need Charles Proxy Configured in order to run this Suite.
- Regression_Suite.xml - We can run the Regression Suite in Chrome, Firefox and Safari browsers.

### Configuration Files:
- VootConstants.java
- ReportsConfig.xml

### Utility Packages:
- **com.viacom.web.utils**  - Utility to fetch the Api values from the Rest Api response based on the MediaType and storing those values into Api map. Common Utility to Validate FE and API Meta Data for All Cards.
MP Utility to compare 2 Arraylist each containing n number of Map of Events.
- **com.viacom.web.pages** - Contains all page related Object Identification Elements.
- **com.viacom.web.properties** Contains credentials, API Urls, Hardcoded Strings as required.
- **com.viacom.web.mail** Contains Email Related Utilities and Google Spreadsheet Related Utilities.

### Module Wise Packages: (57 Java Files)
- **com.viacom.web.Channels -** It covers Channels Tab related test cases. We also validate  2 cards Meta Data from the API in each of the tray inside all the Channels present in Channels Tab.
- **com.viacom.web.Movies -** It covers Movies Tab related test cases. We also validate 2 cards Meta Data from the API in each of the tray in Movies Tab. 
- **com.viacom.web.MyVoot -** It covers My Voot Tab related test cases. We also validate 2 cards Meta Data from the API in each of the tray in My Voot Tab. It also Includes all the Recommendation Trays present for that user.
- **com.viacom.web.News -** It covers News Tab related test cases. We also validate 2 cards Meta Data from the API in each of the tray in News Tab.
- **com.viacom.web.onboarding -** It Covers Login and Sign Up related test cases. We user random email and password to check the login flow.
- **com.viacom.web.Player -** It Covers all Player Functionality Related Test cases.
- **com.viacom.web.Premium -** It covers the Premium Tab Related Test Cases as well as SVOD Scenarios. We also validate 2 cards Meta Data from the API in each of the tray in Premium Tab. We also use test cards in UAT Environment to Automate Subscription related test scenarios. 
- **com.viacom.web.Search -** It covers Search related test cases.  It covers Trending search api validations as well.
- **com.viacom.web.Settings -** It contains Account Settings related test cases.
- **com.viacom.web.Shows -** It covers Shows Tab related test cases. We also validate 2 cards Meta Data from the API in each of the tray in Shows Tab.

- **com.viacom.web.Mixpanel -** (10 Java Files) - We created an Expected List of LinkedHashMaps  of Events and Compared against and Actual List of LinkedHashMaps of Events from the Charles logs and Automated the Comparison.
- **com.viacom.web.DFPTestCases -** (10 Java Files)

## Jenkins CI/CD Configurations: Not Configured Yet

> Author-Ifocus Systec Pvt Ltd.

test pr
