package br.com.joseulisses.authservice.controller.dto;

public record UserResponse(
        Long id,
        String name,
        String email
) {}
