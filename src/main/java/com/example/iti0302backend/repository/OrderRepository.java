package com.example.iti0302backend.repository;

import com.example.iti0302backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into orders (customer, post) values (:userId, :postId)" ,nativeQuery=true)
    void createOrder(int postId, int userId);

}
