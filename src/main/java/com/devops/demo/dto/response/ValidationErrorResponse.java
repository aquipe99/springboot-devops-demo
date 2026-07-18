package com.devops.demo.dto.response;

import java.time.LocalDateTime;
import java.util.Map;

public record ValidationErrorResponse(
        LocalDateTime timestamp,
        Integer status,
        String message,
        Map<String, String> errors
) {
}
