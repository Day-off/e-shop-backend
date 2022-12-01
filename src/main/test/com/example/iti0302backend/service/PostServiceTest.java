package com.example.iti0302backend.service;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.entity.Post;
import com.example.iti0302backend.mapper.PostMapper;
import com.example.iti0302backend.mapper.PostMapperImpl;
import com.example.iti0302backend.repository.CategoryRepository;
import com.example.iti0302backend.repository.PostRepository;
import com.example.iti0302backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Spy
    private PostMapper postMapper = new PostMapperImpl();

    @InjectMocks
    private PostService postService;

    @Test
    void getAll_onePost_listOfOnePost() {
        Post post = Post.builder().id(123).head("one two three").description("counting...").build();
        postService.addPost(postMapper.toDto(post));
        given(postRepository.findAll()).willReturn(List.of(post));
        var result = postService.getAll();
        then(postMapper).should().toDtoList(List.of(post));
        then(postRepository).should().findAll();
        assertEquals(List.of(PostDto.builder().id(123)
                .head("one two three").description("counting...").build()), result);
    }
}