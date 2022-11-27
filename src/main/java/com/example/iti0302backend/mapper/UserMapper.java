package com.example.iti0302backend.mapper;


import com.example.iti0302backend.dto.UserDto;
import com.example.iti0302backend.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    //User to userDto
    UserDto toDto(User user);

    //UserDto to user
    User toUser(UserDto userDto);
    List<UserDto> toDtoList(List<User> users);
}

