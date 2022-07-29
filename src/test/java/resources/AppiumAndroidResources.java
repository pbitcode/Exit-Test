package resources;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumAndroidResources extends LoggerManager{
	
	static public AppiumDriver<MobileElement> driver = null;
	
	static WebDriverWait webdriverwait = null;
	
	static public AppiumDriverLocalService service;
	
	AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
	
	DesiredCapabilities capabilities;
	
	//Method to start the Appium Server
	public void startAppium() {
		serviceBuilder.withLogFile(new File(config.get("AppiumServerLogPath")));
		service = AppiumDriverLocalService.buildService(serviceBuilder);
		service.clearOutPutStreams();
		service.start();
	}
	
	//Method to start the Android Driver
	public void startAndroidDriver() {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", config.get("platformVersion"));
		capabilities.setCapability("platformName", config.get("platformName"));
		capabilities.setCapability("appPackage", config.get("appPackage"));
		capabilities.setCapability("appActivity", config.get("appActivity"));
		capabilities.setCapability("app", config.get("app"));
		capabilities.setCapability("deviceName", config.get("deviceName"));
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL(config.get("url")), capabilities);
			webdriverwait = new WebDriverWait(driver, Integer.parseInt(config.get("DriverWaitTime")));
			
		}catch(Exception e) {
			throw new RuntimeException(e);
			
		}
	}
	
	//Method to stop the Android Driver
	public void stopAndroidDriver() {
		driver.quit();
	}
	
	//Method to stop the Appium Server
	public void stopAppium() {
		service.stop();
	}

}
