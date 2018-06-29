package com.qait.AdvanceTactoc.Advancetactoc;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.sql.*;

public class Select_menu {
	
WebDriver driver;
	WebElement symbol;
	String text;
	
	public Select_menu(WebDriver driver) 
	{
		this.driver=driver;
	}
	public String get_Symbol() 
	{
		symbol= driver.findElement(By.id("symboldisplay"));
		text= symbol.getText();
		return text;
	}
	
	
	public void hover_On_Menu2() throws ClassNotFoundException, SQLException 
	{
		 driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[1]")).click();
	//	Actions action = new Actions(driver);
		//action.moveToElement(menu2).build().perform();
		 driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[5]")).click(); 
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.86/tatoc", "tatocuser", "tatoc01");
	Statement st = con.createStatement();
	ResultSet rs= st.executeQuery("Select * from identity");
	while(rs.next()) 
	{
		System.out.println(rs.getString(2));
		
	}
	 rs= st.executeQuery("Select * from credentials");
		while(rs.next()) 
		{
			System.out.println("Usernames are "+rs.getString(2));
			
		}
    rs= st.executeQuery("Select * from credentials");
	while(rs.next()) 
	{
		System.out.println("Passwords are "+rs.getString(3));
		
	}
	 rs=st.executeQuery("SELECT column_name "
			+ "FROM INFORMATION_SCHEMA.COLUMNS "
			+ "WHERE TABLE_NAME = 'identity'");
	 while(rs.next()) 
		{
	
		System.out.println("column names of identity table are "+rs.getString(1));
		}
	
	rs=st.executeQuery("SELECT column_name "
			+ "FROM INFORMATION_SCHEMA.COLUMNS "
			+ "WHERE TABLE_NAME = 'credentials'");
	while(rs.next()) 
	{
		System.out.println("column names of credentials table are "+rs.getString(1));
	}	
	
	String textofsymbol=get_Symbol();
	rs=st.executeQuery("Select id from identity where symbol='"+textofsymbol+"'");
	rs.next();
	String correspondingid=rs.getString(1);

	System.out.println("The coressponding id to symboltext is "+rs.getString(1));
	
	//String username=get_Symbol();
	rs=st.executeQuery("Select name from credentials where id='"+correspondingid+"'");
	rs.next();
    String usernameofid=rs.getString(1);
	System.out.println("The coressponding username to id is "+usernameofid);
	rs=st.executeQuery("Select passkey from credentials where id='"+correspondingid+"'");
	rs.next();
    String password=rs.getString(1);
	System.out.println("The coressponding password to username is "+ password);
	
	
	driver.findElement(By.id("name")).click();
	driver.findElement(By.id("name")).sendKeys(usernameofid);
	driver.findElement(By.id("passkey")).click();
	driver.findElement(By.id("passkey")).sendKeys(password);
	driver.findElement(By.id("submit")).click();
	}
	

}
