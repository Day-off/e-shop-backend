package com.example.iti0302backend.controllers;

import com.example.iti0302backend.dto.CategoryDto;
import com.example.iti0302backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/api/categories")
    public List<CategoryDto> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/api/category")
    public CategoryDto getCategoryById(int id) {
        return categoryService.findById(id);
    }

}
