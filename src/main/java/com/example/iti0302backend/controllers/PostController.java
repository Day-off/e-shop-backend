package com.example.iti0302backend.controllers;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.repository.PostFilter;
import com.example.iti0302backend.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
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

    @GetMapping("/api/findById")
    public PostDto getById(int id) {
        return postService.findById(id);
    }

    @GetMapping("/api/public/")
    public List<PostDto> getSortedBy(int page, String orderBy){
        return postService.getSortedBy(page, orderBy);
    }
    @GetMapping("/api/public")
    public List<PostDto> getSearch(int page, String orderBy, String header, String order){
        PostFilter postFilter = new PostFilter(page, header, orderBy, order);
        return postService.search(postFilter);
    }
    @PostMapping("/api/posts/delete")
    public void deletePost(@RequestBody PostDto postDto) {
        postService.deletePostById(postDto.getId());
    }

    @GetMapping("/api/posts/update")
    public void updatePost(int id, String header){
        postService.updatePost(id, header);
    }

    @GetMapping("/api/posts/buy")
    public void buy(int postId, int userId, int imageId){
        postService.buyPost(postId, userId, imageId);
    }

    @DeleteMapping("/api/posts/deleteOrder")
    public void deleteFromOrders(int orderId){
        postService.unBuyPostId(orderId);
    }
    @GetMapping("/api/public/mypost")
    public List<PostDto> myPostSearch(int page, String orderBy, Integer userId){
        return postService.paginateProductsByUserId(page, orderBy, userId);
    }
}
