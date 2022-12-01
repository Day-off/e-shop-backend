package com.example.iti0302backend.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PostDto {

    private Integer id;
    private String head;
    private String description;
    private byte[] imageLink;
    private Integer userId;
    private Integer categoryId;
}
