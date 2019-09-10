package com.herokuapp.qa.tests;



import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;



public class LoginPageTest extends Base {
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}



	@BeforeMethod
	public void setup() throws MalformedURLException
	{
		initialization();
		loginPage = new LoginPage();
	
	}
	
@Test(priority=1,description="Validation of Login page tile")
public void verifyloginpagetitle() throws Exception {

	String Logintitle= LoginPage.verifyloginpage();
	assertEquals(Logintitle, "Tracify App - Login","Login Page Title does not match");	
 
}

	@Test(priority = 2,description="Tracify user login Page")
	public void login() throws Exception {

		homepage = loginPage.login(prop.getProperty("UserName"), prop.getProperty("Password"));

	}

//	@AfterMethod
//
//	public void Exit() {
//
//		driver.quit();
//	}

}



