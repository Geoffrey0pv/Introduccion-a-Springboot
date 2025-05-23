package org.example.introspring.service;

import org.example.introspring.entity.UserTable;
import org.example.introspring.security.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserTable user = userService.findByUsername(username);
            return new CustomUserDetail(user);
        } catch (RuntimeException e) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}