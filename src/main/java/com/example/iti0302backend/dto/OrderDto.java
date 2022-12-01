package com.example.iti0302backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {

    private Integer id;
    private Integer userId;
    private Integer postId;
    private Date date;

}
