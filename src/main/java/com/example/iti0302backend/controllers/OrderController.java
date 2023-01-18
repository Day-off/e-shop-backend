package com.example.iti0302backend.controllers;


import com.example.iti0302backend.dto.OrderDto;
import com.example.iti0302backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping("api/public/orders/")
    public List<OrderDto> myPostSearch(int page, String orderBy, Integer userId){
        return orderService.getSortedBy(page, orderBy, userId);
    }
}
