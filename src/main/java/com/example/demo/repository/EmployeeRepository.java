package com.example.demo.repository;


import com.example.demo.generated.jooq.tables.Employee;
import com.example.demo.generated.jooq.tables.records.EmployeeRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import com.example.demo.generated.jooq.tables.records.EmployeeRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final DSLContext dslContext;

    public EmployeeRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<EmployeeRecord> getAllEmployeeRecords() {
        return dslContext.selectFrom(Employee.EMPLOYEE).fetch();
    }
}


