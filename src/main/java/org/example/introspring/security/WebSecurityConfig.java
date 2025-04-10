package org.example.introspring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        // Puedes crear más usuarios con diferentes roles
        // UserDetails user2 = User.withUsername("guest")...

        return new InMemoryUserDetailsManager(user /*, user2, ... */);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desactivamos la protección CSRF en este ejemplo.
                .csrf(csrf -> csrf.disable())

                // Definimos la política de creación de sesión: STATLESS si se maneja un JWT, por ejemplo
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Configuramos qué rutas son de acceso público y cuáles requieren autenticación
                .authorizeHttpRequests(auth -> auth
                        // Rutas estáticas (css, js, imágenes) públicas
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        // Endpoints de autenticación o registro, por ejemplo
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        // Cualquier otra ruta exigirá estar autenticado
                        .anyRequest().authenticated()
                );

        // Finalmente, construimos el objeto FilterChain para que Spring Security lo use.
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}