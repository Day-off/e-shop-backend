package com.example.iti0302backend.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    void getImage_correctImage() {
        Post post = new Post();
        Image image = Image.builder().build();
        post.setImage(image);
        var result = post.getImage();
        assertEquals(image, result);
    }

    @Test
    void getEmail_correctEmail() {
        Post post = new Post();
        post.setEmail("a@gmail.com");
        var result = post.getEmail();
        assertEquals("a@gmail.com", result);
    }
}