package com.yantra.serviceportal.driverfactory;

import org.testng.annotations.Test;

import com.yantra.serviceportal.util.EventDriver;
import com.yantra.serviceportal.util.LogInitilizer;

import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FactoryPatternTest {
	 DriverManager driverManager;
	 EventFiringWebDriver driver;
	    Logger log;

	    @BeforeTest
	    public void beforeTest() {
	        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
	        log=LogInitilizer.getLogger();
	    }

	    @BeforeMethod
	    public void beforeMethod() {
	        driver = EventDriver.getEventFiringWebDriver(driverManager.getDriver());
	    }

	    @AfterMethod
	    public void afterMethod() {
	        driverManager.quitDriver();
	    }

	    @Test
	    public void launchTestAutomationGuruTest() {
	    	log.info("Navigating to "+"http://testautomationguru.com");
	        driver.get("http://testautomationguru.com");
	        driver.findElement(By.linkText("Docker")).click();
	        AssertJUnit.assertEquals("TestAutomationGuru � A technical blog on test automation", driver.getTitle());
	    }

	    @Test
	    public void launchGoogleTest() {
	    	log.info("Navigating to "+"https://www.google.com");
	        driver.get("https://www.google.com");
	        AssertJUnit.assertEquals("Google", driver.getTitle());
	    }

	    @Test
	    public void launchYahooTest() {
	     	log.info("Navigating to "+"https://www.yahoo.com");
	 	   
	        driver.get("https://www.yahoo.com");
	        AssertJUnit.assertEquals("Yahoo", driver.getTitle());
	    }

}
