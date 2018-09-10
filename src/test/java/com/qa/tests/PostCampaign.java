package com.qa.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase1;
import com.qa.client.RestClient_campaign;
import com.qa.payload.Blank;
import com.qa.payload.Campaign_payload;
import com.qa.payload.Campaign_users_payload;
import com.qa.util.TestUtil;

public class PostCampaign 
{
	
	TestBase1 tb1 = TestBase1.getInstance();
	String stringentity;
    String access_token;
	String api_url;
	String Service_URL;
	CloseableHttpResponse httpresponse;
	TestUtil testutil;
	String endpoint_url;
	RestClient_campaign restclient1;
	
	
	@Test
	public void campaign() throws ParseException, IOException, JSONException 
	{
		
		
		restclient1=new RestClient_campaign(); 
		Service_URL=tb1.prop.getProperty("Service_URL_postcampaign");
		
		api_url=tb1.prop.getProperty("URL_cfa");
		
		
		
		endpoint_url=api_url+Service_URL;
		

		Campaign_payload Campaign_payload=new Campaign_payload("Sagar API campaign-scripted 1","2018-08-19T12:20:00.000Z",2,8);
		
		
		
		//payload
		
		stringentity=tb1.getMapper().writeValueAsString(Campaign_payload);
		
		
		
		
		
		
		
		
		
		
		
		//byte[] stringentity1 = tb1.getMapper().writeValueAsBytes(Campaign_payload);
		
		String payload=stringentity;
		

        System.out.println("========================campaign creation began===================================");
		
		
		System.out.println("value of auth token is "+tb1.getAuth_Token());
		System.out.println("value of endpoint_url is "+endpoint_url);
		System.out.println("value of payload is "+stringentity);
		System.out.println("========================campaign created successully=======================");
		
		
		
		
		//headers
		Map<String,String> headermap=new HashMap<String,String>();
		
		headermap.put("Authorization","bearer "+tb1.getAuth_Token());
		headermap.put("Content-Type", "application/json");
		
		
		Set<String> keys = headermap.keySet();
		System.out.println("headers are=========================================");
		for(String key:keys)
		{
			System.out.println(key+":"+headermap.get(key));
		}
		System.out.println("====================================================");
		
		//did print object to find out the reason of null pointer exception-found that object was declared but wasnt initialized
		System.out.println("==============================================================================================");
        System.out.println("Object value is "+restclient1);
		System.out.println("==============================================================================================");
		httpresponse=restclient1.getCampaign(endpoint_url,payload, headermap);
		
		int statuscode = httpresponse.getStatusLine().getStatusCode();
		
		System.out.println("status code is "+statuscode);
		
		SoftAssert sa=new SoftAssert();
		
		sa.assertEquals(statuscode, tb1.Response_Code_200);
		
		HttpEntity httpentity = httpresponse.getEntity();
		
		String stringresponse = EntityUtils.toString(httpentity);
		
		System.out.println("response is "+stringresponse);
		sa.assertAll();
		
		
	
		
		
		
	}
	

}
