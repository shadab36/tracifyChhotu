package com.herokuapp.qa.tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;
import com.herokuapp.qa.pages.LogoutPage;
public class LogoutPageTest extends Base{

	LoginPage loginpage;
	HomePage homepage;
	LogoutPage logout;
	public LogoutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		logout=new LogoutPage();
	}

	
@Test(priority=5,description="Validation the user logout the app")
public void clicklogout() throws Exception {
	
	homepage.hoverUserfrofile();
	logout.applogout();
	
	String title=LoginPage.verifyloginpage();
	assertEquals(title,"Tracify App - Login", "Login title page is not matched");	
	
}

}


