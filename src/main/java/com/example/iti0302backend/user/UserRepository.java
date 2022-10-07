package com.example.iti0302backend.user;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface UserRepository extends JpaRepositoryImplementation<User, Integer> {
    List<User> findAllByFirstNameIgnoreCase(String firstName);
}
