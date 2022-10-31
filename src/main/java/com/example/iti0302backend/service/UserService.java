package com.example.iti0302backend.service;

import com.example.iti0302backend.dto.UserDto;
import com.example.iti0302backend.mapper.UserMapper;
import com.example.iti0302backend.repository.UserRepository;
import com.example.iti0302backend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public void addUser(UserDto userDto) {
        try {
            User user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
