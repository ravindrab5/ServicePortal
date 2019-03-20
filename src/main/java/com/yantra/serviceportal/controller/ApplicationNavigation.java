package com.yantra.serviceportal.controller;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.yantra.serviceportal.model.CreateBox;
import com.yantra.serviceportal.serviceImpl.CreateBoxServiceImpl;
import com.yantra.serviceportal.serviceImpl.LoginServiceImpl;
import com.yantra.serviceportal.serviceImpl.ProdWelComeScreenServiceImpl;
import com.yantra.serviceportal.services.CreateBoxService;
import com.yantra.serviceportal.services.LoginService;
import com.yantra.serviceportal.services.OperatorPopup;
import com.yantra.serviceportal.services.ProdWelComeScreenService;
import com.yantra.serviceportal.util.Environment;
import com.yantra.serviceportal.view.Login;
import com.yantra.serviceportal.view.SelectOperator;

import static org.awaitility.Awaitility.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ApplicationNavigation {
	EventFiringWebDriver driver;
	LoginService login;
	OperatorPopup operatorPopup;
	Environment env;
	ProdWelComeScreenService prodService;
	CreateBoxService createBox;
	

	public ApplicationNavigation(EventFiringWebDriver driver,Environment env) {
		this.driver = driver;
		login = new LoginServiceImpl(driver);
		this.env=env;

	}

	public void loginServicePSelectOperator(String username, String password, String operator) {
		login.typeUsername(username);
		login.typePasssword(password);
		operatorPopup = login.clickLogin();
	 	
		await("Waiting for the spinner").atMost(20, TimeUnit.SECONDS)
				.until(() -> login.getLogin().getHomeLoader().getAttribute("style"), equalTo("display: none;"));

		await("Waiting for radio button").atMost(10, TimeUnit.SECONDS)
				.until(() -> operatorPopup.getSelectOperator().getRadioMsrtc(operator).isDisplayed(), equalTo(true));
		
		assertThat(driver.getCurrentUrl(),not(equalTo(env.urlService())));
		operatorPopup.selectRadio(operator);
		operatorPopup.typeText(operator);
		operatorPopup.clickSaveChanges();

	}
	
	public ProdWelComeScreenServiceImpl loginProdPSelectOperator(String username, String password, String operator) {
		login.typeUsername(username);
		login.typePasssword(password);
		operatorPopup = login.clickLogin();
	 	
		await("Waiting for the spinner").atMost(20, TimeUnit.SECONDS)
				.until(() -> login.getLogin().getHomeLoader().getAttribute("style"), equalTo("display: none;"));

		await("Waiting for radio button").atMost(10, TimeUnit.SECONDS)
				.until(() -> operatorPopup.getSelectOperator().getRadioMsrtc(operator).isDisplayed(), equalTo(true));
		
		assertThat(driver.getCurrentUrl(),not(equalTo(env.urlProd())));
		operatorPopup.selectRadio(operator);
		operatorPopup.typeText(operator);
		operatorPopup.clickSaveChanges();
		
		prodService= new ProdWelComeScreenServiceImpl(driver);
		return (ProdWelComeScreenServiceImpl) prodService;
	}
	
	public void createBox(CreateBox boxData) {
		
		prodService.clickAddNew();
		createBox=new CreateBoxServiceImpl(driver);
		createBox.typeKiviBoxId(boxData.getKiviboxId());
		createBox.typePiCpuId(boxData.getPiCpuId());
		createBox.typeVtsSerial(boxData.getVtsSerialNumber());
		createBox.typeVtsSimMobileNumber(boxData.getVtsSim());
		createBox.typeSSDSerialNumber(boxData.getHddSerialNumber());
		createBox.typeDongleIMEI(boxData.getDongleImei());
		createBox.selectDongleNetworkType("3G");
		createBox.selectDongleSimOperator("Airtel");
		createBox.typeDongleSimMobileNumber(boxData.getDongleSimMobileNumber());
		createBox.typeDongleSimImeiNumber(boxData.getDongleSimImei());
		createBox.typePowerSupplySerialNumber(boxData.getPowerSupplySerialNumber());
		createBox.typeRouterSerialNumber(boxData.getRouterSerialNumber());
		createBox.selectServiceLead("ramesh yadav");
	  	createBox.clickSubmitButton();
	  	createBox.clickSaveButton();
	  	createBox.clickConfirmationYes();
	 
	  	await("Waiting for radio button")
	  	.atMost(10, TimeUnit.SECONDS)
		.until(() -> createBox.getCreateBox().getCloseSuccessMsg().isDisplayed(), equalTo(true));

	  	String sucessMsg=createBox.getCreateBox().getSucessMsg().getText();
	  	assertThat(sucessMsg,equalTo("\"Kivibox is created successfully\""));
	  	createBox.clickCloseSucessMsg();
	}
	
	 
	 
	
	

}
