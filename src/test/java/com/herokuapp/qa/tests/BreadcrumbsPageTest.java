package com.herokuapp.qa.tests;



import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.BreadcrumbsPage;
import com.herokuapp.qa.pages.CreateMissionsPage;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;


public class BreadcrumbsPageTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
	CreateMissionsPage createmission;
	BreadcrumbsPage breadcrumbpage;
	
	
	public BreadcrumbsPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		createmission=new CreateMissionsPage();
		createmission.Add_mission();
		breadcrumbpage=new BreadcrumbsPage();
	}
	@Test(priority=10,description="Verify the breadcrum")
	public void ClickBreadcumlink() {
	
		breadcrumbpage.Landingpage();
		
		String Cuurnetpage= homepage.VerifyHomePageUrl();
		assertEquals(Cuurnetpage, "https://tracify-test.herokuapp.com/tasksmanager/","current Page Titile does not match");
	}
	
	
}
