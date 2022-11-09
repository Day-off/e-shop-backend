package com.example.iti0302backend.post;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;
public interface PostRepository extends JpaRepositoryImplementation<Post, Integer> {
    List<Post> findPostByHeadContainingIgnoreCase(String head);
}
