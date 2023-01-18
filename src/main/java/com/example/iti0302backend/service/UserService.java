package com.example.iti0302backend.service;

import com.example.iti0302backend.exceptions.ApplicationException;
import com.example.iti0302backend.dto.UserDto;
import com.example.iti0302backend.entity.User;
import com.example.iti0302backend.mapper.UserMapper;
import com.example.iti0302backend.repository.UserRepository;
import com.example.iti0302backend.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;


    public List<UserDto> getUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public void addUser(UserDto userDto) {
        try {
            User user = userMapper.toUser(userDto);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.orElseThrow(() -> new ApplicationException("User not found"));
        if (passwordEncoder.matches(password, user.getPassword())) {
            return JwtUtils.generateTokenFromEmail(email, user.getId(), user.getFirstName(), user.getLastName());
        } else {
            throw new ApplicationException("Invalid password !");
        }
    }

    public UserDto getUserById(int id){
        Optional<User> user =  userRepository.findById(id);
        return user.map(userMapper::toDto).orElse(null);
    }
}