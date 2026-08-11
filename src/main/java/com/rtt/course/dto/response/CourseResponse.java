package com.rtt.course.dto.response;

import java.math.BigDecimal;

public record CourseResponse(
        Long id,
        String name,
        BigDecimal fees
) {
}
