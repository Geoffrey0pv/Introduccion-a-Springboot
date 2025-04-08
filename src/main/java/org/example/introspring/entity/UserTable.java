package org.example.introspring.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CascadeType;

import java.util.HashSet;

@Entity
@Table(name = "A00380495_user")
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;


    // Getters y setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
