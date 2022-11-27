package com.example.iti0302backend.service;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.map.MapStructMapper;
import com.example.iti0302backend.mapper.PostMapper;
import com.example.iti0302backend.post.Post;
import com.example.iti0302backend.repository.PostRepository;
import com.example.iti0302backend.repository.UserRepository;
import com.example.iti0302backend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final MapStructMapper mapstructMapper;

    private final PostMapper postMapper;

    public List<PostDto> getPosts() {
        return postMapper.toDtoList(postRepository.findAll());
    }

    public void addPost(PostDto postDto) {
        try {
            Optional<User> user = userRepository.findById(postDto.getUserId());
            Post post = postMapper.toPost(postDto);
            user.ifPresent(post::setUser);
            postRepository.save(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PostDto> findByHeader(String head) {
        return mapstructMapper.postListToPostDtoList(postRepository.findPostByHeadContainingIgnoreCase(head));
    }
}
