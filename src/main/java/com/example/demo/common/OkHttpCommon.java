package com.example.demo.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class OkHttpCommon {
    @Autowired
    OkHttpClient client;

    public static final String JSON = "application/json; charset=utf-8";
    public static String CONNECTION_TIME_OUT = "CONNECTION TIME OUT";
    public String okHttpGET(String url) throws Exception {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (java.net.SocketTimeoutException e){
            log.error("Time out when get url " + url);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return "[]";
    }

    public String okHttpPOST(String url, Object object) throws  Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(object);
        RequestBody requestBody = RequestBody.create(MediaType.parse(JSON), jsonData);
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            log.info("result " + result);
        } catch (Exception e){
            e.printStackTrace();
        }
        return jsonData;
    }

    public String okHttpPOSTJsonResponse(String json, String url) throws Exception {
        String result = "{}";
        try{
            RequestBody body = RequestBody.create(MediaType.parse(JSON), json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            result = response.body().string();
        }catch (java.net.SocketTimeoutException e){
            log.error("Time out when post json " + json + " to " + url);
            result = CONNECTION_TIME_OUT;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

