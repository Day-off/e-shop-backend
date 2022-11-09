package com.example.iti0302backend.controllers;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
@CrossOrigin("http://193.40.255.30:8081/")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getAll(){
        return postService.getAll();
    }

    @GetMapping("/{head}")
    public List<PostDto> getById(@PathVariable("head") String head) {
        return postService.findByHeader(head);
    }


}
