package com.example.iti0302backend.mapper;

import com.example.iti0302backend.category.Category;
import com.example.iti0302backend.dto.CategoryDto;
import com.example.iti0302backend.post.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = PostMapper.class)
public interface CategoryMapper {

    CategoryDto toDto(Category category, List<Post> posts);

    Category toCategory(CategoryDto categoryDto);

    List<CategoryDto> categoriesDtoList(List<Category> categoryList);
}
