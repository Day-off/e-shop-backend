package com.example.iti0302backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PostDto {
    @JsonProperty("post_id")
    private int id;

    @JsonProperty("head")
    private String head;

    @JsonProperty("description")
    private String description;

    @NotNull
    @JsonProperty("image_link")
    private String imageLink;
}
