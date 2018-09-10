package com.qa.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.json.JSONException;

public class RestClient_campaign 
{

	
	CloseableHttpClient httpclients;
	
	
	public CloseableHttpResponse getCampaign(String endpoint_url,String payload,Map<String,String> headermap) throws ClientProtocolException, IOException, JSONException
	{
		
		System.out.println("compiler entered into request method");
		
		 httpclients = HttpClients.createDefault();
		
		HttpPost httppost=new HttpPost(endpoint_url);
		
		
		
		httppost.setEntity(new StringEntity(payload));
		//httppost.setEntity(new StringEntity(payload1));
		
		for(Entry<String, String> entry:headermap.entrySet())
		{
			
			httppost.addHeader(entry.getKey(),entry.getValue());
			
		}
		
		CloseableHttpResponse httpresponse = httpclients.execute(httppost);
		return httpresponse;
		
				
	}


}
