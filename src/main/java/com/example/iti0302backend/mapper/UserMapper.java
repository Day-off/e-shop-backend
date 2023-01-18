package com.example.iti0302backend.mapper;


import com.example.iti0302backend.dto.UserDto;
import com.example.iti0302backend.entity.Order;
import com.example.iti0302backend.entity.Post;
import com.example.iti0302backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {PostMapper.class, OrderMapper.class})
public interface UserMapper {

    //User to userDto
    UserDto toDto(User user, List<Post> posts, List<Order> orders);

    //UserDto to user
    User toUser(UserDto userDto);

    List<UserDto> toDtoList(List<User> users);

    UserDto toDto(User user);
}

