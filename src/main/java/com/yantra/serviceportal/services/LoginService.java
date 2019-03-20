package com.yantra.serviceportal.services;

import com.yantra.serviceportal.serviceImpl.OperatorPopupImpl;
import com.yantra.serviceportal.view.Login;

public interface LoginService {
	public void typeUsername(String username);
	public void typePasssword(String password);
	public OperatorPopupImpl clickLogin();
	public Login getLogin();
}
