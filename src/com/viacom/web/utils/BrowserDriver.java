package com.viacom.web.utils;

import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriver {

	public ThreadLocal<RemoteWebDriver> browserDriver = new ThreadLocal<RemoteWebDriver>();

	public void set(RemoteWebDriver driverInstance) {
		browserDriver.set(driverInstance);
	}

	public RemoteWebDriver get() {
		return browserDriver.get();
	}
}
