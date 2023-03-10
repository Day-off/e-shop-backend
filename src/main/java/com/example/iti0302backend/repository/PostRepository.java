package com.example.iti0302backend.repository;

import com.example.iti0302backend.entity.Post;
import com.example.iti0302backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findPostByHeadContainingIgnoreCase(String head);
    Optional<Post> findPostById(Integer id);
    List<Post> findPostByUser(User user, Pageable pageable);

    List<Post> findPostByIsAvailableIsTrue(Pageable pageable);


    @Transactional
    @Modifying
    @Query(value = "UPDATE posts SET head = :header WHERE post_id = :id" ,nativeQuery=true)
    void update(int id, String header);

    @Transactional
    @Modifying
    @Query(value = "UPDATE posts SET isavailable = false WHERE post_id = :id" ,nativeQuery=true)
    void buy(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE posts SET isavailable = true WHERE post_id = :id" ,nativeQuery=true)
    void unBuy(int id);
}
