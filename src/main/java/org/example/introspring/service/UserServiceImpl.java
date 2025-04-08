package org.example.introspring.service;

import org.example.introspring.entity.UserTable;
import org.example.introspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.introspring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserTable save(UserTable user) {
        // Hashear la contraseña antes de guardar
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserTable findByEmail(String email){
        return userRepository.findByUsername(email).orElseThrow(
                () -> new RuntimeException()
        );
    }
}
