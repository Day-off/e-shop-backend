package com.example.iti0302backend.dto;


import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private List<PostDto> posts;

}
