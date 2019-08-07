package com.qait.automation.gmail.automation;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



/**
 * Unit test for simple App.
 */
public class AppTest 
{ 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
App a1 = new App();

 
	
	@Test
   public void openBrowser() throws IOException
	{
		System.out.println("Test Starts");
		//a1.seleniumGridExecution();
		a1.launchBrower();
		
			
	}
	
	@Test(dependsOnMethods = "openBrowser")
	public void enterCredentials()
	{
		//Assert.assertEquals(actual, expected);
		a1.enterUserCredentials();
		//a1.settingValuesInPropertiesFile();
	}
	
	@Test (dependsOnMethods = "enterCredentials")
	public void composingNewMail()
	{
		a1.composingMail();
		String actualSubject = a1.getSubjectText();
		String expectedSubject = a1.randomString ;
		
		Assert.assertEquals(actualSubject, expectedSubject,"Assert Fails");
	}
}
