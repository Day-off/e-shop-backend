package com.example.iti0302backend.service;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.entity.Category;
import com.example.iti0302backend.entity.Post;
import com.example.iti0302backend.entity.User;
import com.example.iti0302backend.mapper.PostMapper;
import com.example.iti0302backend.repository.CategoryRepository;
import com.example.iti0302backend.repository.PostRepository;
import com.example.iti0302backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    private final PostMapper postMapper;

    public List<PostDto> getPosts() {
        return postMapper.toDtoList(postRepository.findAll());
    }

    public void addPost(PostDto postDto) {
        try {
            Optional<User> user = userRepository.findById(postDto.getUserId());
            Post post = postMapper.toPost(postDto);
            Optional<Category> category = categoryRepository.findById(postDto.getCategoryId());
            category.ifPresent(post::setCategory);

            user.ifPresent(post::setUser);

            postRepository.save(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PostDto> findByHeader(String head) {
        return postMapper.toDtoList(postRepository.findPostByHeadContainingIgnoreCase(head));
    }
}
