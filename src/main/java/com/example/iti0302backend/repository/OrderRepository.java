package com.example.iti0302backend.repository;

import com.example.iti0302backend.entity.Order;
import com.example.iti0302backend.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findOrdersByCustomer(User user, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "insert into orders (customer, post) values (:userId, :postId)" ,nativeQuery=true)
    void createOrder(int postId, int userId);

}
