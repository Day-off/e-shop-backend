package com.example.iti0302backend.service;


import com.example.iti0302backend.dto.CategoryDto;
import com.example.iti0302backend.mapper.CategoryMapper;
import com.example.iti0302backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getCategories() {
        return categoryMapper.categoriesDtoList(categoryRepository.findAll());
    }

    public CategoryDto findById(Integer id) {
        return categoryRepository.findById(id).map(category -> categoryMapper.toDto(category, category.getPosts())).orElse(null);
    }
}
