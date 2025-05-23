package org.example.introspring.controller.api;

import org.example.introspring.dto.AuthRequest;
import org.example.introspring.dto.AuthResponse;
import org.example.introspring.service.CustomUserDetailsService;
import org.example.introspring.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class RestAuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );

            UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
            String jwtToken = jwtService.generateToken(userDetails);
            AuthResponse authResponse = new AuthResponse(jwtToken);

            return ResponseEntity.ok(authResponse);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(401)
                    .body(Map.of("error", "Credenciales incorrectas"));
        } catch (Exception ex) {
            return ResponseEntity.status(500)
                    .body(Map.of("error", "Error interno: " + ex.getMessage()));
        }
    }
}