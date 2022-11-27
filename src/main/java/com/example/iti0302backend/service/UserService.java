package com.example.iti0302backend.service;

import com.example.iti0302backend.dto.UserDto;
import com.example.iti0302backend.mapper.UserMapper;
import com.example.iti0302backend.repository.UserRepository;
import com.example.iti0302backend.security.jwt.JwtUtils;
import com.example.iti0302backend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final JwtUtils jwtUtils;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;


    public List<UserDto> getUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public UserDto findById(Integer id) {
        return userRepository.findById(id).map(user -> userMapper.toDto(user, user.getPosts())).orElse(null);
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

    public String login(String username, String password) {
        User user = userRepository.findByFirstName(username);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return JwtUtils.generateTokenFromUsername(username);
        } else {
            throw new RuntimeException("Invalid password!");
        }
    }
}
