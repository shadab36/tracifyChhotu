package com.herokuapp.qa.tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;

public class HomePageTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	
	public void setup() throws MalformedURLException {
			initialization(); 
			loginpage= new LoginPage();
			homepage = loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		}
	
	@Test(priority=3,description="Validation the home page title")
	public void verifyHomePageTitle() {
		
		String Htitle= homepage.VerifyHomePageTitle();
		assertEquals(Htitle, "Missions - Tracify App","Home Page Titile does not match");
	
	}

	
	@Test(priority=4,description="Validation the userprofile name")
	public void VerifyUserProfileName() {
		
		String ProfileName=homepage.username();
		assertEquals(ProfileName, "ChhotuManual","Profile name is not matched");
		
	}
	
}
