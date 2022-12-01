package com.example.iti0302backend.controllers;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.repository.PostFilter;
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

    @GetMapping("api/public/")
    public List<PostDto> getSortedBy(int page, String orderBy){
        return postService.getSortedBy(page, orderBy);
    }
    @GetMapping("api/public")
    public List<PostDto> getSearch(int page, String orderBy, String header, String order){
        PostFilter postFilter = new PostFilter(page, header, orderBy, order);
        return postService.search(postFilter);
    }

    @DeleteMapping("/api/posts/delete")
    public void deletePost(@RequestBody PostDto postDto) {
        postService.deletePostById(postDto.getId());
    }

}
