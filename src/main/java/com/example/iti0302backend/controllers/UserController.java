package com.example.iti0302backend.controllers;

import com.example.iti0302backend.dto.UserDto;
import com.example.iti0302backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/api/users")
    public void registerNewEmployee(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }
}
