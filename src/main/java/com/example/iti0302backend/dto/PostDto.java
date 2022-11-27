package com.example.iti0302backend.dto;

import lombok.Data;
@Data
public class PostDto {

    private Long id;
    private String head;
    private String description;
    private byte[] imageLink;
}
