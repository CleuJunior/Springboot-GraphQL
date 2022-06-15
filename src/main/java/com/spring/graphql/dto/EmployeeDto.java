package com.spring.graphql.dto;

import java.time.LocalDateTime;

public record EmployeeDto(
        String id,
        String firstname,
        String lastname,
        String location,
        DepartmentDto department,
        LocalDateTime createdOn,
        LocalDateTime updatedOn
) {
}