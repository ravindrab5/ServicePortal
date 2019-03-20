package com.yantra.serviceportal;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.yantra.serviceportal.controller.ApplicationNavigation;
import com.yantra.serviceportal.driverfactory.DriverManager;
import com.yantra.serviceportal.driverfactory.DriverManagerFactory;
import com.yantra.serviceportal.driverfactory.DriverType;
import com.yantra.serviceportal.driverfactory.GridDriver;
import com.yantra.serviceportal.serviceImpl.LoginServiceImpl;
import com.yantra.serviceportal.services.LoginService;
import com.yantra.serviceportal.util.DataProviderArguments;
import com.yantra.serviceportal.util.Environment;
import com.yantra.serviceportal.util.EventDriver;
import com.yantra.serviceportal.util.LogInitilizer;
import com.yantra.serviceportal.util.ReadCSVFile;
import com.yantra.serviceportal.util.TestScriptMetaData;
import com.yantra.serviceportal.view.Login;
import com.yantra.serviceportal.view.SelectOperator;

import static org.awaitility.Awaitility.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Unit test for simple App.
 */
@Listeners(com.yantra.serviceportal.util.Listener.class)
public class AppTest extends TestBase {
	DriverManager driverManager;
	public EventFiringWebDriver driver;
	Logger log;
	Environment env;
	ApplicationNavigation appNavigation;
	LoginService login;

	@Parameters({ "env" })
	@BeforeTest
	public void beforeTest(String env) {
		ConfigFactory.setProperty("env", env);
		this.env = ConfigFactory.create(Environment.class);
		//driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		log = LogInitilizer.getLogger();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		driver = EventDriver.getEventFiringWebDriver(new GridDriver().getDriver(env));
				//EventDriver.getEventFiringWebDriver(driverManager.getDriver());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		appNavigation = new ApplicationNavigation(driver, env);
		TestScriptMetaData.setTestCaseData(method);
	}

	@AfterMethod
	public void afterMethod() {
	//	driverManager.quitDriver();
		driver.quit();
	}

	@Test(testName = "TECH_APP:TC_001 - CheckBoxList",
			description = "Verify List of boxes assigned to depot",
			enabled = true)
	public void testOne() throws InterruptedException {
		driver.get(env.urlService());
		appNavigation.loginServicePSelectOperator(env.userservice(), env.passwordserv(), env.techicianOperator());
		Thread.sleep(5000);
	}
	
	
	@DataProviderArguments(path="./data-files/LoginValidation")
	@Test(priority=2,
	enabled=true,
	dataProvider="CSVData",
	dataProviderClass = ReadCSVFile.class,
	testName = "TECH_APP:TC_001 - CheckBoxList",
	description = "Verify List of boxes assigned to depot")
	public void invalidLogin(String username,String password,String expected)throws Exception {
		driver.get(env.urlService());
		LoginService login=new LoginServiceImpl(driver);
		login.typeUsername(username);
		login.typePasssword(password);
		login.clickLogin();
		String actual=login.getLogin().getErrMsg().getText();
		assertThat(actual,equalTo(expected));
		
	}
	
	

}
