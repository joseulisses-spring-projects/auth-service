package br.com.joseulisses.authservice.service;
import br.com.joseulisses.authservice.domain.entity.User;
import br.com.joseulisses.authservice.domain.repository.UserRepository;
import br.com.joseulisses.authservice.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }
    public String login(String email, String rawPassword) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        boolean senhaOk = passwordEncoder.matches(rawPassword, user.getPassword());

        if (!senhaOk) {
            throw new IllegalArgumentException("Senha inválida");
        }
        return jwtService.generateToken(user.getEmail());
    }
}
