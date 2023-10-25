package com.example.demo.service;

import com.example.demo.common.OkHttpCommon;
import com.example.demo.generated.jooq.tables.records.EmployeeRecord;
import com.example.demo.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OkHttpService {
    @Autowired
    OkHttpCommon common;

    @Value("${api.url}")
    String apiUrl;

    public ResponseEntity<?> getData() {
        try {
            String result = common.okHttpGET(apiUrl);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during call API");
        }
    }

    public ResponseEntity<String> post(Object object) {
        try {
            common.okHttpPOST(apiUrl, object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResponseEntity<String> postData(String json, String url){
        try {
            common.okHttpPOSTJsonResponse(json, apiUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}