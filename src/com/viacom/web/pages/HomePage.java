package com.viacom.web.pages;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.viacom.web.utils.BaseTestWeb;
import com.viacom.web.utils.GlobalVariables;
import com.viacom.web.utils.UtilitiesWeb;
import com.viacom.web.utils.VootConstants;
import io.restassured.response.Response;

/*************************************************************************************
 * Class : HomePage Purpose : This class is used for selecting various sections
 * of voot Remarks : none Author : Roja KC, Ifocus Modifications: 26 May 2017-
 * First created
 **************************************************************************************/
public class HomePage extends BasePage {
	public int countApi;
	public ExtentTest test;

	public HomePage(RemoteWebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	BasePage basePage = new BasePage(driver, test);

	/*
	 * @FindBy(id= "com.tv.v18.viola:id/hamburger_menu") public WebElement MenuTab;
	 */

	int aftinitialDuration = 0;
	int initialDuration = 0;
	BaseTestWeb baseTestWeb = new BaseTestWeb();

	@FindBy(xpath = "//div[@class='mdl-navigation__link register']")
	public WebElement registerLinkInAbLoginform;

	//// bhaskar//////
	@FindBy(xpath = "(//div[@class='mdl-card__title  mdl-card--expand card_title'])[1]")
	public WebElement movieb;
	@FindBy(xpath = "//a[contains(@href,'all-movies')]")
	public WebElement hindimoviesmorebuttonb;

	@FindBy(xpath = "//div[contains(@class,'playkit-overlay-action')]")
	public WebElement vodPlayer;

	@FindBy(xpath = "//a[@class='MSWMLink undefined']")
	public WebElement newsvod;

	@FindBy(xpath = "//div[@class='header-hstar']//img[@title='Voot']")
	public WebElement vootHeader;
	@FindBy(xpath = "//h2[text()='Continue Watching']")
	public WebElement continuewatchingtray;

	@FindBy(xpath = "//div[@class='character_namecard mdl-card__supporting-text']")
	public WebElement kidshow;

	@FindBy(xpath = "//div[@class='VSBannerContainer']//div[@class='play']")
	public WebElement playvod;

	@FindBy(xpath = "//a[contains(@href,'continue-watching')]")
	public WebElement continuewatchmorebutton;

	@FindBy(xpath = "//a[contains(@href,'news-live')]")
	public WebElement livenewsbutton;

	@FindBy(xpath = "(//a[contains(@href,'news18-lokmat-live')])[1]")
	public WebElement livenewschanel;

	@FindBy(xpath = "//h3[contains(text(),'CNN')]")
	public WebElement livenewschanelhom;
	@FindBy(xpath = "//div[@class='episodeTitle']//h2")
	public WebElement kidcontenttitle;

	@FindBy(xpath = "(//div[contains(@class,'VSingletray') and contains(.,'Continue Watching')]//div[contains(@class,'play')])[1]")
	public WebElement continueWatching;

	@FindBy(xpath = "(//span[contains(text(),'Episodes')]/following::div//img[contains(@class,'defaultCardImg image-transition')])[1]")
	public WebElement vootEpisodeContent;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public WebElement cwcontent;

	@FindBy(xpath = "(//div[@class='MSWMWrap'])[1]")
	public WebElement cwcontent1;

	@FindBy(xpath = "//div[@class='episodeTitle']//h1")
	public WebElement liveepisodetitle;

	@FindBy(xpath = "////div[@class='MSWMTitle']//h3")
	public WebElement cwtitle;

	@FindBy(xpath = "//div[@class='MSWMTitle']//h3")
	public List<WebElement> cwtitles;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public List<WebElement> cwcontents;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public WebElement cwmoviecontent;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public List<WebElement> cwmoviecontents;

	@FindBy(xpath = "//h2[text()='All Episodes & Voot Shorts']")
	public WebElement cwepisodesandvoots;

	@FindBy(xpath = "//h2[text()='All Episodes & Voot Shorts']")
	public WebElement cwepisodesandvootstray;

	@FindBy(xpath = "//div[@class='VtitleContainer']")
	public WebElement cwmoviestray;

	@FindBy(xpath = "//a[contains(@href,'all-kids-characters')]")
	public WebElement kidsmorebutton;

	@FindBy(xpath = "//div[@class='episodeTitle']")
	public WebElement kidepisodetitle;

	@FindBy(xpath = "(//div[@class='MSWMWrap'])[1]")
	public WebElement newsshow;

	@FindBy(xpath = "//div[@class='MSWMWrap']")
	public WebElement contentname;

	@FindBy(xpath = "//h2[text()='All Episodes']")
	public WebElement newsallepisodes;

	@FindBy(xpath = "//div[contains(@class,'playkit-progress-bar')]")
	public WebElement playicon;
	@FindBy(xpath = "//div[@class='MLWMTag']")
	public WebElement kidcontent;

	@FindBy(xpath = "//div[@class='MLWMTag']")
	public List<WebElement> kidcontents;

	@FindBy(xpath = "//h2[@class='VSingletrayTitle']")
	public WebElement kidsallepisodes;

	@FindBy(xpath = "//div[@class='play']")
	public WebElement cwplayubutton;

	@FindBy(xpath = "//div[@class='play']")
	public List<WebElement> cwplayubuttons;

	@FindBy(xpath = "//button[@class='loadMoreBtn VButton ']")
	public WebElement cwloadmore;

	@FindBy(xpath = "//div[@class='play']")
	public WebElement episodesandclipscontents;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public WebElement cwepisodesandclipscontents;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public WebElement clipstitle;

	@FindBy(xpath = "//div[@class='MLWMTag']")
	public WebElement clipsseasonandduration;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public WebElement episodetitle;

	@FindBy(xpath = "//div[@class='MLWMTag']")
	public WebElement episodenumberdateduration;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public WebElement allepisodesandvootshortscontent;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public List<WebElement> allepisodesandvootshortscontents;

	@FindBy(xpath = "//div[@class='MLWMTag']")
	public WebElement cwprogressbar;

	@FindBy(xpath = "//div[@class='MSWMWrap']")
	public WebElement cwtumbnailimage;

	@FindBy(xpath = "//div[contains(@class,'mdl-card')]//div[@class='play']")
	public WebElement cwplayicon;

	@FindBy(xpath = "//div[contains(@class,'mdl-card')]//div[@class='play']")
	public List<WebElement> cwplayicons;

	@FindBy(xpath = "//h2[@class='VSingletrayTitle']/../..//h3")
	public WebElement cwect;

	@FindBy(xpath = "//h2[text()='Movies']/../..//a")
	public WebElement cwmt;

	@FindBy(xpath = "//div[contains(@class,'wrap')]")
	public WebElement movie;

	@FindBy(xpath = "//div[contains(@class,'wrap')]")
	public List<WebElement> movies;

	@FindBy(xpath = "//div[@class='MSWMWrap']")
	public WebElement cwec;

	@FindBy(xpath = "//div[@class='MSWMWrap']")
	public List<WebElement> cwecs;

	@FindBy(xpath = "//div[@class='movie-wrap cWatchMovieCards']")
	public WebElement cwm;

	@FindBy(xpath = "//div[@class='movie-wrap cWatchMovieCards']")
	public List<WebElement> cwms;

	@FindBy(xpath = "//div[@class='MLWMTitle']")
	public WebElement episodecontent;

	@FindBy(xpath = "//div[@class='MLWMTitle']")
	public List<WebElement> episodecontents;

	@FindBy(xpath = "//div[@class='episodeTitle']")
	public WebElement epittitle;

	@FindBy(xpath = "//div[@class='MLWMTitle']")
	public WebElement itscontent;

	@FindBy(xpath = "//div[@class='MLWMTitle']")
	public List<WebElement> itscontents;

	@FindBy(xpath = "(//div[@class='MSWMWrap'])[1]")
	public WebElement newscontent;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public List<WebElement> newscontents;

	@FindBy(xpath = "//div[@class='allEpisodes tabs active']//h2")
	public WebElement allepisodes1;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public WebElement newsshow1;

	@FindBy(xpath = "//a[contains(@href,'Shows-We-Recommend')]")
	public WebElement morebutton1;

	@FindBy(xpath = "//div[@class='MSWMWrap']")
	public WebElement kannadacontent;

	@FindBy(xpath = "//div[@class='episodeTitle']//h2")
	public WebElement contenttitle;

	@FindBy(xpath = "//a[@href='/shows/silsila/1/606786']")
	public WebElement silsila;

	@FindBy(xpath = "//a[@href='/shows/silsila/1/606786']")
	public WebElement silsilacontent;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public WebElement showfromdrama;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public WebElement contentfromdrama;

	@FindBy(xpath = "//a[contains(@href,'top-shows-on-voot')]")
	public WebElement vootmorebutton;

	@FindBy(xpath = "//div[@class='MLWML_Label']")
	public WebElement showfromvoot;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public WebElement contentfromvoot;

	@FindBy(xpath = "//h2[text()='Uncut Scenes']")
	public WebElement uncutscens;

	@FindBy(xpath = "//div[@class='episodeTitle']")
	public WebElement generettitle;

	@FindBy(xpath = "//div[@class='MSWMWrap']")
	public WebElement PopularNewsHindiShow;

	@FindBy(xpath = "//div[@class='VSBannerContainer']//div[@class='play']")
	public WebElement playBTNVODplayer;

	/////// bhaskar//////

	//////////// Added by me //////////

	@FindBy(xpath = "//button[@class='slick-arrow slick-prev']")
	public WebElement carousalPrevBtn;

	@FindBy(xpath = "//button[@class='slick-arrow slick-next']")
	public WebElement carousalNextBtn;

	@FindBy(xpath = "//div[@class='details']//small[(contains(.,'Form'))]/../..//div[last()][not(@class='play')]/..//img")
	public WebElement carouselHavingForm;

	@FindBy(xpath = "//div[@class='details']//small[not(contains(.,'Form'))]/../..//div[last()][not(@class='play')]/..//img")
	public WebElement carouselShowForm;

	@FindBy(xpath = "//div[@class='VSTitle']/h1")
	public WebElement carouselShowDetailTitle;

	@FindBy(xpath = "(//div[@class='MLWMLWrap'])[2]")
	public WebElement showCardInHomePage;

	@FindBy(xpath = "//div[@class='MSWMWrap']/ancestor::div[contains(@class,'VSingletray VContainer linearTray')]//iframe[contains(@id,'google_ads_iframe')]")
	public WebElement sponsorAdBannerFrameBelowPlayableContentsTray;

	@FindBy(xpath = "//div[@class='MLWMLWrap']/ancestor::div[contains(@class,'VSingletray VContainer linearTray')]//iframe[contains(@id,'google_ads_iframe')]")
	public WebElement sponsorAdBannerFrameBelowNonPlayableContentsTray;

	@FindBy(xpath = "//div[@class='slick-initialized slick-slider extraBanner-slider']//img")
	public WebElement VotingBanner;

	@FindBy(xpath = "//div[@class='slick-initialized slick-slider extraBanner-slider']//img")
	public List<WebElement> VotingBannersInHomePage;

	@FindBy(xpath = "//h2[contains(.,'Continue Watching')]/../..//a[@class='singletrayBtn VButton']")
	public WebElement cwTrayMoreButton;

	@FindBy(xpath = "//h2[.='Apply Now']")
	public WebElement formPageText;

	@FindBy(xpath = "//div[@class='playkit-progress' and contains(@style,'width')]")
	public WebElement progressPercent;

	@FindBy(xpath = "//div[@class='spotlight_container']//div[@class='MSWMWrap']") // 1st
																					// jumbo
																					// asset,single
																					// asset
																					// all
																					// videos
	public WebElement jumboSingleAssetVideo;

	@FindBy(xpath = "//div[contains(@class,'continueWatchActionBtn')]")
	public List<WebElement> cwTrayContentOptions;

	@FindBy(xpath = "//div[contains(@class,'removeCardTooltip')]")
	public WebElement removeContentFromTrayOption;

	@FindBy(xpath = "//div[contains(@class,'VSingletrayTitle')]//h2[contains(.,'Latest')]/../../..//div[@class='MSWMWrap']")
	public WebElement latestEpisodeContentFromHome;

	@FindBy(xpath = "//a[@class='votingcomponent']/img")
	public WebElement VoteBanner;

	@FindBy(xpath = "//div[@class='MSWMTitle']//h3")
	public List<WebElement> contentTitlesFromCWTrayPage;

	@FindBy(xpath = "//div[@class='languagePreferenceActionBtns']//button[contains(@class,'mdl-chip')]/span[@class='mdl-chip__text']")
	public WebElement upadtePreferences;

	@FindBy(xpath = "//div[@class='VSFavou']/span[@class='VSFavouImage']")
	public WebElement favouriteIcon;

	@FindBy(xpath = "//div[@class='VSFavou']/span[@class='VSFavouImage followed']")
	public WebElement favouritedIcon;

	@FindBy(xpath = "//div[@class='favBtn']")
	public WebElement favButton;

	@FindBy(xpath = "(//div[@class='favBtn'])[1]")
	public WebElement favIconOnShow;

	@FindBy(xpath = "//div[@class='mdl-dialog popup']//label[@class='userName']")
	public WebElement userProfileName;

	@FindBy(xpath = "//div[@class='VForgotPwdFields']//span[@class='VForgotPwdText' and text()='A password reset request will be emailed to you on your registered email address.']")
	public WebElement ForgotPawdEmailAddress;

	@FindBy(xpath = "//div[@id='forgotEmail']//label[@for='forgotEmail' and text()='Enter your registered email address']")
	public WebElement forgotpawdRegEmailAddress;

	@FindBy(xpath = "//button[@id='cancelPswdBtn']")
	public WebElement backBtnFoegotPawd;

	@FindBy(xpath = "//div[@class='emailPwdBtn']//button[@id='proceedBtn']")
	public WebElement EmailpasswordBtn;

	@FindBy(xpath = "//div[@class='VForgotPwdContinuationPopupFields']/span[@class='VForgotPwdText' and text()='New password sent to your registered email.']")
	public WebElement passwordSentToEmailMsg;

	@FindBy(xpath = "//button[@id='backToSignin']")
	public WebElement BackToSignInBtn;

	@FindBy(xpath = "//div[contains(@class,'megaMenu ')]/a[@id='shows_dropbtn']")
	public WebElement showstab;

	@FindBy(xpath = "(//div[contains(@class,'MSWMWrap')])[1]")
	public WebElement showsFirstcard;

	@FindBy(xpath = "(//div[contains(@class,'MSWMWrap')])[2]")
	public WebElement showsSecondcard;

	@FindBy(xpath = "//div[@class='details']/h6")
	public List<WebElement> frntTitleArr;

	@FindBy(xpath = "//div[@class='details']/p")
	public List<WebElement> frntDescArr;

	@FindBy(xpath = "//div[@class='details']/small")
	public List<WebElement> frntLabelArr;

	@FindBy(xpath = "//div[@class='gradient']/following-sibling::img")
	public List<WebElement> imgForntEndList;

	@FindBy(xpath = "//div[@class='error-code']")
	public WebElement HttpError404;

	@FindBy(xpath = "//div[@class='MLWML_Label']")
	public List<WebElement> showimgtotal;

	@FindBy(xpath = "//div[@class='VSTitle']/h1")
	public WebElement assetShowDetailPageTile;

	@FindBy(xpath = "//div[@class=' MLWMWrap']")
	public List<WebElement> episodeimgtotal;

	@FindBy(xpath = "//div[contains(@class,'MSWMWrap')]")
	public List<WebElement> episodeimgtotal1;

	@FindBy(xpath = "//div[contains(@class,'footerWrapper')]")
	public WebElement Homefooter;

	@FindBy(xpath = "//div[contains(@class,'footerWrapper')]//a[contains(text(),'About US') or contains(text(),'About Us')  or contains(text(),'about us')]")
	public WebElement aboutUsFooterLink;

	@FindBy(xpath = "//div[contains(@class,'footerWrapper')]//a[contains(text(),'terms of use') or contains(text(),'TERMS OF USE') or contains(text(),'Terms Of Use ') ]")
	public WebElement termsOfUseFooterLink;

	@FindBy(xpath = "//div[contains(@class,'footerWrapper')]//a[contains(text(),'privacy policy') or contains(text(),'Privacy Policy') or contains(text(),'PRIVACY POLICY') ]")
	public WebElement privacypolicyFooterLink;

	@FindBy(xpath = "//div[contains(@class,'footerWrapper')]//a[contains(text(),'faq') or contains(text(),'FAQ') or contains(text(),'Faq') ]")
	public WebElement FAQFooterLink;

	@FindBy(xpath = "//div[contains(@class,'footerWrapper')]//a[contains(text(),'Contact US') or contains(text(),'CONTACT US') or contains(text(),'Contact Us') ]")
	public WebElement ContactUSFooterLink;

	@FindBy(xpath = "//div[@class='social-share']//a[contains(@class,'faceBookIcon')]")
	public WebElement facebookIconFooter;

	@FindBy(xpath = "//div[@class='social-share']//a[contains(@class,'twitterIcon')]")
	public WebElement twitterIconFooter;

	@FindBy(xpath = "//div[@class='social-share']//a[contains(@class,'googlePlusIcon')]")
	public WebElement googlepluseIconFooter;

	@FindBy(xpath = "//div[@class='app-links']//a[contains(@class,'itunesIcon')]")
	public WebElement appStoreLinkBtn;

	@FindBy(xpath = "//div[@class='app-links']//a[contains(@class,'androidIcon')]")
	public WebElement googlePlayLinkBtn;

	@FindBy(xpath = "//div[@class='app-links']//a[contains(@class,'amazonIcon')]")
	public WebElement fireTVLinkBtn;

	@FindBy(xpath = "//div[@class='-pages-hdr']//h3[text()='about us']")
	public WebElement headerTileAboutUs;

	@FindBy(xpath = "//div[@class='-pages-hdr']//h3[text()='terms of use / user agreement']")
	public WebElement headerTiletermsOfUse;

	@FindBy(xpath = "//div[@class='-pages-hdr']//h3[text()='privacy policy']")
	public WebElement headerTilePrivacyPolicys;

	@FindBy(xpath = "//div[@class='-pages-hdr']//h3[text()='Frequently asked questions']")
	public WebElement headerTileFAQ;

	@FindBy(xpath = "//div[@class='-pages-hdr']//h3[text()='contact us']")
	public WebElement headerTileContactUs;

	@FindBy(xpath = "//input[@class='inputtext']")
	public WebElement faceBookEditText;

	@FindBy(xpath = "//span[@class='emphasize']")
	public WebElement twitterLoginLink;

	@FindBy(xpath = "//div[text()='Voot']")
	public WebElement googlePlusIcon;

	@FindBy(xpath = "//h1[text()='Voot']")
	public WebElement apptoreAppshare;

	@FindBy(xpath = "//a[@title='Google Play Logo']")
	public WebElement googleplaystoreTitle;

	@FindBy(xpath = "//a[@aria-label='Amazon']")
	public WebElement amazonTitle;

	@FindBy(xpath = "(//li[contains(@class,'vhamburger-nav-item')]/a)")
	public List<WebElement> hamburgerMenuItems;

	@FindBy(xpath = "//div[contains(@class,'VHamburgerMenu')]")
	public WebElement hamburgerMenuIcon;

	@FindBy(xpath = "//a[contains(@class,'hamburger-dropdown home active')]")
	public WebElement activeHomeTab;

	@FindBy(xpath = "//a[contains(@class,'hamburger-dropdown shows')]")
	public WebElement showTabInhumburgerMenu;

	@FindBy(xpath = "//a[contains(@class,'active') and @id='shows_dropbtn']")
	public WebElement showsHighlighted;

	@FindBy(xpath = "//a[contains(@class,'hamburger-dropdown channels')]")

	public WebElement channelsTabInhumburgerMenu;

	@FindBy(xpath = "//a[contains(@class,'hamburger-dropdown news')]")

	public WebElement newsTabInhumburgerMenu;

	@FindBy(xpath = "//a[contains(@class,'hamburger-dropdown kids')]")

	public WebElement kidsTabInhumburgerMenu;

	@FindBy(xpath = "//a[contains(@class,'hamburger-dropdown movies')]")

	public WebElement moviesTabInhumburgerMenu;

	@FindBy(xpath = "//div[@class='VSTags']/h2")
	public WebElement kidsMetaData;

	@FindBy(xpath = "//div[@class='VSTags']/h2")
	public WebElement homeShowAssetDetail;

	@FindBy(xpath = "//div[@class='MLWMTitle']")
	public List<WebElement> episodeTitlestotal;

	@FindBy(xpath = "//div[@class='MSWMTitle']")
	public List<WebElement> episodeTitlestotal1;

	@FindBy(xpath = "//button[@class='languageSelectBtn']")
	public WebElement langBtn;

	@FindBy(xpath = "//div[contains(@class,'movie-wrap')]//div[@class='play']")
	public List<WebElement> movieContents;

	@FindBy(xpath = "(//div[contains(@class,'movie-wrap')])[1]//div[@class='play']")
	public WebElement movie1stContent;

	@FindBy(xpath = "(//div[contains(@class,'multigridTabs') and contains(.,'All Shorts')]//div[contains(@class,'demo-card-wide')])[14]")
	public WebElement vootShortContent;

	///////////// End///////////////////
	@FindBy(xpath = "//button[contains(@aria-label,'Pause')]")
	public WebElement pauseBtn;
	@FindBy(xpath = "//button[@aria-label='Play clip']") // play button
	public WebElement playBtn;
	@FindBy(xpath = "//button[@aria-label='Mute']") // Volume button
	public WebElement volumeBtn;

	@FindBy(xpath = "//button[@aria-label='Full screen']")
	public WebElement fullscreenBtn;

	@FindBy(xpath = "//div[@class='mbs _6m6 _2cnj _5s6c']//a")
	public WebElement fbProfilePageFirstPostHeadline;

	@FindBy(xpath = "//*[@class='js-display-url']")
	public WebElement firstTweetLink;

//	@FindBy(xpath = "(//img[@class='scaledImageFitWidth img'])[1]")
	@FindBy(xpath = "//div[@class='_6ks']//a")
	public WebElement fbProfilePageFirstPostLink;

	@FindBy(xpath = "(//a[@data-ad-preview='headline'])[1]")
	public WebElement twitterPageFirstPostHeadline;

	@FindBy(xpath = "//div[@class='TwitterCardsGrid TwitterCard TwitterCard--animation']")
	public WebElement twitterFirstPostLink;

	@FindBy(xpath = "//div[@data-click='profile_icon']//a")
	public WebElement fbMyProfilePage;

	@FindBy(xpath = "//span[@class='news-live-maincarousel' or contains(.,'LIVE')]")
	public WebElement carousalLiveContent;

	@FindBy(xpath = "//div[@class='user-loginContainer']/span")
	public WebElement userLoggedIn;

	@FindBy(id = "user-dropdown")
	public WebElement twitterMyProfilePage;

	@FindBy(xpath = "//a[@data-nav='view_profile']")
	public WebElement twitterMyProfilePageLink;

	@FindBy(xpath = "//div[contains(@class,'VSBannerContainer')]//div[contains(@class,'play')]")
	public WebElement bannerDetailPage;

	@FindBy(xpath = "//img[contains(@id,'channelWaterMarkLogo')]") // Voot Logo
	public WebElement channelLogoPlayer;

	@FindBy(xpath = "//*[contains(@class,'playkit-is-fullscreen')]")
	public WebElement isFullScreen;

	@FindBy(xpath = "//button[contains(@class,'icon-expand')]")
	public WebElement expand360;

	@FindBy(xpath = "//button[contains(@class,'icon-next')]")
	public WebElement next360;

	@FindBy(xpath = "//div[contains(@class,'volumeControl')]")
	public WebElement volumeControl360;

	@FindBy(xpath = "//button[contains(@class,'icon-vr')]")
	public WebElement vrIcon360;

	@FindBy(xpath = "//span[contains(text(),'Episodes')]") // All Episodes tab
	public WebElement allEpisodes;

	@FindBy(xpath = "//img[contains(@class,'Voot-Logo')]")
	public WebElement vootLogo;

	@FindBy(xpath = "//span[@class='favImage']")
	public WebElement favouritesIcon;

	@FindBy(xpath = "//a[contains(@class,'faceBookIcon')]")
	public WebElement facebookIcon;

	@FindBy(xpath = "//a[@class='voot-brand-logo']")
	public WebElement vooticon;

	@FindBy(xpath = "//div[contains(@class,'time')]/span")
	public WebElement currentTime;

	/*
	 * @FindBy(id ="kids_dropbtn") public WebElement kidsTab;
	 */

	@FindBy(xpath = "//button[@aria-label='Pause']")
	public WebElement pause;

	@FindBy(id = "VSearchHome1")
	public WebElement searchBox;

	@FindBy(id = "biggBoss_dropbtn")
	public WebElement biggBossTab;

	@FindBy(id = "news_dropbtn")
	public WebElement NewsTab;

	@FindBy(xpath = "//button[@class='VHamburgerIcon']")
	public WebElement HamburgerIcon;

	@FindBy(xpath = "(//div[contains(@class,'VSingletray') and contains(.,'Colors: Latest Episodes')]//div[contains(@class,'play')])[3]")
	public WebElement latestEpisode;

	@FindBy(xpath = "//h2[contains(.,'Colors: Latest Episodes')]")
	public WebElement colorslatestEpisode;

	@FindBy(xpath = "(//div[contains(@class,'VSingletray') and contains(.,'Live News')]//div[contains(@class,'play')])[3]")
	public WebElement livenewsContent;

	@FindBy(xpath = "//div[contains(@class,'playkit-live')]")
	public WebElement liveTag;

	@FindBy(xpath = "//div[contains(@class,'episodeTitle')]//h1")
	public WebElement livechannelWatchPage;

	@FindBy(xpath = "//div[contains(@class,'VSDescription')]")
	public WebElement livechanneldesc;

	@FindBy(xpath = "//h2[contains(.,'Live News')]")
	public WebElement liveNewsTray;

	@FindBy(xpath = "//h2[.='Top Shows on Voot']")
	public WebElement homePageTrayTitle;

	@FindBy(xpath = "(//h2[.='Top Shows on Voot']/../../..//div[contains(@class,'slick-initialized slick-slider traySlider')]//div[@class='MLWML_Label'])[1]")
	public WebElement topShowFirstShow;

	@FindBy(id = "com.tv.v18.viola:id/progressBar")
	public List<WebElement> progressBar1;

	@FindBy(id = "com.tv.v18.viola:id/progressBar")
	public WebElement progressBar;

	@FindBy(xpath = "//div[@class='user-loginContainer']")
	public WebElement userLogin;

//@FindBy(xpath = "//label[contains(@for,'quality')]")
	@FindBy(xpath = "//div[contains(@class,'settings-li-header')]/p[contains(.,'Quality')]")
	public WebElement qualityInPlayer;

	// sachin(below xpath works for both videomaster/banner/imageMaster)
	@FindBy(xpath = "//div[@class='adDetails']")
	public WebElement AdsBanner;

	/*
	 * @FindBy(xpath = "//div[@class='playkit-dropdown-button']//span[.='Auto']")
	 * public WebElement autoQuality;
	 * 
	 * @FindBy(xpath = "//div[@class='playkit-dropdown-menu-item']//span[.='High']")
	 * public WebElement highQualityOption;
	 * 
	 * @FindBy(xpath =
	 * "//div[@class='playkit-dropdown-menu-item']//span[.='Medium']") public
	 * WebElement mediumQualityOption;
	 * 
	 * @FindBy(xpath = "//div[@class='playkit-dropdown-menu-item']//span[.='Low']")
	 * public WebElement lowQualityOption;
	 */
	// @FindBy(xpath = "//div[@class='playkit-dropdown-button']//span[.='Auto']")
	@FindBy(xpath = "//div[contains(@class,'settings-li')]//p[contains(.,'Auto')]")
	public WebElement autoQuality;

	// @FindBy(xpath = "//div[@class='playkit-dropdown-menu-item']//span[.='High']")
	@FindBy(xpath = "//div[contains(@class,'settings-li')]//p[contains(.,'High')]")
	public WebElement highQualityOption;

//		@FindBy(xpath = "//div[@class='playkit-dropdown-menu-item']//span[.='Medium']")
	@FindBy(xpath = "//div[contains(@class,'settings-li')]//p[contains(.,'Medium')]")
	public WebElement mediumQualityOption;

	// @FindBy(xpath = "//div[@class='playkit-dropdown-menu-item']//span[.='Low']")
	@FindBy(xpath = "//div[contains(@class,'settings-li')]//p[contains(.,'Low')]")
	public WebElement lowQualityOption;

	@FindBy(id = "com.tv.v18.viola:id/txt_ad_count")
	public List<WebElement> textAdCount;

	@FindBy(xpath = "//div[contains(@class,'scrubber')]")
	public WebElement scrubber;
	// h2[contains(@class,'VSingletrayTitle')]

	@FindBy(xpath = "//h2[contains(@class,'VSingletrayTitle')]")
	public WebElement trayValue;

	@FindBy(xpath = "//div[contains(@class,Tags)]//h2[contains(.,'Vote')]")
	public WebElement votingPageText;

	@FindBy(id = "shows_dropbtn")
	public WebElement showsTab;

	@FindBy(id = "news_dropbtn")
	public WebElement newsTab;

	@FindBy(id = "channels_dropbtn")
	public WebElement channelsTab;

	@FindBy(id = "biggBoss_dropbtn")
	public WebElement risingTab;

	@FindBy(id = "movies_dropbtn")
	public WebElement moviesTab;

	@FindBy(id = "kids_dropbtn")
	public WebElement kidsTab;

	@FindBy(xpath = "//button[contains(.,'Skip Ad')]")
	public WebElement skipAd;

	@FindBy(xpath = "//div[contains(@class,'videoAdUiLearnMore') and contains(.,'Learn More')]")
	public WebElement learnMore;

	@FindBy(id = "Shows")
	public WebElement showsDropDownContainer;

	@FindBy(id = "Channels")
	public WebElement channelsDropDownContainer;

	@FindBy(xpath = "//a[.='Home']/../span[contains(.,'Shows')]")
	public WebElement showPageText;

	@FindBy(xpath = "//a[.='Home']/../span[contains(.,'News')]")
	public WebElement newsPageText;

	@FindBy(xpath = "//a[.='Home']/../span[contains(.,'Channels')]")
	public WebElement channelsPageText;

	@FindBy(xpath = "//a[.='Home']/../span[contains(.,'Movies')]")
	public WebElement moviesPageText;

	@FindBy(xpath = "//div[contains(@class,'playkit-progress-bar')]")
	public WebElement playerLengthControl;

	@FindBy(xpath = "//a[contains(@class,'playkit-scrubber')]")
	public WebElement playerScrubber;
	@FindBy(xpath = "//a[.='Home']/../span[contains(.,'Kids')]")
	public WebElement kidsPageText;

	@FindBy(id = "Movies")
	public WebElement moviesDropDownContainer;

	@FindBy(xpath = "//div[@class='VSearch']")
	public WebElement searchIcon;

	@FindBy(xpath = "//div[@class='details']/h6")
	public WebElement featureVideoTitle;

	@FindBy(xpath = "//div[@class='episodeTitle']/h2")
	public WebElement episodeTitle;

	@FindBy(xpath = "//div[@class='VSEpisodeTags']/h2")
	public WebElement metaData;

	@FindBy(xpath = "//div//img[@alt='Search Icon']")
	public WebElement searchNew;

	@FindBy(xpath = "//div//input[@type='text']")
	public WebElement searchboxNew;

	@FindBy(xpath = "//div[@class='VSTitle']")
	public WebElement videotitle;

	@FindBy(xpath = "//button[@aria-label='Fullscreen']")
	public WebElement fullscreen;

	@FindBy(xpath = "//div[contains(@class,'mainCaroselContainer')]")
	public WebElement featurevideo;
	/*
	 * @FindBy(id="VSearchHome1") public WebElement searchBox;
	 */
	@FindBy(xpath = "//button[@class='playkit-control-button' and @aria-label='Play']")
	public WebElement playButton;

	@FindBy(xpath = "//span[@class='settingsImage']")
	public WebElement settingsIcon;

	@FindBy(xpath = "//h6[.='Account Settings']")
	public WebElement accountsettings;

	@FindBy(xpath = "//h6[.='Preferences']")
	public WebElement preferences;

	@FindBy(xpath = "//span[.='Edit Profile']")
	public WebElement editProfileLink;

	@FindBy(xpath = "//div[@id='voot_player']")
	public WebElement videoViewer;

	@FindBy(xpath = "//div[contains(@class,'currentTimeLabel')]")
	public WebElement timer;

	@FindBy(xpath = "//div[contains(@class,'mainCaroselContainer')]/button[contains(.,'Next')]")
	public WebElement homeMastHeadNextButton;
	@FindBy(xpath = "//div[@class='play']")
	public WebElement featureVideoPlayButton;

	@FindBy(xpath = "//div[contains(@class,'durationLabel')]")
	public WebElement totalTime;

	@FindBy(id = "muteBtn")
	public WebElement mute;

	@FindBy(xpath = "//div[@class='playkit-bottom-bar']")
	public WebElement videoControls;

	@FindBy(xpath = "//span[@class='ui-slider-handle ui-corner-all ui-state-default playHead PIE btn']")
	public WebElement slider;

	@FindBy(xpath = "(//div[@class='spotlight_container'])[1]") // 1st jumbo
																// asset
	public WebElement jumboAssetTray;
	@FindBy(xpath = "//span[@class='ad-component ad-notice-label']")
	public WebElement Ad;
	@FindBy(xpath = "((//div[@class='spotlight_container'])[1]//button[@class='next'])[1]") // 1st
																							// jumbo
																							// asset
																							// next
																							// button
	public WebElement jumboAssetTrayNextButton;

	@FindBy(xpath = "(//div[@class='spotlight_container'])[1]//div[@class='MSWMWrap']") // 1st
																						// jumbo
																						// asset,single
																						// asset
																						// all
																						// videos
	public List<WebElement> jumboSingleAssetVideos;

	@FindBy(xpath = "(//div[@class='spotlight_container'])[1]//div[@class='MSWMTitle']") // 1st
																							// jumbo
																							// asset,single
																							// asset
																							// all
																							// videos
	public List<WebElement> jumboSingleAssetVideoTitle;

	@FindBy(xpath = "//h2[contains(.,'Top Shows on Voot')]/../..//a[@class='singletrayBtn VButton']")
	public WebElement topShowMoreButton;

	boolean secondAd = false;
	// boolean add;
	@FindBy(xpath = "//button[contains(@class,'playPauseBtn')]")
	public WebElement playPause;

	@FindBy(xpath = "//a[contains(@id,'kids_dropbtn')]")
	public WebElement kidsPage;

	@FindBy(xpath = "//div[contains(@class,'videoAdUiAttribution') and contains(.,'Ad')]")
	public WebElement AdNew;

	@FindBy(xpath = "//a[contains(@id,'movies_dropbtn')]")
	public WebElement moviesPage;
	@FindBy(xpath = "//a[@class='voot-brand-logo']")
	public WebElement vootBrandLogo;

	@FindBy(xpath = "(//div[contains(@class,'VMoviesCard')])[4]")
	public WebElement contentFromMoviesPage;

	@FindBy(xpath = "//div[contains(@class,'episodeTitle')]//h2")
	public WebElement contentTitle;

	@FindBy(xpath = "//div[contains(@class,'VSTitleContainer')]//h1")
	public WebElement movieTitle;

	@FindBy(xpath = "//div[contains(@class,'social-share')]")
	public WebElement footerPage;

	@FindBy(xpath = "//div[contains(@class,'VSingletrayTitle')]")
	public WebElement trayTitle;

	@FindBy(xpath = "//div[contains(@class,'card-holder')]")
	public WebElement channelCard;

	@FindBy(xpath = "//button[contains(.,'load more')]")
	public WebElement loadMore;

	@FindBy(xpath = "//button[contains(.,'A-Z')]")
	public WebElement AZButton;

	@FindBy(xpath = "//div[contains(@class,'VCard demo-card-wide')]")
	public WebElement showsCard;

	@FindBy(xpath = "//div[contains(@class,'channels_name')]")
	public WebElement ChannelName;

	@FindBy(xpath = "//a[contains(@id,'channels_dropbtn')]")
	public WebElement channelsPage;

	@FindBy(xpath = "//li[.='Replay']")
	public WebElement replayButton; // Replay button

	/*
	 * @FindBy(
	 * xpath="(//div[contains(@class,'VSingletray') and contains(.,'Binge Watch')]//div[contains(@class,'mediaSmallwithMetaCard')])[4]"
	 * ) public WebElement randomContent;
	 */

	@FindBy(xpath = "(//div[contains(@class,'VSingletray') and contains(.,'Binge Watch')]//div[contains(@class,'mediaSmallwithMetaCard')])[4]")
	public WebElement randomContent;

	@FindBy(xpath = "//div[contains(@class,'playkit-headline')]")
	public WebElement somethngwrongNetworkInterruption;

	@FindBy(xpath = "//h2[.='All Shorts']") // All Shorts tab
	public WebElement allShorts;
	@FindBy(xpath = "//li[.='Cancel']")
	public WebElement cancelBtn; // Cancel button

	@FindBy(xpath = "//*[contains(@class,'repeat')]//figure")
	public WebElement contnuousBtn; // Continuous button

	@FindBy(xpath = "//button[@aria-label='Rewind']") // Rewind button
	public WebElement rewind;

	@FindBy(xpath = "//button[@aria-label='Volume']") // Volume button
	public WebElement volume;

	@FindBy(xpath = "//button[contains(@class,'playkit-retry-btn')]")
	public WebElement ReplayNetworkInterruption;

	@FindBy(xpath = "//div[@class='playkit-volume-control-bar']") // Volume
																	// button
	public WebElement volumeValue;

	@FindBy(xpath = "//div[@class='playkit-bar']") // Volume hover bar
	public WebElement volumeBar;

	@FindBy(xpath = "//button[@aria-label='Settings']") // Settings icon
	public WebElement settings;

	@FindBy(xpath = "//button[@aria-label='Fullscreen']") // Full Screen icon
	public WebElement fullScreen;

	@FindBy(xpath = "//img[contains(@src,'Voot-Logo')]") // Voot Logo
	public WebElement vootLogoPlayer;

	@FindBy(xpath = "(//div[contains(@class,'multigridTabs') and contains(.,'All Shorts')]//div[contains(@class,'demo-card-wide')])[3]")
	public WebElement video360;

	@FindBy(xpath = "(//div[contains(@class,'VSingletray') and contains (.,'Up Next?')]//div[contains(@class,'demo-card-wide')])[2]")
	public WebElement playList360;

	@FindBy(xpath = "//a[contains(@id,'shows_dropbtn')]")
	public WebElement showsPage;

	@FindBy(xpath = "(//div[contains(@class,'VSingletray') and contains(.,'All Shows')]//div[contains(@class,'mediaSmallwithMetaCard')])[4]")
	public WebElement randomShowshowsPage;

	@FindBy(xpath = "(//div[contains(@class,'VCard demo-card-wide')])[2]")
	public WebElement contentFromShowPage;

	@FindBy(xpath = "(//div[contains(@class,'VCard demo-card-wide')])[14]")
	public WebElement contentFromKidsPage;

	@FindBy(xpath = "//a[contains(@href,'/listing/top-shows-on-voot/?')]")
	public WebElement morebutton;

	@FindBy(xpath = "(//div[@class='MSWMTitle'])[2]")
	public WebElement episodefromhome;
	@FindBy(xpath = "//a[contains(text(),'The Great Discovery')]")
	public WebElement kidmovie;
	@FindBy(xpath = "(//div[@class='MLWML_Label'])[2]")
	public WebElement showfromhome;

	@FindBy(xpath = "(//div[@class='MSWMTitle'])[2]")
	public WebElement shownamefromchannel;

	@FindBy(xpath = "//div[@class='VSearch']")
	public WebElement searchtab;

	@FindBy(xpath = "(//div[@class='MSWMTitle'])[2]")
	public WebElement episodenamefromchannel;

	@FindBy(xpath = "//div[@class='megaMenu dropdown class_1200']")
	public WebElement moviestab;

	// Saravanan
	@FindBy(xpath = "//div[contains(@class,'card-holder')]")
	public List<WebElement> channelCards;

	@FindBy(xpath = "//h2[contains(.,'Latest in Kannada')]/../..//..//div[@class='MSWMTitle']")
	public WebElement firstShowInLatestKannada;

	@FindBy(xpath = "//h2[contains(.,'Watch All Episodes')]/../..//..//div[@class='MSWMTitle']")
	public WebElement firstShowInWatchAllEpisodesAfterSearch;

	@FindBy(xpath = "//h2[contains(.,'Most Popular Hindi Movies')]/../..//..//..//div[@class='VMoviesCard demo-card demo-card-image mdl-card MoviesCard']")
	public WebElement firstPopularHindiMovie;

	@FindBy(xpath = "//div[@class='VMoviesCard demo-card demo-card-image mdl-card MoviesCard']//div[@class='mdl-card__title  mdl-card--expand card_title']")
	public WebElement cwMovieTitle;

	@FindBy(xpath = "//div[@class='movie-wrap cWatchMovieCards']//a[@title='Bajirao Mastani']")
	public WebElement cwMovieTitle_New;

	@FindBy(xpath = "//div[@class='playkit-bottom-bar']//div[@class='playkit-time-display']//span")
	public WebElement playkitTime;

	@FindBy(xpath = "//div[@class='VSingletrayTitle ']//h2[@class='title'][contains(.,'Continue Watching')]")
	public WebElement continueWatchTrayInHomePage;

	@FindBy(xpath = "//div[@class='mdl-card__supporting-text mdl-shadow--2dp ']//div[@class='MSWMTitle']")
	public WebElement titleInCw;

	@FindBy(xpath = "//div[@class='mdl-card__supporting-text mdl-shadow--2dp ']//div[@class='MSWMTitle']")
	public List<WebElement> titleInCwAsList;

	@FindBy(xpath = "//div[@class='VtitleContainer']//h2[contains(.,'All Shows')]")
	public WebElement allShowsTray;

	@FindBy(xpath = "//div[@class='VtitleContainer']//h2[contains(.,'Continue Watching')]")
	public WebElement continueWatchTrayTitle;

	@FindBy(xpath = "//div[@class='mdl-card__supporting-text mdl-shadow--2dp ']//div[@class='MSWMTitle']")
	public WebElement continueWatchFirstShow;

	@FindBy(xpath = "//div[@class='mediaSmallwithMetaCard-Wrpa cWatchepisodeCards']//span[@class='continueWatchActions']//div[@class='continueWatchActionBtn bottom']")
	public WebElement threeDotIconInFirstCW;

	@FindBy(xpath = "//div[@class='mediaSmallwithMetaCard-Wrpa cWatchepisodeCards']//span//div[contains(.,' Remove From Continue Watching')]")
	public WebElement removeContinueWatch;

	@FindBy(xpath = "//div[@class='toast mdl-snackbar mdl-js-snackbar removeCwatchToast']//div[@class='textWrapper']//div[@class='mdl-snackbar__text ']")
	public WebElement removeContinueWatchToast;

	@FindBy(xpath = "//div[@class='toast mdl-snackbar mdl-js-snackbar removeCwatchToast']//div[@class='textWrapper']//button")
	public WebElement cwToastUndoButton;

	@FindBy(xpath = "//div[@class='xyz']//div[@class='playkit-spinner']")
	public WebElement playkitSpinner;

	@FindBy(xpath = "//h2[contains(.,'Continue Watching')]/../..//a[@class='singletrayBtn VButton']")
	public WebElement moreButtonInContinueWatching;

	@FindBy(xpath = "//div[@class='ContinueWatchTray']//div[@class='MSWMTitle']")
	public WebElement titleInCwTray;

	@FindBy(xpath = "//div[@class='ContinueWatchTray']//div[@class='MSWMTitle']")
	public List<WebElement> titleInCwTrayAsList;

	@FindBy(xpath = "//div[@class='playkit-bottom-bar']")
	public WebElement playkitBottomBar;

//	Saravanan 17th Jan 2019
	@FindBy(xpath = "//div[@class='VSingletrayTitle ']//h2[@class='title'][contains(.,'Latest in Kannada')]")
	public WebElement latestInKannada;

	@FindBy(xpath = "//h2[contains(.,'Latest in Kannada')]/../..//a[@class='singletrayBtn VButton']")
	public WebElement moreButtonAtLatestInKannada;

	@FindBy(xpath = "//h2[contains(.,'Similar Shows')]/../..//a[@class='singletrayBtn VButton']")
	public WebElement moreButtonAtSimilarShows;

	@FindBy(xpath = "//div[@class='VGuestUserExperience']")
	public WebElement guestLoginPopUp;

	@FindBy(xpath = "//div[@class='VLoginMainPopUp']")
	public WebElement guestLoginMainPopUp;

	@FindBy(xpath = "//div[@class='VGuestUserExperience']//button[@class='close']")
	public WebElement guestLoginCloseButton;

	@FindBy(xpath = "//div[@class='channels_name']")
	public WebElement firstChannelNameInChannelsTab;

	@FindBy(xpath = "//div[@class='VSingletray VMultitray ']//div[@class='VtitleContainer']//h2[contains(.,'Similar Shows')]")
	public WebElement similarShowTray;

	@FindBy(xpath = "//div[@class='VSBannerContainer']//div[@class='play']")
	public WebElement playIcon;

	@FindBy(xpath = "//div[@class='VGuestUserExperience']//div[@class='vgue-button-container']//h2")
	public WebElement continueWatchText_InGuestUserPopup;

	@FindBy(xpath = "//div[@class='VGuestUserExperience']//div[@class='vgue-button-container']//p")
	public WebElement continueWatchDescription_InGuestUserPopup;

	@FindBy(xpath = "//div[@class='VGuestUserExperience']//div[@class='vgue-button-container']//button[@class='vgue-login']")
	public WebElement signInButtonInGuestUserPopup;

	@FindBy(xpath = "//div[@class='VPopup dialogContainer VLoginPopup demoPopBg login']//div[@class='mdl-dialog popup demoPopChild']//button[@class='close']")
	public WebElement closeButtonInGuestUserRegisterPopup;

	@FindBy(xpath = "//div[@class='VSShowsPagesWrapper']//div[@class='dynamicTrayCRE']//h2[@class='title']")
	public WebElement similarShowAfterVideoPlayback;

	@FindBy(xpath = "//div[@class='registartionbtnWrapper']")
	public WebElement registerScreen;

	@FindBy(xpath = "//*[@class='margin-a ']//img")
	public WebElement showCarousal;

	@FindBy(xpath = "(//*[@class='MLWMLWrapParent'])[1]")
	public WebElement firstShowFromShowsWeRecommend;

	@FindBy(xpath = "(//*[@class='MLWMLWrapParent'])[1]//ancestor::div[contains(@class,'VSingletray')]//div[@class='VtitleContainer']/div/h2")
	public WebElement TrayNameShowsWeRecommend;

	@FindBy(xpath = "(//*[@class='MLWMLWrapParent'])[1]//ancestor::div[contains(@class,'VSingletray')]")
	public WebElement TrayNumberShowsWeRecommend;

	@FindBy(xpath = "(//*[@class='MLWMLWrapParent'])[1]//div[@class='MLWML_Label']//h3")
	public WebElement firstShowFromShowsWeRecommendName;

	@FindBy(xpath = "((//*[@class='mediaSmallwithMetaCard-Wrpa '])//div[@class='MSWMTitle']/h3)[3]")
	public WebElement allShowsInShowsTabThirdShow;

	@FindBy(xpath = "((//*[@class='mediaSmallwithMetaCard-Wrpa '])//div[@class='MSWMTitle']/h3)[2]")
	public WebElement allShowsInShowsTabSecondShow;

	@FindBy(xpath = "//div[@class='VSingletrayTitle ']//h2[contains(.,'Shows We Recommend')]/../../..//div[@class='MLWMLWrapParent']")
	public WebElement showsRecomendFirstShow;

	// V3 DFP

	@FindBy(xpath = "//h3[contains(text(),'Continue Watching') or contains(text(),'continue watching')]")
	public WebElement ContinueWatchingRail;

	@FindBy(xpath = "//h3[contains(text(),'Continue Watching') or contains(text(),'continue watching')]/following::div[contains(@class,'slick-slide slick-active slick-current')][1]")
	public WebElement ContinueWatching1stCard;

	@FindBy(xpath = "//h3[contains(text(),'Shows For You') or contains(text(),'Shows We Recommend')]")
	public WebElement ShowsforYouRail;

	@FindBy(xpath = "//h3[contains(text(),'Shows For You') or contains(text(),'Shows We Recommend')]/following::div[contains(@class,'meta-desc')][1]//h4")
	public WebElement ShowsForUMetaData;

	@FindBy(xpath = "//h3[contains(text(),'Shows For You') or contains(text(),'Shows We Recommend')]/following::div[contains(@class,'slick-slide slick-active slick-current')][1]")
	public WebElement showsForUFirstCard;

	@FindBy(xpath = "//div[contains(@class,'playkit-time-display')]//span")
	public WebElement playerTimeDetails;

	UtilitiesWeb utilities = new UtilitiesWeb();

	public void clickAllLoadMore() throws Exception {
		HomePage homePage = new HomePage(driver, test);
		for (int i = 0; i < 30; i++) {
			try {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePage.loadMore);
				Thread.sleep(2000);
				// Thread.sleep(1000);
				if (homePage.loadMore.isDisplayed()) {
					homePage.loadMore.click();
					Thread.sleep(2000);
				} else {
					// ((JavascriptExecutor)
					// driver).executeScript("window.scrollTo(0,0)");
					// (//div[contains(@class,'VMSWM episodeCard')])[1]
					WebElement element = driver
							.findElement(By.xpath("//div[contains(@class,'VtitleContainer') and contains(.,'Shows')]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(2000);
					break;
				}
			} catch (Exception e) {
				WebElement element = driver
						.findElement(By.xpath("//div[contains(@class,'VtitleContainer') and contains(.,'Shows')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(2000);
				break;
			}

		}

	}

	public void scrollTillEnd() throws Exception {
		for (int i = 0; i < 30; i++) {
			try {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(500);
			} catch (Exception e) {
				break;
			}
		}

	}

	// Method to calculate playhead position
	public String calculatePlayheadPosition() throws Exception {
		try {
			HomePage homepage = new HomePage(driver, test);
			// Get the playhead position
			String playheadString = homepage.playerTimeDetails.getText().trim().split(" / ")[0];
			event.log( "INFO", "Video duration displayed in UI: " + playheadString);
			String mins = playheadString.split(":")[0];
			String secs = playheadString.split(":")[1];
			int minsInt = Integer.parseInt(mins);
			int SecsInt = Integer.parseInt(secs);
			int playheadTime = (minsInt * 60) + SecsInt;
			return (Integer.toString(playheadTime));
		} catch (Exception e) {
			event.log( "FAIL/WOSS", "Fail to get playhead position");
			

			return "";
		}

	}


	public void homepage() {
		HomePage homepage = new HomePage(driver, test);
		try {
			if (utilities.explicitWaitVisible(driver, homepage.vootBrandLogo, 5)) {
				homepage.vootBrandLogo.click();
			} else {
				event.log( "FAIL/WOSS", "Voot Logo not displayed in Mega menu home page");
				
				baseTestWeb.logScreenShot(driver, test, "");
			}
		} catch (Exception e) {
			event.log( "FAIL", "Voot Logo not displayed in Mega menu home page");
		}
	}



	public void scrollTillEnd(String url, int count, String jsonPath) throws Exception {
		Response rskids = utilities.requestUtility(url);

		countApi = rskids.jsonPath().get(jsonPath);
		countApi = countApi - count;
		HomePage homePage = new HomePage(driver, test);
		int j = 5;
		int k = 30;
		event.log( "INFO", "Total trays/shows count from API Response: " + countApi);
		next: for (int i = 0; i < 50; i++) {
			try {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(500);
				if (i == j) {
					Thread.sleep(2000);
					event.log( "INFO", "Trays displayed after " + j + " scrolls");
					baseTestWeb.logScreenShot(driver, test, "");
					j = j + 5;
				}
				if (i == k) {
					if (homePage.facebookIcon.isDisplayed()) {
						Thread.sleep(2000);
						event.log( "INFO", "Scrolled till end of home page");
						baseTestWeb.logScreenShot(driver, test, "");
						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
						k = k + 5;
						break;

					} else {
						event.log( "INFO", "Social share icon (Facebook) is not displayed on the footer");
						baseTestWeb.logScreenShot(driver, test, "");

						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
						continue next;
					}
				}

			}

			catch (Exception e) {
				break;
			}

		}
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		if (homePage.facebookIcon.isDisplayed()) {
			event.log( "INFO", "Scrolled till end of home page");
			baseTestWeb.logScreenShot(driver, test, "");
		} else {
			event.log( "INFO", "Social share icon (Facebook) is not displayed on the footer");
			baseTestWeb.logScreenShot(driver, test, "");
		}
	}

	/*
	 * public void verifyAndProgressBar() throws Exception {
	 * 
	 * GlobalVariablesWeb.add=false;
	 * 
	 * for(int k=0;k<10;k++) { if(!utilities.explicitWaitVisible(driver,
	 * progressBar,5)) break; } try{ WebElement frame=driver.findElement(By.xpath(
	 * "//iframe[contains(@src,'imasdk.googleapis.com')]"));
	 * driver.switchTo().frame(frame); } catch(Exception e){ } for(int
	 * j=0;j<100;j++) {
	 * 
	 * if(utilities.isDisplayed(driver, Ad)) { GlobalVariablesWeb.add=true;
	 * Thread.sleep(6000); } else if(j>0) break;
	 * 
	 * } try {
	 * 
	 * driver.findElement(By.xpath("//div[contains(@class,'alert-title')]"));
	 * reportFailvPlayback( "Error Alert message is displayed in the video viewer");
	 * Thread.sleep(2000); } catch ( Exception e) { try{
	 * driver.switchTo().defaultContent();}catch(Exception ex){} String url=
	 * driver.getCurrentUrl(); if(url.equals("https://www.voot.com"))
	 * reportFailvPlayback("Clicking on video navigates to Home page"); }
	 * if(utilities.explicitWaitVisible(driver,progressBar,5))
	 * BasePageWeb.reportFail(" Failed to load the video within 90 seconds"); try{
	 * driver.switchTo().defaultContent();}catch(Exception e){} }
	 */


	public String convertCamelCase(String toConvert) throws Exception {
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

	public void pauseVideo() throws Exception {
		if (utilities.explicitWaitVisible(driver, vodPlayer, 20)) {
			try {
				vodPlayer.click();
				event.log( "INFO", "Clicked on player to pause video");
			} catch (Exception e) {
				event.log( "FAIL/WOSS", "Failed to click on player to pause the video");
				

			}
		} else {
			event.log( "FAIL/WOSS", "Player is not visible");
			

		}
	}

	public void playVideo() throws Exception {
		if (utilities.explicitWaitVisible(driver, vodPlayer, 20)) {
			try {
				vodPlayer.click();
				event.log( "INFO", "Clicked on player to play video");
			} catch (Exception e) {
				event.log( "FAIL/WOSS", "Failed to click on player to play the video");
				

			}
		} else {
			event.log( "FAIL/WOSS", "Player is not visible");
			

		}
	}

}
