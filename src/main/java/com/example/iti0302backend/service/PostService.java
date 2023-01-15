package com.example.iti0302backend.service;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.entity.Category;
import com.example.iti0302backend.entity.Image;
import com.example.iti0302backend.entity.Post;
import com.example.iti0302backend.entity.User;
import com.example.iti0302backend.exceptions.ApplicationException;
import com.example.iti0302backend.mapper.PostMapper;
import com.example.iti0302backend.repository.*;
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

    private final ImageRepository imageRepository;
    private final PostCriteriaRepository postCriteriaRepository;
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


            setCategory(postDto, post);
            setDefaultIsAvailable(postDto, post);


            user.ifPresent(post::setUser);
            Image image = imageRepository.findTopByOrderByIdDesc();
            if (image != null) {
                post.setImageId(image.getId());
            } else {
                post.setImageId(null);
            }

            postRepository.save(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setDefaultIsAvailable(PostDto postDto, Post post) {
        if (postDto.getIsAvailable() == null) {
            post.setIsAvailable(true);
        }
    }

    private void setCategory(PostDto postDto, Post post) {
        if (postDto.getCategoryId() != null) {
            log.warn("find category " + postDto.getCategoryId());
            Optional<Category> category = categoryRepository.findById(postDto.getCategoryId());
            category.ifPresent(post::setCategory);
        } else {
            post.setCategory(null);
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

    public List<PostDto> search(PostFilter postFilter) {
        var postList = postCriteriaRepository.search(postFilter);
        return postMapper.toDtoList(postList);
    }

    public void deletePostById(Integer id) {
        Optional<Post> optionalPost = postRepository.findPostById(id);
        Post post = optionalPost.orElseThrow(() -> new ApplicationException("Invalid post id!"));
        postRepository.deleteById(post.getId());
    }

    public void updatePost(int id, String header) {
        postRepository.update(id, header);
    }

    public void buyPost(int id) {
        postRepository.buy(id);
    }

    public void unBuyPost(int id) {
        postRepository.unBuy(id);
    }

    public List<PostDto> paginateProductsByUserId(int page, String orderBy, Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElseThrow(() -> new ApplicationException("User is not found!"));
        Sort sort = Sort.by(orderBy).descending();
        Pageable pageRequest = PageRequest.of(page, PAGE_SIZE, sort);
        List<Post> posts = postRepository.findPostByUser(user, pageRequest);
        return postMapper.toDtoList(posts);
    }

}
