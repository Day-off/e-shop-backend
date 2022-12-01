package com.example.iti0302backend.repository;

import com.example.iti0302backend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findPostByHeadContainingIgnoreCase(String head);

    Optional<Post> findPostById(Integer id);
}
