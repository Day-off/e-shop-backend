package com.example.iti0302backend.mapper;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "user.email", target = "email")
    PostDto toDto(Post post);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "email", target = "user.email")
    Post toPost(PostDto postDto);

    List<PostDto> toDtoList(List<Post> posts);
}