package com.devops.demo.service.impl;

import com.devops.demo.dto.request.EmployeeRequest;
import com.devops.demo.dto.response.EmployeeResponse;
import com.devops.demo.entity.Employee;
import com.devops.demo.exception.ResourceNotFoundException;
import com.devops.demo.mapper.EmployeeMapper;
import com.devops.demo.repository.EmployeeRepository;
import com.devops.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service

public class EmployeeServiceImpl implements EmployeeService {


    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;


    public EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeResponse> findAll() {
        log.info("Obteniendo todos los empleados");
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public EmployeeResponse  save(EmployeeRequest request) {
       log.info("Creando empleado con email: {}", request.email());
       Employee employee=mapper.toEntity(request);
       Employee saved = repository.save(employee);
        log.info("Empleado creado correctamente con id: {}", saved.getId());
       return  mapper.toResponse(saved);

    }

    @Override
    public EmployeeResponse findById(UUID id) {
        log.info("Buscando empleado con ID: {}", id);
        Employee employee = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Empleado no encontrado"));
        return mapper.toResponse(employee);

    }

    @Override
    public EmployeeResponse  update(UUID id, EmployeeRequest  request) {
        log.info("Actualizando empleado con id: {}", id);
        Employee employeeDb = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(("Empleado no encontrado")));

        employeeDb.setFirstName(request.firstName());
        employeeDb.setLastName(request.lastName());
        employeeDb.setEmail(request.email());
        employeeDb.setPosition(request.position());
        employeeDb.setSalary(request.salary());
        Employee update = repository.save(employeeDb);
        log.info("Empleado actualizado correctamente");
        return mapper.toResponse(update);
    }

    @Override
    public void delete(UUID id) {
        log.info("Eliminando empleado con id: {}", id);
        Employee employee= repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Empleado no encontrado"));
        repository.delete(employee);
        log.info("Empleado eliminado correctamente");
    }
}
