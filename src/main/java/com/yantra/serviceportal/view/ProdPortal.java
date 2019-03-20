package com.yantra.serviceportal.view;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.yantra.serviceportal.util.UIName;

public class ProdPortal extends ViewBase {

	public ProdPortal(EventFiringWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		addWebElementMeta(this);
	}
	
	@UIName(uiName="ADD NEW BUTTON")
	@FindBy(id = "addNewBoxBtn")
	private WebElement addNewButton;

	public WebElement getAddNewButton() {
		return addNewButton;
	}
	
}
