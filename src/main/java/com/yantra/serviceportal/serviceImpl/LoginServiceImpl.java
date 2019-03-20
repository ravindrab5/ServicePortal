package com.yantra.serviceportal.serviceImpl;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.yantra.serviceportal.services.LoginService;
import com.yantra.serviceportal.view.Login;

public class LoginServiceImpl implements LoginService {
	EventFiringWebDriver driver;
	Login login;

	public EventFiringWebDriver getDriver() {
		return driver;
	}

	public Login getLogin() {
		return login;
	}

	public LoginServiceImpl(EventFiringWebDriver driver) {
		this.driver = driver;
		login = new Login(driver);
	}

	@Override
	public void typeUsername(String username) {
		// TODO Auto-generated method stub
		login.getUsername().sendKeys(username);
	}

	@Override
	public void typePasssword(String password) {
		// TODO Auto-generated method stub
		login.getPassword().sendKeys(password);
	}

	@Override
	public OperatorPopupImpl clickLogin() {
		// TODO Auto-generated method stub
		login.getLoginButton().click();
		return new OperatorPopupImpl(driver);

	}

}
