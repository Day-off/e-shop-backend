package com.example.iti0302backend.service;

import com.example.iti0302backend.dto.PostDto;
import com.example.iti0302backend.entity.*;
import com.example.iti0302backend.exceptions.ApplicationException;
import com.example.iti0302backend.mapper.PostMapper;
import com.example.iti0302backend.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private final OrderRepository orderRepository;

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
            if (post.getImageId() != null) {
                Image image = imageRepository.findTopByOrderByIdDesc();
                post.setImageId(image.getId());
            } else {
                post.setImageId(null);
            }

            log.info("Post saved");
            postRepository.save(post);
        } catch (ApplicationException e) {
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

    public PostDto findById(int id) {
        Optional<Post> post = postRepository.findById(id);
        return post.map(postMapper::toDto).orElse(null);
    }


    private Page<Post> getPage(int page, Sort sort) {
        Pageable pageRequest = PageRequest.of(page, PAGE_SIZE, sort);
        return postRepository.findAll(pageRequest);
    }

    public List<PostDto> getSortedBy(int page, String orderBy) {
        Sort sort = Sort.by(orderBy).ascending();
        Pageable pageRequest = PageRequest.of(page, PAGE_SIZE, sort);
        List<Post> posts = postRepository.findPostByIsAvailableIsTrue(pageRequest);
        return postMapper.toDtoList(posts);
    }

    public List<PostDto> search(PostFilter postFilter) {
        var postList = postCriteriaRepository.search(postFilter);
        return postMapper.toDtoList(postList);
    }

    public void deletePostById(Integer id) {
        Optional<Post> optionalPost = postRepository.findPostById(id);
        if (optionalPost.isPresent()){
            postRepository.deleteById(optionalPost.get().getId());
        }else {
            log.error("invalid id or post already delete!");
        }
    }

    public void updatePost(int id, String header) {
        postRepository.update(id, header);
    }


    public void buyPost(int postId, int userId, int imageId) {
        postRepository.buy(postId);
        orderRepository.createOrder(postId, userId, imageId);
    }

    public void unBuyPostId(int orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        order.ifPresent(value -> postRepository.unBuy(value.getPost().getId()));
        order.ifPresent(value -> orderRepository.deleteById(value.getId()));
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
