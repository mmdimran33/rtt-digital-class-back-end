package com.rtt.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rtt.user.Permission.ADMIN_CREATE;
import static com.rtt.user.Permission.ADMIN_DELETE;
import static com.rtt.user.Permission.ADMIN_READ;
import static com.rtt.user.Permission.ADMIN_UPDATE;
import static com.rtt.user.Permission.TEACHER_CREATE;
import static com.rtt.user.Permission.TEACHER_DELETE;
import static com.rtt.user.Permission.TEACHER_READ;
import static com.rtt.user.Permission.TEACHER_UPDATE;

@RequiredArgsConstructor
public enum Role {

  USER(Collections.emptySet()),
  ADMIN(
          Set.of(
                  ADMIN_READ,
                  ADMIN_UPDATE,
                  ADMIN_DELETE,
                  ADMIN_CREATE,
                  TEACHER_READ,
                  TEACHER_UPDATE,
                  TEACHER_DELETE,
                  TEACHER_CREATE
          )
  ),
  TEACHER(
          Set.of(
                  TEACHER_READ,
                  TEACHER_UPDATE,
                  TEACHER_DELETE,
                  TEACHER_CREATE
          )
  );

  @Getter
  private final Set<Permission> permissions;

  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }
}
