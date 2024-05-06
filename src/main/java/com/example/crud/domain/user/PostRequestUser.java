package com.example.crud.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostRequestUser(
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotNull
        Integer age
) {
}
