package com.yantra.serviceportal.serviceImpl;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.yantra.serviceportal.services.OperatorPopup;
import com.yantra.serviceportal.view.SelectOperator;

public class OperatorPopupImpl implements OperatorPopup{
	EventFiringWebDriver driver;
	SelectOperator selectOp;
	
	public OperatorPopupImpl(EventFiringWebDriver driver) {
		this.driver=driver;
		selectOp=new SelectOperator(driver);
	}
	
	@Override
	public void selectRadio(String operator) {
		// TODO Auto-generated method stub
		selectOp.getRadioMsrtc(operator).click();
	}

	@Override
	public void typeText(String operator) {
		// TODO Auto-generated method stub
		selectOp.getOperatorInputField().sendKeys(operator);
	}

	@Override
	public void clickSaveChanges() {
		// TODO Auto-generated method stub
		selectOp.getSaveButton().click();
	}

	@Override
	public SelectOperator getSelectOperator() {
		// TODO Auto-generated method stub
		return selectOp;
	}

}
