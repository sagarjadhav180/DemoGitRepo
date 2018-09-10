package com.qa.tests;

 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;


import com.qa.base.TestBase1;
import com.qa.client.RestClient_group;
import com.qa.payload.Group_payload;
import com.qa.util.GetAuthToken;
import com.qa.util.TestUtil;


public class PostGroup 
{ 
	TestBase1 gg1 = TestBase1.getInstance();
 
	String endpoint_url;
	
	RestClient_group restclient;
	String stringentity;
    String access_token;
	String api_url;
	String Service_URL;
	CloseableHttpResponse httpresponse;
	TestUtil testutil;
	
	@Test
	public void group() throws ClientProtocolException, IOException, JSONException
	{
		restclient=new RestClient_group();
		api_url=gg1.prop.getProperty("URL_cfa");
		Service_URL=gg1.prop.getProperty("Service_URL_postgroup");
		
		
		endpoint_url=api_url+Service_URL;
		
		
		Group_payload grouppayload=new Group_payload("Sagar API group-scripted 3",8,"Service");
		
		//payload
		
		stringentity=gg1.getMapper().writeValueAsString(grouppayload);
		
		
        System.out.println("========================group creation began===================================");
		
		
		System.out.println("value of auth token is "+gg1.getAuth_Token());
		System.out.println("value of endpoint_url is "+endpoint_url);
		System.out.println("value of payload is "+stringentity);
		System.out.println("========================group created successully=======================");
		
		
		
		
		//headers
		Map<String,String> headermap=new HashMap<String,String>();
		
		headermap.put("Content-Type", "application/json");
		headermap.put("Authorization","bearer "+gg1.getAuth_Token());
		
		Set<String> keys = headermap.keySet();
		System.out.println("headers are=========================================");
		for(String key:keys)
		{
			System.out.println(key+":"+headermap.get(key));
		}
		System.out.println("====================================================");
		
		
		
		
		String payload=stringentity;
		
		
		System.out.println("==============================================================================================");
        System.out.println("Object value is "+restclient);
		System.out.println("==============================================================================================");
		
		
		
		
		httpresponse=restclient.getGroup(endpoint_url, payload, headermap);
		
		int statuscode = httpresponse.getStatusLine().getStatusCode();
		
		System.out.println("status code is "+statuscode);
		
		//Assert.assertEquals(statuscode, gg1.Response_Code_200);
		
		HttpEntity httpentity = httpresponse.getEntity();
		
		String stringresponse = EntityUtils.toString(httpentity);
		
		System.out.println("response is "+stringresponse);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}