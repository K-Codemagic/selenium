package com.viacom.web.pages;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.viacom.web.utils.BaseTestWeb;
import com.viacom.web.utils.VootConstants;
 import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class BasePage extends BaseTestWeb{
	public RemoteWebDriver driver;
	public static TopMenuPage menu;
	public ExtentTest test;

	public BasePage(RemoteWebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.test = test;

	}

	public void reportPass(String passMsg) {
		event.log( "PASS", passMsg);
	}

	public void reportFail(String failureMsg) throws Exception {

		Assert.fail(failureMsg);

	}

	public TopMenuPage getMenu() {
		return menu;

	}

	public boolean chkForAd(WebElement videoViewer, WebElement skipAd) throws InterruptedException {
		boolean Ad = false;
		Thread.sleep(5000);
		for (int j = 0; j < 15; j++) {
			if (driver.findElements(By.name("Visit Advertiser")).size() > 0
					|| (driver.findElements(By.id("com.tv.v18.viola:id/txt_ad")).size() > 0))
				Ad = true;
			else if (j > 1)
				break;
			try {
				skipAd.click();
			} catch (Exception e) {
			}

		}
		return Ad;
	}

	public static void fullScreenshot() throws InterruptedException, AWTException, IOException {
		String CURRENTPATH = "";
		switch (VootConstants.OS) {
		case "Mac": {
			CURRENTPATH = VootConstants.SCREENSHOT_PATH_MAC;

			break;
		}
		case "Windows": {
			CURRENTPATH = VootConstants.SCREENSHOT_PATH;
			break;
		}
		}

		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String path = CURRENTPATH + screenshotFile;
		Robot robot = new Robot();
		Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage src = robot.createScreenCapture(rect);
		File scrFile = new File(path);
		ImageIO.write(src, "png", scrFile);
		// add screenshot to report
 		// "+test.addScreenCapture(addScreenshotFull(scrFile)));

	}


	@SuppressWarnings("resource")
	public static String addScreenshotFull(File file) throws AWTException, IOException {

		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (FileNotFoundException e) {
			//System.out.println("Failed due to Exception: "+e.getMessage());
		} catch (IOException e) {
			//System.out.println("Failed due to Exception: "+e.getMessage());
		}
		return "data:image/png;base64," + encodedBase64;
	}
}