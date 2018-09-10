package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class AuthToken
{
	
	
	public CloseableHttpResponse postAuth(String url,String entitystring,Map<String,String> headermap) throws IOException
	{
		
		CloseableHttpClient httpclients = HttpClients.createDefault();
		
		
		HttpPost httppost=new HttpPost(url);  //for endpoint url
		
		httppost.setEntity(new StringEntity(entitystring));  //for payload
		
		//for headers
		
		for(Entry<String, String> entry:headermap.entrySet())
		{
			
			httppost.addHeader(entry.getKey(),entry.getValue());   
		}
		
		
		
		
		CloseableHttpResponse httpresponse = httpclients.execute(httppost);
		return httpresponse;
		
	}

}
