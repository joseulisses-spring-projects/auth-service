package br.com.joseulisses.authservice.controller;

import br.com.joseulisses.authservice.controller.dto.CreateUserRequest;
import br.com.joseulisses.authservice.controller.dto.UserResponse;
import br.com.joseulisses.authservice.domain.entity.User;
import br.com.joseulisses.authservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid CreateUserRequest request) {
        User user = userService.create(
                request.name(),
                request.email(),
                request.password()
        );

        UserResponse response = new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );

        return ResponseEntity
                .created(URI.create("/users/" + user.getId()))
                .body(response);
    }
}
