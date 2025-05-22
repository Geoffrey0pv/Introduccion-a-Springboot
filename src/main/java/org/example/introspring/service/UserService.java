package org.example.introspring.service;

import org.example.introspring.entity.UserTable;

public interface UserService {
    UserTable save(UserTable user);
    UserTable findByUsername(String username);
}
