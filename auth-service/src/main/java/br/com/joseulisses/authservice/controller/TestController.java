package br.com.joseulisses.authservice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/me")
    public String me(Authentication auth) {
        return "Você está autenticado como: " + auth.getName();
    }
}
