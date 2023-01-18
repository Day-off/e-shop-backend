package com.example.iti0302backend.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
@Builder
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private List<PostDto> posts;
    private List<OrderDto> orders;

}
