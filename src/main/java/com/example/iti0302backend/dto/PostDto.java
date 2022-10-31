package com.example.iti0302backend.dto;

import lombok.Data;

@Data
public class PostDto {
    private Integer postId;
    private String head;
    private String description;
    private String imageLink;
    private String user;
}
