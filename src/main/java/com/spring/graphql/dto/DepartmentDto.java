package com.spring.graphql.dto;

import java.time.LocalDateTime;

public record DepartmentDto(
        String id,
        String name,
        LocalDateTime createdOn,
        LocalDateTime updatedOn
) {
}
