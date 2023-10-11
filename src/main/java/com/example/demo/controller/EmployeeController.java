package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.generated.jooq.tables.records.EmployeeRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        List<EmployeeRecord> employeeRecords = employeeRepository.getAllEmployeeRecords();
        return employeeRecords.stream()
                .map(Employee::new) // Assuming you have a constructor in Employee class that accepts EmployeeRecord
                .collect(Collectors.toList());
    }
}


