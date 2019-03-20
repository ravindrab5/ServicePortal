package com.yantra.serviceportal.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.yantra.serviceportal.util.UIName;

public class CreateBoxModal extends ViewBase {

	public CreateBoxModal(EventFiringWebDriver driver) {
		super(driver);
		addWebElementMeta(this);
	}

	@UIName(uiName = "SELECT SERVICE LEAD")
	@FindBy(id = "SLUser1")
	private WebElement sluser;

	@UIName(uiName = "KIVI SERIAL NUMBER")
	@FindBy(id = "serialNo1")
	private WebElement kiviBoxId;

	@UIName(uiName = "PI CPU ID")
	@FindBy(id = "rpiCpuId1")
	private WebElement piId;

	@UIName(uiName = "VTS SERIAL NUMBER")
	@FindBy(id = "vtsSn1")
	private WebElement vtsSn;

	@UIName(uiName = "VTS SIM MOBILE NUMBER")
	@FindBy(id = "vtsSim1")
	private WebElement vtsSim1;

	@UIName(uiName = "SSD SERIAL NUMBER")
	@FindBy(id = "hddSn1")
	private WebElement getHddSn;

	@UIName(uiName = "DONGLE IMEI")
	@FindBy(id = "dongleImei1")
	private WebElement dongleImei;

	@UIName(uiName = "DONGLE SIM IMEI NUMBER")
	@FindBy(id = "dongleSim1")
	private WebElement dongleSimImei;

	@UIName(uiName = "POWER SUPPLY SERIAL NUMBER")
	@FindBy(id = "powerSupplySn1")
	private WebElement powerSupplySn;

	@UIName(uiName = "ROUTER SERIAL NUMBER")
	@FindBy(id = "routerSn1")
	private WebElement routerSn;

	@UIName(uiName = "SUBMIT")
	@FindBy(id = "submitbutton")
	private WebElement submitBtn;

	@UIName(uiName = "SAVE BUTTON")
	@FindBy(id = "saveButton")
	private WebElement saveButton;

	@UIName(uiName = "YES BUTTON")
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement confimYes;

	@UIName(uiName = "SUCCESS MESSSAGE")
	@FindBy(id = "success")
	private WebElement sucessMsg;

	@UIName(uiName = "SUCCESS MODAL CLOSE BUTTON")
	@FindBy(id = "SuccessModalCloseBtnNoReload")
	private WebElement closeSuccessMsg;
	
	@UIName(uiName="NETWORK TYPE")
	@FindBy(id="dongleNetwork1")
	private WebElement dongleNetwork;
	
	@UIName(uiName="DONGLE SIM OPERATOR")
	@FindBy(id="dongleSimOper1")
	private WebElement dongleSimOper;
	
	@UIName(uiName="DONGLE SIM MOBILE NUMBER")
	@FindBy(id="dongleSimMob1")
	private WebElement dongleSimMobileNumber;
	
	 

	public WebElement getDongleSimMobileNumber() {
		return dongleSimMobileNumber;
	}

	public WebElement getDongleSimOper() {
		return dongleSimOper;
	}

	public WebElement getDongleNetwork() {
		return dongleNetwork;
	}

	public WebElement getSluser() {
		return sluser;
	}

	public WebElement getKiviBoxId() {
		return kiviBoxId;
	}

	public WebElement getPiId() {
		return piId;
	}

	public WebElement getVtsSn() {
		return vtsSn;
	}

	public WebElement getVtsSim1() {
		return vtsSim1;
	}

	public WebElement getGetHddSn() {
		return getHddSn;
	}

	public WebElement getDongleImei() {
		return dongleImei;
	}

	public WebElement getDongleSimImei() {
		return dongleSimImei;
	}

	public WebElement getPowerSupplySn() {
		return powerSupplySn;
	}

	public WebElement getRouterSn() {
		return routerSn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getConfimYes() {
		return confimYes;
	}

	public WebElement getSucessMsg() {
		return sucessMsg;
	}

	public WebElement getCloseSuccessMsg() {
		return closeSuccessMsg;
	}

}
