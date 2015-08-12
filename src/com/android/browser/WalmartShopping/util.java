package com.android.browser.WalmartShopping;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class util {
	
	public WebDriver getAndroidDriver(WebDriver driver) {
	//File classpathRoot = new File(System.getProperty("user.dir"));
			//File appDir = new File(classpathRoot, "/ContactManager");
			//File app = new File(appDir, "ContactManager.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
			capabilities.setCapability("deviceName", "3200cecac73f8000");
			//capabilities.setCapability("app", app.getAbsolutePath());
			//capabilities.setCapability("appPackage",
			//		"com.example.android.contactmanager");
			//capabilities.setCapability("appActivity", ".ContactManager");
			
			try {
				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
			return driver;
}
}