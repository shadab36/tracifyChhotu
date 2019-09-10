package com.herokuapp.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class NonAdminUserPage extends Base{

	@FindBy(id="username")
	WebElement username;
	
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//a[@href='/admin']//i")
	WebElement AdminLink;
	
	@FindBy(css="body>div.app-content.container.center-layout.mt-2 > div > div.content-body form > button")
	WebElement loginbutton;
	
	
	public NonAdminUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String UN,String PWD) throws InterruptedException {
		
		username.sendKeys(UN);
		password.sendKeys(PWD);
		loginbutton.click();
			Thread.sleep(1000);
		
			try {
				AdminLink.isDisplayed();
				System.out.println("Admin user only see the admin setting link"+AdminLink);
			}
			catch(NoSuchElementException e) {
				System.out.println("Non admin use can not see the admin link icon"+e);
			}
	
		return new HomePage();
		
	}
	
	
}
