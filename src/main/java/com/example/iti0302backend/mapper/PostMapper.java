package com.example.iti0302backend.mapper;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.post.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    PostDto toDto(Post post);

    Post toPost(PostDto postDto);

    List<PostDto> toDtoList(List<Post> posts);
}