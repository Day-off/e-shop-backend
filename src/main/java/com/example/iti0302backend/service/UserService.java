package com.example.iti0302backend.service;

import com.example.iti0302backend.user.User;
import com.example.iti0302backend.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }

    public List<User> findByName(String name) {
        return userRepository.findAllByFirstNameIgnoreCase(name);
    }
}
