package com.example.iti0302backend.service;

import com.example.iti0302backend.post.Post;
import com.example.iti0302backend.post.PostRepository;
import com.example.iti0302backend.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findById(Integer id){
        return postRepository.findById(id);
    }

}
