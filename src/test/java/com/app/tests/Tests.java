package com.app.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.scenarios.Login;
import com.app.scenarios.MoveToBag;

public class Tests {
	
	WebDriver driver;
	Login login;
	MoveToBag mtb;
	
  @BeforeMethod
  public void launchBrowser() throws Exception, Exception {
	 driver=new ChromeDriver();
	 login=new Login(driver);
	 mtb=new MoveToBag(driver);
	 driver.manage().window().maximize();
	 String rootFolder=System.getProperty("user.dir");
	Properties prop=new Properties();
	prop.load(new FileInputStream(rootFolder+"//src//test//resources//data.properties"));
	String url=prop.getProperty("url");
	driver.get(url);   
  }
  @Test
  public void verifyLogin() throws Exception {
	  login.verifyLoginTitle();
	  String expectedTitle="Myntra";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle,"Login not succesfull");
  }
  
  @Test
  public void verifyAddToBagOption() throws Exception {
	  login.verifyLoginTitle();
	  mtb.addToBag();
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='bulkActionStrip-message']")).isDisplayed());
	  Thread.sleep(3000);
	  
  }
  @AfterMethod
  public void tearDown() {
	 driver.quit();
  }
  
}
