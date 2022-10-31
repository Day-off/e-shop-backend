package com.example.iti0302backend.service;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.map.MapStructMapper;
import com.example.iti0302backend.post.PostRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final MapStructMapper mapstructMapper;
    public PostService(PostRepository postRepository, MapStructMapper mapstructMapper) {
        this.postRepository = postRepository;
        this.mapstructMapper = mapstructMapper;
    }

    public List<PostDto> getAll() {
        return mapstructMapper.postListToPostDtoList(postRepository.findAll());
    }

    public List<PostDto> findByHeader(String head) {
        return mapstructMapper.postListToPostDtoList(postRepository.findPostByHeadContainingIgnoreCase(head));
    }
}
