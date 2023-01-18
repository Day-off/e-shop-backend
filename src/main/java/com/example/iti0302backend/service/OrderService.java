package com.example.iti0302backend.service;


import com.example.iti0302backend.dto.OrderDto;
import com.example.iti0302backend.entity.Order;
import com.example.iti0302backend.entity.User;
import com.example.iti0302backend.exceptions.ApplicationException;
import com.example.iti0302backend.mapper.OrderMapper;
import com.example.iti0302backend.repository.OrderRepository;
import com.example.iti0302backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderService {

    private static final int PAGE_SIZE = 2;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    private final OrderMapper orderMapper;

    public List<OrderDto> getSortedBy(int page, String orderBy, Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElseThrow(() -> new ApplicationException("User is not found!"));
        Sort sort = Sort.by(orderBy).ascending();
        Pageable pageRequest = PageRequest.of(page, PAGE_SIZE, sort);
        List<Order> orders = orderRepository.findOrdersByCustomer(user, pageRequest);
        return orderMapper.toDtoList(orders);
    }

}
