package com.example.iti0302backend.repository;

import com.example.iti0302backend.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findPostByHeadContainingIgnoreCase(String head);
}
