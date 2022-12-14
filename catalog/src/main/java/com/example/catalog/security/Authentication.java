package com.example.catalog.security;

import com.example.id.security.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@Value
@Builder
public class Authentication {
    private final long id;
    private final List<String> roles;

    public boolean hasRole(final String role) {
        return roles.contains(role);
    }

    public static Authentication anonymous() {
        return Authentication.builder()
                .id(-1)
                .roles(List.of(Roles.ROLE_ANONYMOUS))
                .build();
    }
}
