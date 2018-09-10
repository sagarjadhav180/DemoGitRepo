package com.qa.client;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;

public class RestClient_group
{
	
	
	CloseableHttpClient httpclients;
	
	public CloseableHttpResponse getGroup(String endpoint_url,String pl1,Map<String,String> headermap) throws ClientProtocolException, IOException, JSONException
	{
		System.out.println("compiler entered into request method");
		
		
		 httpclients = HttpClients.createDefault();
		
		HttpPost httppost=new HttpPost(endpoint_url);
		
		
		httppost.setEntity(new StringEntity(pl1));
		
		
		
		for(Entry<String, String> entry:headermap.entrySet())
		{
			
			httppost.addHeader(entry.getKey(),entry.getValue());
			
		}
		
		CloseableHttpResponse httpresponse = httpclients.execute(httppost);
		return httpresponse;
		
				
	}
	
	public CloseableHttpResponse getCampaign(String endpoint_url,String pl2,Map<String,String> headermap) throws ClientProtocolException, IOException, JSONException
	{
		
		System.out.println("compiler entered into request method");
		
		 httpclients = HttpClients.createDefault();
		
		HttpPost httppost=new HttpPost(endpoint_url);
		
		
		httppost.setEntity(new StringEntity(pl2));
		
		//httppost.setEntity(new StringEntity("test"));
		
		for(Entry<String, String> entry:headermap.entrySet())
		{
			
			httppost.addHeader(entry.getKey(),entry.getValue());
			
		}
		
		CloseableHttpResponse httpresponse = httpclients.execute(httppost);
		return httpresponse;
		
				
	}
	
	public CloseableHttpResponse getGroupList(String endpoint_url,Map<String,String> headermap) throws ClientProtocolException, IOException, JSONException
	{
		System.out.println("compiler entered into request method");
		
		
		 httpclients = HttpClients.createDefault();
		
		HttpPost httppost=new HttpPost(endpoint_url);
		
		
	
		
		
		
		for(Entry<String, String> entry:headermap.entrySet())
		{
			
			httppost.addHeader(entry.getKey(),entry.getValue());
			
		}
		
		CloseableHttpResponse httpresponse = httpclients.execute(httppost);
		return httpresponse;
		
				
	}
	
	


}
