package com.qa.tests;

import com.qa.Base.TestBase;
import com.qa.Client.RestClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PostAPITest extends TestBase {
    TestBase testBase;
    String serviceUrl;
    String apiUrl;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;
    @BeforeMethod
    public void setUp() throws IOException {
        testBase=new TestBase();
        serviceUrl=prop.getProperty("URL");
        apiUrl=prop.getProperty("serviceURL");
//https://reqres.in/api/users
        url = serviceUrl + apiUrl;
    }

    @Test
    public void postAPITest()
    {
restClient=new RestClient();
    }
}
