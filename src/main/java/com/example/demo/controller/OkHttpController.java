package com.example.demo.controller;

import com.example.demo.generated.jooq.tables.records.EmployeeRecord;
import com.example.demo.model.Employee;
import com.example.demo.service.OkHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/okhttp")
public class OkHttpController {
    @Autowired
    private OkHttpService service;

    @GetMapping()
    public List<Employee> getAllEmployees() {
        return service.getAllEmployee();
    }
}
