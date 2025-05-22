package org.example.introspring.repository;

import org.example.introspring.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Long> {
    Optional<UserTable> findByUsername(String email);
    Optional<UserTable> findByUsernameAndPassword(String username, String password);
    Optional<UserTable> findByEmail(String email);
}
