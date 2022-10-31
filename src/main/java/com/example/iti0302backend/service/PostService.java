package com.example.iti0302backend.service;

import com.example.iti0302backend.post.Post;
import com.example.iti0302backend.post.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findById(Long id){
        return postRepository.findById(id);
    }

}
