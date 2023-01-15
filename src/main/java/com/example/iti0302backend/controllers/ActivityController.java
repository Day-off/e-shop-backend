package com.example.iti0302backend.controllers;

import com.example.iti0302backend.service.ActivityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController

public class ActivityController {
    private final ActivityService activityService;

    @GetMapping("/api/public/activity")
    public String getActivity() {
        log.info("Getting meme by GetMapping /api/public/meme");
        return activityService.getActivity();
    }

}
