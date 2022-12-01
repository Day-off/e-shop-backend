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
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PostMapper postMapper;
    private static final int PAGE_SIZE = 2;

    public List<PostDto> getAll() {
        return postMapper.toDtoList(postRepository.findAll());
    }

    public void addPost(PostDto postDto) {
        try {
            log.warn("find user");
            Optional<User> user = userRepository.findById(postDto.getUserId());
            Post post = postMapper.toPost(postDto);


            if (postDto.getCategoryId() != null){
                log.warn("find category " + postDto.getCategoryId());
                Optional<Category> category = categoryRepository.findById(postDto.getCategoryId());
                category.ifPresent(post::setCategory);
            }
            else {
                post.setCategory(null);
            }


            user.ifPresent(post::setUser);

            postRepository.save(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PostDto> findByHeader(String head) {
        return postMapper.toDtoList(postRepository.findPostByHeadContainingIgnoreCase(head));
    }


    private Page<Post> getPage(int page, Sort sort) {
        Pageable pageRequest = PageRequest.of(page, PAGE_SIZE, sort);
        return postRepository.findAll(pageRequest);
    }

    public List<PostDto> getSortedBy(int page, String orderBy) {
        Sort sort = Sort.by(orderBy).ascending();
        return postMapper.toDtoList(getPage(page, sort).getContent());
    }

}
