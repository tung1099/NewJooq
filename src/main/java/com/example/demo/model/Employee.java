package com.example.demo.model;

import com.example.demo.generated.jooq.tables.records.EmployeeRecord;
import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String name;
    private String gender;
    private int age;
    private String address;
    private String phoneNumber;
    public Employee() {
        // Default constructor
    }

    public Employee(EmployeeRecord employeeRecord) {
        this.id = employeeRecord.getId().longValue();
        this.name = employeeRecord.getName();
        this.gender = employeeRecord.getGender();
        this.age = employeeRecord.getAge();
        this.address = employeeRecord.getAddress();
    }
}
