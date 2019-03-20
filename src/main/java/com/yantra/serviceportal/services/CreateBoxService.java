package com.yantra.serviceportal.services;

import com.yantra.serviceportal.view.CreateBoxModal;

public interface CreateBoxService {
	public void typeKiviBoxId(String box);
	public void typePiCpuId(String cpuId);
	public void typeVtsSerial(String vtsSerial);
	public void typeVtsSimMobileNumber(String vtsSim);
	public void typeSSDSerialNumber(String serialNumber);
	public void typeDongleIMEI(String imei);
	public void selectDongleNetworkType(String dongleNetwork);
	public void selectDongleSimOperator(String dongleSimOperator);
	public void typeDongleSimMobileNumber(String mobNumber);
	public void typeDongleSimImeiNumber(String dongleSimImei);
	public void typePowerSupplySerialNumber(String serialNumber);
	public void typeRouterSerialNumber(String routerSerialNumber);
	public void selectServiceLead(String sl);
	public void clickSubmitButton();
	public CreateBoxModal getCreateBox();
	public void clickSaveButton();
	public void clickConfirmationYes();
	public void clickCloseSucessMsg();
}
