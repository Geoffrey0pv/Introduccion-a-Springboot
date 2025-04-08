package org.example.introspring.repository;

import org.example.introspring.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserTable, Long> {
    Optional<UserTable> findByUsername(String email);
    Optional<UserTable> findByUsernameAndPassword(String username, String password);
    Optional<UserTable> findByEmail(String username, String password, Long id);
}
