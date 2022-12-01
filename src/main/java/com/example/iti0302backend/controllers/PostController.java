package com.example.iti0302backend.controllers;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/api/posts")
    public List<PostDto> getPosts() {
        return postService.getAll();
    }

    @PostMapping("/api/posts")
    public void addPost(@RequestBody PostDto postDto) {
        postService.addPost(postDto);
    }

    @GetMapping("/{head}")
    public List<PostDto> getById(@PathVariable("head") String head) {
        return postService.findByHeader(head);
    }

    @GetMapping("api/public/{page}&{orderBy}")
    public List<PostDto> getSortedBy(@PathVariable("page") int page, @PathVariable("orderBy") String orderBy){
        return postService.getSortedBy(page, orderBy);
    }

}
