package com.devops.demo.service;

import com.devops.demo.dto.request.EmployeeRequest;
import com.devops.demo.dto.response.EmployeeResponse;
import com.devops.demo.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    List<EmployeeResponse> findAll();
    EmployeeResponse save(EmployeeRequest employee);
    EmployeeResponse findById(UUID id);
    EmployeeResponse update(UUID id,EmployeeRequest  employee);
    void delete(UUID id);
}
