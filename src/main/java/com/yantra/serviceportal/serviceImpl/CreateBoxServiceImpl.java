package com.yantra.serviceportal.serviceImpl;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.yantra.serviceportal.services.CreateBoxService;
import com.yantra.serviceportal.util.DropDownSelect;
import com.yantra.serviceportal.view.CreateBoxModal;

public class CreateBoxServiceImpl implements CreateBoxService {
	EventFiringWebDriver driver;
	CreateBoxModal createBox;
	public CreateBoxModal getCreateBox() {
		return createBox;
	}

	DropDownSelect select;
	
	public CreateBoxServiceImpl(EventFiringWebDriver driver) {
		this.driver=driver;
		createBox=new CreateBoxModal(driver);
		select=new DropDownSelect(driver);
	}
	
	@Override
	public void typeKiviBoxId(String box) {
		// TODO Auto-generated method stub
		createBox.getKiviBoxId().sendKeys(box);
	}

	@Override
	public void typePiCpuId(String cpuId) {
		// TODO Auto-generated method stub
		createBox.getPiId().sendKeys(cpuId);
	}

	@Override
	public void typeVtsSerial(String vtsSerial) {
		// TODO Auto-generated method stub
		createBox.getVtsSn().sendKeys(vtsSerial);
	}

	@Override
	public void typeVtsSimMobileNumber(String vtsSim) {
		// TODO Auto-generated method stub
		createBox.getVtsSim1().sendKeys(vtsSim);
	}

	@Override
	public void typeSSDSerialNumber(String serialNumber) {
		// TODO Auto-generated method stub
		createBox.getGetHddSn().sendKeys(serialNumber);
		
	}

	@Override
	public void typeDongleIMEI(String imei) {
		// TODO Auto-generated method stub
		createBox.getDongleImei().sendKeys(imei);
	}

	@Override
	public void selectDongleNetworkType(String dongleNetwork) {
		// TODO Auto-generated method stub
		select.SelectByText(createBox.getDongleNetwork(),dongleNetwork);
	}

	@Override
	public void selectDongleSimOperator(String dongleSimOperator) {
		// TODO Auto-generated method stub
		select.SelectByText(createBox.getDongleSimOper(), dongleSimOperator);
	}

	@Override
	public void typeDongleSimMobileNumber(String mobNumber) {
		// TODO Auto-generated method stub
		createBox.getDongleSimMobileNumber().sendKeys(mobNumber);
	}

	@Override
	public void typeDongleSimImeiNumber(String dongleSimImei) {
		// TODO Auto-generated method stub
		createBox.getDongleSimImei().sendKeys(dongleSimImei);
	}

	@Override
	public void typePowerSupplySerialNumber(String serialNumber) {
		// TODO Auto-generated method stub
		createBox.getPowerSupplySn().sendKeys(serialNumber);
	}

	@Override
	public void typeRouterSerialNumber(String routerSerialNumber) {
		// TODO Auto-generated method stub
		createBox.getRouterSn().sendKeys(routerSerialNumber);
	}

	@Override
	public void selectServiceLead(String sl) {
		// TODO Auto-generated method stub
		select.SelectByText(createBox.getSluser(),sl);
	}

	@Override
	public void clickSubmitButton() {
		// TODO Auto-generated method stub
		((JavascriptExecutor)driver).executeScript("return confirmBoxDetails()");
		//createBox.getSubmitBtn().click();
	}

	@Override
	public void clickSaveButton() {
		// TODO Auto-generated method stub
		createBox.getSaveButton().click();
	}

	@Override
	public void clickConfirmationYes() {
		// TODO Auto-generated method stub
		createBox.getConfimYes().click();
	}

	@Override
	public void clickCloseSucessMsg() {
		// TODO Auto-generated method stub
		createBox.getCloseSuccessMsg().click();
	}
	

}
