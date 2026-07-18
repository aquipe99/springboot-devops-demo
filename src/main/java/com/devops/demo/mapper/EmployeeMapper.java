package com.devops.demo.mapper;

import com.devops.demo.config.MapperConfiguration;
import com.devops.demo.dto.request.EmployeeRequest;
import com.devops.demo.dto.response.EmployeeResponse;
import com.devops.demo.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface EmployeeMapper {

    Employee toEntity(EmployeeRequest request);
    EmployeeResponse toResponse(Employee employee);
}
