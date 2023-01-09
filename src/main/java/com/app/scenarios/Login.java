package com.app.scenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {
	
	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	public void verifyLoginTitle() throws Exception, Exception {
		String rootFolder=System.getProperty("user.dir");
		Properties prop=new Properties();
		prop.load(new FileInputStream(rootFolder+"//src//test//resources//data.properties"));
		String v1=prop.getProperty("email");
		String v2=prop.getProperty("pwd");
		driver.findElement(By.xpath("//input[@id='mobileNumberPass']")).sendKeys(v1);
		driver.findElement(By.xpath("//input[@class='form-control has-feedback']")).sendKeys(v2);
		driver.findElement(By.xpath("//button[.='LOGIN']")).click();
		Thread.sleep(35000);
		driver.findElement(By.xpath("//button[.='LOGIN']")).click();
		
	}
	

	

}
