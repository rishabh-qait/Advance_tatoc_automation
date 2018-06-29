package com.qait.AdvanceTactoc.Advancetactoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Advance_home 
{
	WebDriver driver;
	
	
	public Advance_home(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
	public void click_On_Advancecourse() {
		driver.findElement(By.linkText("Advanced Course")).click();
		Assert.assertEquals("http://10.0.1.86/tatoc/advanced/hover/menu",driver.getCurrentUrl());
		
	
	}
	
	
	
	
	
	
	
    
}
