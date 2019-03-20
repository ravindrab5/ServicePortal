package com.yantra.serviceportal.services;

import com.yantra.serviceportal.view.SelectOperator;

public interface OperatorPopup {
	public void selectRadio(String operator);
	public void typeText(String operator);
	public void clickSaveChanges();
	public SelectOperator getSelectOperator();
}
