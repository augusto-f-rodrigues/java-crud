package com.example.crud.domain.user;

import jakarta.validation.constraints.NotNull;

public record PutRequestUser(
        String name,
        String email,
        Integer age
) {
}