package com.rtt.course.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CourseRequest(

        @NotBlank(message = "Course name is required")
        String name,

        @NotNull(message = "Course fees is required")
        @DecimalMin(value = "0.0", message = "Course fees must be greater than or equal to 0")
        BigDecimal fees
) {
}
