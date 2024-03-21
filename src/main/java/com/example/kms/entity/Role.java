package com.example.kms.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.security.Permission;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.kms.entity.Permission.ADMIN_READ;
import static com.example.kms.entity.Permission.ADMIN_UPDATE;
import static com.example.kms.entity.Permission.ADMIN_DELETE;
import static com.example.kms.entity.Permission.ADMIN_CREATE;

@RequiredArgsConstructor
public enum Role {

    USER(Set.of()), // Collections.emptySet()
    ADMIN(Set.of());

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}