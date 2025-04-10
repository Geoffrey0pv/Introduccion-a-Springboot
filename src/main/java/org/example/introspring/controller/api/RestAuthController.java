package org.example.introspring.controller.api;


import org.example.introspring.dto.AuthRequest;
import org.example.introspring.dto.AuthResponse;
import org.example.introspring.service.CustomUserDetailsService;
import org.example.introspring.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.example.introspring.security.CustomUserDetail;
import org.springframework.security.authentication.AuthenticationManager;
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
    private JwtService JwtService;

    @Autowired
    private CustomUserDetailsService CustomUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(),
                            authRequest.getPassword()
                    )
            );
            UserDetails userDetails = CustomUserDetailsService.loadUserByUsername(authRequest.getEmail());
            String jwtToken = JwtService.generateToken(userDetails);
            AuthResponse authResponse = new AuthResponse(jwtToken);
            return ResponseEntity.status(200).body(authResponse);
        }catch (Exception e){
            return ResponseEntity.status(400).body(Map.of("Error", e.getMessage()));
        }
    }
}
