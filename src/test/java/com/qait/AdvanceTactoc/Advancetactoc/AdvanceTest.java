package com.qait.AdvanceTactoc.Advancetactoc;


import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class AdvanceTest 

{
	
	WebDriver driver;
	Advance_home homeobj;
	Select_menu menuobj;
	RestGet getobj;
	DownloadAndSubmit downloadobj;
	@Test(priority=1)
	public void Home_Advance_Tactoc() 
{
		
		
		
		homeobj.click_On_Advancecourse();
		
		
		
}
	@Test(priority=2)
	public void Menu_Item2() throws ClassNotFoundException, SQLException 
	{
		
		menuobj.hover_On_Menu2();
	/*	String symboltext=menuobj.get_Symbol();
		System.out.println("THE SYMBOL VALUE IS "+symboltext);
		*/
	}


	
	
	@Test(priority=3)
	public void GetRest() throws Exception 
	{
		getobj.generateToken();
		getobj.registerUsingToken();
		getobj.clickProceed();
		
		Thread.sleep(3000);
	}
	@Test(priority=4)
	public void DownloadAndSubmit() throws Exception 
	{
		
	downloadobj.downloadAndSubmit();
//		getobj.registerUsingToken();
//		getobj.clickProceed();
	}
	
	@BeforeClass
	public void launch_Browser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rishabh.jain\\eclipse-workspace\\chromedriver.exe");
		driver= new ChromeDriver();
	     driver.get("http://10.0.1.86/tatoc");
	homeobj= new Advance_home(driver);
	menuobj=new Select_menu(driver);
	getobj = new RestGet(driver);
	downloadobj= new DownloadAndSubmit(driver);
	}
	@AfterClass
	public void close_Browser() throws InterruptedException 
	{
		//Thread.sleep(2000);
		//driver.quit();
		
		
	}
	
	
	
	
	
   
}
