package com.rtt.common;

public record ApiResponse<T>(
        String code,
        String description,
        T data
) {
}
