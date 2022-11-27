package com.example.iti0302backend.service;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.map.MapStructMapper;
import com.example.iti0302backend.mapper.PostMapper;
import com.example.iti0302backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final MapStructMapper mapstructMapper;

    private final PostMapper postMapper;

    public List<PostDto> getPosts() {
        return postMapper.toDtoList(postRepository.findAll());
    }

    public void addPost(PostDto postDto) {
        try {
            postRepository.save(postMapper.toPost(postDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PostDto> findByHeader(String head) {
        return mapstructMapper.postListToPostDtoList(postRepository.findPostByHeadContainingIgnoreCase(head));
    }
}
