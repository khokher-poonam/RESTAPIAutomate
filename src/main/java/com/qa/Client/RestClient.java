package com.qa.Client;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    //1.GetMethod
    public void get(String url) throws IOException {
      CloseableHttpClient httpClient= HttpClients.createDefault();//closeable client object it will create
        HttpGet httpGet=new HttpGet(url); //HTTP GET REQUEST
       CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpGet); //hit the GET URL

        //2.Status code
        int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
System.out.println("The Status Code is"  +statusCode);

//3.JSON String
String responseString= EntityUtils.toString(closeableHttpResponse.getEntity(),"utf-8");
        JSONObject responseJson=new JSONObject(responseString);
    System.out.println("response json is" +responseJson);

    //4.All Headers
        Header[] headersArray=closeableHttpResponse.getAllHeaders();
        HashMap<String, String> allHeaders=new HashMap<String,String>();
    for(Header header:headersArray){
        allHeaders.put(header.getName(),header.getValue());
    }
System.out.println("Headers Array" +allHeaders);
    }

/////////////////////////////////////////////
    //5.POST Method
    public CloseableHttpResponse post(String url, String entityString, HashMap<String,String> headerMap) throws IOException {
        CloseableHttpClient httpClient=HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);//http post request
        httpPost.setEntity(new StringEntity(entityString));  //payload

    //for headers
        for(Map.Entry<String,String>entry:headerMap.entrySet()){
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }
CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpPost);
    return closeableHttpResponse;
    }
}
