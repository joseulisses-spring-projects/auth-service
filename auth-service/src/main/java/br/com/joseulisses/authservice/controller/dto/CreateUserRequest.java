package br.com.joseulisses.authservice.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank
        String name,

        @Email
        @NotBlank
        String email,
        @Size(min = 6, max = 10)
        String password
){}
