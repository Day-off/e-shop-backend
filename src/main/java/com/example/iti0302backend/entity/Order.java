package com.example.iti0302backend.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @ManyToOne(targetEntity= User.class)
    @JoinColumn(name = "customer")
    private User customer;

    @ManyToOne(targetEntity= Post.class)
    @JoinColumn(name = "post")
    private Post post;

    @Column(name = "date")
    private Date date;

    @Column(name = "image")
    private Integer imageId;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "image", insertable=false, updatable=false)
    private Image image;

    @Column(name = "email")
    private String email;

}
