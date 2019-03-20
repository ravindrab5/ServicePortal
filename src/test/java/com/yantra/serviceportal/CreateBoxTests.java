package com.yantra.serviceportal;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
import com.yantra.serviceportal.model.CreateBox;
import com.yantra.serviceportal.serviceImpl.CreateBoxServiceImpl;
import com.yantra.serviceportal.serviceImpl.ProdWelComeScreenServiceImpl;
import com.yantra.serviceportal.services.CreateBoxService;
import com.yantra.serviceportal.services.ProdWelComeScreenService;
import com.yantra.serviceportal.util.DataProviderArguments;
import com.yantra.serviceportal.util.Environment;
import com.yantra.serviceportal.util.EventDriver;
import com.yantra.serviceportal.util.LogInitilizer;
import com.yantra.serviceportal.util.ReadCSVFile;
import com.yantra.serviceportal.util.TestScriptMetaData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@Listeners(com.yantra.serviceportal.util.Listener.class)
public class CreateBoxTests extends TestBase {

	DriverManager driverManager;
	public EventFiringWebDriver driver;
	Logger log;
	Environment env;
	ApplicationNavigation appNavigation;
	CreateBox boxData; // model

	@Parameters({ "env" })
	@BeforeTest
	public void beforeTest(String env) {
		ConfigFactory.setProperty("env", env);
		this.env = ConfigFactory.create(Environment.class);
	//s	driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		log = LogInitilizer.getLogger();
		boxData = new CreateBox(this.env.techicianOperator(), this.env.userservice());
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
		driver.quit();
		//driverManager.quitDriver();
	}

	@Test(testName = "TECH_APP:TC_002 - CreateBox",
		  description = "Create box with valid data",
			enabled = false)
	public void createValidBox() throws InterruptedException {
		driver.get(env.urlProd());
 		appNavigation.loginProdPSelectOperator(env.userprod(),env.passwordprod(), env.techicianOperator());
  		appNavigation.createBox(boxData);
 	}
	
	@DataProviderArguments(path="./data-files/CreateBoxValidation")
	@Test(priority=2,enabled=true,dataProvider="CSVData",dataProviderClass = ReadCSVFile.class,
			testName = "TECH_APP:TC_002 - CreateBox",
			  description = "Create box with valid data"
				)
	public void invalidBox(String kiviUnitId,String piCpuId,String vtsSerial,
			               String vtsSim,String ssdSerialNumber,String dongleImei,
			               String dongSimImei,String powerSupplySn,String routerSerNo,
			               String expected,String id) {
		driver.get(env.urlProd());
		ProdWelComeScreenServiceImpl prodService=appNavigation.loginProdPSelectOperator(env.userprod(),env.passwordprod(), env.techicianOperator());
		prodService.clickAddNew();
		CreateBoxService createBox=new CreateBoxServiceImpl(driver);
		createBox.typeKiviBoxId(kiviUnitId);
		createBox.typePiCpuId(piCpuId);
		createBox.typeVtsSerial(vtsSerial);
		createBox.typeVtsSimMobileNumber(vtsSim);
		createBox.typeSSDSerialNumber(ssdSerialNumber);
		createBox.typeDongleIMEI(dongleImei);
		createBox.selectDongleNetworkType("3G");
		createBox.selectDongleSimOperator("Airtel");
		createBox.typeDongleSimMobileNumber(boxData.getDongleSimMobileNumber());
		createBox.typeDongleSimImeiNumber(dongSimImei);
		createBox.typePowerSupplySerialNumber(powerSupplySn);
		createBox.typeRouterSerialNumber(routerSerNo);
		createBox.selectServiceLead("ramesh yadav");
		String actual=driver.findElement(By.id(id)).getText();
		assertThat(actual,equalTo(expected));
		
	  	createBox.clickSubmitButton();
	}
	
	
	
}
