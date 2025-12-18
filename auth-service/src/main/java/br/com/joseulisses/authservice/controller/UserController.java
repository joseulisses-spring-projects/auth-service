package br.com.joseulisses.authservice.controller;

import br.com.joseulisses.authservice.domain.entity.User;
import br.com.joseulisses.authservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint de teste: busca usuário por email
    // Ex: GET /users/by-email?email=teste@teste.com
    @GetMapping("/by-email")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        return userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
