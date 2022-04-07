package com.viacom.web.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.viacom.web.utils.UtilitiesWeb;
import com.viacom.web.utils.VootConstants;

public class TopMenuPage extends BasePage {
	UtilitiesWeb utilitiesWeb = new UtilitiesWeb();

	VootConstants voot_constants_web = new VootConstants();

	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.tv.v18.viola:id/hamburger_menu']")
	public WebElement hambergMenu;

	@FindBy(name = "Home")
	public WebElement home;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.tv.v18.viola:id/tv_tab_title' and @text='Shows']")
	public WebElement shows;

	@FindBy(name = "Kids")
	public WebElement kids;

	@FindBy(name = "Movies")
	public WebElement movies;

	@FindBy(name = "Channels")
	public WebElement channels;

	@FindBy(name = "Downloads")
	public WebElement downloads;

	String logout = "//android.widget.TextView[@text='Logout']";

	@FindBy(id = "com.tv.v18.viola:id/logout_title")
	public WebElement logOutBtn;

	@FindBy(id = "com.tv.v18.viola:id/positive_btn")
	public WebElement yesBtn;

	@FindBy(id = "com.tv.v18.viola:id/settings_menu")
	public WebElement settings;

	@FindBy(id = "com.tv.v18.viola:id/favorites_title")
	public WebElement favorite;

	@FindBy(id = "com.tv.v18.viola:id/help_title")
	public WebElement help;

	@FindBy(id = "com.tv.v18.viola:id/title_toolbar")
	public WebElement bigbossuditions;

//	Saravanan
	@FindBy(xpath = "//div[@id=\"channels\"]//div[@class='menu-channel-logo']//span")
	public WebElement channelListElement;

	@FindBy(xpath = "//div[@id=\"channels\"]//div[@class='menu-channel-logo']//span")
	public List<WebElement> channelList;

//	Saravanan
	@FindBy(xpath = "//div[contains(@class,'channels_name')]")
	public List<WebElement> channelNames;

	@FindBy(xpath = "//span[.='Colors Hindi']/..//img")
	public WebElement channelsHindiName;

	@FindBy(xpath = "//span[.='News18 Bangla']/..//img")
	public WebElement newsEighteenBangla;

	@FindBy(xpath = "//div[contains(@class,'channels_name')]")
	public WebElement channelsName;

	@FindBy(id = "news_dropbtn")
	public WebElement News;

	@FindBy(id = "channels_dropbtn")
	public WebElement channelId;

	@FindBy(xpath = "//div[@class='megaMenu dropdown class_768']//a[@id='shows_dropbtn']")
	public WebElement showsTab;

	@FindBy(xpath = "//div[@class='mdl-layout__header-row search-user-profile']//div[@class='VSearch']")
	public WebElement searchIcon;

	@FindBy(xpath = "//div[@class='VSearchHomeHeader']//input[@id='VSearchHome1']")
	public WebElement searchBar;

	@FindBy(xpath = "//div[@class='VSearchHomeContentDetail']//h6[contains(.,'Big')]")
	public WebElement bigBossResult;

	@FindBy(xpath = "//div[@class='VSearchHomeContentDetail']//h6[contains(.,'Bajirao')]")
	public WebElement bajiraoMovieResult;

	@FindBy(xpath = "//div[@class='-reactjs-scrollbar-track -reactjs-scrollbar-track:vertical  ']//div")
	public WebElement searchHomeResult;

//	All Channels

	@FindBy(xpath = "//div[@class='mdl-grid']//div[@class='img-holder']")
	public WebElement channelLogoInChannelsTab;

	@FindBy(xpath = "//div[@class='mdl-grid']//div[@class='img-holder']")
	public List<WebElement> channelLogoInChannelsTabAsList;

//	Saravanan
	@FindBy(id = "shows_dropbtn")
	public WebElement showsId;

//channelsHindiName
//Vinoth kumar S, Today at 10:23
	WebDriver driver;

	public TopMenuPage(RemoteWebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	public void goToSection() {

	}

	public void search() {

	}

	public void logout() throws Exception {
		if (utilitiesWeb.explicitWaitClickable(voot_constants_web.driver, hambergMenu, 20))
			hambergMenu.click();
		else
			event.log( "ERROR/WOSS", "Failed to click on menu button");
		Thread.sleep(2000);
		try {
			utilitiesWeb.verticalSwipe(voot_constants_web.driver, logout);
		} catch (Exception e) {
			event.log( "ERROR/WOSS", "Failed to navigate to logout button");
		}

		if (utilitiesWeb.explicitWaitClickable(voot_constants_web.driver, logOutBtn, 20)) {
			logOutBtn.click();
		}
		// if(driver.findElementsById("com.tv.v18.viola:id/positive_btn").size()>0)
		yesBtn.click();
 
	}

}
