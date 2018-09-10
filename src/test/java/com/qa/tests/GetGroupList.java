package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.TestBase1;
import com.qa.client.RestClient_group;
import com.qa.payload.Group_payload;
import com.qa.util.TestUtil;

public class GetGroupList
{
	TestBase1 gg1 = TestBase1.getInstance();
	 
	String endpoint_url;
	
	RestClient_group restclient;
	
    String access_token;
	String api_url;
	String Service_URL;
	CloseableHttpResponse httpresponse;
	
	
	@Test
	public void group() throws ClientProtocolException, IOException, JSONException
	{
		restclient=new RestClient_group();
		api_url=gg1.prop.getProperty("URL_cfa");
		Service_URL=gg1.prop.getProperty("Service_URL_getgrouplist");
		
		
		endpoint_url=api_url+Service_URL;
		
		
		
		
        System.out.println("========================grouplist fetching initialized===================================");
		
		
		System.out.println("value of auth token is "+gg1.getAuth_Token());
		System.out.println("value of endpoint_url is "+endpoint_url);
		
		System.out.println("========================grouplist fetching ended=======================");
		
		
		
		
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
		
		
		httpresponse=restclient.getGroupList(endpoint_url, headermap);
		
		int statuscode = httpresponse.getStatusLine().getStatusCode();
		
		System.out.println("status code is "+statuscode);
		
		//Assert.assertEquals(statuscode, gg1.Response_Code_200);
		
		HttpEntity httpentity = httpresponse.getEntity();
		
		String stringresponse = EntityUtils.toString(httpentity);
		
		System.out.println("response is "+stringresponse);
		
		
		
		
		
	}


}
