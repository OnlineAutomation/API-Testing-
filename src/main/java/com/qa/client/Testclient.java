package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Testclient {
	
	//get method
	public void get(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient  httpclient=HttpClients.createDefault(); //Create a client connect
		HttpGet httpget = new HttpGet(url); //create one get connection with this url
	
		CloseableHttpResponse closeablehttpresponse=httpclient.execute(httpget); //Hit the particular ulr /hit the URl
		//closeablehttpresponse is used to save responce message from server
		
		int statuscode = closeablehttpresponse.getStatusLine().getStatusCode();//getting status code
		String Responcestring = EntityUtils.toString(closeablehttpresponse.getEntity(), "UTF-8");
		JSONObject 	responcejson= new JSONObject(Responcestring);
		System.out.println("Responce msg :"+responcejson);
		Header[] headerarray=closeablehttpresponse.getAllHeaders();
	
		//Learn Hashmap concept in jave 
		//its usefull and easy to iterate the array value
		
		HashMap <String ,String> allhearders =new HashMap <String ,String>();
		
		for(Header header : headerarray) {
			allhearders.put(header.getName(),header.getValue());
			
		}
		System.out.println("All Hearder values ;"+allhearders);
		
	}
	
	
}
