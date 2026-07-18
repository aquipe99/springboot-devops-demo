package com.devops.demo.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record EmployeeResponse(

        UUID id,
        String firstName,
        String lastName,
        String email,
        String position,
        BigDecimal salary,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}
