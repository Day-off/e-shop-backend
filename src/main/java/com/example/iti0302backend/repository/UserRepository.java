package com.example.iti0302backend.repository;

import com.example.iti0302backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByFirstName(String username);
    Optional<User> findByEmail(String email);
    Boolean existsByFirstName(String username);

    Boolean existsByEmail(String email);
}
