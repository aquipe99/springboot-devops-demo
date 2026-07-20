package com.devops.demo.util;

import com.devops.demo.dto.request.EmployeeRequest;
import com.devops.demo.dto.response.EmployeeResponse;
import com.devops.demo.entity.Employee;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public final class EmployeeTestData {
    private EmployeeTestData() {
    }

    public static Employee employee(UUID id) {

        Employee employee = new Employee();

        employee.setId(id);
        employee.setFirstName("Alex");
        employee.setLastName("Choque");
        employee.setEmail("alex@email.com");
        employee.setPosition("Backend Developer");
        employee.setSalary(BigDecimal.valueOf(5000));
        employee.setActive(true);

        return employee;
    }

    public static EmployeeRequest request() {

        return new EmployeeRequest(
                "Alex",
                "Choque",
                "alex@email.com",
                "Backend Developer",
                BigDecimal.valueOf(5000)
        );
    }

    public static EmployeeResponse response(UUID id) {

        return new EmployeeResponse(
                id,
                "Alex",
                "Choque",
                "alex@email.com",
                "Backend Developer",
                BigDecimal.valueOf(5000),
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
