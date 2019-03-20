package com.yantra.serviceportal.view;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.yantra.serviceportal.util.UIName;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class ViewBase {
	EventFiringWebDriver driver;
  
	public static Map<String, String> uiName=new HashMap<String, String>();

	public Map<String, String> getUiName() {
		return uiName;
	}

	public ViewBase(EventFiringWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	//	uiName = new HashMap<String, String>();
	}
	
	protected void addWebElementMeta(ViewBase p) {
		Field[] field = p.getClass().getDeclaredFields();
		for (Field fld : field) {
			UIName wem = fld.getAnnotation(UIName.class);
			FindBy fb = fld.getAnnotation(FindBy.class);
			
			if(fb!=null) {
			uiName.put(getLocator(fb), wem.uiName());
			}
		}
	}

	protected void addWebElementMetaIntoMap(String locator,String uiName) {
		 	this.uiName.put(locator, uiName);
				
	}
	
	
	protected String getLocator(FindBy fb) {
		String str = null;
		if (fb.css().length() > 0) {
			str = fb.css();
		} else if (fb.id().length() > 0) {
			str = fb.id();
		} else if (fb.className().length() > 0) {
			str = fb.className();
		} else if (fb.linkText().length() > 0) {
			str = fb.linkText();
		} else if (fb.partialLinkText().length() > 0) {
			str = fb.partialLinkText();
		} else if (fb.xpath().length() > 0) {
			str = fb.xpath();
		}

		if (str == null) {
			System.out.println("Str null detected ");
		}
		return str;

	}

  
}
