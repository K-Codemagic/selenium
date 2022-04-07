package com.viacom.web.pages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.viacom.web.utils.BaseTestWeb;
import com.viacom.web.utils.UtilitiesWeb;
import com.viacom.web.utils.VootConstants;
import io.appium.java_client.AppiumDriver;

public class SigninVootPageV3 extends BasePage {

	public SigninVootPageV3(RemoteWebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//img[@src='/images/icon_facebook_blue.svg' or @alt='Continue with Facebook']")
	public WebElement faceBookIconInOnBoarding;


	@FindBy(xpath = "//img[@src='/images/icon_google_g.svg' or @alt='Google Icon']")
	public WebElement googleIconInOnBoarding;
	
	
	
	@FindBy(xpath = "//img[@alt='Terms & Conditions' or @src='/images/purple.svg']//parent::div")
	public WebElement tcBox;
	
	
	@FindBy(xpath = "//span[text()='Accept and Continue']")
	public WebElement acceptTCCTA;
	
	
	@FindBy(xpath = "//button[text()='Verify']")
	public WebElement verifyCTA;
	
	@FindBy(xpath = "//a[text()='Edit']")
	public WebElement editInVerifyMobileNumber;
	
	@FindBy(xpath = "//span[text()='Please Enter The Details']")
	public WebElement plzEnterDetails;
	
	@FindBy(xpath = "//span[contains(text(),'Please enter the correct OTP')]")
	public WebElement errormessageOTPScreen;
	
	@FindBy(xpath = "//*[text()=' You have signed in to Voot using ']")
	public WebElement lastLoginPopUpMessage;
	
	
	@FindBy(xpath = "//input[contains(@aria-label,'Digit 1')]")
	public WebElement forgotScreenDigit1;
	
	@FindBy(xpath = "//input[contains(@aria-label,'Digit 2')]")
	public WebElement forgotScreenDigit2;
	
	@FindBy(xpath = "//input[contains(@aria-label,'Digit 3')]")
	public WebElement forgotScreenDigit3;
	
	@FindBy(xpath = "//input[contains(@aria-label,'Digit 4')]")
	public WebElement forgotScreenDigit4;
	
	
	@FindBy(xpath = "//span[text()='Verify Mobile Number']")
	public WebElement verifymobileNumberScreen_mobile;
	
	@FindBy(xpath = "//span[contains(text(),'Please enter the OTP sent on')]")
	public WebElement verifymobileNumberScreenDetail_mobile;
	
	@FindBy(xpath = "//span[contains(text(),'Resend OTP')]")
	public WebElement verifymobileNumberScreenResendOTP_mobile;
	
	@FindBy(xpath = "(//div[@aria-label='avatar-icon'])[2]")
	public WebElement profileIconInEditProfilePage;
	
	@FindBy(xpath = "//div[@data-title=\"dropDownMenu\"]//div//nav//li//h5")
	public WebElement profileIconInEditProfilePage1;
	
	@FindBy(xpath = "//label[text()='Date Of Birth']//parent::div//div//input")
	public WebElement dateFieldInEditProfilePage;
	
	@FindBy(xpath = "(//div//h6)[2]")
	public WebElement yearElementInEditProfilePage;
	
	@FindBy(xpath = "//div[text()='2008']")
	public WebElement changedYear;
	
	@FindBy(xpath = "//div[text()='2002']")
	public WebElement changedYear16plus;
	
	@FindBy(xpath = "//span[text()='OK' or text()='ok' or text()='Ok']")
	public WebElement OkCTAInEditProfilePage;
	
	@FindBy(xpath = "//span[text()='Save']")
	public WebElement saveCTAInEditProfilePage;
	

	@FindBy(xpath = "//button[@class='kep-login-facebook medium']")
	public WebElement facebookbutton;

	@FindBy(xpath = "//div[@id='mandatoryLogin']//button[text()='Register']")
	public WebElement registerButton;

	@FindBy(id = "email")
	public WebElement facebookpageemailfield;

	@FindBy(id = "pass")
	public WebElement facebookpagepasswordfield;

	@FindBy(xpath = "//label[@id='loginbutton']")
	public WebElement facebookpagelogin;

	@FindBy(xpath = "//h2[text()='Facebook']")
	public WebElement facebookpagetext;

	@FindBy(xpath = "//div[@data-title='dropDownMenu']/div/nav/li/div/span[text()='Log In']")
	public WebElement logInLink;

	@FindBy(xpath = "//span[text()='Help & Legal']")
	public WebElement help_and_legal;

	@FindBy(xpath = "//input[contains(@id,'email')]")
	public WebElement emailField;
	
	@FindBy(xpath = "//input[contains(@id,'email')]/../..//label")
	public WebElement emailFieldlable;

	@FindBy(xpath = "//*[@id='root']/..//child::*//button[contains(., 'Email')]")
	public WebElement Email;

	@FindBy(id = "email")
	public WebElement PwapleaseEnterTheDetailsEmailFiled;

	@FindBy(id = "password")
	public WebElement PwapleaseEnterTheDetailsPassword;

	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement PwapleaseEnterTheDetailsContinue;

	@FindBy(xpath = "//h2[contains(text(),'Email Address')]")
	public WebElement UseYouremailAddressText;

	@FindBy(name = "Not Now")
	public WebElement notNowBtn;

	// Registration Page
	@FindBy(xpath = "//h4//span[contains(text(),'Details')]")
	public WebElement signUpText;

	@FindBy(xpath = "//div//p[contains(text(),'Step 1 of 2')]")
	public WebElement step1of2Text;

	@FindBy(xpath = "//h4/span[contains(text(),'Create Profile')]")
	public WebElement createProfileText;

	@FindBy(xpath = "//input[@id='name']")
	public WebElement ProfileNameField;

	@FindBy(xpath = "//input[@placeholder='DD/MM/YYYY']")
	// @FindBy(xpath = "//label[text()='Date Of Birth']")
	// @FindBy(id = "dob")
	public WebElement dateOfBirthText;

	@FindBy(css = "[id='dob']")
	public WebElement dateOfBirthField;

	@FindBy(xpath = "//span[contains(text(),'Gender')]")
	public WebElement genderText;

	@FindBy(xpath = "(//div[contains(@class,'text-left')]//span)[2]")
	public WebElement genderTxtField;

	@FindBy(xpath = "//input[@type='radio']")
	public List<WebElement> gender_radio_buttons;

	@FindBy(xpath = "//span[contains(text(),'Gender')]/parent::span/following-sibling::*[name()='svg']")
	public WebElement genderDropDown;

	@FindBy(xpath = "//img[@alt='Close Button']")
	public WebElement closeBtnRegisterPage;

	@FindBy(xpath = "//div//input[contains(@class,'beforeBadge')]")
	public WebElement countrycodedefault;

	@FindBy(xpath = "//p[@class='helperTextOtp']")
	public WebElement helperText;

	@FindBy(xpath = "//div//button[text()=' Cancel ']")
	public WebElement uatCancel;

	@FindBy(xpath = "//div//button[text()=' Enter Password Again ']")
	public WebElement uatenterPasswordAgain;

	@FindBy(xpath = "//div//button[text()=' Forgot Password? ']")
	public WebElement uatforgotPassword;

	@FindBy(xpath = "//input[contains(@id,'password')]")
	public WebElement passwordField;
	
	@FindBy(xpath = "//div[contains(@class,'reduceMargin')]/button")
	public WebElement CTAbutton;
	
	@FindBy(id = "mobile number")
	public WebElement mobileField;

	@FindBy(xpath = "//input[contains(@id,'email')]/following::div[2]//button")
	public WebElement continueBtn;

	@FindBy(xpath = "//div//div//button[text()='Continue']")
	public WebElement UatContinueBtn;
	
	@FindBy(xpath = "//button[contains(@class,'undefined')]")
	public WebElement disablecontinueBtn;
	

	@FindBy(xpath = "//input[contains(@id,'email')]/following::div[3]//button[@class='kep-login-facebook medium']")
	public WebElement FbcontinueBtn;

	@FindBy(xpath = "//img[contains(@alt,'Google')]/parent::button")
	public WebElement gmailcontinueBtn;

	@FindBy(xpath = "//input[contains(@id,'email')]/following::div[2]//button[@disabled and (text()='Continue')]")
	public WebElement continueBtnDisabled;

	// @FindBy(xpath =
	// "//input[contains(@id,'password')]//ancestor::div[4]/following-sibling::div//button[text()='Continue']")
	@FindBy(xpath = "//*[@id='root']/..//child::*//button[contains(., 'Continue')]")
	public WebElement registerPagecontinueBtn;

	// (//input[contains(@id,'password')]//ancestor::div[4])[1]/following-sibling::div//button[@disabled
	// and (text()='Continue')]
	@FindBy(xpath = "//button[contains(@class,'undefined ') and @disabled]")
	public WebElement registerPagecontinueBtnDisabled;

	@FindBy(xpath = "//*[contains(text(),'Select your preference')]")
	public WebElement languageText;

	@FindBy(xpath = "//span[contains(text(),'English,Hindi')]/parent::span/following-sibling::*[name()='svg']")
	public WebElement languageDropDown;

	@FindBy(xpath = "//span[contains(text(),'I agree to the ') or contains(text(),'I warrant that I am above 13 years of age and have read and accept the ')]")
	public WebElement termsAndConditionsText;

	@FindBy(xpath = "//span//a[contains(@title,'Terms of Use') or contains(text(),'terms of use') or  text()='Terms of Use']")
	public WebElement termsOfUsesLink;
	
	@FindBy(xpath = "(//a[contains(text(),'Terms of Use')])[2]")
	public WebElement termsOfUsesLinkUK;

	@FindBy(xpath = "//a[text()='Terms of Use']")
	public WebElement termsOfUsesText;

	@FindBy(xpath = "//a[text()=' Privacy Policy' or text()='Privacy Notice' or text()='Privacy Policy' or text()='privacy policy']")
	public WebElement privacyPolicyLink;

	@FindBy(xpath = "//h1[text()='Privacy Policy']")
	public WebElement privacyPolicyText;

	// updated->@preetish
	@FindBy(xpath = "//button[text()='Submit']|//button[text()='Save']")
	public WebElement submitBtn;

	@FindBy(xpath = "//button[text()=' Save ']")
	public WebElement submitBtn_Pwa;

	@FindBy(xpath = "//label[text()='Select your preference']")
	public WebElement selectYourPreferences;

	@FindBy(xpath = "//button[text()='Save' or text()=' Save ']")
	public WebElement saveButton;

	// end-Registration Page
	@FindBy(xpath = "//div[@data-title='avatar']//img")
	public WebElement profileIcon;

	@FindBy(xpath = "//div[text()='Content Language']")
	public WebElement contentLanguageTitle;
	
	@FindBy(xpath = "//img[@src='/images/icon-tick-purple.svg' and @alt='Hindi']")
	public WebElement defaultLanguageHindi;

	
	
	@FindBy(xpath = "//div[@data-title='avatar']")
	public WebElement profileIcon1;

	@FindBy(xpath = "//h5//preceding-sibling::div[@aria-label='avatar-icon']")
	public WebElement profileIcon2;

	@FindBy(xpath = "//div[@data-title='dropDownMenu']")
	public WebElement profileDropdown;

	@FindBy(xpath = "//div[@data-title='avatar']/div")
	public WebElement UserprofileafterLogin;

	@FindBy(xpath = "(//div[@data-title='avatar']//parent::div)[1]")
	public WebElement Userprofileicon;

	@FindBy(xpath = "//div[@data-title='dropDownMenu']//nav//span[text()='Log In']")
	public WebElement UserprofileafterLogout;

	@FindBy(xpath = "//div[@data-title='dropDownMenu']//div//nav[1]")
	public WebElement UserProfileicon;

	@FindBy(xpath = "//span[contains(text(),'My Voot')]")
	public WebElement myVootTab;

	@FindBy(xpath = "//span[contains(text(),'Sign Out')]")
	public WebElement signOut;

	@FindBy(xpath = "(//div[@role='dialog']//button)[2]/span")
	public WebElement signOutOfPopup;
	
	@FindBy(xpath = "//span[text()='Use Another Account']")
	public WebElement useAnotherAccount;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public WebElement incorrectPwdcloseButton;
	
	// Sudha
	@FindBy(xpath = "//input[@type='checkbox' and contains(text(),checked)]/..//*[name()='svg']//*[name()='path']")
	public WebElement singUpPopCheckBox;

	// Uat and Beta
	@FindBy(xpath = "//img[contains(@src,'/images/purple.svg')]")
	public WebElement UATsingUpPopCheckBox;

	@FindBy(xpath = "//img[contains(@src,'/images/purple.svg')]//parent::span")
	public WebElement UATsingUpPopUnselectedCheckBox;

	@FindBy(xpath = "//p[@id='email-helper-text']")
	public WebElement emailErrorMsg;

	@FindBy(xpath = "//p[contains(@id,'password-helper-text')]")
	public WebElement passwordErrorMsg;

	@FindBy(xpath = "//p[@id='name-helper-text']")
	public WebElement profileNameErrorMsg;

	@FindBy(xpath = "((//ul[contains(@class,'ddListScrol')])[1]//li//span)")
	public List<WebElement> gendersList;

	@FindBy(xpath = "(//ul[contains(@class,'ddListScrol')])[1]")
	public WebElement gendersDropDown;

	@FindBy(xpath = "((//ul[contains(@class,'ddListScrol')])[1])//li[1]")
	public WebElement gendersfirstOption;

	@FindBy(xpath = "(//ul[contains(@class,'ddListScrol')])[2]")
	public WebElement languagesDropDown;

	@FindBy(xpath = "((//div[contains(@class,'text-left')])[2]//span)[2]")
	public WebElement languagesField;

	@FindBy(xpath = "//div[text()='Select Preferred Languages']//parent::div/div/button")
	public List<WebElement> languagesList;

	@FindBy(xpath = "((//ul[contains(@class,'ddListScrol')])[2])//li[1]")
	public WebElement languagesfirstOption;

	@FindBy(xpath = "(((//ul[contains(@class,'ddListScrol')])[2])//span[contains(text(),'*')]/parent::li)[1]")
	public WebElement languageEnglishOption;

	@FindBy(xpath = "(((//ul[contains(@class,'ddListScrol')])[2])//span[contains(text(),'*')]/parent::li)[2]")
	public WebElement languageHindiOption;

	@FindBy(xpath = "//div[@class='slick-slide slick-active slick-center slick-current']")
	public WebElement watchNextRail;

	@FindBy(xpath = "//div[@role='document']")
	public WebElement outerSpace;
	
	@FindBy(xpath = "//img[contains(@alt,'Show Password')]")
	public WebElement showPasswordTextButton;
	
	@FindBy(xpath = "//img[contains(@alt,'Hide Password')]")
	public WebElement hidePasswordTextButton;
	/*
	 * @FindAll( {@FindBy(xpath =
	 * "//img[@alt='Voot effect']//parent::div/following::div/img[@alt='Close Button']"
	 * ),
	 * 
	 * @FindBy(xpath = "//button/img[@alt='Close Button']")}) public WebElement
	 * closeButton;
	 */
	@FindBy(xpath = "//button[text()='Subscribe Now']")
	public WebElement SubscribeNow;
	@FindBy(xpath = "//button[text()='Register']")
	public WebElement register;

	@FindBy(xpath = "//*[text()='Create Profile']")
	public WebElement step2_registration;

	@FindBy(xpath = "//div[@role='presentation']")
	public WebElement Date_of_Birth_dropDown;

	@FindBys(@FindBy(xpath = "//label[@class='jss1686 jss1619']"))
	public List<WebElement> gender_options;

	@FindBy(xpath = "//span[text()='Male']")
	public WebElement gender_male;

	@FindBy(xpath = "//span[text()='Female']")
	public WebElement gender_female;

	@FindBy(xpath = "//span[text()='Other']")
	public WebElement gender_other;

	@FindBy(xpath = "//span[text()='OK']")
	public WebElement DOB_ok_button;

	@FindBy(xpath = "//label[text()='Email']")
	public WebElement emailText;

	@FindBy(xpath = "//div[@role='document']/div/div/div/h6")
	public WebElement year;

	@FindBy(xpath = "//div[@class='jss1144 jss1140']/p")
	public WebElement month;

	@FindBy(xpath = "//span[contains(text(),'agree') or contains(text(),'I warrant that I am above 13 years of age and have read and accept the ')]")
	public WebElement agreement_text;

	@FindBy(xpath = "//div/label[contains(text(),'Password')]")
	public WebElement passwordtext;

	@FindBy(xpath = "//div/button[@aria-label='Toggle password visibility']")
	public WebElement password_toggle;

	@FindBy(linkText = "Login")
	public WebElement login_in_signup_popup;

	@FindBy(xpath = "//button[text()='Login']")
	public WebElement loginButton;

	@FindBy(xpath = "(//div[@class='tray-header-container'])[2]")
	public WebElement second_rail;

	@FindBy(xpath = "//p[text()='Cancel anytime!']")
	public WebElement cancel_anytime;

	@FindBy(xpath = "//img[@title='Bigg Boss 24 Hours LIVE Channel']")
	public WebElement select_to_watch;

	@FindBy(xpath = "//span[text()='Watch First Episode Free']|//*[@id='root']/..//child::*//span[contains(., 'To continue,')]|//*[@id='root']/..//child::*//span[contains(., 'Watch')]")
	public WebElement premiumContent;

	@FindBy(xpath = "//div/h3[text()='Top Shows']")
	public WebElement topShows;

	@FindBy(xpath = "(//div[@class='slick-slide slick-active slick-current'])")
	public WebElement playableAsset;

	@FindBy(xpath = "(//div[@class='jss28 jss31 jss29 jss513 jss613 default-card'])[1]")
	public WebElement playButton;
	
	@FindBy(xpath = "//*[local-name()='svg' or svg[contains(@class,'playArrow')]]")
	public WebElement playButton1;
	
	

	@FindBy(xpath = "//span[text()='Watch Now']")
	public WebElement watchNow;

	@FindBy(xpath = "//button[contains(text(),' Forgot Password')]")
	public WebElement forgotPassword;

	@FindBy(xpath = "//div[@id='mandatoryLogin']/div/div/div[text()='Please subscribe to watch this video']")
	public WebElement subscribe;

	@FindBy(xpath = "//img[@alt='Back Button']")
	public WebElement backButton;

	@FindBy(xpath = "//span[text()='Forgot Password?']")
	public WebElement forgotPassword_text;

	@FindBy(xpath = "//span[contains(text(),'We’ll send an OTP to verify your email address') or contains(text(),\"Don't worry\")]")
	public WebElement password_request_text;

	@FindBy(xpath = "//div[contains(text(),'You must agree to the terms of use and privacy policy to proceed') or text()='You must agree to the terms of use and Privacy Notice to continue']")
	public WebElement errorMessageForCheckBoxUnclick;

	
	@FindBy(xpath = "//button[text()='Send']")
	public WebElement sendButton_forgotPassword;

	@FindBy(xpath = "//div[contains(@class,'otp')]")
	public WebElement otp_request_pop_up;

	@FindBy(xpath = "//span[text()='Reset Request']")
	public WebElement reset_request_text;

	@FindBy(xpath = "//div/p[contains(text(),'An OTP')]")
	public WebElement otp_sent_text;

	@FindBy(xpath = "//button[text()='Verify']")
	public WebElement verifybutton;

	@FindBy(xpath = "//span[text()='Login']")
	public WebElement loginText;

	@FindBy(xpath = "//button/img[contains(@alt,'Facebook')]")
	public WebElement facebook_button;

	@FindBy(xpath = "//div/h1[text()='Facebook']")
	public WebElement faceBook_page;

	@FindBy(name = "__CONFIRM__")
	public WebElement fb_continue;

	@FindBy(xpath = "//button/img[contains(@alt,'Google')]")
	public WebElement google_continue;

	@FindBy(xpath = "//div[text()='Sign in with Google']")
	public WebElement google_page_text;

	@FindBy(how = How.XPATH, using = "//div[1]/h4/span[contains(., 'Incorrect')]|//*[@id='password-helper-text']")
	public WebElement worngPasswordMsg;

	@FindBy(xpath = "//span[contains(text(),'Incorrect Password')]")
	public WebElement incorrectPasswordscreen;

	@FindBy(xpath = "//div[text()='Incorrect Password']")
	public WebElement worngPasswordMsg1;

	@FindBy(how = How.XPATH, using = "//*[text()='Password']|//*[@name='password']")
	public WebElement clickOnPassword;

	@FindBy(how = How.XPATH, using = "//*[@data-title='avatar']")
	public WebElement avatarAfterLogin;

	@FindBy(how = How.XPATH, using = "//div[@data-title='avatar']")
	public WebElement avatar;

	@FindBy(id = "header")
	public WebElement mainContentTab;

	@FindBy(id = "dob")
	public WebElement dob_uat;

	@FindBy(xpath = "dob")
	public WebElement dob_PWA;

	@FindBy(xpath = "//label[text()='Select your preference']")
	public WebElement languagePreference_uat;

	@FindBy(xpath = "//button[text()='Save']")
	public WebElement save_uat;

	@FindBy(xpath = "//button[contains(text(),' Save ')]")
	public WebElement save_PWA;

	// button[text()=' Save ']
	@FindBy(xpath = "//button[text()=' Save ']")
	public WebElement save_uat1;
  
	@FindBy(xpath = "//button//img[contains(@alt,'Hamburger')]")
	public WebElement pwaHamburgermenubar;
	@FindBy(xpath = "//div[contains(@class,'playkit-top-controls')]/div[contains(@class,'playkit-control-button-container playkit-control-fullscreen')]/child::button/i[@class='playkit-icon playkit-icon-maximize']")
	public WebElement pwamaximize;
	
	
	
	
	@FindBy(xpath = "	//div[contains(@class,'playkit-top-controls')]/div[contains(@class,'playkit-control-button-container playkit-control-fullscreen')]/child::button/i[@class='playkit-icon playkit-icon-minimize']")
	public WebElement pwaminimize;

	@FindBy(xpath = "//h4[contains(text(),': First elimination of the Season')]")
	public WebElement landscapeelement;
	
	@FindBy(xpath = "//img[@alt='Hamburger']")
	public WebElement pwaHamburgermenubar1;

	@FindBy(xpath = "//button/span[contains(text(),'Sign Out')]")
	public WebElement pwaSignOutPopup;

	@FindBy(xpath = "//span[contains(@class,'menuLabel ') and text()='Shows']")
	public WebElement pwashowstab;

	@FindBy(xpath = "//span[text()='Shows' and @class='menuLabel active']")
	public WebElement pwashowstabHighlited;

	@FindBy(xpath = "//span[contains(@class,'menuLabel') and text()='Movies']")
	public WebElement pwamoviestab;

	@FindBy(xpath = "//span[text()='Movies' and @class='menuLabel active']")
	public WebElement pwamoviestabHighlited;

	@FindBy(xpath = "//span[contains(@class,'menuLabel ') and text()='News']")
	public WebElement pwanewstab;

	@FindBy(xpath = "//span[text()='News' and @class='menuLabel active']")
	public WebElement pwanewstabHighlited;
	
	@FindBy(xpath = "//span[contains(@class,'menuLabel ') and text()='Sports']")
	public WebElement pwasportstab;
	
	@FindBy(xpath = "//span[contains(@class,'menuLabel') and text()='My Voot']")
	public WebElement pwaMyvootTab;
	
	@FindBy(xpath = "//span[contains(text(),'Upgrade')]")
	public WebElement Upgrade;
	
	@FindBy(xpath = "(//div[@class='[object Object]']/div)[2]/div")
	public WebElement pwaPP2;
	

	@FindBy(xpath = "//span[text()='My Voot' and @class='menuLabel active']")
	public WebElement pwaMyvootTabHighlited;

	@FindBy(xpath = "//span[contains(@class,'menuLabel') and text()='Premium']")
	public WebElement pwaPremiumTab;

	@FindBy(xpath = "//span[text()='Premium' and @class='menuLabel active']")
	public WebElement pwaPremiumTabHighlited;

	@FindBy(xpath = "//span[contains(@class,'menuLabel') and text()='Channels']")
	public WebElement pwaChanneltab;

	@FindBy(xpath = "//span[text()='Channels' and @class='menuLabel active']")
	public WebElement pwaChanneltabHighlited;

	@FindBy(xpath = "//span[text()='Login']")
	public WebElement PwaLogin;

//	@FindBy(id = "email")
//	public WebElement Pwaemail;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement Pwaemail;

	@FindBy(xpath = "//p[contains(text(),'Key Pages')]")
	public WebElement pwakeypage;

	@FindBy(xpath = "//p[contains(text(),'Legal')]")
	public WebElement pwalegalfooter;

	@FindBy(xpath = "//p[contains(text(),'Support')]")
	public WebElement pwasupportfooter;
	
	@FindBy(xpath = "//a[@title='FAQs']")
	public WebElement pwafooterfaqlink;
	
	@FindBy(xpath = "//span[contains(text(),'Voot Select')]")
	public WebElement pwaVootSelect;
	
	@FindBy(xpath = "//span[contains(text(),'Accessing Your Account')]")
	public WebElement pwaYourAccount;
	
	@FindBy(xpath = "//span[contains(text(),'Billing & Invoices')]")
	public WebElement pwaBilling;
	
	@FindBy(xpath = "//span[contains(text(),'Payments & Refunds')]")
	public WebElement pwaPaymentrefunds;
	
	@FindBy(xpath = "//span[contains(text(),'Errors & Buffering')]")
	public WebElement pwaErrorsbuffering;
	
	@FindBy(xpath = "//span[contains(text(),'General Queries')]")
	public WebElement pwageneralQueries;
	
	@FindBy(xpath = "//a[@title='Contact Us']")
	public WebElement pwafooterContactuslink;
	
	@FindBy(id = "//input[@id='enter password' and @type='text']")
	public WebElement webpasswordVisible;
	
	@FindBy(id = "//input[@id='enter password' and @type='password']")
	public WebElement webpasswordNotVisible;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement Pwapassword;

	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement Pwacontinuebutton;

	@FindBy(xpath = "//button[text()='Login']")
	public WebElement PwaLoginbutton;

	@FindBy(xpath = "//button[text()='Continue with Email']")
	public WebElement PwaContinueWithEmail;
	
	@FindBy(xpath = "//button//span[text()='Continue with ']")
	public WebElement webContinueWithEmail;

	@FindBy(xpath = "(//h5[@aria-label='user-name'])[2]")
	public WebElement pwausername;

	@FindBy(xpath = "//img[@alt='Close Icon']")
	public WebElement pwacloseicon;

	@FindBy(id = "com.android.chrome:id/negative_button")
	public WebElement vootlitecancle;

	@FindBy(id = "com.android.chrome:id/infobar_close_button")
	public WebElement vootliteclosebutton;

	@FindBy(xpath = "//button[text()='Subscribe Now']")
	public WebElement subscribeNow;

	@FindBy(xpath = "//span[text()='Subscribe to Watch Now']")
	public WebElement Subscribe_to_Watch_Now;
	
	@FindBy(xpath = "(//span[contains(text(),'Subscribe Now')])[2]")
	public WebElement subscribeNowPWA;
	
	@FindBy(css = "[alt='Close Button']")
	public WebElement closeButton;
	
	@FindBy(css = "[id='dob-helper-text']")
	public WebElement pleaseEnteraValidDateTxt;

	@FindBys(@FindBy(xpath = "//*[@class='genderContainer']/div"))
	public List<WebElement> selectGender;

	@FindBy(xpath = "//button/span[contains(text(),'Watch First Episode Free')]")
	public WebElement firstEpisodeFree;

    @FindBy(xpath = "//img[@src='/images/icon_mail_purple.svg']")
    public WebElement emailButton;
  //p[contains(text(),'Register/Login with Email')]
    @FindBy(xpath = "//img[@src='/images/icon_mail_purple.svg']")
    public WebElement UKemailButton;
    
    @FindBy(xpath = "//input[contains(@id,'password')]/../..//label")
    public WebElement createPasswordLabel;
	
  
    
	@FindBy(xpath = "//p[contains(text(),'Login with Mobile')]")
	public WebElement mobileNumberButton;
	//img[@alt='phone-icon']
	@FindBy(xpath = "//p[contains(text(),'Login with Mobile')]")
	public WebElement mobileNumberButtonUK;
	
	@FindBy(xpath = "//div/label[text()='Select Gender']")
	public WebElement genderLabel;

	// sachin
	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement pwaTermsConditionCB;

	@FindBy(xpath = "//span[contains(@class,'menuLabel ') and text()='My Voot']")
	public WebElement pwamyVoot;

	@FindBy(xpath = "//span[contains(@class,'menuLabel ') and text()='Premium']")
	public WebElement pwaPremium;

	@FindBy(xpath = "//span[contains(@class,'menuLabel ') and text()='Movies']")
	public WebElement pwaMovies;

	@FindBy(xpath = "//span[contains(@class,'menuLabel ') and text()='Channels']")
	public WebElement pwaChannels;

	@FindBy(xpath = "//span[contains(@class,'menuLabel ') and text()='News']")
	public WebElement pwaNews;

	@FindBy(xpath = "//span[contains(@class,'menuLabel') and text()='Help & Legal']")
	public WebElement pwaHelpnlegal;

	@FindBy(xpath = "//span[contains(text(),'Billing History')]")
	public WebElement billingHistory;

	@FindBy(xpath = "//ul//span[contains(text(),'Billing History')]")
	public WebElement pwabillingHistory;

	@FindBy(xpath = "//span[contains(@class,'menuLabel ') and text()='Shows']")
	public WebElement pwaShows;

	@FindBy(xpath = "//span[contains(@class,'menuLabel') and text()='Settings']")
	public WebElement pwaSettings;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	public WebElement pwaLogin;

	//// span[contains(@class,'menuLabel') and text()='Sign out']
	@FindBy(xpath = "//li/span[text()='Sign out']")
	public WebElement pwaSignOut;

	@FindBy(xpath = "//div[contains(@class,'reduceMargin')]//button")
	public WebElement continuepwd_uat;

	@FindBy(xpath = "//span[text()='Resume Watching']")
	public WebElement resumeWatching;

	@FindBy(xpath = "//div/div/button[text()='Continue']")
	public WebElement uatContinueButton;

	@FindBy(xpath = "//button[text()='Continue with Email']")
	public WebElement pwaContinuewithEmail;

	@FindBy(xpath = "//div/button/span[contains(., 'Sign Out')]")
	public List<WebElement> signOutPopup;

	@FindBy(xpath = "//span[contains(text(),'Sign Out')]//parent::button")
	public WebElement signOutPopupscreen;

	@FindBy(xpath = "//div/button[contains(text(),'Save')]")
	public WebElement pwalanguageSaveButton;

	@FindBy(xpath = "//p[contains(text(),'Please Sign Up or Login')]")
	public WebElement signUporLoginPopupText;
	
	@FindBy(xpath = "//p[text()='Please enter valid name']")
	public WebElement enterNameErrorMessage;
	
	@FindBy(xpath = "//div[@class='genderWrapper active']")
	public WebElement genderSelected;
	
	@FindBy(xpath = "//p[text()='Please enter a valid date']")
	public WebElement enterDateErrorMessage;
	
	@FindBy(xpath = "//p[text()='You should be at least 13 years of age to register on Voot']")
	public WebElement enterDateErrorMessageAgeLessThen13;
	
	@FindBy(xpath = "//h4/span[contains(text(),'Verify')]")
	public WebElement verifyEmailId;

	@FindBy(xpath = "//h1[text()='User Agreement']")
	public WebElement userAgreement;

	@FindBy(xpath = "//button[contains(text(),' Enter Password Again ')]")
	public WebElement enterPasswordAgain;

	@FindBy(xpath = "//ul[@role='menu']")
	public WebElement hamburgerMenuPwa;

	@FindBy(id = "m_login_email")
	public WebElement pwaFbEmailText;

	@FindBy(id = "m_login_password")
	public WebElement pwaFbPasswordText;

	@FindBy(name = "login")
	public WebElement pwaFbLoginButton;
	
	@FindBy(xpath = "//span[contains(text(),'Forgot Password?')]")
	public WebElement forgotPwd;
	@FindBy(xpath = "//span[contains(text(),'Verify Email Id')]/parent::h4")
	public WebElement otpscreenverificatio;
	
	@FindBy(xpath = "//span[contains(text(),'Please Enter The Details')]/parent::h4")
	public WebElement EmailScreen;

	@FindBy(xpath = "//div[contains(@class,'otp-screen-view')]/parent::div")
	public WebElement otpscreen;
	
	@FindBy(xpath = "//img[contains(@alt,'Back Button')]")
	public WebElement otpscreenbackbutton;
	@FindBy(xpath = "//span[contains(@class, 'otpLink')]")
	public WebElement resrend;
	@FindBy(xpath = "//div[contains(@class,\"otp-screen-btn-container\")]/button")
	public WebElement verifyotp;
	
	@FindBy(xpath = "//span[contains(text(),\"Please enter the correct OTP\")]")
	public WebElement OTPErrorMsg;
	
	
	
	@FindBy(xpath = "//div[contains(@class,'otpInputWrapper')]/child::div")
	public WebElement otpsnd;
	@FindBy(xpath = "//span[contains(text(), 'Please enter the correct OTP')]")
	public WebElement errormsg;
	

	// Amresh Added
	@FindBy(xpath = "//input[@type='text' and @id='email']")
	public WebElement emailIdBox;

	@FindBy(xpath = "//div[@role='dialog']//h4//span")
	public WebElement pleaseEnterTheDetails;

	@FindBy(xpath = "//div[@role='dialog']/div[2]/div[1]/div[1]/div[2]/div[1]/p")
	public WebElement alreadyRegistered;

	@FindBy(xpath = "//div[@role='dialog']//div[contains(text(),'already registered ')]")
	public WebElement alreadyRegistered1;

	@FindBy(xpath = "//button/span[text()='Continue with facebook']")
	public WebElement facebookContinue;

	@FindBy(xpath = "//p[@class='infoNewRegText']")
	public WebElement pleaseSignUporLoginXpath;

	@FindBy(xpath = "//p[@class='welcomText']")
	public WebElement WelcomeToVootXpath;

	@FindBy(xpath = "(//div[@role=\"dialog\"]//button)[3]")
	public WebElement enterPasswordAgainButton;

	@FindBy(xpath = "//button[text()=' Enter Password Again ']")
	public WebElement enterPasswordAgainButton1;

	@FindBy(xpath = "//span[text()='Forgot Password?']")
	public WebElement forgotPasswordButton;
	@FindBy(xpath = "//button[text()=' Forgot Password? ']")
	public WebElement forgotPasswordButton1;
	
	@FindBy(xpath = "//div[@role='dialog']/div[2]/div[1]/div[1]/div[1]/h4/span")
	public WebElement forgotPasswordHeader;

	@FindBy(xpath = "//p[@class='needHelpText']//span[contains(text(),'Need help logging in?')]")
	public WebElement needHelpText;

	@FindBy(xpath = "//div[@role='dialog']//h2[2]")
	public WebElement forgotPasswordScreenEmailid;

	@FindBy(xpath = "//div[@role='dialog']//h4//span[contains(text(),'Verify Email Id')]")
	public WebElement verifyEmailIDHeader;

	@FindBy(xpath = "//div[@class='otpContent']//p[contains(text(),'An OTP has been sent on ')]/span")
	public WebElement otpSentOnEmailID;

	@FindBy(xpath = "//span[contains(text(),'Resend OTP')]")
	public WebElement resendOTPLink;

	@FindBy(xpath = "//p[@class='waitingText ']//span[contains(text(),'Didn')]")
	public WebElement didnotReceiveOTPText;

	@FindBy(xpath = "//p[@class='textGreen']")
	public WebElement otpSentGreenText;

	@FindBy(xpath = "//div[@role='dialog']//*[@id='password']")
	public WebElement createPassword;

	@FindBy(xpath = "//div[@role='dialog']//span[text()='Create Profile']")
	public WebElement createProfileHeader;

	@FindBy(xpath = "//div[@role='dialog']//h2[text()='Finish setting up your account by creating a profile.']")
	public WebElement finishSettingHeader;

	@FindBy(xpath = "//p[@id='password-helper-text']")
	public WebElement passwordHelperText;

	@FindBy(xpath = "//p[@class='waitingText']//span[1]")
	public WebElement waitingText;

	@FindBy(xpath = "//span[contains(text(),'Continue with Google')]")
	public WebElement continueWithGmail;
	
	@FindBy(xpath = "//input[@id='mobile number']")
	public WebElement mobileNumberField;
	
	@FindBy(xpath = "//div//p[@id='mobile number-helper-text']")
	public WebElement mobileNumberFieldHelpertext;
	
	@FindBy(xpath ="//div//p[text()='Password must contain at least 6 and at most 16 characters.']")
	public WebElement passwordStrengthError;
	
	@FindBy(xpath = "//div[contains(@class,'last-login-popup')]")
	public WebElement lastLoginReminderPopup;
	
	@FindBy(xpath = "//div[contains(@class,'last-login-popup')]//h4")
	public WebElement textofReminderPopup;
	
	@FindBy(xpath = "(//div[contains(@class,'last-login-popup')]//h2//parent::div//button[1]/span)[1]")
	public WebElement continueCTAinReminderPopup;

	@FindBy(xpath = "//button/span/img")
	public WebElement uatHamburgerMenuBar;
	
	@FindBy(xpath = "//a[@class='wzrkClose']")
	public WebElement toastMessage; 
	
	@FindBy(xpath = "//iframe[@id='wiz-iframe']")
	public WebElement toastMessageFrame; 
	
	@FindBy(xpath = "//span[text()='Skip']")
	public WebElement skipLink; 
	

	@FindBy(xpath = "//button/img[contains(@alt,'Apple')]")
	public WebElement appleIcon; 
	
	@FindBy(xpath = "//h6[contains(text(),'Voot Select')]")
	public WebElement vootSelectOnlyPopup; 
	
	@FindBy(xpath = "//h6/parent::div//p")
	public WebElement subTextInVootSelectPopup; 
	
	@FindBy(xpath = "//h6/parent::div/div/button")
	public WebElement subscibeButtonInVootSelectPopup; 
	

	//Raghav
	@FindBy(xpath = "//div[text()='Select Preferred Languages']")
	public WebElement selectPreferredLanguagesText;
	
	@FindBy(xpath = "//div[text()='Please select atleast 1 language']")
	public WebElement selectLanguagesErrorMsg;
	
	@FindBy(xpath = "//button [@value=\"Hindi\"]")
	public WebElement hindiLanguagesButton;
	
	@FindBy(xpath = "//button [@value=\"English\"]")
	public WebElement englishLanguagesButton;
	
	@FindBy(xpath = "//button [@value=\"Kannada\"]")
	public WebElement kannadaLanguagesButton;
	
	@FindBy(xpath = "//button [@value=\"Marathi\"]")
	public WebElement marathiLanguagesButton;
	
	@FindBy(xpath = "//button [@value=\"Gujarati\"]")
	public WebElement gujaratiLanguagesButton;
	
	@FindBy(xpath = "//button [@value=\"Bengali\"]")
	public WebElement bengaliLanguagesButton;
	
	@FindBy(xpath = "//button [@value=\"Tamil\"]")
	public WebElement tamilLanguagesButton;
	
	@FindBy(xpath = "//button [@value=\"Telugu\"]")
	public WebElement teluguLanguagesButton;
	
	@FindBy(xpath = "//button [@value=\"Tulu\"]")
	public WebElement tuluLanguagesButton;
	
	@FindBy(xpath = "//img[@alt='Terms & Conditions']/parent::span")
	public WebElement termsConditionCheckbox;
	
	@FindBy(xpath = "//button[@value='Hindi']/div/img")
	public WebElement hindiLanguageByDefault;
	
	@FindBy(xpath = "//button[@value='English']/div/img")
	public WebElement englishLanguageByDefault;
	
	@FindBy(xpath = "//*[text()='OTP generation limit exceeded.']")
	public WebElement OTPLimitExceed;

	
	UtilitiesWeb utilties = new UtilitiesWeb();

	public void signInUsingphoneNumber(String phoneNumber , String Password) throws InterruptedException
	{
		BaseTestWeb baseTestWeb = new BaseTestWeb();
		
		if ((VootConstants.PROJECT).equalsIgnoreCase("WEB")) {
			
		      if (utilties.explicitWaitClickable(driver, profileIcon, 40)) {
			try {
//				profileIcon.click();
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", profileIcon);
				event.log( "INFO", "Clicked on profile icon");
			} catch (Exception e) {
				System.out.println("Unable to click on Profile Icon" + e);
			}
		      }
		      
		      if (utilties.explicitWaitClickable(driver, logInLink, 20)) {
					try {
//				logInLink.click();
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", logInLink);
 
						event.log( "INFO", "Clicked on logInLink");
 
					} catch (Exception e) {
						System.out.println("Unable to click on Login link" + e);

					}
				}
			
                  
				try {
					if (utilties.waitUntilElememtIsEnabled(driver, useAnotherAccount, 15))
					{
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", useAnotherAccount);
 
						event.log( "INFO", "Clicked on useAnotherAccount");
					}else
					{
						useAnotherAccount.click();
 
					}
				} catch (Exception e) {
					
				}
				
				
				 if (utilties.explicitWaitClickable(driver, mobileNumberButton, 20)) {
					 mobileNumberButton.click();
 
					 event.log( "INFO", "Clicked on mobileNumberButton");
 
					}
				 
					
				 if (utilties.explicitWaitClickable(driver, mobileNumberField, 20)) {
					 mobileNumberField.click();
					 mobileNumberField.sendKeys(phoneNumber);
					 try {
						 if(driver instanceof AppiumDriver) {
							 ((AppiumDriver)driver).hideKeyboard();
							 Thread.sleep(2000);
						 }
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							event.log( "EXCEPTION", "Failed Due to: " + e.getMessage());
						} 
					 event.log( "INFO", "Enter the mobile Number "+phoneNumber);
 
					}
				 
				 if (utilties.explicitWaitClickable(driver, UatContinueBtn, 20)) {
					 UatContinueBtn.click();
 
					 event.log( "INFO", "Clicked on ContinueBtn");
 
					}
				 
				 Thread.sleep(2000);
				 
				  
				 
				 if (utilties.explicitWaitClickable(driver, passwordField, 20)) {
					 passwordField.click();
					 passwordField.sendKeys(Password);
					 try {
						   if(driver instanceof AppiumDriver) {
							   ((AppiumDriver)driver).hideKeyboard();
								 Thread.sleep(2000);
						   }
						} catch (Exception e) {
							// TODO Auto-generated catch block
							event.log( "EXCEPTION", "Failed Due to: " + e.getMessage());
						} 
					 event.log( "INFO", "Enter the password "+Password);

					}
				 
				 if (utilties.explicitWaitClickable(driver, UatContinueBtn, 20)) {
					 UatContinueBtn.click();

					 event.log( "INFO", "Clicked on ContinueBtn");

					 }
				 
				 if (utilties.waitUntilElememtIsEnabled(driver, UserprofileafterLogin, 30)) {

						((JavascriptExecutor) driver).executeScript("arguments[0].click();", UserprofileafterLogin);

						event.log( "INFO", "Successfully logged in through " + VootConstants.USERTYPE + " login");
//					
						Thread.sleep(3000);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", UserprofileafterLogin);
					} else {
						 
						
					}
				 
				 
		      
		      
		}
	}

	
	public Object logout() throws Exception {

		event.log( "INFO", "Logging Out...");
 		if (VootConstants.PROJECT.equalsIgnoreCase("WEB")) {
			driver.navigate().to(VootConstants.URL);
			Thread.sleep(2000);
			utilties.scrollToTop(driver);

			if (utilties.explicitWaitVisible(driver, UserprofileafterLogin, 5)) {

				try {
					utilties.scrollToParticularElement(driver, UserprofileafterLogin);
					utilties.waitUntilPageLoaded(driver);
					utilties.waitUntilPageLoaded(driver);
					utilties.clickButton(driver, UserprofileafterLogin, 20);
				} catch (Exception e) {
					event.log( "INFO", " User is not logged in / Log in failed");
				}

				utilties.waitUntilPageLoaded(driver);
				if (utilties.explicitWaitVisible(driver, signOut, 30)) {
					utilties.waitUntilPageLoaded(driver);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", signOut);
					Thread.sleep(2000);
				} else {
					event.log( "INFO", " User is not logged in ");
				}
				if (utilties.explicitWaitVisible(driver, signOutPopupscreen, 40)) {
					signOutPopupscreen.click();
					Thread.sleep(3000);
				} else {
					event.log( "INFO", " User is not logged in ");
				}

				utilties.waitUntilPageLoaded(driver);
				if (utilties.explicitWaitVisible(driver, profileIcon, 40)) {
					event.log( "INFO", "User logged out successfully.");
				} else {
					event.log( "FAIL/WOSS", "logout unsuccessful");
					

				}
			} else {
				// Check for Login Button.
				event.log( "INFO", "User is not logged in ");
 			}
		} else if (VootConstants.PROJECT.equalsIgnoreCase("PWA")) {
			driver.navigate().to(VootConstants.URL);
			Thread.sleep(2000);
			utilties.scrollToTop(driver);
			if (utilties.waitUntilElememtIsEnabled(driver, pwaHamburgermenubar, 40)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", pwaHamburgermenubar);
				if (utilties.waitUntilElememtIsEnabled(driver, pwausername, 30)) {
//					utilties.scrollToElement(driver, "//li/span[text()='Sign out']");
					utilties.scrollToParticularElement(driver, pwaSignOut);
					if (utilties.waitUntilElememtIsEnabled(driver, pwaSignOut, 30)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", pwaSignOut);
					}
					if (utilties.waitUntilElememtIsEnabled(driver, pwaSignOutPopup, 20)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", pwaSignOutPopup);
					}
					Thread.sleep(5000);
					if (utilties.waitUntilElememtIsEnabled(driver, pwaHamburgermenubar, 30)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", pwaHamburgermenubar);
					}
					if (utilties.waitUntilElememtIsEnabled(driver, PwaLogin, 30)) {
						event.log( "INFO", "User logout successfull");
					} else {
						event.log( "WARNING/WOSS", "Logout Unsuccessfull");
					}
					if (utilties.explicitWaitVisible(driver, pwacloseicon, 50)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", pwacloseicon);
					}
				} else {
					event.log( "INFO", "User is not logged in.");
 				}
			}
		}
		HomePage homePage = new HomePage(driver, test);
		PageFactory.initElements(driver, homePage);
		return homePage;
	}

	public Object logoutMyvootVP0() throws Exception {

		if (VootConstants.PROJECT.equalsIgnoreCase("WEB")) {

			Thread.sleep(2000);
			utilties.scrollToTop(driver);

			if (utilties.explicitWaitVisible(driver, UserprofileafterLogin, 40)) {
				try {
					utilties.scrollToParticularElement(driver, UserprofileafterLogin);
					utilties.waitUntilPageLoaded(driver);
					utilties.waitUntilPageLoaded(driver);
					utilties.clickButton(driver, UserprofileafterLogin, 20);
				} catch (Exception e) {
					event.log( "INFO", " User is not logged in / Log in failed");
				}

				utilties.waitUntilPageLoaded(driver);
				if (utilties.explicitWaitVisible(driver, signOut, 30)) {
					utilties.waitUntilPageLoaded(driver);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", signOut);
					Thread.sleep(2000);
				} else {
					event.log( "INFO", " User is not logged in ");
				}
				if (utilties.explicitWaitVisible(driver, signOutPopupscreen, 40)) {
					signOutPopupscreen.click();
					Thread.sleep(3000);
				} else {
					event.log( "INFO", " User is not logged in ");
				}

				utilties.waitUntilPageLoaded(driver);
				if (utilties.explicitWaitVisible(driver, profileIcon, 40)) {
					event.log( "INFO", " User logout successfully");
				} else {
					event.log( "FAIL/WOSS", "logout unsuccessful");
					

				}
			} else {
				event.log( "INFO", " User is not logged in ");
			}
		} else if (VootConstants.PROJECT.equalsIgnoreCase("PWA")) {

			Thread.sleep(2000);
			utilties.scrollToTop(driver);
			if (utilties.waitUntilElememtIsEnabled(driver, pwaHamburgermenubar, 40)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", pwaHamburgermenubar);
				if (utilties.waitUntilElememtIsEnabled(driver, pwausername, 30)) {
					utilties.scrollToParticularElement(driver, pwaSignOut);
					if (utilties.waitUntilElememtIsEnabled(driver, pwaSignOut, 30)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", pwaSignOut);
					}

					if (utilties.waitUntilElememtIsEnabled(driver, pwaSignOutPopup, 20)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", pwaSignOutPopup);
					}
					Thread.sleep(5000);
					if (utilties.waitUntilElememtIsEnabled(driver, pwaHamburgermenubar, 30)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", pwaHamburgermenubar);
					}
					if (utilties.waitUntilElememtIsEnabled(driver, PwaLogin, 30)) {
						event.log( "WARNING/WOSS", "Logout Unsuccessfull");

					} else {
						event.log( "INFO", "User logout successfull");
					}
					if (utilties.explicitWaitVisible(driver, pwacloseicon, 50)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", pwacloseicon);
					}
				} else {
					event.log( "INFO", "User is not logged in");
				}
			}
		}
		HomePage homePage = new HomePage(driver, test);
		PageFactory.initElements(driver, homePage);
		return homePage;
	}


 
	 
	
	

	
	public void deviceToportrait()
	{
		if(VootConstants.PROJECT.equalsIgnoreCase("PWA"))
		{
		 ((AppiumDriver) driver).rotate(ScreenOrientation.PORTRAIT);
		}
	}

}
