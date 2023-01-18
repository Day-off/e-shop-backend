package com.example.iti0302backend.controllers;

import com.example.iti0302backend.dto.CategoryDto;
import com.example.iti0302backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/api/categories")
    public List<CategoryDto> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/api/category/{id}")
    public CategoryDto getCategoryById(@PathVariable("id") Integer id) {
        return categoryService.findById(id);
    }

    @PostMapping("/api/public/category")
    public void registerNewEmployee(@RequestBody CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
    }

}
