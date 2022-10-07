package com.example.iti0302backend.controllers;

import com.example.iti0302backend.post.Post;
import com.example.iti0302backend.service.PostService;
import com.example.iti0302backend.service.UserService;
import com.example.iti0302backend.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HelloController {
    private final UserService userService;
    private final PostService postService;

    public HelloController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }


    @GetMapping("user/{userId}")
    public Optional<User> getUser(@PathVariable("userId") Integer id) {
        return userService.findById(id);
    }

    @GetMapping("user")
    public List<User> getUserByName(@RequestParam("name") String name) {
        return userService.findByName(name);
    }

    @GetMapping("post/{postId}")
    public Optional<Post> getPost(@PathVariable("postId") Integer id){
        return postService.findById(id);
    }

    @GetMapping("api/hello")
    public String hello() {
        return "Hello!";
    }
}
