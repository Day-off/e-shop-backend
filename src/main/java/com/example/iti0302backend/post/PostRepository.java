package com.example.iti0302backend.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

import java.util.List;

public interface PostRepository extends JpaRepositoryImplementation<Post, Integer> {
    List<Post> findPostByHeadContainingIgnoreCase(String head);
}
