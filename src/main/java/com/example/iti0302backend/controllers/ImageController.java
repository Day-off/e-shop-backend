package com.example.iti0302backend.controllers;

import com.example.iti0302backend.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/api/public/images")
    public int saveImage(@RequestParam("file") MultipartFile file) throws IOException {
        return imageService.saveImage(file);
    }

    @GetMapping("/api/public/images/{imageId}")
    public ResponseEntity<Object> getImageById(@PathVariable("imageId") Integer imageId) {
        return imageService.getImageById(imageId);
    }

}