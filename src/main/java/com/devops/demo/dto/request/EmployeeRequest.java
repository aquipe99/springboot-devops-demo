package com.devops.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record EmployeeRequest(
        @NotBlank(message = "El nombre es obligatorio")
        String firstName,
        @NotBlank(message = "El apellido es obligatorio")
        String lastName,
        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "Correo inválido")
        String email,
        @NotBlank(message = "El cargo es obligatorio")
        String position,
        @NotNull(message = "El salario es obligatorio")
        @Positive(message = "El salario debe ser mayor a 0")
        BigDecimal salary
) {
}
