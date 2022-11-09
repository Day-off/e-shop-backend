package com.example.iti0302backend.service;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.map.MapStructMapper;
import com.example.iti0302backend.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MapStructMapper mapstructMapper;

    public List<PostDto> getAll() {
        return mapstructMapper.postListToPostDtoList(postRepository.findAll());
    }

    public List<PostDto> findByHeader(String head) {
        return mapstructMapper.postListToPostDtoList(postRepository.findPostByHeadContainingIgnoreCase(head));
    }
}
