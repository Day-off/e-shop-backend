package com.example.iti0302backend.entity;

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
    private Integer id;

    @Column(name = "head")
    private String head;

    @Column(name = "description")
    private String description;

    @Column(name = "isavailable")
    private Boolean isAvailable;

    @ManyToOne(targetEntity= Category.class)
    @JoinColumn(name = "category")
    private Category category;

    @ManyToOne(targetEntity= User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "image_id")
    private Integer imageId;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "image_id", insertable=false, updatable=false)
    private Image image;
}
