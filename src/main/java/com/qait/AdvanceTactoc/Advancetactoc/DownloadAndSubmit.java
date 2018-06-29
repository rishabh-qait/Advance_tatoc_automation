package com.qait.AdvanceTactoc.Advancetactoc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DownloadAndSubmit {
	
	
	WebDriver driver;
	public  DownloadAndSubmit(WebDriver driver) 
	{
		this.driver=driver;
		
		
		
	}
	
	public void downloadAndSubmit() throws Exception 
	{
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		Thread.sleep(3000);
	FileReader fr = new FileReader("C:\\Users\\rishabh.jain\\Downloads\\file_handle_test.dat");
	BufferedReader br = new BufferedReader(fr);
	String datainfile;
	
	String data="";
	
	while((datainfile=br.readLine())!=null) 
	{
		System.out.println(datainfile);
		data= data+datainfile;
	
		
	}
		br.close();
		
		
		 String data1[] = data.split("\\s+");
		 driver.findElement(By.xpath("//*[@id=\"signature\"]")).sendKeys(data1[4]);
		 
		 driver.findElement(By.xpath("/html/body/div/div[2]/form/input[2]")).click();
		
		
	}
	
	
	

}
