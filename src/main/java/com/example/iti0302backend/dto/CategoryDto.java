package com.example.iti0302backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {

    private Integer id;
    private String name;
    private List<PostDto> posts;

}
