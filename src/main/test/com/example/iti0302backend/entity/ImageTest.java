package com.example.iti0302backend.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImageTest {

    @Test
    void getBytes_correctBytes() {
        Image image = Image.builder().build();
        byte[] arr = "\\x00".getBytes();
        image.setBytes(arr);
        var result = image.getBytes();
        assertEquals(arr, result);
    }

    @Test
    void getPost_correctPost() {
        Image image = Image.builder().build();
        Post post = Post.builder().build();
        image.setPost(post);
        var result = image.getPost();
        assertEquals(post, result);
    }
}
