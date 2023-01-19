package com.example.iti0302backend.entity;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getId_correctId() {
        Order order = new Order();
        order.setId(1);
        var result = order.getId();
        assertEquals(1, result);
    }

    @Test
    void getCustomer_correctCustomer() {
        Order order = new Order();
        User user = User.builder().build();
        order.setCustomer(user);
        var result = order.getCustomer();
        assertEquals(user, result);
    }

    @Test
    void getPost_correctPost() {
        Order order = new Order();
        Post post = Post.builder().build();
        order.setPost(post);
        var result = order.getPost();
        assertEquals(post, result);
    }

    @Test
    void getDate_correctDate() {
        Order order = new Order();
        Date date = Date.from(Instant.now());
        order.setDate(date);
        var result = order.getDate();
        assertEquals(date, result);
    }

    @Test
    void getImageId_correctImageId() {
        Order order = new Order();
        order.setImageId(1);
        var result = order.getImageId();
        assertEquals(1, result);
    }

    @Test
    void getImage_correctImage() {
        Order order = new Order();
        Image image = Image.builder().build();
        order.setImage(image);
        var result = order.getImage();
        assertEquals(image, result);
    }

    @Test
    void getEmail_correctEmail() {
        Order order = new Order();
        order.setEmail("a@gmail.com");
        var result = order.getEmail();
        assertEquals("a@gmail.com", result);
    }
}
