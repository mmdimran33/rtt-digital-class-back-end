package com.rtt.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    TEACHER_READ("management:read"),
    TEACHER_UPDATE("management:update"),
    TEACHER_CREATE("management:create"),
    TEACHER_DELETE("management:delete");

    @Getter
    private final String permission;
}
