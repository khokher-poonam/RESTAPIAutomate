package com.qa.tests;

import com.qa.Base.TestBase;
import com.qa.Client.RestClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetAPITest extends TestBase {
   TestBase testBase;
   String serviceUrl;
   String apiUrl;
   String url;
    RestClient restClient;
    @BeforeMethod
    public void setUp() throws IOException {
         testBase=new TestBase();
 serviceUrl=prop.getProperty("URL");
 apiUrl=prop.getProperty("serviceURL");
//https://reqres.in/api/users
        url = serviceUrl + apiUrl;
    }

    @Test
    public void getAPITest() throws IOException {
         restClient=new RestClient();
        restClient.get(url);
    }

}
