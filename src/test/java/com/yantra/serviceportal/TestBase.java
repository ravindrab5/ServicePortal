package com.yantra.serviceportal;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeTest;

public class TestBase {
	public static void cleanResults() {
		try {
			FileUtils.cleanDirectory(new File("./Results/Screenshots"));
			//FileUtils.cleanDirectory(new File("./logs/crashlogs"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void cleanUp() {
		cleanResults();
	}
}
