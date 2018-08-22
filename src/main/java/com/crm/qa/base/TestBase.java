package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	static WebDriver driver;
	static Properties prop;
	
	TestBase(){
		
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("/FreeCrm/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialisation(){
		
		String browseName=prop.getProperty("browser");
		
		if(browseName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Storage\\F Drive\\Softwares\\SeleniumPro\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		
		String urlValue=prop.getProperty("url");
		driver.get(urlValue);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

}
