/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.restclient;

import com.hulkstore.service.restclient.dto.RestClientResponse;
import java.nio.charset.StandardCharsets;
import org.apache.directory.api.util.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpCoreContext;


/**
 *
 * @author Daniel
 */
public class RestClient {

    private final String endPoint;

    public RestClient(String endPoint) {
        this.endPoint = endPoint;
    }

    private RestClientResponse consumeHttpService(HttpUriRequest httpUriRequest, String requestBody) throws Exception {
        RestClientResponse restClientResponse = new RestClientResponse();
        HttpResponse response;
        HttpCoreContext localContext = null;
        CloseableHttpClient client;

        client = HttpClients.createDefault();
        response = client.execute(httpUriRequest);
        String responseContent = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
        
        restClientResponse.setResponse(responseContent);
        restClientResponse.setHttpCode(response.getStatusLine().getStatusCode());
        return restClientResponse;
    }

    public RestClientResponse consumeGetService() throws Exception {
        HttpGet httpGet = new HttpGet(endPoint);
        return consumeHttpService(httpGet, null);
    }

    public RestClientResponse consumePostService(String body, String contentType) throws Exception {
        HttpPost httpPost = new HttpPost(endPoint);
        StringEntity input = new StringEntity(body);
        input.setContentType(contentType);
        httpPost.setEntity(input);
        return consumeHttpService(httpPost, body);
    }

    public RestClientResponse consumePutService(String body, String contentType) throws Exception {
        HttpPut httpPut = new HttpPut(endPoint);
        StringEntity input = new StringEntity(body);
        input.setContentType(contentType);
        httpPut.setEntity(input);
        return consumeHttpService(httpPut, body);
    }

    public RestClientResponse consumeDeleteService() throws Exception {
        HttpDelete httpDelete = new HttpDelete(endPoint);
        return consumeHttpService(httpDelete, null);
    }

}
