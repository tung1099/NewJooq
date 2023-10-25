package com.example.demo.controller;

import com.example.demo.generated.jooq.tables.records.EmployeeRecord;
import com.example.demo.model.Employee;
import com.example.demo.service.OkHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/okhttp")
@Slf4j
public class OkHttpController {
    @Autowired
    private OkHttpService service;

    @GetMapping()
    public ResponseEntity<?> getData() {
        log.info("\n---------------------------------------------------------------------------&gt;\n");
        log.info("[GET] ['{}']", ServletUriComponentsBuilder.fromCurrentRequest().build());
        return service.getData();
    }

    @PostMapping
    public ResponseEntity<String> post(Object object) {
        return service.post(object);
    }
}
