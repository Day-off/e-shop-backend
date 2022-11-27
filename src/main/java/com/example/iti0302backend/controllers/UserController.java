package com.example.iti0302backend.controllers;

import com.example.iti0302backend.dto.UserDto;
import com.example.iti0302backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/api/register")
    public void registerNewEmployee(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @PostMapping("/api/login")
    public String loginUser(@RequestBody UserDto userDto) {
        return userService.login(userDto.getFirstName(), userDto.getPassword());
    }

    @GetMapping("/api/user/{id}")
    public UserDto getUserById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }


}
