package com.example.iti0302backend.repository;

import com.example.iti0302backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
