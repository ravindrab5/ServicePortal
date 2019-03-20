package com.yantra.serviceportal.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.yantra.serviceportal.util.UIName;

public class SelectOperator extends ViewBase{

	public SelectOperator(EventFiringWebDriver driver) {
		super(driver);
		addWebElementMeta(this);
	}
	
	@UIName(uiName="MODAL DIALOG")
	@FindBy(xpath="//input[@value='MSRTC']")
	private WebElement radioMsrtc;

	@UIName(uiName="OPERATOR INPUT FIELD ")
	@FindBy(xpath="//input[@name='operator-input-field']")
	private WebElement operatorInputField;
	
	@UIName(uiName="SAVE OPERATOR BUTTON")
	@FindBy(id="save-operator")
	private WebElement saveButton;

	public WebElement getRadioMsrtc(String operator) {
		String path="//input[@value='"+operator+"']";
		addWebElementMetaIntoMap(path,"SELECT OPERATOR - "+operator);
		return driver.findElement(By.xpath(path));
	}

	public WebElement getOperatorInputField() {
		return operatorInputField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
}

