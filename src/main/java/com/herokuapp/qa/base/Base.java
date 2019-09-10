package com.herokuapp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Base {
	 public static String AppURL;
		public static WebDriver driver;
		public static String browserName;
		public static Logger Log;
		public static ExtentHtmlReporter htmlReporter;
		public static ExtentReports extent;
		static String nodeURL;
		public static Properties prop;
		


		
		
	public Base() {
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/"
						+ "/qa/Config/Conf.properties");
				prop.load(ip);
			
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		public static void initialization()throws MalformedURLException
		{
			String browserName = prop.getProperty("browser");
			 DesiredCapabilities cab = new DesiredCapabilities();
			if(browserName.equals("Chrome")){
				cab=DesiredCapabilities.chrome();
				cab.setPlatform(Platform.WINDOWS);
				String hubUrl = "http://localhost:4444/wd/hub";
				  driver=new RemoteWebDriver(new URL(hubUrl),cab);
				driver.manage().window().maximize();
				
//				WebDriverManager.chromedriver().setup();		
//				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FireFox")){
		
			}
			else if (browserName.equals("Grid")) {
//				nodeURL = "http://10.50.88.59:4444/wd/hub";
//				DesiredCapabilities capability = DesiredCapabilities.chrome();
//				capability.setBrowserName("chrome");
//				capability.setPlatform(Platform.WINDOWS);
//				driver = new RemoteWebDriver(new URL(nodeURL), capability);
			
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.get(prop.getProperty("url"));

		}

		@AfterMethod
		public void teardown() {
			driver.quit();
		}

}

