package com.app.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MoveToBag {
	WebDriver driver;
	
	public MoveToBag(WebDriver driver){
		this.driver=driver;
	}
	
	public void addToBag() throws Exception {
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[.='Bag']")).click();
		//driver.findElement(By.className("desktop-userTitle"));
		driver.findElement(By.xpath("//div[@class='button-base-button emptyCart-base-wishlistButton ']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[.='MOVE TO BAG'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='sizeselect-done']")).click();
		driver.findElement(By.xpath("//span[.='Bag']")).click();
		Thread.sleep(4000);
	}

}
