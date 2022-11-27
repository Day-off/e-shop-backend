package com.example.iti0302backend.post;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "head")
    private String head;

    @Column(name = "description")
    private String description;

    @Column(name = "image_link")
    private byte[] imageLink;
}
