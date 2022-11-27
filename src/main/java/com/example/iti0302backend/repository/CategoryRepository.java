package com.example.iti0302backend.repository;

import com.example.iti0302backend.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
