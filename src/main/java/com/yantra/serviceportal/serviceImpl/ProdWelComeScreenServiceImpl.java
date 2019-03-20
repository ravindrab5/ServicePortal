package com.yantra.serviceportal.serviceImpl;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.yantra.serviceportal.services.ProdWelComeScreenService;
import com.yantra.serviceportal.view.ProdPortal;

public class ProdWelComeScreenServiceImpl implements ProdWelComeScreenService {
	EventFiringWebDriver driver;
	ProdPortal portal;
	
	public ProdWelComeScreenServiceImpl(EventFiringWebDriver driver) {
		this.driver=driver;
		portal=new ProdPortal(driver);
	}
	
	@Override
	public void clickAddNew() {
		portal.getAddNewButton().click();
	}
	
}
