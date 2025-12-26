package br.com.joseulisses.authservice.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        // 1️⃣ Se NÃO tiver Authorization OU não começar com Bearer → segue o fluxo
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 2️⃣ Extrai o token
        String token = authHeader.substring(7);

        // 3️⃣ Valida token
        if (!jwtService.isTokenValid(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        // 4️⃣ Extrai o subject (email)
        String email = jwtService.extractSubject(token);

        // 5️⃣ Cria autenticação
        var authentication = new UsernamePasswordAuthenticationToken(
                email,
                null,
                List.of()
        );

        // 6️⃣ Coloca no contexto do Spring Security
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 7️⃣ Continua o fluxo
        filterChain.doFilter(request, response);
    }
}

