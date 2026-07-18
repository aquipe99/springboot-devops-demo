package com.devops.demo.controller;

import com.devops.demo.dto.request.EmployeeRequest;
import com.devops.demo.dto.response.EmployeeResponse;
import com.devops.demo.entity.Employee;
import com.devops.demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(
        name = "Employees",
        description = "API para la administración de empleados"
)

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Operation(summary = "Obtiene todos los empleados")
    @GetMapping
    public List<EmployeeResponse>findAll(){
        return service.findAll();
    }
    @PostMapping
    public EmployeeResponse save(@Valid @RequestBody EmployeeRequest request){
        return service.save(request);
    }
    @GetMapping("/{id}")
    public EmployeeResponse findById(@PathVariable UUID id) {
        return service.findById(id);
    }
    @PutMapping("/{id}")
    public  EmployeeResponse update (@PathVariable UUID id, @Valid @RequestBody EmployeeRequest request){

        return  service.update(id,request);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
