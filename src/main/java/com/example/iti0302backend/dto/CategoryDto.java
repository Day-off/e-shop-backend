package com.example.iti0302backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CategoryDto {

    private Integer id;
    private String name;
    private List<PostDto> posts;

}
