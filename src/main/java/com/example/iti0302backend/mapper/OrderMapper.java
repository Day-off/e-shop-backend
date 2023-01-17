package com.example.iti0302backend.mapper;

import com.example.iti0302backend.dto.OrderDto;
import com.example.iti0302backend.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    @Mapping(source = "customer.id", target = "userId")
    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "image.id", target = "imageId")
    OrderDto toDto(Order order);

    Order toOrder(OrderDto orderDto);

    List<OrderDto> toDtoList(List<Order> orders);
}
