package com.rtt.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUsernameNotFoundException extends UsernameNotFoundException {

    public CustomUsernameNotFoundException(String msg) {
        super(msg);
    }

    public CustomUsernameNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
