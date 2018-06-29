package com.qait.AdvanceTactoc.Advancetactoc;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestGet {
	
	
	WebDriver driver;
	String tokenusedforregister;
	
	public RestGet(WebDriver driver) 
	{
		this.driver=driver;
		
	}
	public String get_Session_Id() 
	{
		String sessionId = driver.findElement(By.id("session_id")).getText();
		String sessionIdvalue[]=sessionId.split("\\s+");
		System.out.println("the session ID value is "+sessionIdvalue[2]);
		return sessionIdvalue[2];
		
		
	}
	public void generateToken() throws Exception 
	{
		driver.get("http://10.0.1.86/tatoc/advanced/rest");
		String USER_AGENT="Chrome/67.0.3396.99";
		String sessionId=get_Session_Id();
		String url ="http://10.0.1.86/tatoc/advanced/rest/service/token/"+sessionId+"";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
       JSONObject jsonobj=new JSONObject(response.toString());
       tokenusedforregister=jsonobj.getString("token");
       
       
		System.out.println("The generated Token is "+response.toString());
		
	} 
	public void registerUsingToken() throws Exception 
	{
		String USER_AGENT="Chrome/67.0.3396.99";
		String sessionId=get_Session_Id();
		System.out.println("Token used to register is"+tokenusedforregister);
		
		String url ="http://10.0.1.86/tatoc/advanced/rest/service/register";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		String urlParameters = "id="+sessionId+"&signature="+ tokenusedforregister+"&allow_access=1";
		System.out.println(urlParameters);
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
//		wr.flush();
//		wr.close();
//		. POST BODY: id=["+sessionId+"],"
//				+ "signature=["+tokenusedforregister +"],allow_access=1";
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		
		
	
	}
	public void clickProceed() 
	{
		driver.findElement(By.linkText("Proceed")).click();
		
	}
	
	
	
	
	
	
	
	
	
	

}
