package com.devops.demo.service.impl;

import com.devops.demo.dto.request.EmployeeRequest;
import com.devops.demo.dto.response.EmployeeResponse;
import com.devops.demo.entity.Employee;
import com.devops.demo.exception.ResourceNotFoundException;
import com.devops.demo.mapper.EmployeeMapper;
import com.devops.demo.repository.EmployeeRepository;
import com.devops.demo.util.EmployeeTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository repository;

    @Mock
    private EmployeeMapper mapper;

    @InjectMocks
    private EmployeeServiceImpl service;

    @Test
    void findAll_shouldReturnEmployeeList(){
        //Arrange
        Employee employee= EmployeeTestData.employee(UUID.randomUUID());
        EmployeeResponse response = EmployeeTestData.response(UUID.randomUUID());

        when(repository.findAll()).thenReturn(List.of(employee));

        when(mapper.toResponse(employee)).thenReturn(response);

        // Act
        List<EmployeeResponse> result = service.findAll();

        // Assert
        assertEquals(1,result.size());
        assertEquals("Alex", result.get(0).firstName());
        assertEquals("Choque", result.get(0).lastName());

        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toResponse(employee);

    }
    @Test
    void findById_shouldReturnEmployee() {

        // Arrange
        UUID id = UUID.randomUUID();

        Employee employee = EmployeeTestData.employee(id);
        employee.setId(id);

        EmployeeResponse response = EmployeeTestData.response(id);

        when(repository.findById(id))
                .thenReturn(Optional.of(employee));

        when(mapper.toResponse(employee))
                .thenReturn(response);

        // Act
        EmployeeResponse result = service.findById(id);

        // Assert
        assertEquals(id, result.id());
        assertEquals("Alex", result.firstName());

        verify(repository).findById(id);
        verify(mapper).toResponse(employee);
    }
    @Test
    void findById_shouldThrowResourceNotFoundException() {

        // Arrange
        UUID id = UUID.randomUUID();

        when(repository.findById(id))
                .thenReturn(Optional.empty());

        // Act & Assert
        ResourceNotFoundException exception =
                assertThrows(
                        ResourceNotFoundException.class,
                        () -> service.findById(id)
                );

        assertEquals("Empleado no encontrado", exception.getMessage());

        verify(repository).findById(id);

        verify(mapper, never()).toResponse(any(Employee.class));
    }
    @Test
    void save_shouldCreateEmployee() {

        // Arrange
        EmployeeRequest request = EmployeeTestData.request();

        Employee employee = EmployeeTestData.employee(UUID.randomUUID());

        EmployeeResponse response = EmployeeTestData.response(UUID.randomUUID());

        when(mapper.toEntity(request))
                .thenReturn(employee);

        when(repository.save(employee))
                .thenReturn(employee);

        when(mapper.toResponse(employee))
                .thenReturn(response);

        // Act
        EmployeeResponse result = service.save(request);

        // Assert
        assertNotNull(result);

        assertEquals("Alex", result.firstName());

        verify(mapper).toEntity(request);

        verify(repository).save(employee);

        verify(mapper).toResponse(employee);
    }
    @Test
    void update_shouldUpdateEmployee() {

        // Arrange
        UUID id = UUID.randomUUID();

        EmployeeRequest request = EmployeeTestData.request();

        Employee employee = EmployeeTestData.employee(id);

        EmployeeResponse response = EmployeeTestData.response(UUID.randomUUID());

        when(repository.findById(id))
                .thenReturn(Optional.of(employee));

        when(repository.save(employee))
                .thenReturn(employee);

        when(mapper.toResponse(employee))
                .thenReturn(response);

        // Act
        EmployeeResponse result = service.update(id, request);

        // Assert
        assertNotNull(result);

        assertEquals("Alex", result.firstName());

        verify(repository).findById(id);
        verify(repository).save(employee);
        verify(mapper).toResponse(employee);
    }
    @Test
    void delete_shouldDeleteEmployee() {

        // Arrange
        UUID id = UUID.randomUUID();

        Employee employee = EmployeeTestData.employee(id);

        when(repository.findById(id))
                .thenReturn(Optional.of(employee));

        doNothing().when(repository).delete(employee);

        // Act
        service.delete(id);

        // Assert
        verify(repository).findById(id);

        verify(repository).delete(employee);
    }



}