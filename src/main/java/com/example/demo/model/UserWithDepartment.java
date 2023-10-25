package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class UserWithDepartment {
    private String id;
    private String name;
    private int age;
    private String address;
    private List<Department> departments;
}
