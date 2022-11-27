package com.example.iti0302backend.post;

import com.example.iti0302backend.category.Category;
import com.example.iti0302backend.user.User;
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

    @Column(name = "image_link")
    private byte[] imageLink;

    @ManyToOne(targetEntity= Category.class)
    @JoinColumn(name = "category")
    private Category category;

    @ManyToOne(targetEntity= User.class)
    @JoinColumn(name = "user_id")
    private User user;

}
