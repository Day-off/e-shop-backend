package com.example.iti0302backend.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column(name = "post_id")
    private Integer id;
    private String head;
    private String description;
    @Column(name = "image_link")
    private String imageLink;
}
