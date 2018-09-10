package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.payload.Auth_pojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.base.TestBase1;
import com.qa.client.AuthToken;



public class GetAuthToken 
{
	TestUtil testutil;
	CloseableHttpResponse httpResponse;
	protected String auth1;
	//protected ObjectMapper mapper=new ObjectMapper();  
	
	public void generateAuth() throws IOException, JSONException 
	{
		TestBase1 ga1 = TestBase1.getInstance();
		
		String api_url = ga1.prop.getProperty("URL_cfa");
		 String service_url = ga1.prop.getProperty("Service_URL_auth");
		 String endpoint_url = api_url+service_url;
		 
		 String client_id = ga1.prop.getProperty("client_id");
		 String client_secret = ga1.prop.getProperty("client_secret");
		 String grant_type = ga1.prop.getProperty("grant_type");
		 String password = ga1.prop.getProperty("password");
		 String username = ga1.prop.getProperty("username");
		 
		 
		
		Auth_pojo authpojo=new Auth_pojo(client_id, client_secret, grant_type, password, username);
		
		//mapper.writeValue(new File("./src/test/java/com/qa/util/data.json"), authpojo);
		
		String entitystring = ga1.getMapper().writeValueAsString(authpojo); 
		
		System.out.println("===============");
		System.out.println(entitystring);
		
		System.out.println("===============");
		
		AuthToken auth=new AuthToken();
		
     Map<String,String> headermap=new HashMap<String,String>();
		
		headermap.put("Content-Type", "application/json");
		
		
		
		httpResponse=auth.postAuth(endpoint_url, entitystring, headermap);
		
		
		int statuscode = httpResponse.getStatusLine().getStatusCode();
		
		
		HttpEntity httpentity = httpResponse.getEntity();
		String responsestring = EntityUtils.toString(httpentity);
		
		JSONObject jsonobj=new JSONObject(responsestring);
		
		System.out.println("=========================Auth token began===============================");
		
		
         System.out.println("Response code is "+statuscode);
		
		Assert.assertEquals(statuscode, ga1.Response_Code_200);
		
		
		
		
		System.out.println(jsonobj );
		
		testutil=new TestUtil();
		String utilresponse = testutil.getValueByJpath(jsonobj,"access_token");
		
		ga1.setAuth_Token(utilresponse);
		 auth1=ga1.getAuth_Token();
		System.out.println("access token from util is "+ga1.getAuth_Token());
		
		System.out.println("=======================Auth token generated===============================");
		//System.out.println(entitystring);
		
		
	}
	

}
