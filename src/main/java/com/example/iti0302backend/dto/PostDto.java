package com.example.iti0302backend.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PostDto {
    private int id;

    private String head;

    private String description;

    @NotNull
    private String imageLink;
}
