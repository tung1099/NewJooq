package com.example.demo.service;

import com.example.demo.common.OkHttpCommon;
import com.example.demo.generated.jooq.tables.records.EmployeeRecord;
import com.example.demo.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OkHttpService {
    @Autowired
    OkHttpCommon common;

    @Autowired
    HttpUrl apiUrl;

    public List<Employee> getAllEmployee() {
        try {

            String result = common.okHttpGET(apiUrl);

            ObjectMapper objectMapper = new ObjectMapper();
            List<Employee> employees = objectMapper.readValue(result, new TypeReference<List<Employee>>() {});

            return employees;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

