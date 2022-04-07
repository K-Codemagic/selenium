package com.viacom.web.RecycleBin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.viacom.web.utils.VootConstants;

  import com.viacom.web.pages.SigninVootPageV3;
import com.viacom.web.utils.BaseTestWeb;
import com.viacom.web.utils.UtilitiesWeb;

/*************************************************************************************
 * Author :Amresh
 *
 **************************************************************************************/
public class Sample extends BaseTestWeb {

	@Test(enabled=true, groups = { "Premium", "nonPremium", "Guest" })
	public void SampleLaunchMethod() throws Exception {
		
		System.out.println("Launching the Browser.");
		event.log( "INFO", "Launching the Browser.");

 		
		// launching the browser
		launchWeb(VootConstants.OS, VootConstants.browser);
		SigninVootPageV3 signInPage = new SigninVootPageV3(driver, test);
 		BaseTestWeb baseTestWeb = new BaseTestWeb();
		UtilitiesWeb utilities = new UtilitiesWeb();
 		String strEmail="sample@grr.la"; 
 		String strPassword="123123";
 		
 		
		event.log( "INFO", "Using Email : "+strEmail);
		event.log( "INFO", "Using Password : "+strPassword);
 
				if (utilities.explicitWaitClickable(driver, signInPage.profileIcon, 40)) {
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInPage.profileIcon);
						event.log( "INFO", "Clicked on profile icon");
					} catch (Exception e) {
						System.out.println("Unable to click on Profile Icon" + e);
					}


					if (utilities.explicitWaitClickable(driver, signInPage.logInLink, 20)) {
						try {
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInPage.logInLink);
						} catch (Exception e) {
							System.out.println("Unable to click on Login link" + e);

						}
					}

					try {
						if (utilities.explicitWaitVisible(driver, signInPage.useAnotherAccount, 5)) {
							if (VootConstants.OS.equalsIgnoreCase("windows")) {
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInPage.useAnotherAccount);
							} else {
								signInPage.useAnotherAccount.click();
							}
						}
					} catch (Exception e) {
						System.out.println("Unable to locate Use another Account" + e.getMessage());
					}

				
						if (utilities.explicitWaitClickable(driver, signInPage.emailButton, 20)) {
							signInPage.emailButton.click();

						}
					

					try {
						if (utilities.explicitWaitClickable(driver, signInPage.emailField, 30)) {
							signInPage.emailField.clear();
							signInPage.emailField.sendKeys(strEmail);
						} else {
							baseTestWeb.logScreenShot(driver, test,
									"Sign in page is not loaded after clicking on sign in option");
							System.out.println("Sign in page is not loaded after clicking on sign in option");
							
						}
					} catch (Exception e) {
					 System.out.println("Sign in page is not loaded after clicking on sign in option");
					}
					if (utilities.explicitWaitClickable(driver, signInPage.continueBtn, 10)) {

						if (VootConstants.OS.equalsIgnoreCase("windows")) {
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInPage.continueBtn);
						} else {
							signInPage.continueBtn.click();

						}

					} else {
						throw new Exception("Login button is not displayed");
					}

					if (utilities.explicitWaitClickable(driver, signInPage.passwordField, 30)) {
						signInPage.passwordField.sendKeys(strPassword);
					} else {
						throw new Exception("Password field not displayed ");
					}
					Thread.sleep(2000);

					  if(VootConstants.PLATFORM_NAME.equalsIgnoreCase("android")) 
					{
						Actions action = new Actions(driver);
						action.sendKeys(Keys.ENTER).perform();
						Thread.sleep(3000);
					}
					else {
						signInPage.UatContinueBtn.click();
					}
					

					utilities.handleToastMessage(driver, test);
					if (VootConstants.apiURLs_uatFlag == true) {
						if (utilities.explicitWaitClickable(driver, signInPage.tcBox, 5)) {
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInPage.tcBox);

							if (utilities.explicitWaitClickable(driver, signInPage.acceptTCCTA, 10)) {
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInPage.acceptTCCTA);

							}
						}
					}
					
					
					 
					if (utilities.waitUntilElememtIsEnabled(driver, signInPage.UserprofileafterLogin, 30)) {

						((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInPage.UserprofileafterLogin);

						event.log( "INFO", "Successfully logged in through " + VootConstants.USERTYPE + " login");
			
						Thread.sleep(3000);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInPage.UserprofileafterLogin);
					} else {
						 throw new Exception("Unable to login");

					}

				} else {
					event.log( "INFO", "Profile icon is not visible");
					baseTestWeb.logScreenShot(driver, test, "profile icon is not present");
				}

			
			
			
		 
		logScreenShot(driver, test, "");
		event.log( "PASS", "Sample Test Method Ended.");

	}
	
	 
	
	
	
	@Test(enabled=true, groups = { "Premium", "nonPremium", "Guest" })
	public void SampleLogMethods() throws Exception {
		
		launchWeb(VootConstants.OS, VootConstants.browser);

 		event.log( "INFO", "Infoing the Browser without SS.");
		event.log( "INFO/WSS", "Infoing the Browser with SS.");
		
		event.log( "SKIP", "Skipping the Browser without SS.");
		event.log( "SKIP/WSS", "Skipping the Browser with SS.");
		
		
		
		event.log( "DEBUG", "Debugginging the Browser without SS.");
		event.log( "DEBUG/WSS", "Debugginging the Browser with SS.");
		
 		
 		
		event.log( "PASS", "Passing the Browser without SS.");
		event.log( "PASS/WSS", "Passsing the Browser with SS.");		
		
		
		// launching the browser
  
		event.log( "INFO", "Sample Test Method Ended.");
		System.out.println("Sample Test Method Ended.");

	}
	
	 
	
	

}
