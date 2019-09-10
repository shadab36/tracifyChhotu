package com.herokuapp.qa.tests;


import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.NonAdminUserPage;
import com.herokuapp.qa.util.TestUtil;

public class NonAdminUserPageTest extends Base{

	String sheetName="MultipleUser";
	HomePage homepage;
	NonAdminUserPage nonAdmin;
	public NonAdminUserPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws MalformedURLException {
			initialization(); 
			
			nonAdmin= new NonAdminUserPage();
		}
	
	
	@DataProvider
	public Object[][] NonAdminUser() {
	Object data[][]=TestUtil.getTestData(sheetName);	
	 return data;	
	
	}
	@Test(priority=13,dataProvider="NonAdminUser",description="Validation the non admin user loginthe application")
	public void verifyHomePageTitle(String UserName,String Password) throws InterruptedException {
		homepage = nonAdmin.login(UserName, Password);
		
	
	}
	
	

}
