package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;


public class TestBase1 
{
	public Properties prop;
	public int Response_Code_200=200;
	public int Response_code_400=400;
	public int Response_code_401=401;
	public int Response_code_404=404;
	private String Auth_Token ;
	private static TestBase1 bp;
	
	private ObjectMapper mapper=new ObjectMapper();
	
	static int count=0;
	
	public String getAuth_Token() {
		return Auth_Token;
	}


	public void setAuth_Token(String auth_Token) {
		Auth_Token = auth_Token;
	}


	public TestBase1()
	{
		try
		{
			 prop = new Properties();
			FileInputStream ip=new FileInputStream("./src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException c)
		{
			// TODO Auto-generated catch block
			c.printStackTrace();
		}
	
	}

	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}
	
	public static TestBase1 getInstance()
	{
		if(count==0)
		{
			bp=new TestBase1();
			count++;
		}
		else
		{
			return bp;
			
		}
		return bp;
		
	}

}

