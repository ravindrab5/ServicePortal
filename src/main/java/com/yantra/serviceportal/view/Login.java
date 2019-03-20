package com.yantra.serviceportal.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.yantra.serviceportal.util.UIName;

public class Login extends ViewBase {

	public Login(EventFiringWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		addWebElementMeta(this);
	}

	@UIName(uiName="MODAL DIALOG")
	@FindBy(css = "#selectOperatorModal .modal-dialog")
	private WebElement modal;

	public WebElement getModal() {
		return modal;
	}

	@UIName(uiName="USERNAME FIELD")
	@FindBy(id="username")
	private WebElement username;

	@UIName(uiName="PASSWORD FIELD")
	@FindBy(id="password")
	private WebElement password;

	@UIName(uiName="LOGIN BUTTON")
	@FindBy(id="loginBtn")
	private WebElement loginButton;

	@UIName(uiName="OPERATOR")
	@FindBy(id = "operatorName")
	private WebElement operatorName;

	@UIName(uiName="USERNAME FIELD")
	@FindBy(xpath = "//button[text()='Save changes']")
	private WebElement saveButton;
	
	@UIName(uiName="HOME LOADER")
	@FindBy(id="HomeLoader")
	private WebElement homeLoader;
	
	@UIName(uiName="ERROR MSG")
	@FindBy(xpath="//p[@class='sgError text-danger']")
	private WebElement errMsg;

	public WebElement getErrMsg() {
		return errMsg;
	}

	public WebElement getHomeLoader() {
		return homeLoader;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getOperatorName() {
		return operatorName;
	}

	public WebElement getOperatorRadio(String operator) {
		WebElement we = driver
				.findElement(By.xpath("//label/input[@type='radio' and @value='" + operator.toUpperCase() + "']"));
		return we;

	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getUsername() {
		return username;
	}

}
