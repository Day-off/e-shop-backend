package com.example.iti0302backend.dto;

import lombok.Data;
@Data
public class PostDto {

    private Integer id;
    private String head;
    private String description;
    private byte[] imageLink;
    private Integer userId;
    private Integer categoryId;
}
