package com.yantra.serviceportal.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.yantra.serviceportal.util.Capabilities;
import com.yantra.serviceportal.util.Environment;
import com.yantra.serviceportal.util.ResourceUtil;

public class GridDriver {

	public WebDriver getDriver(Environment env) {
 
		Capabilities cap = new Capabilities(
				new ResourceUtil().getFile("desiredcapabilities/" + env.browser() + ".json"));

		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://" + env.hubip() + ":4444/wd/hub"), cap.getCapability());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver=new FirefoxDriver();
		return driver;

	}

}
