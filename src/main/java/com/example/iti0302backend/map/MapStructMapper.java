package com.example.iti0302backend.map;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.post.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import javax.validation.Valid;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapStructMapper {

    Post postDtoToPost(@Valid PostDto postDto);

    @Mapping(source = "user.id", target = "userId")
    PostDto postToPostDto(Post post);

    // User list to List of Dto Users
    List<PostDto> postListToPostDtoList(List<Post> posts);
}