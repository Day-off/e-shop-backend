package com.example.iti0302backend.repository;

import com.example.iti0302backend.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    Image findTopByOrderByIdDesc();
}
